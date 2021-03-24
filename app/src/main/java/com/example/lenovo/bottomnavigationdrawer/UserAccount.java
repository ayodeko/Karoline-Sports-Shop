package com.example.lenovo.bottomnavigationdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.parse.ParseUser;

public class UserAccount extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        final String presentUser = ParseUser.getCurrentUser().getUsername();
    }

    public void addDetailsButton(View view) {

    }
}
