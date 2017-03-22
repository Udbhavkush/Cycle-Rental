package com.example.udbhav.cyclerental;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity {

    String Tag = "com.example.udbhav";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etname = (EditText)findViewById(R.id.etname);
        final EditText etusername = (EditText)findViewById(R.id.etusername);
        final EditText etemail = (EditText)findViewById(R.id.etemail);
        final EditText etpassword = (EditText)findViewById(R.id.etpassword);

        final Button btreg = (Button)findViewById(R.id.btreg);


        btreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name = etname.getText().toString();
                final String username = etusername.getText().toString();
                final String email = etemail.getText().toString();
                final String password = etpassword.getText().toString();

                if(TextUtils.isEmpty(name)) {
                    etname.setError("Name can not be empty");
                    return;
                }
                if(TextUtils.isEmpty(name)) {
                    etusername.setError("Username can not be empty");
                    return;
                }
                if(TextUtils.isEmpty(email)) {
                    etemail.setError("Email can not be empty");
                    return;
                }

                if(TextUtils.isEmpty(password)) {
                    etpassword.setError("Password is must");
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.i(Tag,"["+response+"]");
                            JSONObject jsonResponse = new JSONObject(response);
                            Log.i(Tag,"1");
                            boolean success = jsonResponse.getBoolean("success");
                            Log.i(Tag,"2");
                            if(success){
                                Log.i(Tag,"inside listener");
                                Intent intent = new Intent(Register.this, Login.class);
                                Register.this.startActivity(intent);
                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                                builder.setMessage("Register failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.i(Tag,"2.1");
                    }
                };
                Log.i(Tag,"3");
                RegisterRequest registerRequest = new RegisterRequest(name,username, email, password, responseListener);
                Log.i(Tag,"3.1");
                RequestQueue queue = Volley.newRequestQueue(Register.this);
                Log.i(Tag,"3.2");
                queue.add(registerRequest);
                Log.i(Tag,"3.3");

            }
        });
    }
}
