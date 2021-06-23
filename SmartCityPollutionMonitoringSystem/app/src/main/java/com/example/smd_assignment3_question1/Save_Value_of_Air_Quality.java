package com.example.smd_assignment3_question1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Save_Value_of_Air_Quality extends AppCompatActivity {


    public static final String sharedPreference="MysharedPref";
    public static final String air_quality_reading="Air";
    public static final String air_time="time";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save__value_of__air__quality);
        Intent intent=getIntent();
        final String air_quality=intent.getStringExtra("Current_air_value");
        final String time=intent.getStringExtra("time");
        TextView textView=(TextView)findViewById(R.id.textView15);
        textView.setText(air_quality +" "+time);
        TextView textView1=(TextView)findViewById(R.id.textView20);
        SharedPreferences sharedPreferences=getSharedPreferences(sharedPreference,MODE_PRIVATE);
        String aaa=sharedPreferences.getString(air_quality_reading,"");
        String bbb=sharedPreferences.getString(air_time,"");
        textView1.setText(aaa+"  "+bbb);









        Button save_value=(Button)findViewById(R.id.button2);
        save_value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences(sharedPreference,MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(air_quality_reading,air_quality);
                editor.putString(air_time,time);
                editor.apply();
                Toast.makeText(getApplicationContext(),"Saved Successfully",Toast.LENGTH_LONG).show();
                TextView textView1=(TextView)findViewById(R.id.textView20);
                textView1.setText(air_quality+" "+time);


            }
        });
    }
}
