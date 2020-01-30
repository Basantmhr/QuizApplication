package com.example.quizapplication;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class questionScreen extends AppCompatActivity implements View.OnClickListener {
    private TextView questionText, correctAns, wrongAns ,sectionName, counterText;
    private Button option1, option2, option3, option4;
    private String ansString;
    private CountDownTimer var;
    private int correctSum = 0, wrongSum = 0, globalIndex = 0;
    ArrayList<questionClass> questionArrayChemistry = new ArrayList<>();
    ArrayList<questionClass> questionArrayPhysics = new ArrayList<>();
    ArrayList<questionClass> questionArrayHistory = new ArrayList<>();
    ArrayList<questionClass> questionArrayBiology = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_screen);
        questionText = findViewById(R.id.questionView);
        correctAns = findViewById(R.id.correctAnsText);
        wrongAns = findViewById(R.id.wrongAnsText);
        sectionName=findViewById(R.id.sectionNameId);
        option1 = findViewById(R.id.optionOne);
        option2 = findViewById(R.id.optionTwo);
        option3 = findViewById(R.id.optionThree);
        option4 = findViewById(R.id.optionFour);
        counterText=findViewById(R.id.counterReal);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);
        //Chemistry Question ArrayList
        questionArrayChemistry.add(new questionClass("Who is regarded as father of modern chemistry ?", "Ruterford", "Einstein", "Lavoisier", " C.V. Raman", "Lavoisier"));
        questionArrayChemistry.add(new questionClass("Which is not a type of elements ?", "Metal", "Non Metals", "Metalloids", "Gases", "Gases"));
        questionArrayChemistry.add(new questionClass("Which acid is present in lemon ?", "Marlic acid", "Citric acid", "Lactic acid", "Tartaric acid", "Citric acid"));
        questionArrayChemistry.add(new questionClass("Rare gases are", "Mono atomic", "Di atomic", "Tri atomic", " None of above", "Mono atomic"));
        questionArrayChemistry.add(new questionClass("The term PVC used in the plastic industry stands for", "Polyvinyl chloride", "Polyvinyl carbobate", "Phosphor vanadiu chloride", "Phosphavinyl chloride", "Polyvinyl chloride"));
        questionArrayChemistry.add(new questionClass("What among following is used to produce artificial rain ?", "Copper oxide", "Carbon monoxide", "Silver iodide", "Silver nitrate", "Silver iodide"));

        //Physics Question ArrayList
        questionArrayPhysics.add(new questionClass("Which instrument is used to measure altitudes in aircraft's ?", "Audiometer", "Ammeter", "Altimeter", "Anemometer", "Altimeter"));
        questionArrayPhysics.add(new questionClass("Radian is used to measure?", "Temperature", "Intensity of Flame", "Angle", "Solid Angle", "Angle"));
        questionArrayPhysics.add(new questionClass("What is unit of Viscosity ?", "Coulomb", "Newton second per square meter", "Watt per meter per degree celcius", "Joule per kilogram per Kelvin", "Newton second per square meter"));
        questionArrayPhysics.add(new questionClass("Force of attraction between the molecules of different substances is called", "Surface tension", "Cohensive force", "Adhesive force", "None of above", "Adhesive force"));
        questionArrayPhysics.add(new questionClass("What is the maximum value of deforming force upto which a material shows elastic property and above which the material loses it ?", "Elasticity", "Strain", "Elastic Limit", "Stress", "Elastic Limit"));

        //History Question ArrayList
        questionArrayHistory.add(new questionClass("What was the time period of Indus Civilization / Harappan Civilization ?", "2400 BC - 1700 BC", "2400 BC - 1750 BC", "2500 BC - 1700 BC", "2500 BC - 1750 BC", "2500 BC - 1750 BC"));
        questionArrayHistory.add(new questionClass("Which was the largest site of Indus Civilization ?", "Dholavira", "Mohenjodaro", "Lothal", "Chanhudaro", "Mohenjodaro"));
        questionArrayHistory.add(new questionClass("Pali Texts are associated with ?", "Hiduism", "Budhhaism", "Islam", "Jews", "Budhhaism"));
        questionArrayHistory.add(new questionClass("The Red Fort was built by :", "Akbar", "Shahjhan", "Jahangir", "Sher Shah", "Shahjhan"));
        questionArrayHistory.add(new questionClass("Which one of the following began with the Dandi March ?", "Home rule Movement", "Non-Cooperation Movement", "Civil disobedience Movement", "Quit India Movement", "Civil disobedience Movemen"));

        //GK Question ArrayList
        questionArrayBiology.add(new questionClass("What is Pollination ?", "Germination of pollen grains", "Growth of pollen tube in ovule", "Transfer of pollen from anther to stigma", "Visiting flowers by insects", "Transfer of pollen from anther to stigma"));
        questionArrayBiology.add(new questionClass("What is movement of cell against concentration gradient is called", "Osmosis", "Active transport", "Diffusion", "Passive transport", "Active transport"));
        questionArrayBiology.add(new questionClass("Which of the following is a skin disease ?", "Rickets", "Osteomalacia", "Anaemia", "Pellagra", "Pellagra"));
        questionArrayBiology.add(new questionClass("Which one of the following is an enzyme ?", "Somatotropin", "Trypsin", "Glucagon", "Insulin", "Trypsin"));
        questionArrayBiology.add(new questionClass("The deficiency of which of the following leads to dental caries ?", "Iron", "Fluorine", "Copper", "Zinc", "Fluorine"));

        //Changing Section Name
        sectionName.setText(getIntent().getStringExtra("SectionName"));
        gettingIntent();

    }

    @Override
    public void onClick(View view) {
        var.cancel();
        switch (view.getId()) {

            case R.id.optionOne:
                if (option1.getText().toString().equals(ansString)) {
                    correctSum = correctSum + 1;
                    correctAns.setText("Correct: " + correctSum);
                    option1.setBackground(getDrawable(R.drawable.drawabletruebutton));
                    sleeping();

                } else {
                    wrongSum = wrongSum + 1;
                    wrongAns.setText("Wrong: " + wrongSum);
                    option1.setBackground(getDrawable(R.drawable.drawablefalsebutton));
                    sleeping();
                }
                break;
            case R.id.optionTwo:
                if (option2.getText().toString().equals(ansString)) {
                    correctSum = correctSum + 1;
                    correctAns.setText("Correct: " + correctSum);
                    option2.setBackground(getDrawable(R.drawable.drawabletruebutton));
                    sleeping();

                } else {
                    wrongSum = wrongSum + 1;
                    wrongAns.setText("Wrong: " + wrongSum);
                    option2.setBackground(getDrawable(R.drawable.drawablefalsebutton));
                    sleeping();

                }
                break;
            case R.id.optionThree:
                if (option3.getText().toString().equals(ansString)) {
                    correctSum = correctSum + 1;
                    correctAns.setText("Correct: " + correctSum);
                    option3.setBackground(getDrawable(R.drawable.drawabletruebutton));
                    sleeping();

                } else {
                    wrongSum = wrongSum + 1;
                    wrongAns.setText("Wrong: " + wrongSum);
                    option3.setBackground(getDrawable(R.drawable.drawablefalsebutton));
                    sleeping();
                }
                break;
            case R.id.optionFour:
                if (option4.getText().toString().equals(ansString)) {
                    correctSum = correctSum + 1;
                    correctAns.setText("Correct: " + correctSum);
                    option4.setBackground(getDrawable(R.drawable.drawabletruebutton));
                    sleeping();
                } else {
                    wrongSum = wrongSum + 1;
                    wrongAns.setText("Wrong: " + wrongSum);
                    option4.setBackground(getDrawable(R.drawable.drawablefalsebutton));
                    sleeping();
                }
                break;


        }
    }
    void gettingIntent()
    {
        if ((getIntent().getStringExtra("SectionName")).equals("Chemistry")) {

            changeQuestion(questionArrayChemistry);
        }
        if ((getIntent().getStringExtra("SectionName")).equals("Physics")) {

            changeQuestion(questionArrayPhysics);
        }
        if ((getIntent().getStringExtra("SectionName")).equals("History")) {
            changeQuestion(questionArrayHistory);
        }
        if ((getIntent().getStringExtra("SectionName")).equals("Biology")) {
            changeQuestion(questionArrayBiology);
        }
    }

    void changeQuestion(ArrayList<questionClass> ql) {
        option1.setBackground(getDrawable(R.drawable.curvedbutton));
        option2.setBackground(getDrawable(R.drawable.curvedbutton));
        option3.setBackground(getDrawable(R.drawable.curvedbutton));
        option4.setBackground(getDrawable(R.drawable.curvedbutton));
        if (globalIndex == ql.size()) {
            Intent completedQuiz = new Intent(questionScreen.this, completionScreen.class);
            Log.e("Score::", correctSum + "");
            completedQuiz.putExtra("score", correctSum + "");
            completedQuiz.putExtra("size",ql.size()+"");
            startActivity(completedQuiz);
            finish();

        } else {

            ansString = ql.get(globalIndex).getAns();
            questionText.setText(ql.get(globalIndex).getQuestion());
            option1.setText(ql.get(globalIndex).getOption1());
            option2.setText(ql.get(globalIndex).getOption2());
            option3.setText(ql.get(globalIndex).getOption3());
            option4.setText(ql.get(globalIndex).getOption4());
            counter();
            globalIndex++;
        }
    }
    void counter()
    {
        var= new CountDownTimer(30000,1000)
        { int count=30;

            @Override
            public void onTick(long l) {
                counterText.setText(String.valueOf(count));
                count--;
            }

            @Override
            public void onFinish() {
                wrongSum=wrongSum+1;
                wrongAns.setText("Wrong: " + wrongSum);
               gettingIntent();
            }

        }.start();
    }
    void sleeping()
    {

        Handler hm = new Handler();
        hm.postDelayed(new Runnable() {
            @Override
            public void run() {
                gettingIntent();
            }
        },500);
    }
}
