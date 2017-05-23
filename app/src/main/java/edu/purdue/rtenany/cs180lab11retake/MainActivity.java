package edu.purdue.rtenany.cs180lab11retake;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.media.MediaPlayer;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.GridView;
        import android.widget.TextView;

        import java.util.ArrayList;


/**
 * MainActivity class that serves the same purpose to an Android app as the heart does to humans
 * Basically, the most important class of the app
 *
 * @author Sahil Pujari (pujari@purdue.edu)
 * @author Tori Shurman (vshurman@purdue.edu)
 */
public class MainActivity extends Activity {

    //The context of the app. Context is used to refer to certain resources of the app outside of
    //the MainActivity class
    private static Context mContext;
    /**
     * Get the context of the app
     *
     * @return the context of the app
     */
    public static Context getAppContext() {
        return mContext;
    }

    //An object of our TwentyFortyEight class
    private TwentyFortyEight twentyFortyEight;

    //An object of CustomGrid class
    private CustomGrid customGrid;
//   MediaPlayer sound = MediaPlayer.create(this, R.raw.click);

    //The score box text in the app
    private TextView scoreBox;


    public ArrayList<Integer> findScore = new ArrayList<Integer>();

    /**
     * Called when the activity is starting.  This is where most initialization
     * should go.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.
     * @see #onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        twentyFortyEight = new TwentyFortyEight(4);
        customGrid = new CustomGrid();

        GridView grid = (GridView) findViewById(R.id.mainGrid);
        scoreBox = (TextView) findViewById(R.id.scoreBox);
//        findScore.add(twentyFortyEight.getScore());

        grid.setAdapter(customGrid);

        //twentyFortyEight.placeRandom();
        //TODO: Call the reset() method of your TwentyFortyClass to reset the board when the app
        //first starts

        twentyFortyEight.reset();

//        Button moveUp = (Button) this.findViewById(R.id.click_one);

    }

    /**
     * Method invoked when the Up button is pressed
     *
     * @param view - the UI of the app
     */
    public void upAction(View view) {
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
        //sound.start();
//        twentyFortyEight.stack.push();
       final MediaPlayer sound = MediaPlayer.create(this, R.raw.cow);
        sound.start();

        twentyFortyEight.push(twentyFortyEight.temp());
        while(twentyFortyEight.moveUp()); //while loop to make sure it goes all the way to the right
        customGrid.updateGrid(twentyFortyEight.getBoard());
        twentyFortyEight.placeRandom(); //place a random 2 everytime
        scoreBox.setText(String.valueOf(twentyFortyEight.getScore())); //update Text for score
        findScore.add(twentyFortyEight.getScore()); //add the score to the previous one
        customGrid.changeColor(twentyFortyEight.getBoard()); //change color depending on the number

    }


    /**
     * Method invoked when the Down button is pressed
     *
     * @param view - the UI of the app
     */
    public void downAction(View view) {
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
        final MediaPlayer sound = MediaPlayer.create(this, R.raw.cow);
        sound.start();
        //same thing as up but change to moveDown
        twentyFortyEight.push(twentyFortyEight.temp());
        while(twentyFortyEight.moveDown());
        customGrid.updateGrid(twentyFortyEight.getBoard());
        twentyFortyEight.placeRandom();
        scoreBox.setText(String.valueOf(twentyFortyEight.getScore()));
        findScore.add(twentyFortyEight.getScore());
        customGrid.changeColor(twentyFortyEight.getBoard());
    }

    /**
     * Method invoked when the Left button is pressed
     *
     * @param view - the UI of the app
     */
    public void leftAction(View view) {
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
        final MediaPlayer sound = MediaPlayer.create(this, R.raw.cow);
        sound.start();
        //same thing as up but change to moveLeft
        twentyFortyEight.push(twentyFortyEight.temp());
        while(twentyFortyEight.moveLeft());
        customGrid.updateGrid(twentyFortyEight.getBoard());
        twentyFortyEight.placeRandom();
        scoreBox.setText(String.valueOf(twentyFortyEight.getScore()));
        findScore.add(twentyFortyEight.getScore());
        customGrid.changeColor(twentyFortyEight.getBoard());
    }

    /**
     * Method invoked when the Right button is pressed
     *
     * @param view - the UI of the app
     */
    public void rightAction(View view) {
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
        final MediaPlayer sound = MediaPlayer.create(this, R.raw.cow);
        sound.start();
        //same thing as up method but change to moveRight
        twentyFortyEight.push(twentyFortyEight.temp());
        while(twentyFortyEight.moveRight());
        customGrid.updateGrid(twentyFortyEight.getBoard());
        twentyFortyEight.placeRandom();
        scoreBox.setText(String.valueOf(twentyFortyEight.getScore()));
        findScore.add(twentyFortyEight.getScore());
        customGrid.changeColor(twentyFortyEight.getBoard());


    }
    public void resetAction(View view){
        twentyFortyEight.reset();
        //reset the grid back to normal
        customGrid.updateGrid(twentyFortyEight.getBoard());
        //make sure the grid is updated to the current one
        scoreBox.setText("2");
        //everytime the game resets, the score should be 2
        customGrid.changeColor(twentyFortyEight.getBoard());

    }
    public void undoAction(View view){
        int [] [] popped = twentyFortyEight.pop();
        customGrid.updateGrid(popped);
        int max = 2;
        for(int i = 0; i < popped.length; i++) {
            for (int j = 0; j < popped.length; j++) {
                if (popped[i][j] > max) {
                    max = popped[i][j];
                }
            }
        }
        scoreBox.setText(String.valueOf(max));
        customGrid.changeColor(twentyFortyEight.getBoard());


            //  scoreBox.setText(String.valueOf(findScore.size()-1));


    }
    public void redoAction(View view){
        int [][] popped = twentyFortyEight.pop();
        customGrid.updateGrid(popped);
        twentyFortyEight.push(twentyFortyEight.temp());
        customGrid.updateGrid(popped);
        int max = 2;
        for(int i = 0; i < popped.length; i++){
            for(int j = 0; j < popped.length; j++){
                if(popped[i][j] > max){
                    max = popped[i][j];
                }
            }
        }
        scoreBox.setText(String.valueOf(max));
        customGrid.changeColor(twentyFortyEight.getBoard());

    }


}
