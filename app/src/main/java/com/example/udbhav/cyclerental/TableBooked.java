package com.example.udbhav.cyclerental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class TableBooked extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_booked);

        TextView tvtable = (TextView)findViewById(R.id.tvtable);
        CycleDatabase cd = new CycleDatabase(TableBooked.this);
        cd.open();
        String check = cd.getContent();
        cd.open();

        tvtable.setText(check);
    }
}
