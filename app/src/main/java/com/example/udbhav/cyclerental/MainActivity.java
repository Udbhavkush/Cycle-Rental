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
            "Cycle1",
            "Cycle2",
            "Cycle3",
            "Cycle4",
            "Cycle5",
            "Cycle6",
            "Cycle7",
            "Cycle8"
    };
    String[] desc ={
            "Description of Cycle1",
            "Description of Cycle2",
            "Description of Cycle3",
            "Description of Cycle4",
            "Description of Cycle5",
            "Description of Cycle6",
            "Description of Cycle7",
            "Description of Cycle8"
    };
    String[] cid={"1","2","3","4","5","6","7","8"};
    Integer[] rent={1,2,3,4,5,6,7,8};
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

        CustomAdapter adapter=new CustomAdapter(this, itemname, desc, imgid);
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