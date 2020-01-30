package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class completionScreen extends AppCompatActivity {
    private TextView scoreView, congratAndTry, resultView, scoreWordView;
    private ImageView congratImageView , tryAgainImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completion_screen);
        Bundle b = getIntent().getExtras();
        String score = b.getString("score");
        String size = b.getString("size");
        scoreView = findViewById(R.id.scoreView);
        congratAndTry = findViewById(R.id.congratsAndTry);
        resultView = findViewById(R.id.taskResultView);
        scoreWordView = findViewById(R.id.scoreWordView);
        congratImageView=findViewById(R.id.congratImageView);
        tryAgainImageView=findViewById(R.id.tryImageView);
        // Toast.makeText(getApplicationContext(),"score"+Integer.parseInt(score),Toast.LENGTH_SHORT).show();
        Log.d("score", ": " + Integer.parseInt(size));
        int percentage = ((Integer.parseInt(score) * 100) / Integer.parseInt(size));
        scoreView.setText(percentage + " % Score");
        if (percentage <75) {
            congratAndTry.setText("Try Again!");
            resultView.setVisibility(View.GONE);
            congratImageView.setVisibility(View.INVISIBLE);
            tryAgainImageView.setVisibility(View.VISIBLE);

        }
        scoreWordView.setText("You attempt "+size+" questions and from that "+score+" answers is correct.");
    }
}
