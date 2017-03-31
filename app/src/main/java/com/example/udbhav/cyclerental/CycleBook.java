package com.example.udbhav.cyclerental;

import android.database.Cursor;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;

import org.w3c.dom.Text;

public class CycleBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle_book);

        CycleDatabase info;
        info = new CycleDatabase(CycleBook.this);


        Integer[] imgid={
                R.drawable.p1,
                R.drawable.p2,
                R.drawable.p1,
                R.drawable.p2,
                R.drawable.p1,
                R.drawable.p2,
                R.drawable.p1,
                R.drawable.p2,
        };


        TextView tvname = (TextView)findViewById(R.id.tvname);
        TextView tvdesc = (TextView)findViewById(R.id.tvdesc);
        TextView tvrent = (TextView)findViewById(R.id.tvrent);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("Name");
        info.open();
        String desc = info.getDescription(name);
        String rent = "" + info.getRent(name);
        info.close();
        tvname.setText(name);
        tvdesc.setText(desc);
        tvrent.setText(rent);

    }
}
