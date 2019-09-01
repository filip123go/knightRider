package com.stavros.chess.logic;

import java.util.ArrayList;

public class KnightSearch {

    private static int DIMENSIONS = 6;

    private ArrayList<KnightMove> move_queue;
    private boolean[][] not_visited;
    private int[] target;
    private KnightMove root;


    /* Constructor
     * 		Takes a start and an end position for the
     * search. Sets the root of the KnightMove instance
     * and instantiates the not_visited array.
     */
    public KnightSearch(int[] start, int[] target, int DIMENSIONS) throws Exception {
        this.DIMENSIONS = DIMENSIONS;
        move_queue = new ArrayList<KnightMove>();
        not_visited = new boolean[DIMENSIONS][DIMENSIONS];
        this.target = target;
        this.root = new KnightMove(start);


        // instantiate not_visited board to true
        for (int i = 0; i < DIMENSIONS; ++i) {
            for (int j = 0; j < DIMENSIONS; ++j) {
                System.out.println("Instantiate not_visited to be true");
                not_visited[i][j] = true;
            }
        }


        if (!is_valid(root) || !is_valid(new KnightMove(target))) {
            throw new Exception("Error: Index out of bounds");
        }


        // visit the root node
        System.out.println("The root node is : " + root.coords[0] + " - " + root.coords[1]);
        enqueue(root);
        not_visited[start[0]][start[1]] = false;
    }

    /*
     Perform a breadth-first search (BFS) through the graph
     of all possible positions for the knight in order to find
     the shortest path to the target position. Check if the position
     has already been visited and if it is in bounds
     */
    public ArrayList<KnightMove> knight_BFS() {

        while (true) {

            // take a move off the queue and use it to generate
            // new moves
            KnightMove move = dequeue();
            ArrayList<KnightMove> new_moves = move.get_children();

            for (int i = 0; i < new_moves.size(); ++i) {

                KnightMove potential_move = new_moves.get(i);

                // if the move is on board and unvisited
                if (is_valid(potential_move)) {

                    // check if we have reached the target
                    if (target[0] == potential_move.get_coords()[0] &&
                            target[1] == potential_move.get_coords()[1]) {
                        return potential_move.shortest_path();
                    }

                    // add move to queue and mark as visited
                    enqueue(new_moves.get(i));
                    not_visited[potential_move.get_coords()[0]][potential_move.get_coords()[1]] = false;
                }

            }
        }
    }

    // check if the move is in bounds and has not been done yet
    private boolean is_valid(KnightMove move) {
        int[] coords = move.get_coords();
        boolean in_bounds = coords[0] >= 0 && coords[1] >= 0 &&
                coords[0] < DIMENSIONS && coords[1] < DIMENSIONS;
        if (in_bounds) {
            System.out.println("The in_bounds is " + in_bounds + " this means that coords[0] and coords[1]  : [" + coords[0] + " , " + coords[1] + "] are positive and inside the chess borders -VALID COORDINATES-");
        } else {
//			System.out.println("The in_bounds is " + in_bounds + " this means that coords[0] : " + coords[0] + " or coords[1] : " + coords[1] + " are not both positive or inside the chess borders");
        }

        return in_bounds && not_visited[coords[0]][coords[1]];
    }

    // add a move to the end of the queue
    private void enqueue(KnightMove move) {
        move_queue.add(move);
        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("The new move_queue is : " + move.coords[0] + " - " + move.coords[1]);
        System.out.println("++++++++++++++++++++++++++++++++");
    }

    // remove a move from the front of the queue and return it
    private KnightMove dequeue() {
        return move_queue.remove(0);
    }
}

