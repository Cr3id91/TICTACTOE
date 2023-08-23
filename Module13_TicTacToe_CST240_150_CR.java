package TICTACTOE;//imports libraries needed to execute program
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.*;
import javafx.stage.Stage;
import java.util.Random;

public class Module13_TicTacToe_CST240_150_CR extends Application //Class name becomes TicTacToe which extends application class
{
    public static void main(String[] args) //Main method header
    {
        launch(args); //Launch method is called which sets up program
    }
    @Override
    public void start(Stage primaryStage) //Method header for when begin to write code for GUI
    {
        Image Xpic = new Image("file:Xpic.png"); //Creates image object for X
        Image Opic = new Image("file:Opic.png"); //Creates image object for O

        Label winnerLabel = new Label(); //Label for who wins is made
        HBox winnerBox = new HBox(10,winnerLabel); //Label for who wins is put inside HBox layout
        winnerBox.setAlignment(Pos.CENTER); //Label is centered in HBox

        Button RefreshGame = new Button("New Game"); //Button is created the says new game
        HBox buttonBox = new HBox(10,RefreshGame); //Box is created for button
        buttonBox.setAlignment(Pos.CENTER); //Button is centered in HBox

        GridPane gameBoard = new GridPane(); //GridPane layout is created for game board
        gameBoard.setAlignment(Pos.CENTER);
        gameBoard.setHgap(10); //Horizontal gaps are set to 10 pixels between pictures
        gameBoard.setVgap(10); //Vertical gaps are set to 10 pixels between pictures

        RefreshGame.setOnAction(event -> //New game button becomes linked to the action  within the brackets
        {
            int[][] intArr = new int[3][3]; //A 3x3 2D array is created that will hold random generated numbers

            for (int c = 0; c < 3; c++) //For loop is created that will add values in a row
            {
                for (int r = 0; r < 3; r++) //For loop is created that will add values in a column
                {
                    Random rand = new Random(); //Random number object is created assigned to rand variable
                    int randomNum = rand.nextInt(2); //Random number is generated between 0 and 1 and assigned to randomNum variable
                    intArr[c][r]= randomNum; //Random number is generated into 2D array
                    if (randomNum == 0) //If number generated is 0 the X image will be placed into game board
                    {
                        gameBoard.add(new ImageView(Xpic),r,c);
                    }
                    else
                    {
                        gameBoard.add(new ImageView(Opic),r,c);
                    }
                }
            }
            boolean X_Wins = false; //Initializes X_Wins variable which help determine if variable wins
            boolean Y_Wins = false; //Initializes Y_Wins variable which help determine if variable wins

            for (int c = 0; c < 3; c++)
            {
                int sum = 0; //Sum variable initialized
                for (int r =0; r < 3; r++)
                {
                    sum += intArr[c][r];
                }
                if (sum == 0) //If sum equals zero the statement below will be executed
                {
                    X_Wins = true; //X_Wins variable will become true
                }
                else if (sum == 3) //If Sum equals three then the statement below will be executed
                {
                    Y_Wins = true; //Y_Wins variable will become true
                }
            }
            int sum = 0; // Same function as above
            for(int c = 0; c < 3; c++)
            {
                for(int r = 0; r < 3; r++)
                    sum += intArr[r][c];
            }
            if (sum == 0)
            {
                X_Wins = true;
            }
            if (sum == 3)
            {
                Y_Wins = true;
            }
            sum = 0;
            for(int r = 2,c = 0;c < 3;c++,r--)
            {
                sum += intArr[c][r];
            }
            if(sum == 0)
            {
                X_Wins = true;
            }
            if (sum == 3)
            {
                Y_Wins = true;
            }
            if(X_Wins && Y_Wins)
            {
                winnerLabel.setText("It's a tie"); //If there is a tie text will be printed
            }
            else if(X_Wins)
            {
                winnerLabel.setText("X Wins"); //If X_Wins is true text will be printed
            }
            else if(Y_Wins)
            {
                winnerLabel.setText("O Wins"); //If Y_Wins is true text will be printed
            }
            else
            {
                winnerLabel.setText("It's a tie");
            }

        });
        VBox layout = new VBox(15,gameBoard,winnerBox,buttonBox);
        layout.setPadding(new Insets(15));

        Scene scene = new Scene(layout,400,400);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Tic Tac Toe");

        primaryStage.show();
    }
}
/*
Caleb Reid
11/22/2020
Java Programming
CST 240
 */
