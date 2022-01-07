package com.example.testmultiq

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.TextView

import android.widget.EditText
import android.widget.Toast


class MainActivity3 : AppCompatActivity() {
    var name: EditText? = null
    var email:EditText? = null
    var phone:EditText? = null
    var password:EditText? = null
    lateinit  var register: Button
    var login: TextView? = null
    var isNameValid = false
    var isEmailValid = false
    var isPhoneValid= false
    var isPasswordValid= false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);


        register.setOnClickListener {
            SetValidation();

        }


    }

    private fun SetValidation() {
        // Check for a valid name.
        if (name?.getText().toString().isEmpty()) {
            name?.setError(getResources().getString(R.string.name_error));
            isNameValid = false;
        } else  {
            isNameValid = true;
        }

        // Check for a valid email address.
        if (email?.getText().toString().isEmpty()) {
            email?.setError(getResources().getString(R.string.email_error));
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email?.getText().toString()).matches()) {
            email?.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;
        } else  {
            isEmailValid = true;
        }

        // Check for a valid phone number.
        if (phone?.getText().toString().isEmpty()) {
            phone?.setError(getResources().getString(R.string.phone_error));
            isPhoneValid = false;
        } else  {
            isPhoneValid = true;
        }

        // Check for a valid password.
        if (password?.getText().toString().isEmpty()) {
            password?.setError(getResources().getString(R.string.password_error));
            isPasswordValid = false;
        } else if (password?.getText()?.length!! < 6) {
            password?.setError(getResources().getString(R.string.error_invalid_password));
            isPasswordValid = false;
        } else  {
            isPasswordValid = true;
        }

        if (isNameValid && isEmailValid && isPhoneValid && isPasswordValid) {
            Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
        }

    }

}
