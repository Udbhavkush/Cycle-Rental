package com.example.udbhav.cyclerental;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity{

    ListView list;
    String[] itemname ={
            "Cycle1",
            "Cycle2",
            "Cycle1",
            "Cycle2",
            "Cycle1",
            "Cycle2",
            "Cycle1",
            "Cycle2"
    };

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomAdapter adapter=new CustomAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        
    }
}