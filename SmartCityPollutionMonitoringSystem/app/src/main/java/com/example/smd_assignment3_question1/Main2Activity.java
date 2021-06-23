package com.example.smd_assignment3_question1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {
    DrawerLayout drawerLayout ;
    boolean flag=false;
    Button onupdate ;
    TextView textView1 ;
    TextView airquality ;
    RequestQueue mrequest_queue;
    Toolbar toolbar ;
    ActionBarDrawerToggle actionBarDrawerToggle ;
    NavigationView navigationView ;
    TextView times ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setup();
        mrequest_queue= Volley.newRequestQueue(this);
        times=(TextView) findViewById(R.id.time) ;
        airquality=(TextView)findViewById(R.id.textView11);
        navigationView=(NavigationView) findViewById(R.id.navigationviews);
        onupdate=(Button)findViewById(R.id.onupdate);
        final String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
        times.setText(currentDateTimeString);

        textView1=(TextView)findViewById(R.id.textView11);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home:
                        Intent intent=new Intent(getApplicationContext(),Graph.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"Graph Opened",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.Rateus:
                        Intent intent1=new Intent(getApplicationContext(),Predicted_Value_of_Air_Quality.class);
                        startActivity(intent1);
                        Toast.makeText(getApplicationContext(),"Predicted Value of Air Quality Opened",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.savevalue:
                        String current_air_quality=airquality.getText().toString();
                        Intent intent2=new Intent(getApplicationContext(),Save_Value_of_Air_Quality.class);
                        intent2.putExtra("Current_air_value",current_air_quality);
                        intent2.putExtra("time",currentDateTimeString);
                        startActivity(intent2);
                        Toast.makeText(getApplicationContext(),"Predicted Value of Air Quality Opened",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.kumar:
                        Toast.makeText(getApplicationContext(),"Thanks",Toast.LENGTH_LONG).show();
                        break;
                    case  R.id.logout:
                        Intent intent3=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent3);
                        Toast.makeText(getApplicationContext(),"Successfully Logout",Toast.LENGTH_LONG).show();


                }

                return false;
            }
        });
    onupdate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Jsonparse();
        }
    });
    }
    private void Jsonparse()
    {
        String url="http://api.thingspeak.com/channels/1076583/fields/field1.json?results=&api_key=AIPQEIKJY1CS10XM";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray=response.getJSONArray("feeds");
                            int k=jsonArray.length();
                            k=k-1;
                            //for(int i=0 ; i<jsonArray.length();i++)
                            //{
                            JSONObject data=jsonArray.getJSONObject(k);
                            String field1=data.getString("field1");
                            airquality.setText(field1+" PPM ");
                            Toast.makeText(Main2Activity.this, "Air Quality Updated", Toast.LENGTH_SHORT).show();
                            //}
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mrequest_queue.add(request);
    }

    private void setup()
    {
        drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar= (Toolbar) findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();




    }
}
