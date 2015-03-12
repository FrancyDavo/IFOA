package com.example.mobile.ifoa_justasolution;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class VerificaLog extends ActionBarActivity {

    EditText nome, pass;
    Button login;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("Login");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2B4085")));
        nome=(EditText)findViewById(R.id.editTextUserNameToLogin);
        pass=(EditText)findViewById(R.id.editTextPasswordToLogin);
        login=(Button)findViewById(R.id.buttonSignIn);
        Parse.initialize(this, "BfoASZEEga37GCCz1tAswP1Iv47pTbS6yABgSKnX", "dZq9ZqwLD4SV6DALqAbhG5mWrQBiGThUuU6Gw0oz");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> query = ParseQuery.getQuery("Login");
                query.orderByAscending("index");
                query.setLimit(200);
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> parseObjects, ParseException e) {
                        for(int i=0;i<parseObjects.size();i++) {
                            ParseObject parseObject = parseObjects.get(i);
                            if(nome.getText().toString().equals(parseObject.getString("Nome")) && pass.getText().toString().equals(parseObject.getString("Password"))){

                                Intent intent=new Intent(VerificaLog.this, HomePageActivity.class);
                                startActivity(intent);
                            }


                        }


                        nome.setText("Username e/o password errati");
                        pass.setText("");

                    }
                });
            }
        });

    }
}
