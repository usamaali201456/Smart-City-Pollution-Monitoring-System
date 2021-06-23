package com.example.smd_assignment3_question1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Graph extends AppCompatActivity {
    RequestQueue mrequest_queue;
    List<Integer> readings=new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        final GraphView graph = (GraphView) findViewById(R.id.graph);
        mrequest_queue= Volley.newRequestQueue(this);
        Jsonparse();
        try {
            int k=1;
            for(int i=5 ; i<=10; i++)
            {
                LineGraphSeries < DataPoint > series = new LineGraphSeries< >(new DataPoint[] {
                        new DataPoint(i,readings.get(k))
                });
                graph.addSeries(series);
                k++;
            }


        } catch (IllegalArgumentException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
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
                            for(int i=0 ; i<jsonArray.length();i++)
                            {
                            JSONObject data=jsonArray.getJSONObject(i);
                             String field1=data.getString("field1");
                             readings.add(Integer.valueOf(field1));

                            }
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
}
