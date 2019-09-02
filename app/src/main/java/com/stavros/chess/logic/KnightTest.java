package com.stavros.chess.logic;

import java.util.ArrayList;

public class KnightTest {

    public String[] calculate(int[] start , int[] target , int dimensions) {
         String stringToReturn = "";
        String stringToReturnInCoords = "";

        try {
            KnightSearch search = new KnightSearch(start, target ,dimensions);
            ArrayList<KnightMove> path = search.knight_BFS();

            if (path.size() != 3) {
//                System.out.println("The moves from starting point to target are above 3 , please play again.");
                stringToReturn= "The moves from starting point to target are not exactly 3 , please play again.";
                stringToReturnInCoords = "";
            }else{
                for (int i = 0; i < path.size(); ++i) {
                    stringToReturn = stringToReturn + " >> " + path.get(i).to_string();
                    stringToReturnInCoords = stringToReturnInCoords + " >> " + path.get(i).to_string_in_coords();
                    System.out.print(" >> " + path.get(i).to_string());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: Index out of bounds");
        }


        return new String[]{stringToReturn , stringToReturnInCoords};
    }

    //translate numbers to letters 0->A , 1->B etc
    static String getCharForNumber(int i) {
        return i > -1 && i < 26 ? String.valueOf((char)(i + 65)) : null;
    }
}


