package com.mukreminbagci.next.caychthekany;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreText;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        sharedPreferences=this.getSharedPreferences("com.mukreminbagci.next.caychthekany", Context.MODE_PRIVATE);

        scoreText=(TextView)findViewById(R.id.scoreText);
        Intent i=getIntent();
        sharedPreferences.edit().putString("skorr",sharedPreferences.getString("skorr","")+"\n-"+i.getStringExtra("skor").toString()).apply();
        //scoreText.append("\na"+i.getStringExtra("skor").toString());
        scoreText.append(sharedPreferences.getString("skorr",""));
    }

    public void baslat(View view){
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}
