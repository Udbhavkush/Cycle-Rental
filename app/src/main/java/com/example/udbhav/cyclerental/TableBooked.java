package com.example.udbhav.cyclerental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TableBooked extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_booked);
        final String username = "udk";
        TextView tvtable = (TextView)findViewById(R.id.tvtable);
        Button btdelete = (Button) findViewById(R.id.btdelete);
        final CycleDatabase cd = new CycleDatabase(TableBooked.this);
        cd.open();
        String check = cd.getContent();

        btdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cd.open();
                cd.delete();
                Intent i = new Intent(TableBooked.this, Hours.class);
                i.putExtra("username", username);
                startActivity(i);
            }
        });
        cd.close();

        tvtable.setText(check);
    }
}
