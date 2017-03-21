package com.example.udbhav.cyclerental;

import android.content.Intent;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etusername = (EditText) findViewById(R.id.etusername);
        final EditText etpassword = (EditText) findViewById(R.id.etpassword);
        final Button btlogin = (Button) findViewById(R.id.btlogin);
        final TextView tvregister = (TextView) findViewById(R.id.tvregister);

        tvregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent = new Intent(Login.this, Register.class);
                Login.this.startActivity(regIntent);
            }
        });

    }
}
