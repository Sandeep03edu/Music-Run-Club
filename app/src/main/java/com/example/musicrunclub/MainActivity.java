package com.example.musicrunclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musicrunclub.R;

public class MainActivity extends AppCompatActivity {

    /* Define the UI elements */
    private EditText eName;
    private EditText ePassword;
    private TextView eAttemptsInfo;
    private Button eLogin;

    String userName = "";
    String userPassword = "";

    /* Class to hold credentials */
    class Credentials
    {
        String name1 = "MSD";
        String name2 = "RunRun";
        String password1 = "Dhoni";
        String password2 = "SimRun";
    }

    boolean isValid1 = false;
    boolean isValid2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Bind the XML views to Java Code Elements */
        eName = findViewById(R.id.activity_main_usernameEditText);
        ePassword = findViewById(R.id.activity_main_passwordEditText);
        eLogin = findViewById(R.id.activity_main_loginButton);

        /* Describe the logic when the login button is clicked */
        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Obtain user inputs */
                userName = eName.getText().toString();
                userPassword = ePassword.getText().toString();

                /* Check if the user inputs are empty */
                if(userName.isEmpty() || userPassword.isEmpty())
                {
                    /* Display a message toast to user to enter the details */
                    Toast.makeText(MainActivity.this, "Please enter name and password!", Toast.LENGTH_LONG).show();

                }
                else {

                    /* Validate the user inputs */
                    isValid1 = validate1(userName, userPassword);
                    isValid2 = validate2(userName,userPassword);

                    if(isValid1){

                        /* Allow the user in to your app by going into the next activity */
                        startActivity(new Intent(MainActivity.this, MainActivity2.class));
                    }
                    else if(isValid2){
                        startActivity(new Intent(MainActivity.this, MainActivity2a.class));
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Incorrect credentials, please try again!", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }

    /* Validate the credentials */
    private boolean validate1(String userName, String userPassword)
    {
        /* Get the object of Credentials class */
        Credentials credentials = new Credentials();

        /* Check the credentials */
        if(userName.equals(credentials.name1) && userPassword.equals(credentials.password1))
        {
            return true;
        }

        return false;
    }

    private boolean validate2(String userName, String userPassword)
    {
        /* Get the object of Credentials class */
        Credentials credentials = new Credentials();

        /* Check the credentials */
        if(userName.equals(credentials.name2) && userPassword.equals(credentials.password2))
        {
            return true;
        }

        return false;
    }
}