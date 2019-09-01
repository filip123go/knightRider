package com.stavros.chess;

import android.widget.Button;

import java.util.ArrayList;

public class CustomButtonWithCoord {

    Button button;
    ArrayList blackCoords;
    ArrayList whiteCoords;


    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public ArrayList getBlackCoords() {
        return blackCoords;
    }

    public ArrayList getWhiteCoords() {
        return whiteCoords;
    }

    public void setWhiteCoords(ArrayList whiteCoords) {
        this.whiteCoords = whiteCoords;
    }

    public void setBlackCoords(ArrayList blackCoords) {
        this.blackCoords = blackCoords;
    }
}
