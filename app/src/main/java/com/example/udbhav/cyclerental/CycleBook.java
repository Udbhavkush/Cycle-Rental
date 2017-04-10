package com.example.udbhav.cyclerental;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;

import org.w3c.dom.Text;

public class CycleBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle_book);
        Log.d("Udbhav", "inside cyclebook class");
        CycleDatabase info;
        info = new CycleDatabase(CycleBook.this);
        Bundle b = getIntent().getExtras();
        final String username = b.getString("username");

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
        Button btbook = (Button)findViewById(R.id.btbook);

        Bundle bundle = getIntent().getExtras();
        String cid = bundle.getString("id");
        int hours = bundle.getInt("hour1");

        Log.d("udbhav", "before laudamethod");

        info.open();
        info.initialise();
        String name = info.getName(cid);
        String desc = info.getDescription(cid);
        int irent = info.getRent(cid);
        String rent = "" + irent;
        String check = info.getName1(cid);
        info.close();
        tvname.setText(name);
        tvdesc.setText(desc);
        tvrent.setText(check);
        final int approx_rent = hours * irent;

         ImageView cycle_image = (ImageView) findViewById(R.id.img);
         int check_img = 0;
         check_img = Integer.parseInt(cid) - 1;
         cycle_image.setImageResource(imgid[check_img]);

        btbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_final = new Intent(CycleBook.this, Final.class);
                i_final.putExtra("finalRent", approx_rent);
                i_final.putExtra("username", username);
                startActivity(i_final);
            }
        });




    }
}
