package com.example.udbhav.cyclerental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class Hours extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hours);

        final Button bthours = (Button)findViewById(R.id.bthours);
        Bundle b = getIntent().getExtras();
        //final String username = b.getString("username");

        final NumberPicker numberPicker = (NumberPicker)findViewById(R.id.numberPicker);
        numberPicker.setMaxValue(100);
        numberPicker.setMinValue(0);
        numberPicker.setWrapSelectorWheel(false);
        Log.d("udbhav", "in hours class");
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener(){
            @Override
            public void onValueChange(final NumberPicker picker, int oldVal, final int newVal) {
                bthours.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int val =  picker.getValue();
                        Intent intent = new Intent(Hours.this, MainActivity.class);
                        intent.putExtra("hours", val);
          //              intent.putExtra("username", username);
                        startActivity(intent);




                    }
                });
            }
        });

    }
}
