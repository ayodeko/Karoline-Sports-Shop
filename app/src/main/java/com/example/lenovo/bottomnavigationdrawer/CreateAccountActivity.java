 package com.example.lenovo.bottomnavigationdrawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lenovo.bottomnavigationdrawer.MyParseUser.MyParseUser;
import com.parse.Parse;

 public class CreateAccountActivity extends AppCompatActivity {

     EditText firstnameEditText;
     EditText lastnameEditText;
     EditText usernameEditText;
     EditText passwordEditText;
     EditText confirmPasswordEditText;
     ImageButton createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        createAccountButton = findViewById(R.id.createAccountButton);

        Parse.initialize(this);

        firstnameEditText = findViewById(R.id.firstname_editText);
        lastnameEditText = findViewById(R.id.lastname_editText);
        usernameEditText = findViewById(R.id.username_editText);
        passwordEditText = findViewById(R.id.password_editText);
        confirmPasswordEditText = findViewById(R.id.confirm_password_editText);



        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stringEmpty(toText(firstnameEditText), toText(lastnameEditText), toText(usernameEditText), toText(passwordEditText), toText(confirmPasswordEditText))){
                    Toast.makeText(getApplicationContext(), "Please Fill All Spaces", Toast.LENGTH_LONG).show();
                }
                else{
                    MyParseUser myUser = new MyParseUser(toText(firstnameEditText), toText(lastnameEditText), toText(usernameEditText), toText(passwordEditText), toText(confirmPasswordEditText));
                    myUser.createParseUser(getApplicationContext());
                }
            }
        });




    }

     public void goBackLogin(View view) {

        Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

     }

     public String toText(EditText editText){
        String text = editText.getText().toString();
        return text;
     }

     public boolean stringEmpty(String... string){
        boolean a = false;
        for(String s : string)
            if (s.isEmpty()) {
                a = false;
            }
        return a;
     }
 }
