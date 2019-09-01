package com.stavros.chess;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.stavros.chess.logic.KnightTest;

import java.util.ArrayList;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class BoardActivity extends AppCompatActivity {

    CreateTiles createTiles = new CreateTiles();

    TableLayout tableLayout;
    RelativeLayout relativeLayout;
    ConstraintLayout constraintLayout;
    public KnightTest knightTest = new KnightTest();
    public static int[] start = new int[2];
    public static int[] target = new int[2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent mIntent = getIntent();

        int boardSizeFromMainActivity = mIntent.getIntExtra("valueFromBoardSizeSpinner", 0);





        ArrayList<TableRow> tableRowArrayList = new ArrayList<>();
        ArrayList<CustomButtonWithCoord> blackAndWhiteTileButtonsReturned = null;

        tableLayout = new TableLayout(this);


        for (int t = 0; t < 5; t++) {
            tableRowArrayList.add(new TableRow(this));
        }

        TableRow.LayoutParams trp = new TableRow.LayoutParams(MATCH_PARENT, MATCH_PARENT);

        TableLayout.LayoutParams lp = new TableLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT);
//        lp.setMargins(100,100,100,100);
        tableLayout.setLayoutParams(lp);

        relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams r1 = new RelativeLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT);

        relativeLayout.setLayoutParams(r1);

        constraintLayout = new ConstraintLayout(this);
        ConstraintLayout.LayoutParams c1 = new ConstraintLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT);
        constraintLayout.setLayoutParams(c1);


//for (int k=0; k<3; k++) {
        int tableColumns = 4;

        blackAndWhiteTileButtonsReturned = createTiles.createBlackAndWiteTiles(tableColumns, this);
        tableRowArrayList.get(0).addView(blackAndWhiteTileButtonsReturned.get(0).button);

        final ArrayList<CustomButtonWithCoord> finalBlackAndWhiteTileButtonsReturned = blackAndWhiteTileButtonsReturned;


        for (int setBlackCoord = 0; setBlackCoord < tableColumns; setBlackCoord = setBlackCoord + 2) {
            final int finalSetBlackCoord = setBlackCoord;
            blackAndWhiteTileButtonsReturned.get(finalSetBlackCoord).button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + finalBlackAndWhiteTileButtonsReturned.get(finalSetBlackCoord).getBlackCoords());
                    start[0] = Integer.parseInt(finalBlackAndWhiteTileButtonsReturned.get(finalSetBlackCoord).getBlackCoords().get(0).toString());
                    start[1] = Integer.parseInt(finalBlackAndWhiteTileButtonsReturned.get(finalSetBlackCoord).getBlackCoords().get(1).toString());
                }
            });
        }

        for (int setWhiteCoord = 1; setWhiteCoord < tableColumns; setWhiteCoord = setWhiteCoord + 2) {
            final int finalSetWhiteCoord = setWhiteCoord;
            blackAndWhiteTileButtonsReturned.get(finalSetWhiteCoord).button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + finalBlackAndWhiteTileButtonsReturned.get(finalSetWhiteCoord).getWhiteCoords());
                    target[0] = Integer.parseInt(finalBlackAndWhiteTileButtonsReturned.get(finalSetWhiteCoord).getWhiteCoords().get(0).toString());
                    target[1] = Integer.parseInt(finalBlackAndWhiteTileButtonsReturned.get(finalSetWhiteCoord).getWhiteCoords().get(1).toString());
                    calculateDistance(start,target);
                }
            });
        }


        for (int q = 0; q < finalBlackAndWhiteTileButtonsReturned.size(); q++) {
            if (q == 0 || q == 8) {
                continue;
            }
            tableRowArrayList.get(0).addView(blackAndWhiteTileButtonsReturned.get(q).button);

//            tableRowArrayList.get(0).addView(blackAndWhiteTileButtonsReturned.get(2).button);
//            tableRowArrayList.get(0).addView(blackAndWhiteTileButtonsReturned.get(3).button);
//
//            tableRowArrayList.get(0).addView(blackAndWhiteTileButtonsReturned.get(4).button);
//            tableRowArrayList.get(0).addView(blackAndWhiteTileButtonsReturned.get(5).button);
//
//            tableRowArrayList.get(0).addView(blackAndWhiteTileButtonsReturned.get(6).button);
//            tableRowArrayList.get(0).addView(blackAndWhiteTileButtonsReturned.get(7).button);


//            tableRowArrayList.get(1).addView(blackAndWhiteTileButtonsReturned.get(9).button);
//
//            tableRowArrayList.get(1).addView(blackAndWhiteTileButtonsReturned.get(10).button);
//            tableRowArrayList.get(1).addView(blackAndWhiteTileButtonsReturned.get(11).button);
//
//            tableRowArrayList.get(1).addView(blackAndWhiteTileButtonsReturned.get(12).button);
//            tableRowArrayList.get(1).addView(blackAndWhiteTileButtonsReturned.get(13).button);
//
//            tableRowArrayList.get(1).addView(blackAndWhiteTileButtonsReturned.get(14).button);
//            tableRowArrayList.get(1).addView(blackAndWhiteTileButtonsReturned.get(15).button);
        }

//
//        tableRowArrayList.get(2).addView(blackAndWhiteTileButtonsReturned.get(17).button);
//
//        tableRowArrayList.get(2).addView(blackAndWhiteTileButtonsReturned.get(18).button);
//        tableRowArrayList.get(2).addView(blackAndWhiteTileButtonsReturned.get(19).button);
//
//        tableRowArrayList.get(2).addView(blackAndWhiteTileButtonsReturned.get(20).button);
//        tableRowArrayList.get(2).addView(blackAndWhiteTileButtonsReturned.get(21).button);
//
//        tableRowArrayList.get(2).addView(blackAndWhiteTileButtonsReturned.get(22).button);
//        tableRowArrayList.get(2).addView(blackAndWhiteTileButtonsReturned.get(23).button);


        for (int w = 0; w < 2; w++) {
            tableLayout.addView(tableRowArrayList.get(w), MATCH_PARENT, MATCH_PARENT);
        }
        relativeLayout.addView(tableLayout);
        setContentView(relativeLayout);


    }
    public void calculateDistance( int[] start,int[] target) {
        String shortestPath = knightTest.calculate(start, target ,6);
        Toast.makeText(getApplicationContext(), shortestPath, Toast.LENGTH_LONG).show();
    }

}
