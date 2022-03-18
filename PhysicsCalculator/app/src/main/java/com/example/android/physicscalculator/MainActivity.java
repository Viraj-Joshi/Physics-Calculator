package com.example.android.physicscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView oneD = (TextView) findViewById(R.id.OneDM);  //OneD Click Listener

        oneD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oneDIntent = new Intent(MainActivity.this, OneDActivity.class);
                startActivity(oneDIntent);
            }
        });

        TextView TwoD = (TextView) findViewById(R.id.TwoDM);  //TwoD Click Listener

        TwoD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent twoDIntent = new Intent(MainActivity.this, TwoDActivity.class);
                startActivity(twoDIntent);
            }
        });

        TextView f = (TextView) findViewById(R.id.forces);  //Forces Click Listener

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent force = new Intent(MainActivity.this, ForcesActivity.class);
                startActivity(force);
            }
        });
    }
}
