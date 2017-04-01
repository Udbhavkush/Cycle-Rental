package com.example.udbhav.cyclerental;

import android.database.Cursor;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
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
                R.drawable.p3,
                R.drawable.p4,
                R.drawable.p5,
                R.drawable.p6,
                R.drawable.p7,
                R.drawable.p8,
        };


        TextView tvname = (TextView)findViewById(R.id.tvname);
        TextView tvdesc = (TextView)findViewById(R.id.tvdesc);
        TextView tvrent = (TextView)findViewById(R.id.tvrent);

        Bundle bundle = getIntent().getExtras();
        String cid = bundle.getString("id");
        info.open();
        String name = info.getName(cid);
        String desc = info.getDescription(cid);
        String rent = "" + info.getRent(cid);
        info.close();
        tvname.setText(name);
        tvdesc.setText(desc);
        tvrent.setText(rent);

         ImageView cycle_image = (ImageView) findViewById(R.id.img);
         int check_img = 0;
         check_img = Integer.parseInt(cid);
         cycle_image.setImageResource(imgid[check_img]);




    }
}
