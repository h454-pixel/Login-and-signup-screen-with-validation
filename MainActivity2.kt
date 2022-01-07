package com.example.testmultiq

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {
    var email: EditText? = null
    var password:EditText? = null
  //  var login: Button? = null
    var register: TextView? = null
    var isEmailValid = false
    var isPasswordValiBoolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        email = findViewById(R.id.email_2)
        password =findViewById(R.id.password_2)
       val login =findViewById<Button>(R.id.logi_2)

   login.setOnClickListener(){

       setvalidation()

   }




    }

    private fun setvalidation() {
        if (email?.text.toString().isEmpty()) {
            email?.setError(getResources().getString(R.string.email_error));
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email?.getText().toString()).matches()) {
            email?.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;
        } else  {
            isEmailValid = true;
        }

        if (password?.getText().toString().isEmpty()) {
            password?.setError(getResources().getString(R.string.password_error));
            isPasswordValiBoolean = false;
        } else if (password?.getText()?.length!! < 6) {
            password?.setError(getResources().getString(R.string.error_invalid_password));
            isPasswordValiBoolean = false;
        } else  {
            isPasswordValiBoolean = true;
        }

        if (isEmailValid && isPasswordValiBoolean) {
            Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
        }

    }
}