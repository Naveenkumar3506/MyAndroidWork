package com.naveen.testapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etuserName, etPassword;
    private Button buttonLogin;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        etuserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        buttonLogin = (Button) findViewById(R.id.btnLogin);

        etuserName.setText("123456");
        etPassword.setText("qwerty");

        this.setTitle("Naveen's Home");

        buttonLogin.setOnClickListener(this);


        etPassword.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE || i == EditorInfo.IME_ACTION_GO) {
                    buttonLogin.performClick();
                }

                return false;
            }
        });

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnLogin: {
                if (etuserName.getText().toString().isEmpty()) {
                    showAlert("Please enter user name");
                } else if (etPassword.getText().toString().isEmpty()) {
                    showAlert("Please enter password");
                } else {
                    buttonLoginTapped();
                }
            }
            break;
        }
    }

    void showAlert(String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    void buttonLoginTapped() {

        Model modelObj = new Model();
        modelObj.setPassword(etPassword.getText().toString());
        modelObj.setUserName(etuserName.getText().toString());

        Intent homeintent = new Intent(this, HomeActivity.class);
        homeintent.putExtra("userName", etuserName.getText().toString());
        homeintent.putExtra("password", etPassword.getText().toString());
        homeintent.putExtra("modelObj", modelObj);

        SingletonTest.getInstance().testModel = modelObj;

        startActivity(homeintent);
        finish();
    }


}
