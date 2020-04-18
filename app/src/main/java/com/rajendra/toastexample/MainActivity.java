package com.rajendra.toastexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.muddzdev.styleabletoast.StyleableToast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void displayToast(View v){

        switch (v.getId()){

            case R.id.basicToast:
                Toast.makeText(getApplicationContext(),"This is a basic toast", Toast.LENGTH_LONG).show();
            break;

            case R.id.gravityToast:

                //we can also change the display position in toast
                toast = Toast.makeText(getApplicationContext(), "This is a gravity toast.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 500);
                toast.show();
            break;


            case R.id.customToast:

                // wee need to create a toast layout
                LayoutInflater layoutInflater = getLayoutInflater();
                View view = layoutInflater.inflate(R.layout.custom_toast_layout,
                        (ViewGroup) findViewById(R.id.custom_toast_container));

                toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(view);
                toast.show();

                break;

            // for styleable toast we need to add gradle dependency

            case R.id.styleableToast:
                StyleableToast.makeText(getApplicationContext(),"This is a styleable toast.", Toast.LENGTH_SHORT, R.style.mytoast).show();
                break;

            // for Toasty Toast also we need to add some gradle dependency

            case R.id.buttonError:
                Toasty.error(this, "This is an error toast.", Toast.LENGTH_SHORT, true).show();
                break;


            case R.id.buttonSuccess:
                Toasty.success(this, "Success!", Toast.LENGTH_SHORT, true).show();

                break;


            case R.id.buttoninfo:
                Toasty.info(this, "Here is some info for you.", Toast.LENGTH_SHORT, true).show();

                break;


            case R.id.buttonwarning:
                Toasty.warning(this, "Beware of the dog.", Toast.LENGTH_SHORT, true).show();

                break;


            case R.id.buttonicon:
                Toasty.normal(this, "Normal toast w/ icon", ContextCompat.getDrawable(this, R.drawable.download)).show();

                break;


                // Toast tutorial completed
            // if you like please support my channel
            // see you in the next tutorial





        }




    }
}
