package com.example.udbhav.cyclerental;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity{

    ListView list;
    String[] itemname ={
            "Roadster",
            "Ladybird",
            "Kiddo 447",
            "Turbodrive MTB",
            "CMX",
            "Ranger MTB",
            "Roadeo",
            "Atlas"
    };
    String[] desc ={
            "A cycle with 18 gears most preferable by mountaineers",
            "A pretty pink cycle for the ladies who love cycling",
            "A sports bike for the young enthusiasts in a very affordable price",
            "An advanced cycle particularly for the speed lovers",
            "The twin of BMX for the cycle stunts lover",
            "Another cycle for the young generation",
            "A sporty bike for the girls with the front carriage",
            "A basic model for day to day use"
    };
    
    String[] cid={"1","2","3","4","5","6","7","8"};
    Integer[] rent={82,45,38,105,75,30,54,28};
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final CycleDatabase cd = new CycleDatabase(MainActivity.this);

        Bundle bundle = getIntent().getExtras();
        final String username = bundle.getString("username");
        Log.d("udk", username);
        final int hour1 = bundle.getInt("hours");
        cd.open();
        Log.d("udbhav", "before insertion");
        for(int i=0; i<imgid.length; i++) {
            if(cd.count(cid[i])){
                cd.createEntry(cid[i], itemname[i], desc[i], rent[i]);
            }

        }

        //cd.createEntry2("2", "cycle", "udbhav");
        Log.d("udbhav", "after insertion to table 1");
       // if(cd.count1("87"))
         //   cd.createEntry2("87", "cycle", "udbhav");


        cd.close();
        //CycleDatabase ab = new CycleDatabase(MainActivity.this);
        //ab.open();

        //ab.close();

        CustomAdapter adapter=new CustomAdapter(this, itemname, rent, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);




        Log.d("Udbhav", "before set button");
        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                //if(position == cid.length-1)
                  //  position--;
                Log.d("udbhav", "onItemClick: ");
                Intent i = new Intent(MainActivity.this, CycleBook.class);
                i.putExtra("id", cid[position]);
                i.putExtra("hour1", hour1);
                cd.open();
                if(cd.count1(cid[position]))
                cd.createEntry2(cid[position], itemname[position], username);

                cd.close();
                Log.d("udbhav", "starting activity");
                i.putExtra("username", username);
                startActivity(i);
                //String Selecteditem= itemname[+position];
                //Toast.makeText(getApplicationContext(), Selecteditem, Toast.LENGTH_SHORT).show();

            }
        });


    }
}