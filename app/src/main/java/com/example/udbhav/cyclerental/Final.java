package com.example.udbhav.cyclerental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Final extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Button bttable = (Button)findViewById(R.id.bttable);
        TextView tvconfirm = (TextView)findViewById(R.id.tvconfirm);
        String final_message = "Your cycle has been booked successfully!";
        tvconfirm.setText(final_message);

        TextView tvappRent = (TextView)findViewById(R.id.tvappRent);
        Bundle b = getIntent().getExtras();
        final  String username = b.getString("username");
        String final_rent = "" + b.getInt("finalRent");
        String message = "Approximate rent will be Rs " + final_rent;



        tvappRent.setText(message);

        Button btback = (Button)findViewById(R.id.btback);

        bttable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Final.this, TableBooked.class);
                startActivity(i);
            }
        });

        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_back = new Intent(Final.this, Hours.class);
                i_back.putExtra("username", username);
                startActivity(i_back);
            }
        });

    }
}
