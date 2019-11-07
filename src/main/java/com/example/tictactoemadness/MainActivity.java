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
    int randomCornerSelector = 666;
    int moveNumber = 0;
    String userSymbol = "";
    String difficultySelected = "";
    String whoGoesFirst = "";
    String curTurn = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateBoard();
    }
    public void showSelectedDifficultyFromJavaCode(){
        setContentView(R.layout.select_difficulty);
    }

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
        setContentView(R.layout.select_cross_circle);
    }

    //user picks cross -> displays difficulty selector screen
    public void select_cross (View view){
        userSymbol = "cross";
        setContentView(R.layout.select_difficulty);
    }
    //user picks circle -> displays difficulty selector screen
    public void select_circle (View view){
        userSymbol = "circle";
        setContentView(R.layout.select_difficulty);
    }

    //user selects easy -> game screen
    //100% user goes first
    public void select_easy (View view){
        difficultySelected = "easy";
        whoGoesFirst = "user";
        curTurn = "user";
        setContentView(R.layout.game_screen);
    }
    //user selects medium -> game screen
    //50% user goes first
    public void select_medium (View view){
        difficultySelected = "medium";
        int whoGoesFirstMedium = (int)(Math.random()*10);
        if (whoGoesFirstMedium < 6){
            curTurn = "user";
            whoGoesFirst = "user";
        } else {
            curTurn = "ai";
            whoGoesFirst = "ai";
        }
        setContentView(R.layout.game_screen);
        makeMove();
    }
    //user selects hard -> game screen
    //25% user goes first
    public void select_hard (View view){
        difficultySelected = "hard";
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
            System.out.println("Box Filled " + i + " " + boxFilled[i]);
        }
        //checks value of board piece
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board.length; col++){
                System.out.println("Board Value " + "row " + row + "col" + col + board[row][col]);
            }
        }
    }

    //Changes value in array to box filled
    public void boxClicked(View view){
        if (curTurn.equals("user")) {
            boxFilled[0] = true;
            board[0][0] = userSymbol;
            placeSymbol(0);
        }
    }
    public void boxClicked1(View view){
        if (curTurn.equals("user")) {
            boxFilled[1] = true;
            board[0][1] = userSymbol;
            placeSymbol(1);
        }
    }
    public void boxClicked2(View view){
        if (curTurn.equals("user")) {
            boxFilled[2] = true;
            board[0][2] = userSymbol;
            placeSymbol(2);
        }
    }
    public void boxClicked3(View view){
        if (curTurn.equals("user")) {
            boxFilled[3] = true;
            board[1][0] = userSymbol;
            placeSymbol(3);
        }
    }
    public void boxClicked4(View view){
        if (curTurn.equals("user")) {
            boxFilled[4] = true;
            board[1][1] = userSymbol;
            placeSymbol(4);
        }
    }
    public void boxClicked5(View view){
        if (curTurn.equals("user")) {
            boxFilled[5] = true;
            board[1][2] = userSymbol;
            placeSymbol(5);
        }
    }
    public void boxClicked6(View view) {
        if (curTurn.equals("user")){
            boxFilled[6] = true;
            board[2][0] = userSymbol;
            placeSymbol(6);
        }
    }
    public void boxClicked7(View view){
        if (curTurn.equals("user")) {
            boxFilled[7] = true;
            board[2][1] = userSymbol;
            placeSymbol(7);
        }
    }
    public void boxClicked8(View view){
        if (curTurn.equals("user")){
            boxFilled[8] = true;
            board[2][2] = userSymbol;
            placeSymbol(8);
        }

    }

    public void placeSymbol(int boxNum){
        if (!gameOver){
            if (curTurn.equals("user")) {
                if (userSymbol.equals("circle")) {
                    boxFilled[boxNum] = true;
                    ImageView img = findViewById(R.id.ImageCircle + boxNum);
                    img.setVisibility(View.VISIBLE);
                    moveNumber += 1;
                } else if (userSymbol.equals("cross")) {
                    boxFilled[boxNum] = true;
                    ImageView img = findViewById(R.id.ImageCross + boxNum);
                    img.setVisibility(View.VISIBLE);
                    moveNumber += 1;
                }
            } else if (curTurn.equals("ai")) {
                ArrayList convertedBoxNumber = convertBooleanArrayIntTo2DBoardValue(boxNum);
                int rowValue = Integer.parseInt(convertedBoxNumber.get(0).toString());
                int colValue = Integer.parseInt(convertedBoxNumber.get(1).toString());
                if (userSymbol.equals("cross")) {
                    boxFilled[boxNum] = true;
                    ImageView img = findViewById(R.id.ImageCircle + boxNum);
                    img.setVisibility(View.VISIBLE);
                    moveNumber += 1;
                } else if (userSymbol.equals("circle")) {
                    boxFilled[boxNum] = true;
                    ImageView img = findViewById(R.id.ImageCross + boxNum);
                    img.setVisibility(View.VISIBLE);
                    moveNumber += 1;
                }
                if (userSymbol.equals("circle")){
                    board[rowValue][colValue] = "cross";
                } else {
                    board[rowValue][colValue] = "circle";
                }
            }
            Button resetButton = findViewById(R.id.Box + boxNum);
            resetButton.setVisibility(View.INVISIBLE);
            if (curTurn.equals("user")){
                curTurn = "ai";
            } else if (curTurn.equals("ai")){
                curTurn = "user";
            }
            if (moveNumber == 9){
                if (!gameOver){
                    gameOver = true;
                    showWinScreen();
                    TextView outcomeText = (findViewById(R.id.EndOfGameText));
                    outcomeText.setText("You tied!!!");
                    return;
                }
            }
            if (moveNumber > 4){
                //check for win
                checkBoard();
            } else {
                makeMove();
            }


        } else {
            showWinScreen();
            TextView outcomeText = (findViewById(R.id.EndOfGameText));
            outcomeText.setText("You tied!!!");
        }
    }

    private void makeMove() {
        if (difficultySelected.equals("easy")){
            randomPlacer();
        } else if (difficultySelected.equals("hard") && moveNumber % 2 == 0){
            perfectGamePlacer();
        } else if (difficultySelected.equals("medium") && curTurn.equals("ai")){
            mediumModePlacer();
        }
    }
    public void resetBoard (){
        populateBoard();
        moveNumber = 0;
        gameOver = false;
    }

    public void resetDifficulty(View view){
        resetBoard();
        difficultySelected = "";
        showSelectedDifficultyFromJavaCode();
        makeMove();
    }

    public void playAgain(View view ){
        resetBoard();
        showGameScreen();
        if (difficultySelected.equals("easy")){
            whoGoesFirst = "user";
            curTurn = "user";
        } else if (difficultySelected.equals("medium")){
            int whoGoesFirstMedium = (int)(Math.random()*10);
            if (whoGoesFirstMedium < 6){
                curTurn = "user";
                whoGoesFirst = "user";
            } else {
                curTurn = "ai";
                whoGoesFirst = "ai";
                makeMove();
            }
        } else if (difficultySelected.equals("hard")){
            whoGoesFirst = "ai";
            curTurn = "ai";
            makeMove();
        }
    }

    public void showGameScreen(){
        setContentView(R.layout.game_screen);
    }

    public void randomPlacer (){
        if (gameOver){
            return;
        }
        int boxToFill = (int) (Math.random()*9);

        while ((boxFilled[boxToFill])&& !gameOver){
            boxToFill = (int) (Math.random()*9);//random number created 1-9
        }
        if (!boxFilled[boxToFill]) {

            boxFilled[boxToFill] = true;
            if (userSymbol.equals("circle")) {
                if (boxToFill == 0) {
                    ImageView aimove = findViewById(R.id.ImageCross);
                    aimove.setVisibility(View.VISIBLE);
                    Button resetButton = findViewById(R.id.Box);
                    resetButton.setVisibility(View.INVISIBLE);
                    moveNumber += 1;
                } else {
                    ImageView aimove = findViewById(R.id.ImageCross + (boxToFill));
                    aimove.setVisibility(View.VISIBLE);

                    Button resetButton = findViewById(R.id.Box + (boxToFill));
                    resetButton.setVisibility(View.INVISIBLE);

                    moveNumber += 1;
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
            } else if (userSymbol.equals("cross")) {
                boxFilled[boxToFill] = true;
                if (boxToFill == 0) {
                    ImageView aimove = findViewById(R.id.ImageCircle);
                    aimove.setVisibility(View.VISIBLE);
                    Button resetButton = findViewById(R.id.Box);
                    resetButton.setVisibility(View.INVISIBLE);
                    moveNumber += 1;
                } else {
                    ImageView aimove = findViewById(R.id.ImageCircle + (boxToFill));
                    aimove.setVisibility(View.VISIBLE);
                    Button resetButton = findViewById(R.id.Box + (boxToFill));
                    resetButton.setVisibility(View.INVISIBLE);
                    moveNumber += 1;
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
        checkBoard();
        if (moveNumber == 9){
            checkBoard();
            if (!gameOver){
                gameOver = true;
                showWinScreen();
                TextView outcomeText = (findViewById(R.id.EndOfGameText));
                outcomeText.setText("You tied!!!");
            }
        }
    }

    public void mediumModePlacer(){//AI that combines random placing and blocking wins : methods used checkBoard() randomPlacer
        if (curTurn.equals("ai") && moveNumber < 3){
            randomPlacer();
        } else {
            checkBoard();
        }
    }

    public void perfectGamePlacer(){//AI that plays perfect game
        if (moveNumber % 2 !=0){
            return;
        }
        String aiSymbol = "";
        if (userSymbol.equals("cross")){
            aiSymbol = "circle";
        } else if (userSymbol.equals("circle")){
            aiSymbol = "cross";
        }
        if (whoGoesFirst.equals("ai") && moveNumber == 0){//chooses a random corner to go
            randomCornerSelector = (int) (Math.random()*4);
            while (boxFilled[randomCornerSelector] && !gameOver){
                randomCornerSelector = (int) (Math.random()*4);
            }
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
            if (randomCornerSelector == 0 && !boxFilled[8]){
                boxFilled[8] = true;
                board[2][2] = aiSymbol;
                placeSymbol(8);
            } else if (randomCornerSelector == 0){
                boxFilled[4] = true;
                board[1][1] = aiSymbol;
                placeSymbol(4);
            }
            if (randomCornerSelector == 1 && !boxFilled[6]){
                boxFilled[6] = true;
                board[2][0] = aiSymbol;
                placeSymbol(6);
            } else if (randomCornerSelector == 1 ){
                boxFilled[4] = true;
                board[1][1] = aiSymbol;
                placeSymbol(4);
            }
            if (randomCornerSelector == 2 && !boxFilled[2]){
                boxFilled[2] = true;
                board[0][2] = aiSymbol;
                placeSymbol(2);
            } else if (randomCornerSelector == 2){
                boxFilled[4] = true;
                board[1][1] = aiSymbol;
                placeSymbol(4);
            }
            if (randomCornerSelector == 3 && !boxFilled[0]){
                boxFilled[0] = true;
                board[0][0] = aiSymbol;
                placeSymbol(0);
            } else if (randomCornerSelector == 3 && boxFilled[0]){
                boxFilled[4] = true;
                board[1][1] = aiSymbol;
                placeSymbol(4);
            }

        } else if ( moveNumber >= 4 && curTurn.equals("ai") && moveNumber % 2 == 0){
            checkBoard();
        }
        curTurn = "user";
    }
    public void checkBoard (){
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

        for (int row = 0; row < board.length; row++){

            numCirclesCurRow = 0;
            numCrossesCurRow = 0;
            numCirclesCurCol = 0;
            numCrossesCurCol = 0;
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col].equals("empty") && !difficultySelected.equals("easy") && curTurn.equals("ai")) {
                    emptySquareRow = row;
                    emptySquareCol = col;
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(emptySquareRow, emptySquareCol);
                }
                //adds for circle in col
                if (!board[col][row].equals("empty") && board[col][row].equals("circle")) {
                    numCirclesCurCol += 1;
                } else if (!board[col][row].equals("empty") && board[col][row].equals("cross")) {//adds for cross in col
                    numCrossesCurCol += 1;
                }

                //adds for circle in row
                if (!board[row][col].equals("empty") && board[row][col].equals("circle")) {
                    numCirclesCurRow += 1;
                } else if (!board[row][col].equals("empty") && board[row][col].equals("cross")) {//adds for cross in row
                    numCrossesCurRow += 1;
                }//else if value == null

                //check for win and almost win conditions
                if (numCirclesCurCol == 3) {
                    gameOver = true;
                    circleWon = true;
                } else if (numCirclesCurCol == 2 && !difficultySelected.equals("easy")) {
                    for (int col2 = 0; col2 < 3; col2++) {
                        if (board[col2][row].equals("empty")) {
                            emptySquareRow = col2;
                            emptySquareCol = row;
                            boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(emptySquareRow, emptySquareCol);
                            if (userSymbol.equals("circle")){
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
                    gameOver = true;
                    crossWon = true;
                } else if (numCrossesCurCol == 2 && !difficultySelected.equals("easy")) {
                    for (int col2 = 0; col2 < 3; col2++) {
                        if (board[col2][row].equals("empty")) {
                            emptySquareRow = col2;
                            emptySquareCol = row;
                            boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(emptySquareRow, emptySquareCol);
                            if (userSymbol.equals("cross")){
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
                    gameOver = true;
                    crossWon = true;
                } else if (numCrossesCurRow == 2 && !difficultySelected.equals("easy")) {
                    for (int col2 = 0; col2 < 3; col2++) {
                        if (board[row][col2].equals("empty")) {
                            emptySquareRow = row;
                            emptySquareCol = col2;
                            boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(emptySquareRow, emptySquareCol);
                            if (userSymbol.equals("cross")){
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
                    gameOver = true;
                    circleWon = true;
                } else if (numCirclesCurRow == 2 && !difficultySelected.equals("easy")) {
                    for (int col2 = 0; col2 < 3; col2++) {
                        if (board[row][col2].equals("empty")) {
                            emptySquareRow = row;
                            emptySquareCol = col2;
                            boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(emptySquareRow, emptySquareCol);
                            if (userSymbol.equals("circle")){
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
                if ((!difficultySelected.equals("easy") && !board[0][0].equals("empty") && board[0][0].equals("circle") && (board[1][1].equals("empty") && (!board[2][2].equals("empty") && board[2][2].equals("circle"))))) {
                    circleAlmostWin = true;
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(1, 1);
                    if (userSymbol.equals("circle")){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (!difficultySelected.equals("easy") &&(!board[0][2].equals("empty") && board[0][2].equals("circle") && (board[1][1].equals("empty") && (!board[2][0].equals("empty") && board[2][0].equals("circle"))))) {
                    circleAlmostWin = true;
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(1, 1);
                    if (userSymbol.equals("circle")){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (!difficultySelected.equals("easy") &&(board[0][0].equals("empty")  && (!board[1][1].equals("empty") && board[1][1].equals("circle")&& (!board[2][2].equals("empty") && board[2][2].equals("circle"))))) {
                        circleAlmostWin = true;
                        boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(0, 0);
                    if (userSymbol.equals("circle")){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (!difficultySelected.equals("easy") &&(!board[0][0].equals("empty")&& board[0][0].equals("circle") && (!board[1][1].equals("empty") && board[1][1].equals("circle") && (board[2][2].equals("empty"))))) {
                        circleAlmostWin = true;
                        boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(2, 2);
                    if (userSymbol.equals("circle")){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (!difficultySelected.equals("easy") &&(board[2][0].equals("empty")  && (!board[1][1].equals("empty") && board[1][1].equals("circle")&& (!board[0][2].equals("empty") && board[0][2].equals("circle"))))) {
                    circleAlmostWin = true;
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(2, 0);
                    if (userSymbol.equals("circle")){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (!difficultySelected.equals("easy") &&(board[0][2].equals("empty") && (!board[1][1].equals("empty") && board[1][1].equals("circle") && (!board[2][0].equals("empty") && board[2][0].equals("circle"))))) {
                    circleAlmostWin = true;
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(0, 2);
                    if (userSymbol.equals("circle")){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                }

                //chekcs for almost diagonal win by cross
                if (!difficultySelected.equals("easy") &&(!board[0][0].equals("empty") && board[0][0].equals("cross") && (board[1][1].equals("empty") && (!board[2][2].equals("empty") && board[2][2].equals("cross"))))) {
                    crossAlmostWin = true;
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(1, 1);
                    if (userSymbol.equals("cross")){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (!difficultySelected.equals("easy") &&(!board[0][2].equals("empty") && board[0][2].equals("cross") && (board[1][1].equals("empty") && (!board[2][0].equals("empty") && board[2][0].equals("cross"))))) {
                    crossAlmostWin = true;
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(1, 1);
                    if (userSymbol.equals("cross")){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (!difficultySelected.equals("easy") &&(board[0][0].equals("empty")  && (!board[1][1].equals("empty") && board[1][1].equals("cross")&& (!board[2][2].equals("empty") && board[2][2].equals("cross"))))) {
                    crossAlmostWin = true;
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(0, 0);
                    if (userSymbol.equals("cross")){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (!difficultySelected.equals("easy") &&(!board[0][0].equals("empty")&& board[0][0].equals("cross") && (!board[1][1].equals("empty") && board[1][1].equals("cross") && (board[2][2].equals("empty"))))) {
                    crossAlmostWin = true;
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(2, 2);
                    if (userSymbol.equals("cross")){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (!difficultySelected.equals("easy") &&(board[2][0].equals("empty")  && (!board[1][1].equals("empty") && board[1][1].equals("cross")&& (!board[0][2] .equals("empty") && board[0][2].equals("cross"))))) {
                    crossAlmostWin = true;
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(2, 0);
                    if (userSymbol.equals("cross")){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                } else if (!difficultySelected.equals("easy") &&(board[0][2].equals("empty") && (!board[1][1].equals("empty") && board[1][1].equals("cross") && (!board[2][0].equals("empty") && board[2][0].equals("cross"))))) {
                    crossAlmostWin = true;
                    boxToWinOrBlock = convert2DBoardValueToBooleanArrayInt(0, 2);
                    if (userSymbol.equals("cross")){
                        boxToWinForUser = boxToWinOrBlock;
                    }else {
                        boxToWinForAi = boxToWinOrBlock;
                    }
                }
            }

        }
        if (!gameOver && !circleWon && !crossWon&& moveNumber == 9){
            showWinScreen();
            TextView outcomeText = (findViewById(R.id.EndOfGameText));
            outcomeText.setText("You Tied!!");
        }
        //places winning move for ai
        if (!difficultySelected.equals("easy") && boxToWinOrBlock != 666 && (circleAlmostWin || crossAlmostWin) && curTurn.equals("ai") && !gameOver) {
            if (circleAlmostWin && userSymbol.equals("cross") && boxToWinForAi != 666) {
                placeSymbol(boxToWinForAi);
                circleWon = true;
            } else if (crossAlmostWin && userSymbol.equals("circle") && boxToWinForAi != 666) {
                placeSymbol(boxToWinForAi);
                crossWon = true;
            } else if (circleAlmostWin && userSymbol.equals("circle") && boxToWinForUser != 666) {
                placeSymbol(boxToWinForUser);
            } else if (crossAlmostWin && userSymbol.equals("cross") && boxToWinForUser != 666) {
                placeSymbol(boxToWinForUser);
            }
        } else if (!difficultySelected.equals("easy") && curTurn.equals("ai")){
            randomPlacer();
        }
        //adds for diagonal win for circles
        if ((!board[0][0].equals("empty") && board[0][0].equals("circle") && (!board[1][1].equals("empty") && board[1][1].equals("circle") && (!board[2][2].equals("empty") && board[2][2].equals("circle"))))){
            gameOver = true;
            circleWon = true;
        } else if ((!board[0][2].equals("empty") && board[0][2].equals("circle") && (!board[1][1].equals("empty") && board[1][1].equals("circle") && (!board[2][0].equals("empty") && board[2][0].equals("circle"))))){
            gameOver = true;
            circleWon = true;
        }

        //adds for diagonal win for circles
        if ((!board[0][0].equals("empty") && board[0][0].equals("cross") && (!board[1][1].equals("empty") && board[1][1].equals("cross") && (!board[2][2].equals("empty") && board[2][2].equals("cross"))))){
            gameOver = true;
            crossWon = true;
        } else if ((!board[0][2].equals("empty") && board[0][2].equals("cross") && (!board[1][1].equals("empty") && board[1][1].equals("cross") && (!board[2][0].equals("empty") && board[2][0].equals("cross"))))){
            gameOver = true;
            crossWon = true;
        }
        //changes game outcome text
        if (gameOver && (circleWon || crossWon)){
            showWinScreen();
            if (circleWon && userSymbol.equals("circle")){
                TextView outcomeText = (findViewById(R.id.EndOfGameText));
                outcomeText.setText("You won!!! by circle");
                return;
            } else if (circleWon && !userSymbol.equals("circle")){
                TextView outcomeText = (findViewById(R.id.EndOfGameText));
                outcomeText.setText("You lost!!! by circle");
                return;
            } else if (crossWon && userSymbol.equals("cross")){
                TextView outcomeText = (findViewById(R.id.EndOfGameText));
                outcomeText.setText("You won!!! by cross");
                return;
            } else if (crossWon && !userSymbol.equals("cross")){
                TextView outcomeText = (findViewById(R.id.EndOfGameText));
                outcomeText.setText("You lost!!! by cross");
                return;
            }
        } else if (gameOver){
            showWinScreen();
            TextView outcomeText = (findViewById(R.id.EndOfGameText));
            outcomeText.setText("You tied!!!");
            return;
        }
        if (difficultySelected.equals("easy")&& curTurn == "ai"){
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
        ArrayList<Integer> coordinates = new ArrayList<>();

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


