package com.example.kiaramcnulty.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {


    public final static String TAG = "Main2Activity";
    Intent intentBack;
    Button buttonBack;
    Button buttonReset;
    TextView txtDisplay;
    ArrayList<player> listOfPlayers;
    boolean reset;
    //private static final String LIST = "list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //ArrayList<player> listOfPlayers = (ArrayList<player>)getIntent().getExtras().get("list");
        //ArrayList<player> listOfPlayers = (ArrayList<player>)getIntent().getExtras();
        listOfPlayers = (ArrayList<player>)getIntent().getSerializableExtra("list");
        intentBack = new Intent(Main2Activity.this, MainActivity.class);
        buttonBack = (Button)findViewById(R.id.btnBack);
        buttonReset = (Button)findViewById(R.id.btnReset);
        txtDisplay = (TextView)findViewById(R.id.tvDisplay);

        int totalServeHits = 0;
        int totalServeAtt = 0;
        int totalTransHits = 0;
        int totalTransAtt = 0;
        int totalBlockErr = 0;
        int totalHitErr = 0;
        int totalWashPoints = 0;
        int totalWashTotal = 0;

        for (player p : listOfPlayers)
        {
            totalServeHits += p.getServeHits();
            totalServeAtt += p.getServeAtt();
            totalTransHits += p.getTransHits();
            totalTransAtt += p.getTransAtt();
            totalBlockErr += p.getBlockErr();
            totalHitErr += p.getHitErr();
            totalWashPoints += p.getWashPoints();
            totalWashTotal += p.getWashTotal();
        }

        Log.v(TAG, "Hi!" + listOfPlayers.get(0).getServeAtt());

        txtDisplay.setText(
                "Team Hitting %: " + (int)(1000*((totalServeHits+totalTransHits)/(double)(totalServeAtt + totalTransAtt)))/(double)1000 +
                "\nTeam Hitting % S/R: " + (int)(1000*(totalServeHits/(double)totalServeAtt))/(double)1000 +
                "\nHitting % Trans: " + (int)(1000*(totalTransHits/(double)totalTransAtt))/(double)1000 +
                        "\n% of Team Errors by block: " + (int)(1000*(totalBlockErr/(double)(totalBlockErr + totalHitErr)))/(double)1000 +
                        "\n% of Team Errors by hit: " + (int)(1000*(totalHitErr/(double)(totalBlockErr + totalHitErr)))/(double)1000 +
                        "\nTeam Wash %: " + (int)(1000*(totalWashPoints/(double)totalWashTotal))/(double)1000);

        for(player p : listOfPlayers)
        {
            txtDisplay.setText(txtDisplay.getText().toString() + "\n\n" + p.toString());
        }

        reset = true;

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset = false;
                intentBack.putExtra("reset", reset);
                intentBack.putExtra("list", (Serializable) listOfPlayers);
                startActivity(intentBack);
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentBack.putExtra("reset", reset);
                startActivity(intentBack);
            }
        });


    }
}
