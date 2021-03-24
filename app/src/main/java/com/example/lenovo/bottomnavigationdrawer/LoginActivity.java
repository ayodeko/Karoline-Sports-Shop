package com.example.lenovo.bottomnavigationdrawer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends Activity {

    EditText usernameEditText;
    EditText passwordEditText;
    ImageButton loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.username_editText);
        passwordEditText = findViewById(R.id.password_editText);
        loginButton = findViewById(R.id.loginButton);

        final String usernameText = toText(usernameEditText);
        final String passwordText = toText(passwordEditText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stringEmpty(usernameText, passwordText)){
                    Toast.makeText(LoginActivity.this, "Please Fill All Spaces", Toast.LENGTH_SHORT).show();
                }
                else{
                    loginMethod();
                }
            }
        });


    }

    public void createAccount(View view) {

        Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
        startActivity(intent);

    }

    public void loginMethod(){

        ParseUser.logInInBackground(toText(usernameEditText), toText(passwordEditText), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(user != null){
                    Toast.makeText(LoginActivity.this, "Logged in Successfully", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(LoginActivity.this, "An Error Occurred", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public String toText(EditText editText){
        String text = editText.getText().toString();
        return text;
    }

    public boolean stringEmpty(String... string){
        boolean a = true;
        for(String s : string)
            if (s.isEmpty()) {
                a = false;
            }
        return a;
    }

}
