package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewDice1;
    private ImageView imageViewDice2;
    private Random rng = new Random();
    private Button up_7;
    private Button down_7;
    Button button;
    Button playgame;
    LinearLayout aa;
    LinearLayout ja;
    int res=2;
    TextView tv;
    private Button playagain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playagain=findViewById(R.id.playagain);
        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res=2;
                aa.setVisibility(View.GONE);
                ja.setVisibility(View.VISIBLE);
            }
        });
        tv=findViewById(R.id.result);
        up_7=findViewById(R.id.up7);
        down_7=findViewById(R.id.down7);
        up_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res=1;

            }
        });
        down_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res=0;
            }
        });
        aa=findViewById(R.id.aoab);
        ja=findViewById(R.id.jaoab);
        playgame=findViewById(R.id.playgame);
        button= (Button)findViewById(R.id.btn);
        imageViewDice1 = findViewById(R.id.image_view_dice1);
        imageViewDice2 = findViewById(R.id.image_view_dice2);
        final TextView text = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
        playgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(res==2){
                    Toast.makeText(MainActivity.this,"please select one challenge",Toast.LENGTH_LONG).show();
                }
                else{
                    ja.setVisibility(View.GONE);
                    aa.setVisibility(View.VISIBLE);
                }

            }
        });



//        imageViewDice1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                rollDice();
//            }
//        });

//        imageViewDice2 = findViewById(R.id.image_view_dice2);
////        final TextView text = (TextView) findViewById(R.id.textView);
//        imageViewDice2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                rollDice();
//            }
//        });
//
        
    }

    public void rollDice() {

        final TextView text = (TextView) findViewById(R.id.textView);
        int randomNumber1 = rng.nextInt(6) + 1;
        int randomNumber2 = rng.nextInt(6) + 1;
        int randomNumber = randomNumber1 + randomNumber2;
        text.setText(new StringBuilder().append(randomNumber));
        if(res==0){
            if(randomNumber>7){
                tv.setText("you lose");
            }
            else{
                tv.setText("you win");
            }
        }
        if(res==1){
            if(randomNumber<7){
                tv.setText("you lose");
            }
            else{
                tv.setText("you win");
            }
        }
        switch (randomNumber1) {
            case 1:
                imageViewDice1.setImageResource(R.drawable.dice1);
                break;
            case 2:
                imageViewDice1.setImageResource(R.drawable.dice2);
                break;
            case 3:
                imageViewDice1.setImageResource(R.drawable.dice3);
                break;
            case 4:
                imageViewDice1.setImageResource(R.drawable.dice4);
                break;
            case 5:
                imageViewDice1.setImageResource(R.drawable.dice5);
                break;
            case 6:
                imageViewDice1.setImageResource(R.drawable.dice6);
                break;
        }

        switch (randomNumber2) {
            case 1:
                imageViewDice2.setImageResource(R.drawable.dice1);
                break;
            case 2:
                imageViewDice2.setImageResource(R.drawable.dice2);
                break;
            case 3:
                imageViewDice2.setImageResource(R.drawable.dice3);
                break;
            case 4:
                imageViewDice2.setImageResource(R.drawable.dice4);
                break;
            case 5:
                imageViewDice2.setImageResource(R.drawable.dice5);
                break;
            case 6:
                imageViewDice2.setImageResource(R.drawable.dice6);
                break;
        }

    }

    }
