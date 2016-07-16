package com.example.ckkwong.amaze;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ckkwong.amaze.DatabaseHelpers.DatabaseHelper;

public class SignInActivity extends Activity {

    DatabaseHelper databaseHelper;
    EditText editFullName, editEmailID, editPassword;
    Button buttonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        databaseHelper = new DatabaseHelper(this);

        editFullName = (EditText) findViewById(R.id.editText_fullName);
        clearText(editFullName);
        editEmailID = (EditText) findViewById(R.id.editText_emailID);
        clearText(editEmailID);
        editPassword = (EditText) findViewById(R.id.editText_password);
        clearText(editPassword);
        buttonSignIn = (Button) findViewById(R.id.button_signIn);

        addData();
    }

    public void addData() {
        buttonSignIn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        databaseHelper.insert(editFullName.getText().toString(),
                                editEmailID.getText().toString(),
                                editPassword.getText().toString());

                    }
                }
        );
    }

    /*
    public void clearText(final EditText currentEditText) {
        currentEditText.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currentEditText.setText("");
                    }
                }
        );
    }
    */

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
}
