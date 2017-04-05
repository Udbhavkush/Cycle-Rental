package com.example.udbhav.cyclerental;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

        CycleDatabase cd = new CycleDatabase(MainActivity.this);


        cd.open();
        for(int i=0; i<imgid.length; i++) {
            cd.createEntry(cid[i], itemname[i], desc[i], rent[i]);
        }
        cd.close();

        CustomAdapter adapter=new CustomAdapter(this, itemname, desc, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                //if(position == cid.length-1)
                  //  position--;
                Intent i = new Intent(MainActivity.this, CycleBook.class);
                i.putExtra("id", cid[position]);
                startActivity(i);
                //String Selecteditem= itemname[+position];
                //Toast.makeText(getApplicationContext(), Selecteditem, Toast.LENGTH_SHORT).show();

            }
        });


    }
}