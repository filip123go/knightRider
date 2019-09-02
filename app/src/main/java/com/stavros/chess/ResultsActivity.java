package com.stavros.chess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsActivity extends AppCompatActivity {

    TextView tableResults;
    TextView chessTableResults;
    TextView startText;
    TextView targetText;
    int[] start = new int[2];
    int[] target = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent boardIntent = getIntent();

        String[] results = boardIntent.getStringArrayExtra("resultsToPassToResultClass");
        start = boardIntent.getIntArrayExtra("start");
        target = boardIntent.getIntArrayExtra("target");


        tableResults = findViewById(R.id.tableResults);
        chessTableResults = findViewById(R.id.chessTableResults);
        startText = findViewById(R.id.startTextView);
        targetText = findViewById(R.id.targetTextView);

        String FinalStringStart = "Start :" + start[0] + " - " + start[1];
        String FinalStringTarget = "Target :" + target[0] + " - " + target[1];

        startText.setText(FinalStringStart);
        targetText.setText(FinalStringTarget);
        tableResults.setText(results[0]);
        chessTableResults.setText(results[1]);

        if (start[0] == target[0] && start[1] == target[1]) {
            String errorText = "The starting point cannot be the same with the target point. Please Play Again.";
            tableResults.setText(errorText);
        }
    }
    public void resetGame(View v) {

        Intent ResetGame = new Intent(ResultsActivity.this, MainActivity.class);
        ResetGame.putExtra("ResetCheckHowManyTimesEnteredInStartAndEndCoords", 0);
        startActivity(ResetGame);
        Toast.makeText(this, "Resetting board , please wait", Toast.LENGTH_SHORT).show();
    }
}
