package com.stavros.chess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.stavros.chess.boards.EightByEight;
import com.stavros.chess.boards.ElevenByEleven;
import com.stavros.chess.boards.FifteenByFifteen;
import com.stavros.chess.boards.FourteenByFourteen;
import com.stavros.chess.boards.NineByNine;
import com.stavros.chess.boards.SevenBySeven;
import com.stavros.chess.boards.SixBySix;
import com.stavros.chess.boards.SixteenBySixteen;
import com.stavros.chess.boards.TenByTen;
import com.stavros.chess.boards.ThirteenByThirteen;
import com.stavros.chess.boards.TwelveByTwelve;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner boardSizeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boardSizeSpinner = findViewById(R.id.boardSizeSpinner);
        ArrayAdapter<CharSequence> boardSizeAdapter = ArrayAdapter.createFromResource(this, R.array.boardSizeArray, android.R.layout.simple_spinner_item);
        boardSizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        boardSizeSpinner.setAdapter(boardSizeAdapter);

        boardSizeSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedText = adapterView.getItemAtPosition(i).toString();

        if (i == 0) {
            Toast.makeText(adapterView.getContext(), "Please choose a valid layout", Toast.LENGTH_SHORT).show();
        } else {
            int boardSize;
            switch (i) {
                case 1:
                    boardSize = 6;
                    Intent goToSixBySixIntent = new Intent(MainActivity.this, SixBySix.class);
                    goToSixBySixIntent.putExtra("valueFromBoardSizeSpinner", boardSize);
                    startActivity(goToSixBySixIntent);
                    Toast.makeText(adapterView.getContext(), selectedText, Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    boardSize = 7;
                    Intent goToSevenBySevenIntent = new Intent(MainActivity.this, SevenBySeven.class);
                    goToSevenBySevenIntent.putExtra("valueFromBoardSizeSpinner", boardSize);
                    startActivity(goToSevenBySevenIntent);
                    Toast.makeText(adapterView.getContext(), selectedText, Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    boardSize = 8;
                    Intent goToEightByEightIntent = new Intent(MainActivity.this, EightByEight.class);
                    goToEightByEightIntent.putExtra("valueFromBoardSizeSpinner", boardSize);
                    startActivity(goToEightByEightIntent);
                    Toast.makeText(adapterView.getContext(), selectedText, Toast.LENGTH_SHORT).show();
                    break;
                case 4:
                    boardSize = 9;
                    Intent goToNineByNineIntent = new Intent(MainActivity.this, NineByNine.class);
                    goToNineByNineIntent.putExtra("valueFromBoardSizeSpinner", boardSize);
                    startActivity(goToNineByNineIntent);
                    Toast.makeText(adapterView.getContext(), selectedText, Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    boardSize = 10;
                    Intent goToTenByTenIntent = new Intent(MainActivity.this, TenByTen.class);
                    goToTenByTenIntent.putExtra("valueFromBoardSizeSpinner", boardSize);
                    startActivity(goToTenByTenIntent);
                    Toast.makeText(adapterView.getContext(), selectedText, Toast.LENGTH_SHORT).show();
                    break;
                case 6:
                    boardSize = 11;
                    Intent goToElevenByElevenIntent = new Intent(MainActivity.this, ElevenByEleven.class);
                    goToElevenByElevenIntent.putExtra("valueFromBoardSizeSpinner", boardSize);
                    startActivity(goToElevenByElevenIntent);
                    Toast.makeText(adapterView.getContext(), selectedText, Toast.LENGTH_SHORT).show();
                    break;
                case 7:
                    boardSize = 12;
                    Intent goToTwelveByTwelveIntent = new Intent(MainActivity.this, TwelveByTwelve.class);
                    goToTwelveByTwelveIntent.putExtra("valueFromBoardSizeSpinner", boardSize);
                    startActivity(goToTwelveByTwelveIntent);
                    Toast.makeText(adapterView.getContext(), selectedText, Toast.LENGTH_SHORT).show();
                    break;
                case 8:
                    boardSize = 13;
                    Intent goToThirteenByThirteenIntent = new Intent(MainActivity.this, ThirteenByThirteen.class);
                    goToThirteenByThirteenIntent.putExtra("valueFromBoardSizeSpinner", boardSize);
                    startActivity(goToThirteenByThirteenIntent);
                    Toast.makeText(adapterView.getContext(), selectedText, Toast.LENGTH_SHORT).show();
                    break;
                case 9:
                    boardSize = 14;
                    Intent goToFourteenByFourteenIntent = new Intent(MainActivity.this, FourteenByFourteen.class);
                    goToFourteenByFourteenIntent.putExtra("valueFromBoardSizeSpinner", boardSize);
                    startActivity(goToFourteenByFourteenIntent);
                    Toast.makeText(adapterView.getContext(), selectedText, Toast.LENGTH_SHORT).show();
                    break;
                case 10:
                    boardSize = 15;
                    Intent goToFifteenByFifteenIntent = new Intent(MainActivity.this, FifteenByFifteen.class);
                    goToFifteenByFifteenIntent.putExtra("valueFromBoardSizeSpinner", boardSize);
                    startActivity(goToFifteenByFifteenIntent);
                    Toast.makeText(adapterView.getContext(), selectedText, Toast.LENGTH_SHORT).show();
                    break;
                case 11:
                    boardSize = 16;
                    Intent goToSixteenBySixteenIntent = new Intent(MainActivity.this, SixteenBySixteen.class);
                    goToSixteenBySixteenIntent.putExtra("valueFromBoardSizeSpinner", boardSize);
                    startActivity(goToSixteenBySixteenIntent);
                    Toast.makeText(adapterView.getContext(), selectedText, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    boardSize = 0;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
