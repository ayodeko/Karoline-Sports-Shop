package com.example.lenovo.bottomnavigationdrawer.MyParseUser;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.example.lenovo.bottomnavigationdrawer.LoginActivity;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class MyParseUser {

    String firstName, lastName, userName, password, confirmPassword;
    private Context context;

    public MyParseUser(String firstName, String lastName, String userName, String password, String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public void createParseUser(Context gottenContext){
        this.context = gottenContext;
        if (!(password.equals(confirmPassword))) {
            Toast.makeText(context, "Confirm Password must be the same with Password", Toast.LENGTH_SHORT).show();
        }
        else{
            ParseUser user = new ParseUser();
            user.setPassword(password);
            user.setUsername(userName);

            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(context, "Successfully SignedUp the Username: " + userName, Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }
            });
            ParseUser.logInInBackground(userName, password, new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if(user!=null){
                        Toast.makeText(context, "Now Logged in as "+ userName, Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(context, "Error: "+e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });

            ParseObject userObject = new ParseObject("UserObject");
            userObject.put("username", userName);
            userObject.put("FirstName", firstName);
            userObject.put("LastName", lastName);

            userObject.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null){
                        Toast.makeText(context, "An Error Occurred", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(context, "SignUp now Complete", Toast.LENGTH_LONG).show();
                    }
                }
                });
            }
        }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
