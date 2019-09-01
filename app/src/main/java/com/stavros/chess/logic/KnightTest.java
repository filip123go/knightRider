package com.stavros.chess.logic;

import java.util.Scanner;
import java.util.ArrayList;

public class KnightTest {

    public String calculate(int[] start , int[] target , int dimensions) {
         String stringToReturn = "";
//        int[] start = new int[2];
//        target = new int[2];

//				Scanner scan = new Scanner(System.in);
//				System.out.println("Enter begining x coordinate: ");
//				start[0] = scan.nextInt();
//				System.out.println("Enter begining y coordinate: ");
//				start[1] = scan.nextInt();
//				System.out.println("Enter target x coordinate: ");
//				target[0] = scan.nextInt();
//				System.out.println("Enter target y coordinate: ");
//				target[1] = scan.nextInt();

//		System.out.println(getCharForNumber(0));

//        start[0] = 0;
//        start[1] = 0;
//        target[0] = 3;
//        target[1] = 3;


        try {
            KnightSearch search = new KnightSearch(start, target ,dimensions);
            ArrayList<KnightMove> path = search.knight_BFS();

            if (path.size() < 3) {
                System.out.println("The steps are not 3");
            }else{
                for (int i = 0; i < path.size(); ++i) {
                    stringToReturn = stringToReturn + " >> " + path.get(i).to_string();
                    System.out.print(" >> " + path.get(i).to_string());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: Index out of bounds");
        }


        return stringToReturn;
    }

    //translate numbers to letters 0->A , 1->B etc
    static String getCharForNumber(int i) {
        return i > -1 && i < 26 ? String.valueOf((char)(i + 65)) : null;
    }
}


