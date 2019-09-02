package com.stavros.chess.boards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.stavros.chess.R;
import com.stavros.chess.ResultsActivity;
import com.stavros.chess.logic.KnightTest;

public class ThirteenByThirteen extends AppCompatActivity {

    KnightTest knightTest = new KnightTest();
    TextView moves;
    public int boardSizeFromMainActivity;
    boolean startFlag = false;
    boolean endFlag = false;
    int[] start = new int[2];
    int[] target = new int[2];

    public static int checkHowManyTimesEnteredInStartAndEndCoords = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirteen_by_thirteen);
        checkHowManyTimesEnteredInStartAndEndCoords = 0;
        Intent mIntent = getIntent();

        boardSizeFromMainActivity = mIntent.getIntExtra("valueFromBoardSizeSpinner", 0);
    }

    public void startAndEndCoords(View v) {
        startFlag = true;
        String buttonText = (String) ((AppCompatButton) v).getText();
        String[] arrOfStr = buttonText.split(",");
        if (checkHowManyTimesEnteredInStartAndEndCoords == 0) {
            start[0] = Integer.parseInt(arrOfStr[0]);
            start[1] = Integer.parseInt(arrOfStr[1]);
            Toast.makeText(this, "Starting coords are : " + start[0] + "-" + start[1], Toast.LENGTH_SHORT).show();
        }
        if (checkHowManyTimesEnteredInStartAndEndCoords > 0) {
            target[0] = Integer.parseInt(arrOfStr[0]);
            target[1] = Integer.parseInt(arrOfStr[1]);
            Toast.makeText(this, "Target coords are : " + target[0] + "-" + target[1], Toast.LENGTH_SHORT).show();
            endFlag = true;
            checkStartOrTarget(startFlag, endFlag, start, target);
        }
        checkHowManyTimesEnteredInStartAndEndCoords++;

    }

    public String[] checkStartOrTarget(boolean startFlag, Boolean endFlag, int[] start, int[] target) {
        if (startFlag && endFlag) {
            String[] coordsReturn = knightTest.calculate(start, target, boardSizeFromMainActivity);
            Intent goToResult = new Intent(ThirteenByThirteen.this, ResultsActivity.class);
            goToResult.putExtra("resultsToPassToResultClass" , coordsReturn);
            goToResult.putExtra("start" , start);
            goToResult.putExtra("target" , target);
            startActivity(goToResult);
            return coordsReturn;
        }
        return null;
    }
}
