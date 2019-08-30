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
            goToBoardActivityIntent.putExtra("valueFromBoardSizeSpinner",3);
            startActivity(goToBoardActivityIntent);
            Toast.makeText(adapterView.getContext(), selectedText, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
