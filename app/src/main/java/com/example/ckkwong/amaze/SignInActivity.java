package com.example.ckkwong.amaze;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ckkwong.amaze.DatabaseHelpers.DatabaseHelper;

public class SignInActivity extends Activity {

    DatabaseHelper databaseHelper;
    EditText editFullName, editEmailID, editPassword;
    Button buttonLogin, buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        databaseHelper = new DatabaseHelper(this);

        editEmailID = (EditText) findViewById(R.id.editText_emailID);
        clearText(editEmailID);
        editPassword = (EditText) findViewById(R.id.editText_password);
        clearText(editPassword);

        buttonLogin = (Button) findViewById(R.id.button_login);
        attemptLogin(buttonLogin);
        buttonSignUp = (Button) findViewById(R.id.button_signUp);
        attemptSignUp(buttonSignUp);
    }

    public void attemptLogin(Button currentButton) {
        currentButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String emailID = editEmailID.getText().toString();
                        String password = editPassword.getText().toString();

                        if (emailID.equals("") || emailID.equals("Email") || emailID == null) {
                            Toast.makeText(getApplicationContext(), "Email ID Empty", Toast.LENGTH_SHORT).show();
                        } else if (password.equals("") || password == null) {
                            Toast.makeText(getApplicationContext(), "Password Empty", Toast.LENGTH_SHORT).show();
                        } else {
                            boolean isValidUser = databaseHelper.checkIfValidUser(emailID, password, SignInActivity.this);

                            if (isValidUser == true) {
                                transferToHomeScreen();
                            } else {
                                Toast.makeText(getApplicationContext(), "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }

        );
    }


    public void attemptSignUp(Button currentButton) {
        currentButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String emailID = editEmailID.getText().toString();
                        String password = editPassword.getText().toString();

                        if (emailID.equals("") || emailID.equals("Email") || emailID == null) {
                            Toast.makeText(getApplicationContext(), "Email ID Empty", Toast.LENGTH_SHORT).show();
                        } else if (password.equals("") || password == null) {
                            Toast.makeText(getApplicationContext(), "Password Empty", Toast.LENGTH_SHORT).show();
                        } else {
                            boolean isExistingUser = databaseHelper.checkIfExistingUser(emailID, password, SignInActivity.this);

                            if (isExistingUser == true) {
                                Toast.makeText(getApplicationContext(), "User Already Exists", Toast.LENGTH_SHORT).show();
                            } else if (isExistingUser == false) {
                                databaseHelper.insert(emailID, password);
                                Toast.makeText(getApplicationContext(), "Account Successfully Created", Toast.LENGTH_SHORT).show();
                                transferToHomeScreen();
                            }
                        }
                    }
                }

        );
    }


    public void clearText(final EditText currentEditText) {
        currentEditText.setOnFocusChangeListener(
                new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {
                            currentEditText.getText().clear();
                        }
                    }
                }
        );
    }

    public void transferToHomeScreen() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
