package com.example.kiaramcnulty.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = "MainActivity";

    Intent intent;
    Button buttonGetStats;
    TextView textStat;
    Button buttonEnter;
    ArrayList<player> listOfPlayers;
    boolean reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listOfPlayers = new ArrayList<player>();

        reset = true;
        Bundle bundle = getIntent().getExtras();
        if( bundle != null){
            reset = bundle.getBoolean("reset");
        }

        if (reset)
        {
            listOfPlayers = new ArrayList<player>();
        }
        else
        {
            listOfPlayers = (ArrayList<player>)getIntent().getSerializableExtra("list");
        }


        intent = new Intent(MainActivity.this, Main2Activity.class);
        buttonGetStats = (Button)findViewById(R.id.btnGetStats);
        textStat = (TextView)findViewById(R.id.etStat);
        buttonEnter = (Button)findViewById(R.id.btnEnter);

        buttonGetStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("list", (Serializable) listOfPlayers);
                //intent.putParcelableArrayListExtra("list", listOfPlayers);
                startActivity(intent);
            }
        });

        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stat = textStat.getText().toString();
                Log.v(TAG, stat);
                //player myPlayer = new player(stat);

                String[] statsRaw = stat.split("");

                String[] stats = new String[statsRaw.length-1];


                for (int i = 1; i < statsRaw.length; i++)
                {
                    stats[i-1] = statsRaw[i];
                }

                //stats[0] = statsRaw[1];
                //stats[1] = statsRaw[2];
                //stats[2] = statsRaw[3];

                //Log.v(TAG, "stats " + stats[0] + stats[1] + stats[2]);
                String p = null;
                String n = null;
                String h = null;
                String t = null;
                if (stats.length >= 1)
                {
                    p = stats[0];
                }
                if (stats.length >= 2)
                {
                    n = stats[1];
                }
                if (stats.length >= 3)
                {
                    h = stats[2];
                }
                if (stats.length >= 4)
                {
                    t = stats[3];
                }

                boolean added = false;
                int currentSize = listOfPlayers.size();

                for (int i = 0; i < currentSize; i++)
                {
                    if (listOfPlayers.get(i).getName().equals(n))
                    {
                        listOfPlayers.get(i).addStats(p, h, t);
                        added = true;
                    }
                }
                if (!added)
                {
                    listOfPlayers.add(new player(n));
                    listOfPlayers.get(currentSize).addStats(p, h, t);
                }
                Log.v(TAG, "Hi!" + listOfPlayers.get(0).getServeAtt());
                Log.v(TAG, "p " + p);
                Log.v(TAG, "n " + n);
                Log.v(TAG, "h " + h);
                Log.v(TAG, "t " + t);
                textStat.setText(String.valueOf(""));
            }
        });

    }

}
