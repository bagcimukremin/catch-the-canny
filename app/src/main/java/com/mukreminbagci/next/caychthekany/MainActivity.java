package com.mukreminbagci.next.caychthekany;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView timeText,scoreText;
    ImageView imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10;
    int skor,zaman;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    int skorKontrol=0;
    Button button,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView =(ImageView) findViewById(R.id.imageView);
        imageView2 =(ImageView) findViewById(R.id.imageView2);
        imageView3 =(ImageView) findViewById(R.id.imageView3);
        imageView4 =(ImageView) findViewById(R.id.imageView4);
        imageView5 =(ImageView) findViewById(R.id.imageView5);
        imageView6 =(ImageView) findViewById(R.id.imageView6);
        imageView7 =(ImageView) findViewById(R.id.imageView7);
        imageView8 =(ImageView) findViewById(R.id.imageView8);
        imageView9 =(ImageView) findViewById(R.id.imageView9);
        imageView10 =(ImageView) findViewById(R.id.imageView10);
        button=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);
        imageArray =new ImageView[]{imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};
        hideImages();
        skor=0;
        timeText=(TextView) findViewById(R.id.timeText);
        say();

    }

    public void skorArt(View view){
        if(skorKontrol==0) {
            scoreText = (TextView) findViewById(R.id.scoreText);
            skor++;
            scoreText.setText("Score: " + skor);
            skorKontrol=1;
        }

    }
    public void say(){
        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long l) {

                timeText.setText("Time: "+ l/1000);
            }

            @Override
            public void onFinish() {
                timeText.setText("Time's Off");
                handler.removeCallbacks(runnable);
                for (ImageView i:imageArray){
                    i.setVisibility(View.INVISIBLE);
                }
                imageView10.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);

            }
        }.start();
    }
    public void baslat(View view){
        skor=0;
        imageView10.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);
        hideImages();
        say();

    }

    public void skorOn(View view){
        Intent intent=new Intent(getApplicationContext(),ScoreActivity.class);
        intent.putExtra("skor"," "+skor);
        startActivity(intent);
    }
    public void hideImages(){

        handler =new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for (ImageView image:imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random=new Random();
                int r=random.nextInt(9);
                imageArray[r].setVisibility(View.VISIBLE);
                skorKontrol=0;
                handler.postDelayed(this,2000);
            }
        };

        handler.post(runnable);

    }
}
