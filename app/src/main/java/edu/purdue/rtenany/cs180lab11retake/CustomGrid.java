package edu.purdue.rtenany.cs180lab11retake;

/**
 * Created by Richa on 4/4/17.
 */
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

/**
 * CustomGrid class that takes care of handling the 4x4 main grid of the game
 *
 * @author Sahil Pujari (pujari@purdue.edu)
 * @author Tori Shurman (vshurman@purdue.edu)
 */
class CustomGrid extends BaseAdapter {

    //Stores the cells in the grid
    private TextView[][] cellGrid;
    private int [][] cellGrid2;
    //Checks if a cell is pre-occupied
    private boolean[][] isOccupied;



    /**
     * Constructor to do initializations
     */
    CustomGrid() {
        cellGrid = new TextView[4][4];
        cellGrid2 = new int[4][4];
        isOccupied = new boolean[4][4];
    }

    /**
     * Get a View that displays the data at the specified position in the data set.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible.
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView b = new TextView(MainActivity.getAppContext());

        int xPosition = position / 4;
        int yPosition = position % 4;

        if (isOccupied[xPosition][yPosition]) return cellGrid[xPosition][yPosition];

        isOccupied[xPosition][yPosition] = true;
        cellGrid[position / 4][position % 4] = b;
        b.setText("");
        b.setTextSize(35);
        b.setTypeface(null, Typeface.BOLD);
        b.setGravity(Gravity.CENTER);
        b.setBackground(MainActivity.getAppContext().getDrawable(R.drawable.grid_cell));
        b.setLayoutParams(new GridView.LayoutParams(147, 147));

//        if(cellGrid2[xPosition][yPosition] == 2){
//            b.setBackgroundColor(Color.parseColor("#FFFFFF"));
//        }

        return b;
    }

    /**
     * Get the count of total cells in the grid
     *
     * @return The count for total cells to initialize the grid with
     */
    public final int getCount() {
        return 16;
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    public final Integer getItem(int position) {
        return 1;
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    public final long getItemId(int position) {
        return position;
    }

    /**
     * Update the grid to display as per the provided board
     *
     * @param board - the current snapshot of the board
     */
    @SuppressLint("SetTextI18n")
    void updateGrid(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    cellGrid[i][j].setText(board[i][j] + "");
                    cellGrid[i][j].setBackground(MainActivity.getAppContext().getDrawable(R.drawable.grid_cell));

                    //updateCellTextAndColor(board[i][j], cellGrid[i][j]);
                }

                else if (board[i][j] == 0 && !cellGrid[i][j].getText().toString().equals("0")) {
                    cellGrid[i][j].setText("");
                    cellGrid[i][j].setBackground(MainActivity.getAppContext().getDrawable(R.drawable.grid_cell));
//                    updateCellTextAndColor(board[i][j], cellGrid[i][j]);
                }

            }
        }
    }
    void changeColor(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
//                if(board[i][j] == Integer.parseInt(null)){
//                    cellGrid[i][j].setBackgroundColor(Color.parseColor("#ECE2D8"));
//                }
                if(board[i][j] == 2){
                    cellGrid[i][j].setBackgroundColor(Color.parseColor("#ECE2D8"));
                    // cellGrid[i][j].setBackground(MainActivity.getAppContext().getDrawable(R.drawable.grid_cell));

                }
                if(board[i][j] == 4){
                    cellGrid[i][j].setBackgroundColor(Color.parseColor("#EDE0C9"));
                    // cellGrid[i][j].setBackground(MainActivity.getAppContext().getDrawable(R.drawable.grid_cell));
                }
                if(board[i][j] == 8){
                    cellGrid[i][j].setBackgroundColor(Color.parseColor("#F0B07D"));
                    // cellGrid[i][j].setBackground(MainActivity.getAppContext().getDrawable(R.drawable.grid_cell));
                }
                if(board[i][j] == 16){
                    cellGrid[i][j].setBackgroundColor(Color.parseColor("#EA8D5A"));
                    //cellGrid[i][j].setBackground(MainActivity.getAppContext().getDrawable(R.drawable.grid_cell));
                }
                if(board[i][j] == 32){
                    cellGrid[i][j].setBackgroundColor(Color.parseColor("#F47C63"));
                    //  cellGrid[i][j].getBackground().clearColorFilter();
                }
                if(board[i][j] == 64){
                    cellGrid[i][j].setBackgroundColor(Color.parseColor("#F45E43"));
                    //   cellGrid[i][j].getBackground().clearColorFilter();
                }
                if(board[i][j] == 128){
                    cellGrid[i][j].setBackgroundColor(Color.parseColor("#ECCD77"));
                    //  cellGrid[i][j].getBackground().clearColorFilter();
                }
                if(board[i][j] == 256){
                    cellGrid[i][j].setBackgroundColor(Color.parseColor("#ECCB6B"));
                    cellGrid[i][j].getBackground().clearColorFilter();
                }
                if(board[i][j] == 512){
                    cellGrid[i][j].setBackgroundColor(Color.parseColor("#EBC75A"));
                    cellGrid[i][j].getBackground().clearColorFilter();
                }
                if(board[i][j] == 1024){
                    cellGrid[i][j].setBackgroundColor(Color.parseColor("#E28913"));
                    cellGrid[i][j].getBackground().clearColorFilter();

                }
                if(board[i][j] == 2048){
                    cellGrid[i][j].setBackgroundColor(Color.parseColor("#EEC22E"));
                    cellGrid[i][j].getBackground().clearColorFilter();
                }
                if(board[i][j] >= 4096){
                    cellGrid[i][j].setBackgroundColor(Color.parseColor("#5EDA92"));
                    cellGrid[i][j].getBackground().clearColorFilter();
                }

            }
        }
    }

    /**
     * Reset the View Grid
     */
    @SuppressWarnings("unused")
    void reset() {
        for (TextView[] gridRow : cellGrid) {
            for (TextView aGridRow : gridRow) {
                aGridRow.setText("");
                aGridRow.setBackground(MainActivity.getAppContext().getDrawable(R.drawable.grid_cell));
            }
        }
    }
}