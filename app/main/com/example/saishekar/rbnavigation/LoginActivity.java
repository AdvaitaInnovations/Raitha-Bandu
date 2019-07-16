package com.example.saishekar.rbnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

import com.example.saishekar.rbnavigation.helper.InputValidation;
import com.example.saishekar.rbnavigation.sql.DatabaseHelper;

import java.net.PasswordAuthentication;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = LoginActivity.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutPhone;
    private TextInputLayout textInputLayoutPassword;

    private TextInputEditText textInputEditTextPhone;
    private TextInputEditText textInputEditTextPassword;

    private AppCompatButton appCompatButtonLogin;

    private AppCompatTextView textViewLinkRegister;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    String MobilePattern = "[0-9]{10}";
    String Password = "[0-9]{8}||[A-Z]{8}||[a-z]{8}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
    }

    /**
     * This method is to initialize views
     */
    private void initViews() {

        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutPhone = (TextInputLayout) findViewById(R.id.textInputLayoutPhone);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);

        textInputEditTextPhone = (TextInputEditText) findViewById(R.id.textInputEditTextPhone);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);

        appCompatButtonLogin = (AppCompatButton) findViewById(R.id.appCompatButtonLogin);

        textViewLinkRegister = (AppCompatTextView) findViewById(R.id.textViewLinkRegister);

    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        appCompatButtonLogin.setOnClickListener(this);
        textViewLinkRegister.setOnClickListener(this);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);

    }

    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonLogin:
                verifyFromSQLite();
            Intent intentL = new Intent(getApplicationContext(), NavMainActivity.class);
                startActivity(intentL);

                break;
            case R.id.textViewLinkRegister:
                // Navigate to RegisterActivity
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
                break;
        }
    }

    /**
     * This method is to validate the input text fields and verify login credentials from SQLite
     */
    private void verifyFromSQLite() {
//        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_phone))) {
//            return;
//        }
//        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_phone))) {
//            return;
//        }
        if(textInputEditTextPhone.getText().toString().matches(MobilePattern))
        {
                if(textInputEditTextPassword.getText().toString().matches(Password)) {

                    Toast.makeText(getApplicationContext(), "Registered Succesfully", Toast.LENGTH_SHORT).show();
                    return;
                }
        } else if(!textInputEditTextPhone.getText().toString().matches(MobilePattern)) {

            //Toast.makeText(getApplicationContext(), "Please enter valid 10 digit phone number", Toast.LENGTH_SHORT).show();
            return ;
        }
        else if(!textInputEditTextPassword.getText().toString().matches(Password)) {

            Toast.makeText(getApplicationContext(), "Please enter Password", Toast.LENGTH_SHORT).show();
            return ;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_phone ))) {
            return;
        }

        if (databaseHelper.checkUser(textInputEditTextPhone.getText().toString().trim()
                , textInputEditTextPassword.getText().toString().trim())) {


            Intent intentL = new Intent(getApplicationContext(), NavMainActivity.class);

            intentL.putExtra("Phone", textInputEditTextPhone.getText().toString().trim());
            emptyInputEditText();
            startActivity(intentL);


        } else {
            // Snack Bar to show success message that record is wrong
            Snackbar.make(nestedScrollView, getString(R.string.error_valid_phone_password), Snackbar.LENGTH_LONG).show();
        }
    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        textInputEditTextPhone.setText(null);
        textInputEditTextPassword.setText(null);
    }
}


//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.design.widget.Snackbar;
//import android.support.design.widget.TextInputEditText;
//import android.support.design.widget.TextInputLayout;
//import android.support.v4.widget.NestedScrollView;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.AppCompatButton;
//import android.support.v7.widget.AppCompatTextView;
//import android.util.Log;
//import android.view.View;
//
//import com.example.saishekar.rbnavigation.R;
//import com.example.saishekar.rbnavigation.helper.InputValidation;
//import com.example.saishekar.rbnavigation.sql.DatabaseHelper;
//
//public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
//    private final AppCompatActivity activity = LoginActivity.this;
//
//    private NestedScrollView nestedScrollView;
//
//    private TextInputLayout textInputLayoutEmail;
//    private TextInputLayout textInputLayoutPassword;
//
//    private TextInputEditText textInputEditTextEmail;
//    private TextInputEditText textInputEditTextPassword;
//
//    private AppCompatButton appCompatButtonLogin;
//
//    private AppCompatTextView textViewLinkRegister;
//
//    private InputValidation inputValidation;
//    private DatabaseHelper databaseHelper;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        getSupportActionBar().hide();
//
//        initViews();
//        initListeners();
//        initObjects();
//    }
//
//    /**
//     * This method is to initialize views
//     */
//    private void initViews() {
//
//        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
//
//        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutPhone);
//        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
//
//        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextPhone);
//        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
//
//        appCompatButtonLogin = (AppCompatButton) findViewById(R.id.appCompatButtonLogin);
//
//        textViewLinkRegister = (AppCompatTextView) findViewById(R.id.textViewLinkRegister);
//
//    }
//
//    /**
//     * This method is to initialize listeners
//     */
//    private void initListeners() {
//        appCompatButtonLogin.setOnClickListener(this);
//        textViewLinkRegister.setOnClickListener(this);
//    }
//
//    /**
//     * This method is to initialize objects to be used
//     */
//    private void initObjects() {
//        databaseHelper = new DatabaseHelper(activity);
//        inputValidation = new InputValidation(activity);
//
//    }
//
//    /**
//     * This implemented method is to listen the click on view
//     *
//     * @param v
//     */
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.appCompatButtonLogin:
//                verifyFromSQLite();
//                break;
//            case R.id.textViewLinkRegister:
//                // Navigate to RegisterActivity
//                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
//                startActivity(intentRegister);
//                break;
//        }
//    }
//
//    /**
//     * This method is to validate the input text fields and verify login credentials from SQLite
//     */
//    private void verifyFromSQLite() {
//        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_phone))) {
//            return;
//        }
//        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_phone))) {
//            return;
//        }
//        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_phone))) {
//            return;
//        }
//
//        if (databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim()
//                , textInputEditTextPassword.getText().toString().trim())) {
//
//
//            Intent accountsIntent = new Intent(activity, UserListActivity.class);
//            accountsIntent.putExtra("EMAIL", textInputEditTextEmail.getText().toString().trim());
//            emptyInputEditText();
//            startActivity(accountsIntent);
//
//
//        } else {
//            // Snack Bar to show success message that record is wrong
//            Snackbar.make(nestedScrollView, getString(R.string.error_valid_phone_password), Snackbar.LENGTH_LONG).show();
//        }
//    }
//
//    /**
//     * This method is to empty all input edit text
//     */
//    private void emptyInputEditText() {
//        textInputEditTextEmail.setText(null);
//        textInputEditTextPassword.setText(null);
//    }
//}