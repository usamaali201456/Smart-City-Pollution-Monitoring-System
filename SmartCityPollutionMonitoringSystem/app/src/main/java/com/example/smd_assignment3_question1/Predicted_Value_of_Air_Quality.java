package com.example.smd_assignment3_question1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Predicted_Value_of_Air_Quality extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predicted__value_of__air__quality);
        final GraphView graph = (GraphView) findViewById(R.id.graph);

        try {
            LineGraphSeries<DataPoint> series = new LineGraphSeries< >(new DataPoint[] {
                    new DataPoint(5, 245),
                    new DataPoint(6,295),
                    new DataPoint(7,235),
                    new DataPoint(8,299),
                    new DataPoint(9,265)
            });
            graph.addSeries(series);
        } catch (IllegalArgumentException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
