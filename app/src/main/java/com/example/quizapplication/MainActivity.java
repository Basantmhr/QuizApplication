package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CardView cardViewChemistry,cardViewPhysics,cardViewHistory,cardViewBiology;
    private TextView section1 ,section2 , section3 , section4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        section1=findViewById(R.id.section1);
        section2=findViewById(R.id.section2);
        section3=findViewById(R.id.section3);
        section4=findViewById(R.id.section4);

        cardViewChemistry=findViewById(R.id.cardViewChemistry);
        cardViewPhysics=findViewById(R.id.cardViewPhysics);
        cardViewBiology=findViewById(R.id.cardViewBiology);
        cardViewHistory=findViewById(R.id.cardViewHistory);

        cardViewChemistry.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                Intent changeQuestion = new Intent(MainActivity.this , questionScreen.class);
                changeQuestion.putExtra("SectionName",section1.getText().toString());
                startActivity(changeQuestion);
            }
        });
        cardViewPhysics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent changeQuestion = new Intent(MainActivity.this , questionScreen.class);
                changeQuestion.putExtra("SectionName",section2.getText().toString());
                startActivity(changeQuestion);
            }
        });
        cardViewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent changeQuestion = new Intent(MainActivity.this , questionScreen.class);
                changeQuestion.putExtra("SectionName",section3.getText().toString());
                startActivity(changeQuestion);
            }
        });
        cardViewBiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent changeQuestion = new Intent(MainActivity.this , questionScreen.class);
                changeQuestion.putExtra("SectionName",section4.getText().toString());
                startActivity(changeQuestion);
            }
        });

   }
}
