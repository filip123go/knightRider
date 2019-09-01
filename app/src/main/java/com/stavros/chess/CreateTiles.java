package com.stavros.chess;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;

import java.util.ArrayList;

public class CreateTiles {

    CustomButtonWithCoord customButtonWithBlackCoord;
    CustomButtonWithCoord customButtonWithWhiteCoord;

    public ArrayList<CustomButtonWithCoord> createBlackAndWiteTiles(int tableColumns, Context context) {
        ArrayList<CustomButtonWithCoord> blackAndWhiteTileButtons = new ArrayList<>();

        for (int x = 0; x < tableColumns; x++) {
            for (int y = 0; y < tableColumns; y++) {
                final ArrayList<Integer> blackCoords = new ArrayList<>();
                final ArrayList<Integer> whiteCoords = new ArrayList<>();

                customButtonWithBlackCoord = new CustomButtonWithCoord();
                customButtonWithWhiteCoord = new CustomButtonWithCoord();
                Button blackButton = new Button(context);//Creating Button
                Button whiteButton = new Button(context);//Creating Button

                if (y%2==0) {
                    blackCoords.add(x);
                    blackCoords.add(y);
                    customButtonWithBlackCoord.setBlackCoords(blackCoords);
                    blackButton.setBackgroundColor(Color.BLACK);
                    customButtonWithBlackCoord.setButton(blackButton);
                    blackAndWhiteTileButtons.add(customButtonWithBlackCoord);
                } else {
                    whiteCoords.add(x);
                    whiteCoords.add(y);
                    customButtonWithWhiteCoord.setWhiteCoords(whiteCoords);
                    whiteButton.setBackgroundColor(Color.WHITE);
                    customButtonWithWhiteCoord.setButton(whiteButton);
                    blackAndWhiteTileButtons.add(customButtonWithWhiteCoord);
                }
            }
        }

        return blackAndWhiteTileButtons;
    }


}
