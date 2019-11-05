package com.example.tictactoemadness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    public String[][] board = new String[3][3];

    public Boolean boxFilled[] = new Boolean[9];

    String win = "You Won!";
    String lose = "You Lost!";

    Boolean userWon = false;
    Boolean gameOver = false;
//System.out.println("MOVEBEING INCREASED IN );
    int randomCornerSelector = 666;
    int moveNumber = 0;
    String userSymbol = "";
    String difficultySelected = "";
    String whoGoesFirst = "";
    String curTurn = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //System.out.println("Inside Main");
        setContentView(R.layout.activity_main);
        populateBoard();

    }


    public String getCurTurn(){
        return curTurn;
    }

    public String getDifficultySelected(){
        return difficultySelected;
    }
    public void showselectdifficulty(View view){
        setContentView(R.layout.select_difficulty);
    }
    public void showSelectedDifficultyFromJavaCode(){
        setContentView(R.layout.select_difficulty);
    }
    public int getMoveNumber(){
        return moveNumber;
    }
    //onclick displays selector screen

    public void populateBoard(){
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board.length; col++){
                board[row][col] = "empty";
            }
        }
        for (int i = 0; i < 9; i++){
            boxFilled[i] = false;
        }
    }
    public void select_ex_oh (View view){
        //System.out.println("Inside Select");
        setContentView(R.layout.select_cross_circle);
    }

    //user picks cross -> displays difficulty selector screen
    public void select_cross (View view){
        userSymbol = "cross";
        //System.out.println("Inside Select Cross");
        setContentView(R.layout.select_difficulty);
    }
    //user picks circle -> displays difficulty selector screen
    public void select_circle (View view){
        userSymbol = "circle";
        //System.out.println("Inside Select Circle");
        setContentView(R.layout.select_difficulty);
    }

    //user selects easy -> game screen
    //100% user goes first
    public void select_easy (View view){
        difficultySelected = "easy";
        //System.out.println("Inside Select Easy");
        whoGoesFirst = "user";
        curTurn = "user";
        setContentView(R.layout.game_screen);
    }
    //user selects medium -> game screen
    //50% user goes first
    public void select_medium (View view){
        difficultySelected = "medium";
        System.out.println("Inside Select Medium");

        int whoGoesFirstMedium = (int)(Math.random()*10);
        System.out.println("whoGoesFirstMedium " + whoGoesFirstMedium);
        if (whoGoesFirstMedium < 6){
            curTurn = "user";
            whoGoesFirst = "user";
        } else {
            curTurn = "ai";
            whoGoesFirst = "ai";
        }
        System.out.println("whoGoesFirstMedium CURTURN " + curTurn);
        setContentView(R.layout.game_screen);
        makeMove();
    }
    //user selects hard -> game screen
    //25% user goes first
    public void select_hard (View view){
        difficultySelected = "hard";
        //System.out.println("Inside Select Hard");
        whoGoesFirst = "ai";
        curTurn = "ai";

        setContentView(R.layout.game_screen);
        makeMove();
    }

    //checks values of user
    public void check_values (View view){
        System.out.println("User Symbol " + userSymbol);
        System.out.println("Difficulty Selected " + difficultySelected);
        System.out.println("Curturn " + curTurn);
        System.out.println("MoveNumber " + moveNumber);
        //System.out.println("Inside Select Hard");
        //Checks if box/board space is filled
        for (int i = 0; i < boxFilled.length;i++){
            //System.out.println("Box Filled Length " + boxFilled.length);
            System.out.println("Box Filled " + i + " " + boxFilled[i]);
        }
        //checks value of board piece
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board.length; col++){
                System.out.println("Board Value " + "row " + row + "col" + col + board[row][col]);
            }
        }
        //checks visibilty of the button
        for (int i = 0; i < 9; i++){
            Button but=(Button)findViewById(R.id.Box + (i));
            //System.out.println("Visibilty of Button " + i + " " + but.getVisibility());

        }
    }
    //Restarts board
    public void play_again (View view){
    }
    //Allows the player to change the difficulty
    public void change_difficulty (View view){
        setContentView(R.layout.select_difficulty);
    }

    //Changes value in array to box filled
    public void boxClicked(View view){
        //System.out.println("BOX");
        if (curTurn == "user") {
            boxFilled[0] = true;
            board[0][0] = userSymbol;
            placeSymbol(0);
        }
    }
    public void boxClicked1(View view){
        //System.out.println("BOX1");
        if (curTurn == "user") {
            boxFilled[1] = true;
            board[0][1] = userSymbol;
            placeSymbol(1);
        }
    }
    public void boxClicked2(View view){
        if (curTurn == "user") {
            boxFilled[2] = true;
            board[0][2] = userSymbol;
            placeSymbol(2);
        }
    }
    public void boxClicked3(View view){
        if (curTurn == "user") {
            boxFilled[3] = true;
            board[1][0] = userSymbol;
            placeSymbol(3);
        }
    }
    public void boxClicked4(View view){
        if (curTurn == "user") {
            boxFilled[4] = true;
            board[1][1] = userSymbol;
            placeSymbol(4);
        }
    }
    public void boxClicked5(View view){
        if (curTurn == "user") {
            boxFilled[5] = true;
            board[1][2] = userSymbol;
            placeSymbol(5);
        }
    }
    public void boxClicked6(View view) {
        if (curTurn == "user"){
            boxFilled[6] = true;
            board[2][0] = userSymbol;
            placeSymbol(6);
        }
    }
    public void boxClicked7(View view){
        if (curTurn == "user") {
            boxFilled[7] = true;
            board[2][1] = userSymbol;
            placeSymbol(7);
        }
    }

    public void boxClicked8(View view){
        if (curTurn == "user"){
            boxFilled[8] = true;
            board[2][2] = userSymbol;
            placeSymbol(8);
        }

    }

    public void placeSymbol(int boxNum){
        System.out.println("CURTURN " + "     " + curTurn + " BOX NUMBER " + boxNum);
        if (gameOver != true){
            if (curTurn == "user") {
                if (userSymbol.equals("circle")) {
                    boxFilled[boxNum] = true;
                    ImageView img = (ImageView) findViewById(R.id.ImageCircle + boxNum);
                    img.setVisibility(View.VISIBLE);

                    moveNumber += 1;
                    System.out.println("MOVEBEING INCREASED IN userSymbol.equals(circle)t=user " + moveNumber);
                } else if (userSymbol.equals("cross")) {//TODO: on 9th move isn't showing cross correctly
                    System.out.println("IMAGECROSS " + boxNum);
                    boxFilled[boxNum] = true;
                    ImageView img = (ImageView) findViewById(R.id.ImageCross + boxNum);
                    img.setVisibility(View.VISIBLE);

                    moveNumber += 1;
                    System.out.println("MOVEBEING INCREASED IN userSymbol.equals(cross)t=user " + moveNumber);
                }
            } else if (curTurn == "ai" ) {
                ArrayList convertedBoxNumber = convertBooleanArrayIntTo2DBoardValue(boxNum);
                System.out.println(" BOXNUM SELECTED " + boxNum);
                System.out.println("convertedBoxNumber " + convertedBoxNumber.get(0) + " " +convertedBoxNumber.get(1));
                int rowValue = Integer.parseInt(convertedBoxNumber.get(0).toString());
                int colValue = Integer.parseInt(convertedBoxNumber.get(1).toString());
                if (userSymbol.equals("cross")) {
                    boxFilled[boxNum] = true;
                    ImageView img = (ImageView) findViewById(R.id.ImageCircle + boxNum);
                    img.setVisibility(View.VISIBLE);

                    moveNumber += 1;
                    System.out.println("MOVEBEING INCREASED IN userSymbol.equals(cross)t=ai " + moveNumber);
                } else if (userSymbol.equals("circle")) {
                    boxFilled[boxNum] = true;
                    ImageView img = (ImageView) findViewById(R.id.ImageCross + boxNum);
                    img.setVisibility(View.VISIBLE);

                    moveNumber += 1;
                    System.out.println("MOVEBEING INCREASED IN userSymbol.equals(circle)t=ai " + moveNumber);

                }
                if (userSymbol == "circle"){
                    System.out.println("Pookie placesymbol " + rowValue + " " + colValue);
                    board[rowValue][colValue] = "cross";
                } else {
                    System.out.println("Pookie placesymbol " + rowValue + " " + colValue);
                    board[rowValue][colValue] = "circle";
                }
            }
            Button resetButton=(Button)findViewById(R.id.Box + boxNum);
            resetButton.setVisibility(View.INVISIBLE);
            System.out.println("CURTURNINPLACESYMBOL " + curTurn + " boxNum " + boxNum);
            if (curTurn == "user"){
                curTurn = "ai";
            } else if (curTurn == "ai"){
                curTurn = "user";
            }
            System.out.println("CURTURNINPLACESYMBOL " + curTurn + moveNumber + gameOver);

            if (moveNumber == 9){
                System.out.println("BUG IS under here and happening in checkBoard " + moveNumber);
                //checkBoard();
                System.out.println("BUG IS above here and happening in checkBoard " + moveNumber);
                if (!gameOver){
                    System.out.println(" Insidemovenum " + moveNumber);
                    gameOver = true;
                    // resetBoard();
                    showWinScreen();
                    TextView outcomeText = (TextView)(findViewById(R.id.EndOfGameText));
                    System.out.println("TIE under move 9" + moveNumber);
                    outcomeText.setText("You tied!!!");
                    return;
                }
            }
            if (moveNumber > 4){
                System.out.println("HELPMEEE " );
                //check for win
                checkBoard();
                //perfectGamePlacer();
            } else {
                makeMove();
            }


        } else if (gameOver == true ){
            System.out.println("WHYISMYCODEBROKE");
            showWinScreen();
            TextView outcomeText = (TextView)(findViewById(R.id.EndOfGameText));
            System.out.println("TIE under gameover == true" + moveNumber);
            outcomeText.setText("You tied!!!");
        }
        return;
    }

    public void showHomeScreen() {
        setContentView(R.layout.activity_main);
    }

    private void makeMove() {

        System.out.println("Move Number in MakeMove = " + moveNumber);
        if (difficultySelected == "easy"){
            randomPlacer();
        } else if (difficultySelected == "hard" && moveNumber % 2 == 0){
            System.out.println("INSIDEMAKEMOVE");
            perfectGamePlacer();
        } else if (difficultySelected == "medium" && curTurn == "ai"){
            System.out.println("INSIDEMAKEMOVEMEDIUM");
            mediumModePlacer();
        }
    }
    public void resetBoard (){
        System.out.println("INSIDERESETBOARD above populate");
        populateBoard();
        System.out.println("INSIDERESETBOARD below populate");

        moveNumber = 0;
        gameOver = false;
        System.out.println("INSIDERESETBOARD above reset image of cross ");
    }

    public void resetDifficulty(View view){
        System.out.println("inside resetdifficulty");
        resetBoard();
        difficultySelected = "";
        showSelectedDifficultyFromJavaCode();
        System.out.println("inside resetdifficulty2 curturn = " + curTurn);
        System.out.println("inside resetdifficulty2");
        makeMove();
    }

    public void playAgain(View view ){
        System.out.println("inside playAgain");
        resetBoard();
        System.out.println("inside playAgain");
        showGameScreen();
        if (difficultySelected == "easy"){
            whoGoesFirst = "user";
            curTurn = "user";
        } else if (difficultySelected == "medium"){
            int whoGoesFirstMedium = (int)(Math.random()*10);
            if (whoGoesFirstMedium < 6){
                curTurn = "user";
                whoGoesFirst = "user";
            } else {
                curTurn = "ai";
                whoGoesFirst = "ai";
                makeMove();
            }
        } else if (difficultySelected == "hard"){
            whoGoesFirst = "ai";
            curTurn = "ai";
            makeMove();
        }

        System.out.println("inside playAgain");
    }

    public void showGameScreen(){
        setContentView(R.layout.game_screen);
    }
    public void randomPlacer (){
        if (gameOver){
            return;
        }
        int boxToFill = (int) (Math.random()*9);

        while ((boxFilled[boxToFill] == true )&& !gameOver){
            //System.out.println("BOXTOFILLINSIDE RANDOM " + (boxToFill));
            boxToFill = (int) (Math.random()*9);//random number created 1-9
        }
        System.out.println("ActualRANDOMNUMBERGENERATED " + (boxToFill));
        if (boxFilled[boxToFill] == false) {

            boxFilled[boxToFill] = true;
            //System.out.println("LOOOOOOK " + boxToFill);
            if (userSymbol == "circle") {

                //System.out.println("Inside FILL NULL BOX ");
                if (boxToFill == 0) {
                    //System.out.println("WHICH BOX IS IT? ImageCross" );
                    //placeSymbol(0);
                    ImageView aimove = (ImageView) findViewById(R.id.ImageCross);
                    aimove.setVisibility(View.VISIBLE);

                    Button resetButton = (Button) findViewById(R.id.Box);
                    resetButton.setVisibility(View.INVISIBLE);

                    moveNumber += 1;
                    System.out.println("MOVEBEING INCREASED IN randomplacer us=circle " + moveNumber);
                } else {
                    //System.out.println("WHICH BOX IS IT? ImageCross" + (boxToFill));
                    //placeSymbol(boxToFill);
                    ImageView aimove = (ImageView) findViewById(R.id.ImageCross + (boxToFill));
                    aimove.setVisibility(View.VISIBLE);

                    Button resetButton = (Button) findViewById(R.id.Box + (boxToFill));
                    resetButton.setVisibility(View.INVISIBLE);

                    moveNumber += 1;
                    System.out.println("MOVEBEING INCREASED IN randomplacer us=circle " + moveNumber);
                }


                boxFilled[boxToFill] = true;
                if (boxToFill == 0) {
                    board[0][0] = "cross";
                } else if (boxToFill == 1) {
                    board[0][1] = "cross";
                } else if (boxToFill == 2) {
                    board[0][2] = "cross";
                } else if (boxToFill == 3) {
                    board[1][0] = "cross";
                } else if (boxToFill == 4) {
                    board[1][1] = "cross";
                } else if (boxToFill == 5) {
                    board[1][2] = "cross";
                } else if (boxToFill == 6) {
                    board[2][0] = "cross";
                } else if (boxToFill == 7) {
                    board[2][1] = "cross";
                } else if (boxToFill == 8) {
                    board[2][2] = "cross";
                }
            } else if (userSymbol == "cross") {
                //System.out.println("Inside FILL NULL BOX ");

                boxFilled[boxToFill] = true;
                if (boxToFill == 0) {
                    //System.out.println("WHICH BOX IS IT? ImageCircle" );
                    //placeSymbol(0);
                    ImageView aimove = (ImageView) findViewById(R.id.ImageCircle);
                    aimove.setVisibility(View.VISIBLE);
                    Button resetButton = (Button) findViewById(R.id.Box);
                    resetButton.setVisibility(View.INVISIBLE);
                    moveNumber += 1;
                    System.out.println("MOVEBEING INCREASED IN userSymbol.equals(cross) " + moveNumber);
                } else {
                    //System.out.println("WHICH BOX IS IT? ImageCircle" + (boxToFill));
                    //placeSymbol(boxToFill);
                    ImageView aimove = (ImageView) findViewById(R.id.ImageCircle + (boxToFill));
                    aimove.setVisibility(View.VISIBLE);
                    Button resetButton = (Button) findViewById(R.id.Box + (boxToFill));
                    resetButton.setVisibility(View.INVISIBLE);

                    moveNumber += 1;
                    System.out.println("MOVEBEING INCREASED IN userSymbol.equals(cross) " + moveNumber);
                }
                if (boxToFill == 0) {
                    board[0][0] = "circle";
                } else if (boxToFill == 1) {
                    board[0][1] = "circle";
                } else if (boxToFill == 2) {
                    board[0][2] = "circle";
                } else if (boxToFill == 3) {
                    board[1][0] = "circle";
                } else if (boxToFill == 4) {
                    board[1][1] = "circle";
                } else if (boxToFill == 5) {
                    board[1][2] = "circle";
                } else if (boxToFill == 6) {
                    board[2][0] = "circle";
                } else if (boxToFill == 7) {
                    board[2][1] = "circle";
                } else if (boxToFill == 8) {
                    board[2][2] = "circle";
                }
            }

            curTurn = "user";

        }
        if (moveNumber == 9){
            checkBoard();
            if (!gameOver){
                //System.out.println(" Insidemovenum " + moveNumber);
                gameOver = true;
                // resetBoard();
                showWinScreen();
                TextView outcomeText = (TextView)(findViewById(R.id.EndOfGameText));
                System.out.println("TIE " + moveNumber);
                outcomeText.setText("You tied!!!");
                return;
            }
        }
    }

    public void mediumModePlacer(){//AI that combines random placing and blocking wins : methods used checkBoard() randomPlacer
        if (curTurn == "ai" && moveNumber < 3){
            randomPlacer();
        } else if (curTurn == "ai" && moveNumber > 2){
            checkBoard();
        }

    }

    public void perfectGamePlacer(){//AI that plays perfect game
        //System.out.println("INSIDE PERFECT");
        if (moveNumber % 2 !=0){
            return;
        }
        String aiSymbol = "";
        if (userSymbol == "cross"){
            aiSymbol = "circle";
        } else if (userSymbol == "circle"){
            aiSymbol = "cross";
        }
        if (whoGoesFirst.equals("ai") && moveNumber == 0){//chooses a random corner to go
            randomCornerSelector = (int) (Math.random()*4);
            while (boxFilled[randomCornerSelector] && !gameOver){
                randomCornerSelector = (int) (Math.random()*4);
            }
            //System.out.println("randomCornerSelector " + randomCornerSelector);
            if (randomCornerSelector == 0){

                boxFilled[0] = true;
                board[0][0] = aiSymbol;

                placeSymbol(0);

            } else if (randomCornerSelector == 1 ){
                boxFilled[2] = true;
                board[0][2] = aiSymbol;

                placeSymbol(2);

            } else if (randomCornerSelector == 2){
                boxFilled[6] = true;
                board[2][0] = aiSymbol;

                placeSymbol(6);

            } else if (randomCornerSelector == 3){
                boxFilled[8] = true;
                board[2][2] = aiSymbol;

                placeSymbol(8);

            }

        } else if (moveNumber == 2){//second mover
            //System.out.println("INSIDEMOVE@@@@ " + randomCornerSelector);
            if (randomCornerSelector == 0 && !boxFilled[8]){
                //System.out.println("INSIDEMOVERANSELECT 0 !8");
                boxFilled[8] = true;
                board[2][2] = aiSymbol;
                placeSymbol(8);
            } else if (randomCornerSelector == 0 && boxFilled[8]){
                //System.out.println("INSIDEMOVERANSELECT 0 8@@@@");
                boxFilled[4] = true;
                board[1][1] = aiSymbol;
                placeSymbol(4);
            }
            if (randomCornerSelector == 1 && !boxFilled[6]){
                //System.out.println("INSIDEMOVERANSELECT 1 !6");
                boxFilled[6] = true;
                board[2][0] = aiSymbol;
                placeSymbol(6);
            } else if (randomCornerSelector == 1 && boxFilled[6]){
                //System.out.println("INSIDEMOVERANSELECT 1 6");
                boxFilled[4] = true;
                board[1][1] = aiSymbol;
                placeSymbol(4);
            }

            if (randomCornerSelector == 2 && !boxFilled[2]){
                //System.out.println("INSIDEMOVERANSELECT 2 !2");
                boxFilled[2] = true;
                board[0][2] = aiSymbol;
                placeSymbol(2);
            } else if (randomCornerSelector == 2 && boxFilled[2]){
                //System.out.println("INSIDEMOVERANSELECT 2 2");
                boxFilled[4] = true;
                board[1][1] = aiSymbol;
                placeSymbol(4);
            }
            if (randomCornerSelector == 3 && !boxFilled[0]){
                //System.out.println("INSIDEMOVERANSELECT 3 !0");
                boxFilled[0] = true;
                board[0][0] = aiSymbol;
                placeSymbol(0);
            } else if (randomCornerSelector == 3 && boxFilled[0]){
                //System.out.println("INSIDEMOVERANSELECT 3 0");
                boxFilled[4] = true;
                board[1][1] = aiSymbol;
                placeSymbol(4);
            }

        } else if ( moveNumber >= 4 && curTurn == "ai" && moveNumber % 2 == 0){
            checkBoard();
        }
        curTurn = "user";
    }
    public void checkBoard (){
        System.out.println("insideofcheckboard");

        int numCirclesCurCol = 0;
        int numCrossesCurCol = 0;
        int numCirclesCurRow = 0;
        int numCrossesCurRow = 0;

        int emptySquareCol = 666;
        int emptySquareRow = 666;

        int boxToWinOrBlock = 666;
        int boxToWinForUser = 666;
        int boxToWinForAi = 666;

        Boolean crossWon = false;
        Boolean circleWon = false;

        Boolean circleAlmostWin = false;
        Boolean crossAlmostWin = false;

        //make blank space variable

        for (int row = 0; row < board.length; row++){

            numCirclesCurRow = 0;
            numCrossesCurRow = 0;
            numCirclesCurCol = 0;
            numCrossesCurCol = 0;
            for (int col = 0; col < board[0].length; col++) {
                //System.out.println("VALUE AT ROW " + row + " AT COL " + col + " " + board[row][col].toString());
                if (board[row][col] == "empty" && difficultySelected != "easy" && curTurn == "ai") {
                    //System.out.println("Empty spaces " + row + " AT COL " + col + " ");
                    emptySquareRow = row;
                    emptySquareCol = col;
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(emptySquareRow, emptySquareCol);
                    //System.out.println("Empty spaces BOXSQUARE " + boxToWinOrBlock);
                }
                //adds for circle in col
                if (board[col][row] != "empty" && board[col][row].equals("circle")) {
                    numCirclesCurCol += 1;
                    //System.out.println("numCirclesCurCol " + numCirclesCurCol + " ROW " + row + " COL " + col);
                } else if (board[col][row] != "empty" && board[col][row].equals("cross")) {//adds for cross in col
                    numCrossesCurCol += 1;
                    //System.out.println("numCrossesCurCol " + numCrossesCurCol + " ROW " + row + " COL " + col);
                } //else if value == null


                //adds for circle in row
                System.out.println("numCirclesCurRow " + numCirclesCurRow + " ROW " + row + " COL " + col);
                if (board[row][col] != "empty" && board[row][col].equals("circle")) {
                    numCirclesCurRow += 1;
                    System.out.println("numCirclesCurRow " + numCirclesCurRow + " ROW " + row + " COL " + col);
                } else if (board[row][col] != "empty" && board[row][col].equals("cross")) {//adds for cross in row
                    numCrossesCurRow += 1;
                    //System.out.println("numCrossesCurRow " + numCrossesCurRow + " ROW " + row + " COL " + col);
                }//else if value == null


                //chekc for win and almost win conditions
                if (numCirclesCurCol == 3) {
                    //System.out.println("CIRCLEWONCOL");
                    gameOver = true;
                    circleWon = true;
                } else if (numCirclesCurCol == 2 && difficultySelected !="easy") {
                    //System.out.println("numCircleCurColAlmostWin col " + emptySquareCol + " row " + emptySquareRow);


                    for (int col2 = 0; col2 < 3; col2++) {
                        if (board[col2][row] == "empty") {
                            emptySquareRow = col2;
                            emptySquareCol = row;
                            //System.out.println("numCirclesCurColAlmostWin row " + row2 + " col " + 1);
                            boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(emptySquareRow, emptySquareCol);
                            System.out.println("numCirclesCurColWINNINGSQUARE " + boxToWinOrBlock);
                            if (userSymbol == "circle"){
                                boxToWinForUser = boxToWinOrBlock;
                            }else {
                                boxToWinForAi = boxToWinOrBlock;
                            }
                            circleAlmostWin = true;
                        }
                    }
                    //place in current col
                }

                if (numCrossesCurCol == 3) {
                    //System.out.println("CROSSWONCOL");
                    gameOver = true;
                    crossWon = true;
                } else if (numCrossesCurCol == 2 && difficultySelected !="easy") {
                    //System.out.println("numCrossesCurColAlmostWin emptySquareCol " + emptySquareCol + " row " + emptySquareRow);

                    for (int col2 = 0; col2 < 3; col2++) {
                        if (board[col2][row] == "empty") {
                            emptySquareRow = col2;
                            emptySquareCol = row;
                            //System.out.println("numCrossesCurColAlmostWin row " + row2 + " col " + 1);
                            boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(emptySquareRow, emptySquareCol);
                            System.out.println("numCrossesCurColAlmostWinWINNINGSQUARE " + boxToWinOrBlock);
                            if (userSymbol == "cross"){
                                boxToWinForUser = boxToWinOrBlock;
                            } else {
                                boxToWinForAi = boxToWinOrBlock;
                            }
                            crossAlmostWin = true;
                        }
                    }
                    //place in current col
                }

                if (numCrossesCurRow == 3) {
                    //System.out.println("CROSSWONROW");
                    gameOver = true;
                    crossWon = true;
                } else if (numCrossesCurRow == 2 && difficultySelected !="easy") {
                    //System.out.println("numCrossesCurRowAlmostWin emptySquareCol "+ emptySquareRow + " ROW " +  emptySquareCol );

                    for (int col2 = 0; col2 < 3; col2++) {
                        if (board[row][col2] == "empty") {
                            emptySquareRow = row;
                            emptySquareCol = col2;
                            //System.out.println("numCrossesCurRowAlmostWin row"+ 1 + " col " +  col2 );
                            boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(emptySquareRow, emptySquareCol);
                            System.out.println("numCrossesCurRowAlmostWinWINNINGSQUARE " + boxToWinOrBlock);
                            if (userSymbol == "cross"){
                                boxToWinForUser = boxToWinOrBlock;
                            }else {
                                boxToWinForAi = boxToWinOrBlock;
                            }
                            crossAlmostWin = true;
                        }
                    }
                    //place in current row
                }

                if (numCirclesCurRow == 3) {
                    //System.out.println("CIRCLEWONROW");
                    gameOver = true;
                    circleWon = true;
                    //setContentView(R.layout.game_over_screen);
                } else if (numCirclesCurRow == 2 && difficultySelected !="easy") {
                    //System.out.println("numCirclesCurRowAlmostWin emptySquareCol "+ emptySquareRow + " ROW " +  emptySquareCol );

                    for (int col2 = 0; col2 < 3; col2++) {
                        if (board[row][col2] == "empty") {
                            emptySquareRow = row;
                            emptySquareCol = col2;
                            System.out.println("numCirclesCurRowAlmostWin row"+ row + " col " +  col2 );
                            boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(emptySquareRow, emptySquareCol);
                            System.out.println("numCirclesCurRowAlmostWinWINNINGSQUARE " + boxToWinOrBlock);
                            if (userSymbol == "circle"){
                                boxToWinForUser = boxToWinOrBlock;
                            } else {
                                boxToWinForAi = boxToWinOrBlock;
                            }
                            circleAlmostWin = true;
                        }

                    }

                    //place in current row
                }

                //chekcs for almost diagonal win by circle
                if ((difficultySelected != "easy" && board[0][0] != "empty" && board[0][0].equals("circle") && (board[1][1] == "empty" && (board[2][2] != "empty" && board[2][2].equals("circle"))))) {
                    circleAlmostWin = true;
                    System.out.println("CIRCLEalmostWONDIAGONAL");
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(1, 1);
                    if (userSymbol == "circle"){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (difficultySelected != "easy" &&(board[0][2] != "empty" && board[0][2].equals("circle") && (board[1][1] == "empty" && (board[2][0] != "empty" && board[2][0].equals("circle"))))) {
                    circleAlmostWin = true;
                    System.out.println("CIRCLEalmostWONDIAGONAL");
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(1, 1);
                    if (userSymbol == "circle"){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (difficultySelected != "easy" &&(board[0][0] == "empty"  && (board[1][1] != "empty" && board[1][1].equals("circle")&& (board[2][2] != "empty" && board[2][2].equals("circle"))))) {
                        circleAlmostWin = true;
                        System.out.println("CIRCLEalmostWONDIAGONAL");
                        boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(0, 0);
                    if (userSymbol == "circle"){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (difficultySelected != "easy" &&(board[0][0] != "empty"&& board[0][0].equals("circle") && (board[1][1] != "empty" && board[1][1].equals("circle") && (board[2][2] == "empty")))) {
                        circleAlmostWin = true;
                        System.out.println("CIRCLEalmostWONDIAGONAL");
                        boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(2, 2);
                    if (userSymbol == "circle"){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (difficultySelected != "easy" &&(board[2][0] == "empty"  && (board[1][1] != "empty" && board[1][1].equals("circle")&& (board[0][2] != "empty" && board[0][2].equals("circle"))))) {
                    circleAlmostWin = true;
                    System.out.println("CIRCLEalmostWONDIAGONAL");
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(2, 0);
                    if (userSymbol == "circle"){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (difficultySelected != "easy" &&(board[0][2] == "empty" && (board[1][1] != "empty" && board[1][1].equals("circle") && (board[2][0] != "empty" && board[2][0].equals("circle"))))) {
                    circleAlmostWin = true;
                    System.out.println("CIRCLEalmostWONDIAGONAL");
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(0, 2);
                    if (userSymbol == "circle"){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                }


                //chekcs for almost diagonal win by cross
                if (difficultySelected != "easy" &&(board[0][0] != "empty" && board[0][0].equals("cross") && (board[1][1] == "empty" && (board[2][2] != "empty" && board[2][2].equals("cross"))))) {
                    crossAlmostWin = true;
                    System.out.println("CROSSalmostWONDIAGONAL");
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(1, 1);
                    if (userSymbol == "cross"){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (difficultySelected != "easy" &&(board[0][2] != "empty" && board[0][2].equals("cross") && (board[1][1] == "empty" && (board[2][0] != "empty" && board[2][0].equals("cross"))))) {
                    crossAlmostWin = true;
                    System.out.println("CROSSalmostWONDIAGONAL");
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(1, 1);
                    if (userSymbol == "cross"){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (difficultySelected != "easy" &&(board[0][0] == "empty"  && (board[1][1] != "empty" && board[1][1].equals("cross")&& (board[2][2] != "empty" && board[2][2].equals("cross"))))) {
                    crossAlmostWin = true;
                    System.out.println("CROSSalmostWONDIAGONAL");
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(0, 0);
                    if (userSymbol == "cross"){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (difficultySelected != "easy" &&(board[0][0] != "empty"&& board[0][0].equals("cross") && (board[1][1] != "empty" && board[1][1].equals("cross") && (board[2][2] == "empty")))) {
                    crossAlmostWin = true;
                    System.out.println("CROSSalmostWONDIAGONAL");
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(2, 2);
                    if (userSymbol == "cross"){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (difficultySelected != "easy" &&(board[2][0] == "empty"  && (board[1][1] != "empty" && board[1][1].equals("cross")&& (board[0][2] != "empty" && board[0][2].equals("cross"))))) {
                    crossAlmostWin = true;
                    System.out.println("CROSSalmostWONDIAGONAL");
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(2, 0);
                    if (userSymbol == "cross"){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (difficultySelected != "easy" &&(board[0][2] == "empty" && (board[1][1] != "empty" && board[1][1].equals("cross") && (board[2][0] != "empty" && board[2][0].equals("cross"))))) {
                    crossAlmostWin = true;
                    System.out.println("CROSSalmostWONDIAGONAL");
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(0, 2);
                    if (userSymbol == "cross"){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                }
            }

        }
        if (!gameOver && !circleWon && !crossWon&& moveNumber == 9){
            System.out.println("CHECKINGININSIDEOFCHECKBOARD " );
            showWinScreen();
            TextView outcomeText = (TextView)(findViewById(R.id.EndOfGameText));
            System.out.println("You Tied!!");
            outcomeText.setText("You Tied!!");
        }
        //places winning move for ai
        System.out.println("CHECKINGIN " + moveNumber + circleWon + crossWon + gameOver);
        if (difficultySelected != "easy" && boxToWinOrBlock != 666 && (circleAlmostWin || crossAlmostWin) && curTurn == "ai" && !gameOver) {
            //System.out.println("INSIDE OF DIFFICULTYSLECTED IN CHECK");
            //System.out.println("CHECK " + circleAlmostWin + " " + crossAlmostWin);
            System.out.println("INSIDE OF DIFFICULTYSLECTED IN CHECK " + circleAlmostWin + crossAlmostWin);
            if (circleAlmostWin && userSymbol == "cross" && boxToWinForAi != 666) {
                System.out.println("INSIDE OF circleAlmostWin IN CHECK WIN " +boxToWinForAi);
                placeSymbol(boxToWinForAi);
                System.out.println("PUKE circleAlmostWin IN CHECK WIN " + boxToWinForAi);
                return;
            } else if (crossAlmostWin && userSymbol == "circle" && boxToWinForAi != 666) {
                System.out.println("INSIDE OF crossAlmostWin IN CHECK WIN " + boxToWinForAi);
                placeSymbol(boxToWinForAi);
                System.out.println("PUKE crossAlmostWin IN CHECK WIN " + boxToWinOrBlock);
                return;
            } else if (circleAlmostWin && userSymbol == "circle" && boxToWinForUser != 666) {
                System.out.println("INSIDE OF circleAlmostWin IN CHECK BLOCK " + boxToWinForUser);
                placeSymbol(boxToWinForUser);
                System.out.println("PUKE circleAlmostWin IN CHECK BLOCK " + boxToWinOrBlock);
                return;
            } else if (crossAlmostWin && userSymbol == "cross" && boxToWinForUser != 666) {
                System.out.println("INSIDE OF crossAlmostWin IN CHECK BLOCK " + boxToWinForUser);
                placeSymbol(boxToWinForUser);
                System.out.println("PUKE crossAlmostWin IN CHECK BLOCK " + boxToWinOrBlock);
                return;
            }
        } else if (difficultySelected != "easy" && curTurn == "ai"){
            randomPlacer();
            System.out.println("SYSTEMISCONFUSEDBCNOLOGICALMOVES");
        }
        System.out.println("Vomiting " + !circleAlmostWin + !crossAlmostWin + curTurn == "ai");
        //adds for diagonal win for circles
        if ((board[0][0] != "empty" && board[0][0].equals("circle") && (board[1][1] != "empty" && board[1][1].equals("circle") && (board[2][2] != "empty" && board[2][2].equals("circle"))))){
            gameOver = true;
            circleWon = true;
            System.out.println("CIRCLEWONDIAGONAL");
        } else if ((board[0][2] != "empty" && board[0][2].equals("circle") && (board[1][1] != "empty" && board[1][1].equals("circle") && (board[2][0] != "empty" && board[2][0].equals("circle"))))){
            gameOver = true;
            circleWon = true;
            System.out.println("CIRCLEWONDIAGONAL");
        }


        //adds for diagonal win for circles
        if ((board[0][0] != "empty" && board[0][0].equals("cross") && (board[1][1] != "empty" && board[1][1].equals("cross") && (board[2][2] != "empty" && board[2][2].equals("cross"))))){
            gameOver = true;
            crossWon = true;
            System.out.println("CROSSWONDIAGONAL");
        } else if ((board[0][2] != "empty" && board[0][2].equals("cross") && (board[1][1] != "empty" && board[1][1].equals("cross") && (board[2][0] != "empty" && board[2][0].equals("cross"))))){
            gameOver = true;
            crossWon = true;
            System.out.println("CROSSWONDIAGONAL");
        }
        System.out.println( "CIRCLE WON " + circleWon + " CROSSWON " + crossWon);
        //changes game outcome text
        if (gameOver && (circleWon || crossWon)){
            System.out.println( "IFGAMEOVERMOVE NUM " + moveNumber);
            showWinScreen();
            System.out.println( "CIRCLE WON " + circleWon + " CROSSWON " + crossWon);
            if (circleWon && userSymbol == "circle"){
                TextView outcomeText = (TextView)(findViewById(R.id.EndOfGameText));
                System.out.println("You won!!! by circle");
                outcomeText.setText("You won!!! by circle");
                return;
            } else if (circleWon && userSymbol != "circle"){
                TextView outcomeText = (TextView)(findViewById(R.id.EndOfGameText));
                System.out.println("You lost!!! by circle");
                outcomeText.setText("You lost!!! by circle");
                return;
            } else if (crossWon && userSymbol == "cross"){
                TextView outcomeText = (TextView)(findViewById(R.id.EndOfGameText));
                System.out.println("You won!!! by cross");
                outcomeText.setText("You won!!! by cross");
                return;
            } else if (crossWon && userSymbol != "cross"){
                TextView outcomeText = (TextView)(findViewById(R.id.EndOfGameText));
                System.out.println("You lost!!! by cross");
                outcomeText.setText("You lost!!! by cross");
                return;
            }
        } else if (gameOver){
            showWinScreen();
            TextView outcomeText = (TextView)(findViewById(R.id.EndOfGameText));
            System.out.println("TIE under checkboard" + moveNumber);
            outcomeText.setText("You tied!!!");
            return;
        }
        if (difficultySelected == "easy"){
            randomPlacer();
        }
    }
    public int convert2DBoardValueToBooleanArrayInt(int row, int col){
        if (row == col && col == 0){//box
            return 0;
        } else if (row == 0 && col == 1){//box1
            return 1;
        } else if (row == 0 && col == 2){//box2
            return 2;
        } else if (row == 1 && col == 0){//box3
            return 3;
        } else if (row == 1 && col == 1){//box4
            return 4;
        } else if (row == 1 && col == 2){//box5
            return 5;
        } else if (row == 2 && col == 0){//box6
            return 6;
        } else if (row == 2 && col == 1){//box7
            return 7;
        } else if (row == 2 && col == 2){//box8
            return 8;
        }
        return 666;
    }

    public ArrayList<Integer> convertBooleanArrayIntTo2DBoardValue(int integerValue){
        ArrayList<Integer> coordinates = new ArrayList<Integer>();

        if (integerValue == 0){//box
            coordinates.add(0);
            coordinates.add(0);
            return coordinates;
        } else if (integerValue == 1){//box1
            coordinates.add(0);
            coordinates.add(1);
            return coordinates;
        } else if (integerValue == 2){//box2
            coordinates.add(0);
            coordinates.add(2);
            return coordinates;
        } else if (integerValue == 3){//box3
            coordinates.add(1);
            coordinates.add(0);
            return coordinates;
        } else if (integerValue == 4){//box4
            coordinates.add(1);
            coordinates.add(1);
            return coordinates;
        } else if (integerValue == 5){//box5
            coordinates.add(1);
            coordinates.add(2);
            return coordinates;
        } else if (integerValue == 6){//box6
            coordinates.add(2);
            coordinates.add(0);
            return coordinates;
        } else if (integerValue == 7){//box7
            coordinates.add(2);
            coordinates.add(1);
            return coordinates;
        } else if (integerValue == 8){//box8
            coordinates.add(2);
            coordinates.add(2);
            return coordinates;
        }
        return coordinates;
    }
    public void showWinScreen(){
        setContentView(R.layout.game_over_screen);
    }


}

    //    void toast (View view){
//        Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
//    }

