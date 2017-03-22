package com.example.udbhav.cyclerental;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by udbhav on 22/3/17.
 */

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://expensemanager.pe.hu/Register.php";
    private Map<String, String> params;
    private String Tag = "com.example.udbhav";

    RegisterRequest(String name,String username, String email, String password, Response.Listener<String> listener){
        super(Request.Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("username", username);
        params.put("email", email);
        params.put("password", password);
        Log.i(Tag,"4");
    }

    @Override
    public Map<String, String> getParams() {
        Log.i(Tag,"4.1");
        return params;
    }
}
