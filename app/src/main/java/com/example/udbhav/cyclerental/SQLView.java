package com.example.udbhav.cyclerental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SQLView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlview);

        TextView tvsqlinfo = (TextView)findViewById(R.id.tvsqlinfo);

        CycleDatabase info = new CycleDatabase(this);
        info.open();
        String data = info.getData();
        info.close();
        tvsqlinfo.setText(data);
    }
}
