package com.example.udbhav.cyclerental;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by udbhav on 22/3/17.
 */

public class LoginRequest extends StringRequest {
    private static final String login_request_url = "http://expensemanager.pe.hu/Login.php";
    private Map<String, String> params;
    LoginRequest(String username, String password, Response.Listener<String> listener) {
        super(Method.POST, login_request_url, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}

