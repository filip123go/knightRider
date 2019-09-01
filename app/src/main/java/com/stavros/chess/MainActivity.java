package com.stavros.chess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner boardSizeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boardSizeSpinner = findViewById(R.id.boardSizeSpinner);
        ArrayAdapter<CharSequence> boardSizeAdapter = ArrayAdapter.createFromResource(this,R.array.boardSizeArray,android.R.layout.simple_spinner_item);
        boardSizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        boardSizeSpinner.setAdapter(boardSizeAdapter);

        boardSizeSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedText = adapterView.getItemAtPosition(i).toString();

        if ( i ==0 ){
            Toast.makeText(adapterView.getContext(), "Please choose a valid layout", Toast.LENGTH_SHORT).show();
        }else{
            Intent goToBoardActivityIntent = new Intent(MainActivity.this, BoardActivity.class);

            int boardSize;
            switch (i){
                case 1:
                    boardSize = 6;
                    break;
                case 2:
                    boardSize = 7;
                    break;
                case 3:
                    boardSize = 8;
                    break;
                case 4:
                    boardSize = 9;
                    break;
                case 5:
                    boardSize = 10;
                    break;
                case 6:
                    boardSize = 11;
                    break;
                case 7:
                    boardSize = 12;
                    break;
                case 8:
                    boardSize = 13;
                    break;
                case 9:
                    boardSize = 14;
                    break;
                case 10:
                    boardSize = 15;
                    break;
                case 11:
                    boardSize = 16;
                    break;
                default:
                    boardSize = 0;
            }


            goToBoardActivityIntent.putExtra("valueFromBoardSizeSpinner",boardSize);
            startActivity(goToBoardActivityIntent);
            Toast.makeText(adapterView.getContext(), selectedText, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
