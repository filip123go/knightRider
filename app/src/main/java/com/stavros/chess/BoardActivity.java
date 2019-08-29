package com.stavros.chess;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

public class BoardActivity extends AppCompatActivity {


    Button firstBtn;

    TableLayout tableLayout;
    TableRow tableRow1, tableRow2 , tableRow3 , tableRow4 , tableRow5 , tableRow6;
    Button b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent mIntent = getIntent();

        int boardSizeFromMainActivity = mIntent.getIntExtra("valueFromBoardSizeSpinner",0);

        tableLayout = new TableLayout(this);
        tableRow1 = new TableRow(this);
        tableRow2 = new TableRow(this);
        tableRow3 = new TableRow(this);
        tableRow4 = new TableRow(this);
        tableRow5 = new TableRow(this);
        tableRow6 = new TableRow(this);
        Drawable icon=this.getResources(). getDrawable( R.drawable.iconsearchtr);
        b1 = new Button(this);
        b2 = new Button(this);
        b3 = new Button(this);
        b4 = new Button(this);
        b5 = new Button(this);


        TableLayout.LayoutParams lp = new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        tableLayout.setLayoutParams(lp);
        b1.setBackgroundColor(Color.WHITE);
        b2.setBackgroundColor(Color.BLACK);
        b3.setBackgroundColor(Color.WHITE);
        b4.setBackgroundColor(Color.BLACK);
        b5.setBackgroundColor(Color.WHITE);

for (int k=0; k<boardSizeFromMainActivity; k++) {
    for (int i = 0; i < 5; i++) {
        Button blackButton = new Button(this);//Creating Button
        Button whiteButton = new Button(this);//Creating Button
        blackButton.setId(i);//Setting Id for using in future
        whiteButton.setId(i + 1);//Setting Id for using in future
        blackButton.setBackgroundColor(Color.BLACK);
        whiteButton.setBackgroundColor(Color.WHITE);
        tableRow1.addView(blackButton);
        tableRow1.addView(whiteButton);
    }

    for (int i = 0; i < 5; i++) {
        Button blackButton = new Button(this);//Creating Button
        Button whiteButton = new Button(this);//Creating Button
        blackButton.setId(i);//Setting Id for using in future
        whiteButton.setId(i + 1);//Setting Id for using in future
        blackButton.setBackgroundColor(Color.BLACK);
        whiteButton.setBackgroundColor(Color.WHITE);
        tableRow2.addView(whiteButton);
        tableRow2.addView(blackButton);
    }

    for (int i = 0; i < 5; i++) {
        Button blackButton = new Button(this);//Creating Button
        Button whiteButton = new Button(this);//Creating Button
        blackButton.setId(i);//Setting Id for using in future
        whiteButton.setId(i + 1);//Setting Id for using in future
        blackButton.setBackgroundColor(Color.BLACK);
        whiteButton.setBackgroundColor(Color.WHITE);
        tableRow3.addView(blackButton);
        tableRow3.addView(whiteButton);
    }
    for (int i = 0; i < 5; i++) {
        Button blackButton = new Button(this);//Creating Button
        Button whiteButton = new Button(this);//Creating Button
        blackButton.setId(i);//Setting Id for using in future
        whiteButton.setId(i + 1);//Setting Id for using in future
        blackButton.setBackgroundColor(Color.BLACK);
        whiteButton.setBackgroundColor(Color.WHITE);
        tableRow4.addView(whiteButton);
        tableRow4.addView(blackButton);
    }

    for (int i = 0; i < 5; i++) {
        Button blackButton = new Button(this);//Creating Button
        Button whiteButton = new Button(this);//Creating Button
        blackButton.setId(i);//Setting Id for using in future
        whiteButton.setId(i + 1);//Setting Id for using in future
        blackButton.setBackgroundColor(Color.BLACK);
        whiteButton.setBackgroundColor(Color.WHITE);
        tableRow5.addView(blackButton);
        tableRow5.addView(whiteButton);
    }
    for (int i = 0; i < 5; i++) {
        Button blackButton = new Button(this);//Creating Button
        Button whiteButton = new Button(this);//Creating Button
        blackButton.setId(i);//Setting Id for using in future
        whiteButton.setId(i + 1);//Setting Id for using in future
        blackButton.setBackgroundColor(Color.BLACK);
        whiteButton.setBackgroundColor(Color.WHITE);
        tableRow6.addView(whiteButton);
        tableRow6.addView(blackButton);
    }

}


//        tableRow1.addView(b1);
//        tableRow1.addView(b2);
//        tableRow1.addView(b3);
//        tableRow2.addView(b4);
//        tableRow2.addView(b5);

        tableLayout.addView(tableRow1);
        tableLayout.addView(tableRow2);
        tableLayout.addView(tableRow3);
        tableLayout.addView(tableRow4);
        tableLayout.addView(tableRow5);
        tableLayout.addView(tableRow6);











        setContentView(tableLayout);








        firstBtn = findViewById(R.id.firstBtn);
//        firstBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Button secondBtn = new Button(BoardActivity.this);
//                boardLayout = findViewById(R.id.BoardLayout);
//
//                secondBtn.setText("This is black");
//                secondBtn.setPadding(5, 5, 5, 5);//paading
//                secondBtn.setLayoutParams(new RelativeLayout.LayoutParams(
//                        RelativeLayout.LayoutParams.WRAP_CONTENT,
//                        RelativeLayout.LayoutParams.WRAP_CONTENT
//                ));
//                boardLayout.addView(secondBtn);
//            }
//        });
    }
}
