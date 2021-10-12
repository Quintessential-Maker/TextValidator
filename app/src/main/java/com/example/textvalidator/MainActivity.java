package com.example.textvalidator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.validator.ValidateTor;

public class MainActivity extends AppCompatActivity {

    ValidateTor validateTor;
    EditText emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        validateTor = new ValidateTor();
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        if (validateTor.isEmpty(emailEditText.getText().toString().trim())) {
            emailEditText.setError("Field is empty!");
        }

        if (validateTor.isAtleastLength(passwordEditText.getText().toString().trim(), 8)
                && validateTor.hasAtleastOneDigit(passwordEditText.getText().toString().trim())
                && validateTor.hasAtleastOneUppercaseCharacter(passwordEditText.getText().toString().trim())
                && validateTor.hasAtleastOneSpecialCharacter(passwordEditText.getText().toString().trim())) {
            Toast.makeText(this, "Valid Password!", Toast.LENGTH_SHORT).show();
        } else {
            passwordEditText.setError("Password needs to be a minimum length of 8 characters and should have at least 1 digit, 1 upppercase letter and 1 special character ");
        }

    }
}