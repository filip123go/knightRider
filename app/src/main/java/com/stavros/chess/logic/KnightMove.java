package com.stavros.chess.logic;

import java.util.ArrayList;

import static com.stavros.chess.logic.KnightTest.getCharForNumber;

public class KnightMove  {

    private KnightMove parent;
    private ArrayList<KnightMove> children;
    public int[] coords;
    public static final int[] DELTA = {-1, 1};
    public static final int[] DISTS = {1, 2};

    public KnightMove(int[] coords) {
        this.coords = coords;
        this.parent = null;
        this.children = null;
    }

    public KnightMove(int[] coords, KnightMove parent) {
        this.coords = coords;
        this.parent = parent;
        this.children = null;
    }

    public ArrayList<KnightMove> get_children() {
        this.children = new ArrayList<KnightMove>();

        for(int sign_x : DELTA) {
            for(int sign_y : DELTA) {
                for(int k = 0; k < 2; ++k) {

                    int delta_x = DISTS[k] * sign_x;
//					System.out.println("the int delta_x now is " + delta_x);
                    int delta_y = DISTS[(k + 1) % 2] * sign_y;
//					System.out.println("the int delta_y now is " + delta_y);

//					System.out.println("-----------------------------------");

                    int[] new_coords = new int[2]; // instantiate inside in order to avoid change

                    new_coords[0] = coords[0] + delta_x;
                    new_coords[1] = coords[1] + delta_y;


                    KnightMove move = new KnightMove(new_coords, this);

                    children.add(move);
                }
            }
        }


        return children;
    }

    public ArrayList<KnightMove> shortest_path() {
        ArrayList<KnightMove> path = new ArrayList<KnightMove>();
        path.add(this);
        KnightMove curr = this;

        while(curr.get_parent() != null) {
            curr = curr.get_parent();
            path.add(0, curr);
        }

        return path;
    }

    public KnightMove get_parent() {
        return this.parent;
    }

    public String to_family_string() {
        String self_string =  "[" + String.valueOf(coords[0]) + ", " +
                String.valueOf(coords[1]) + "]";

        String parent_string = "";
        String child_string = "";

        if(parent != null) {
            parent_string += "[" + String.valueOf(parent.get_coords()[0]) + ", " +
                    String.valueOf(parent.get_coords()[1]) + "]";
        }
        if(children != null) {
            for(int i = 0; i < children.size(); ++i) {
                child_string += "[" + String.valueOf(children.get(i).get_coords()[0]) + ", " +
                        String.valueOf(children.get(i).get_coords()[1]) + "]";
            }
        }

        return parent_string + " >> " + self_string + " >> " + child_string;
    }

    public String to_string() {
        return "[" + String.valueOf(getCharForNumber(coords[0])) + ", " +
                String.valueOf(coords[1]+1) + "]";
    }

    public int[] get_coords() {
        return coords;
    }
}