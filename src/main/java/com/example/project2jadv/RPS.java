/*My name is Ammaad Denmark.
 And this is my program for Rock, Paper, Scissors.
 As a part of project 2 for CSC 225.

 The purpose of this program is to create an
 RPS game with an interactive GUI. Using concepts
 across modules 4 and 5.*/

package com.example.project2jadv;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class RPS extends Application {

    //Lets declare our variables and constants.

    final double SPACE_OUT = 15;
    final int ROCK = 0;
    final int PAPER = 1;
    final int SCISSORS = 2;

    int user_wins = 0;
    int user_losses = 0;
    int ties = 0;
    int rounds_played = 0;
    int roundNum2 = 0;

    @Override
    public void start(Stage stage) throws IOException {



        Random rand = new Random();/*rand is the object linked to the random class.
        The number in the parentheses of the nextInt() method
        will determine the range from which the computer can choose from.
        It will choose from 0 to 2 (but not 3).
      This represents the computers turn.*/


        //Part 1, opening startScene.

        Label introLabel = new Label("Rock, Paper, Scissors.");
        introLabel.setFont(new Font("Arial", 30));
        //Once we have a label object, we can set its font and size.

        introLabel.setMaxWidth(Double.MAX_VALUE);
        introLabel.setAlignment(Pos.CENTER);
        //Sets our label to the center.

        introLabel.setTextFill(Color.RED);
        //The set text fill method will assign our label a color.

        Label nameLabel = new Label("Enter name here: ");
        nameLabel.setFont(new Font("Arial", 15));
        nameLabel.setTextFill(Color.BLUE);
        nameLabel.setMaxWidth(Double.MAX_VALUE);
        nameLabel.setAlignment(Pos.TOP_LEFT);

        Label roundsLabel = new Label("Enter number of rounds: ");
        roundsLabel.setFont(new Font("Arial", 15));
        roundsLabel.setTextFill(Color.BLUE);
        roundsLabel.setMaxWidth(Double.MAX_VALUE);
        roundsLabel.setAlignment(Pos.TOP_LEFT);

        Label errorLabel = new Label("");
        errorLabel.setFont(new Font("Arial", 30));
        errorLabel.setTextFill(Color.RED);
        errorLabel.setMaxWidth(Double.MAX_VALUE);
        errorLabel.setAlignment(Pos.CENTER);

        /*Next, we add 2 empty TextField objects that will
        receive input from the user. The first will get their name,
        and the other will get the number of rounds.*/

        TextField inputName = new TextField("");
        TextField inputRounds = new TextField("");

        //Next, we make a start button.
        Button startButton = new Button("Click to Start!");
        startButton.setAlignment(Pos.CENTER);
        startButton.setTextFill(Color.GREEN);

        /*The VBox will contain all controls in order from TOP to BOTTOM.
        A root node is an object that groups/lays out all the components inside it.*/
        VBox root = new VBox(introLabel, nameLabel, inputName, roundsLabel, inputRounds, errorLabel, startButton);
        //The order their input, (from left to right), formats from top to down.

        root.setPadding(new Insets(SPACE_OUT));/*This will add space between the
        4 edges of the window and the grouping of controls within.*/

        root.setSpacing(SPACE_OUT);/*The setSpacing() method sets
        spacing vertically between the controls.
        This method ONLY affects the spacing vertically between nodes in the VBox.*/

        /*Lastly, startScene and stage. The startScene is a 2nd level container and
        contains all visual GUI components inside.*/

        Scene startScene = new Scene(root, 600, 600);
        /*Scene object with our VBox root node passed in.
        The 600's are width and height.*/
        stage.setScene(startScene);//Scene must be set on stage in order to be visible.
        stage.setTitle("Rock, Paper, Scissors.");
        stage.show();

        //Input our images, HERE Ms.Shaffer
        Image rockImage = new Image("file:src/main/resources/Images/RockHand.jpg", 150, 0, true, true);
        Image paperImage = new Image("file:src/main/resources/Images/PaperHand.png", 150, 0, true, true);
        Image scissorImage = new Image("file:src/main/resources/Images/ScissorHand.png", 150, 0, true, true);


        ImageView imageView1 = new ImageView(rockImage);
        ImageView imageView2 = new ImageView(paperImage);
        ImageView imageView3 = new ImageView(scissorImage);



        //This HBox object should align our images horizontally.
        //HERE also.
        HBox alignPicsHoriz = new HBox(imageView1, imageView2, imageView3);
        alignPicsHoriz.setSpacing(135);
        alignPicsHoriz.setMaxWidth(Double.MAX_VALUE);
        alignPicsHoriz.setAlignment(Pos.CENTER);

        Label messageLabel = new Label( " ");
        //This label will contain the users name and ask them to select an image.

        //Next we need to create labels for the users wins, losses and ties, and round.

        Label roundsLabel2 = new Label( "Round: ");
        roundsLabel2.setFont(new Font("Arial", 20));
        TextField roundsOutput = new TextField("");

        Label winsLabel = new Label( "Wins: ");
        winsLabel.setFont(new Font("Arial", 20));
        TextField winsOutput = new TextField("");

        Label lossesLabel = new Label( "Losses: ");
        lossesLabel.setFont(new Font("Arial", 20));
        TextField lossesOutput= new TextField("");

        Label tiesLabel = new Label( "Ties: ");
        tiesLabel.setFont(new Font("Arial", 20));
        TextField tiesOutput= new TextField("");

        HBox alignStatsHoriz = new HBox( roundsLabel2, roundsOutput, winsLabel, winsOutput,
                lossesLabel, lossesOutput, tiesLabel, tiesOutput);
        alignStatsHoriz.setSpacing(50);
        alignStatsHoriz.setMaxWidth(Double.MAX_VALUE);
        alignStatsHoriz.setAlignment(Pos.CENTER);

        //These labels will display what the user and comp chose on each turn.
        Label userChoiceLabel = new Label(" ");
        userChoiceLabel.setTextFill(Color.BLUE);

        Label compChoiceLabel = new Label(" ");
        compChoiceLabel.setTextFill(Color.RED);

        Label winnerLabel = new Label(" ");
        winnerLabel.setTextFill(Color.GREEN);

        Label gameOverLabel = new Label(" ");
        gameOverLabel.setTextFill(Color.RED);
        gameOverLabel.setFont(new Font("Arial", 50));
        gameOverLabel.setMaxWidth(Double.MAX_VALUE);
        gameOverLabel.setAlignment(Pos.CENTER);

        HBox alignChoicesHoriz = new HBox(userChoiceLabel, compChoiceLabel, winnerLabel);
        alignChoicesHoriz.setSpacing(135);
        alignChoicesHoriz.setMaxWidth(Double.MAX_VALUE);
        alignChoicesHoriz.setAlignment(Pos.CENTER);

        Button mmButton = new Button("Main Menu.");
        Button restartButton = new Button("Restart.");
        Button chartButton = new Button("See Chart.");

        HBox alignButtonsHoriz = new HBox(mmButton, restartButton, chartButton);
        alignButtonsHoriz.setSpacing(135);
        alignButtonsHoriz.setMaxWidth(Double.MAX_VALUE);
        alignButtonsHoriz.setAlignment(Pos.CENTER);

        VBox root2 = new VBox(alignPicsHoriz, messageLabel, alignStatsHoriz, alignChoicesHoriz,
                alignButtonsHoriz, gameOverLabel);

        root2.setPadding(new Insets(SPACE_OUT));/*This will add space between the
        4 edges of the window and the grouping of controls within.*/

        root2.setSpacing(SPACE_OUT);/*The setSpacing() method sets
        spacing vertically between the controls.
        This method ONLY affects the spacing vertically between nodes in the VBox.*/

        /*Now we need to create a new Scene that will open
        when the user enters valid input for name
        and number of rounds.*/

        Scene gameScene = new Scene(root2, 800, 400);
        Stage gameStage = new Stage();
        gameStage.setTitle("Game Time!");
        gameStage.setScene(gameScene);


        /*Alright, now we need to create a new class that
         will implement the EventHandler Interface.
         This class within our main is an Anonymous class.*/


        startButton.setOnAction(e ->{//Use the lambda expression to create an event handler.


            String user_name = inputName.getText();/*Call the getText method
            on our input Name object to get user input and store it in a string variable.*/

            String roundNum = inputRounds.getText();
            roundNum2 = Integer.parseInt(roundNum);

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert!");
            alert.setHeaderText("This is an alert!");

            if(user_name.isEmpty()) {

                alert.setContentText("Name field can't be blank!");
                alert.show();

            }   else if(roundNum2 < 0){

                alert.setContentText("Rounds field must be a positive integer!");
                alert.show();

            }


            else{

                messageLabel.setText(user_name + ", please select an image.");
                messageLabel.setFont(new Font("Arial", 20));

                stage.setScene(gameScene);/*If the user enters valid input
                the first window will close and the game window will open.*/

            }//End of else block

        });//End of Start button event handler


        /*Alright, now we need to create event handlers for each of the
         images, to represent the users decsion.*/


        imageView1.setOnMouseClicked(k -> {
            String user_name = inputName.getText();


            if(rounds_played < roundNum2){

                int comp_turn = rand.nextInt(3);/*We need to redeclare
            the computers turn for each event. So a new random number will
            generate each time the user selects an image.*/

                userChoiceLabel.setText(user_name + " chose rock.");

                if (comp_turn == ROCK) {//Computer chooses Rock

                    ties++;
                    rounds_played++;

                    compChoiceLabel.setText("Computer chose rock.");
                    winnerLabel.setText("TIE! No winner.");
                    tiesOutput.setText(String.valueOf(ties));
                    roundsOutput.setText(String.valueOf(rounds_played));

                } else if (comp_turn == PAPER) {//Computer chooses paper.

                    user_losses++;
                    rounds_played++;

                    compChoiceLabel.setText("Computer chose paper.");
                    winnerLabel.setText("Computer is the winner.");
                    lossesOutput.setText(String.valueOf(user_losses));
                    roundsOutput.setText(String.valueOf(rounds_played));

                } else if (comp_turn == SCISSORS) {//Computer chooses scissors.

                    user_wins++;
                    rounds_played++;

                    compChoiceLabel.setText("Computer chose scissors.");
                    winnerLabel.setText(user_name + " is the winner.");
                    winsOutput.setText(String.valueOf(user_wins));
                    roundsOutput.setText(String.valueOf(rounds_played));
                }

            }   else{

                if(user_wins > user_losses) {

                    gameOverLabel.setText("GAME OVER!!! " + user_name + " is the winner.");
                }   else{

                    gameOverLabel.setText("GAME OVER!!! Computer is the winner.");
                }

            }//End of if-else block.
        });//End of Rock image event handler.


        imageView2.setOnMouseClicked(k -> {
            String user_name = inputName.getText();

            if(rounds_played < roundNum2){
                int comp_turn = rand.nextInt(3);
                userChoiceLabel.setText(user_name + " chose paper.");

                if (comp_turn == ROCK) {

                    user_wins++;
                    rounds_played++;

                    compChoiceLabel.setText("Computer chose rock.");
                    winnerLabel.setText(user_name + " wins.");
                    winsOutput.setText(String.valueOf(user_wins));
                    roundsOutput.setText(String.valueOf(rounds_played));

                } else if (comp_turn == PAPER) {//Computer chooses paper.

                    ties++;
                    rounds_played++;

                    compChoiceLabel.setText("Computer chose paper.");
                    winnerLabel.setText("TIE! No winner.");
                    tiesOutput.setText(String.valueOf(ties));
                    roundsOutput.setText(String.valueOf(rounds_played));

                } else if (comp_turn == SCISSORS) {//Computer chooses scissors.

                    user_losses++;
                    rounds_played++;

                    compChoiceLabel.setText("Computer chose scissors.");
                    winnerLabel.setText("Computer wins.");
                    lossesOutput.setText(String.valueOf(user_losses));
                    roundsOutput.setText(String.valueOf(rounds_played));
                }

            } else{

                if(user_wins > user_losses) {

                    gameOverLabel.setText("GAME OVER!!! " + user_name + " is the winner.");
                }   else{

                    gameOverLabel.setText("GAME OVER!!! Computer is the winner.");
                }

            }//End of if-else block.
        });//End of paper image event handler.


        imageView3.setOnMouseClicked(k -> {//User chose scissors
            String user_name = inputName.getText();

            if(rounds_played < roundNum2){/*First we need to check if the number
                of rounds played is greater than the number of rounds the user wants to play.*/

                int comp_turn = rand.nextInt(3);
                userChoiceLabel.setText(user_name + " chose scissors.");

                if (comp_turn == ROCK) {//Computer chooses Rock

                    user_losses++;
                    rounds_played++;

                    compChoiceLabel.setText("Computer chose rock.");
                    winnerLabel.setText("Computer wins.");
                    lossesOutput.setText(String.valueOf(user_losses));
                    roundsOutput.setText(String.valueOf(rounds_played));

                } else if (comp_turn == PAPER) {//Computer chooses paper.

                    user_wins++;
                    rounds_played++;

                    compChoiceLabel.setText("Computer chose paper.");
                    winnerLabel.setText(user_name + " wins.");
                    winsOutput.setText(String.valueOf(user_wins));
                    roundsOutput.setText(String.valueOf(rounds_played));

                } else if (comp_turn == SCISSORS) {//Computer chooses scissors.

                    ties++;
                    rounds_played++;

                    compChoiceLabel.setText("Computer chose scissors.");
                    winnerLabel.setText("TIE! No winner");
                    tiesOutput.setText(String.valueOf(ties));
                    roundsOutput.setText(String.valueOf(rounds_played));
                }

            }   else{

                if(user_wins > user_losses) {

                    gameOverLabel.setText("GAME OVER!!! " + user_name + " is the winner.");
                }   else{

                    gameOverLabel.setText("GAME OVER!!! Computer is the winner.");
                }

            }//End of if-else block.
        });//End of Scissor image event handler.


        /*This event handler will send the user back to the main screen
        and ask them to input name and number of rounds again.
        Everything needs to be reset.*/
        mmButton.setOnAction(e ->{

            user_wins = 0;
            user_losses = 0;
            ties = 0;
            rounds_played = 0;

            inputName.setText("");
            inputRounds.setText("");

            userChoiceLabel.setText("");
            compChoiceLabel.setText("");
            winnerLabel.setText("");
            gameOverLabel.setText("");

            roundsOutput.setText("");
            winsOutput.setText("");
            lossesOutput.setText("");
            tiesOutput.setText("");

            stage.setScene(startScene);
        });

        //This event handler will reset the game.
        restartButton.setOnAction(e ->{

            user_wins = 0;
            user_losses = 0;
            ties = 0;
            rounds_played = 0;

            userChoiceLabel.setText("");
            compChoiceLabel.setText("");
            winnerLabel.setText("");
            gameOverLabel.setText("");

            roundsOutput.setText("");
            winsOutput.setText("");
            lossesOutput.setText("");
            tiesOutput.setText("");
        });//End of restart button event handler.


        /*This event handler will display a pie chart
        and display the current wins, losses and ties.*/
        chartButton.setOnAction(e ->{

            PieChart scores = new PieChart();
            PieChart.Data slice1 = new PieChart.Data("Wins", user_wins);
            PieChart.Data slice2 = new PieChart.Data("Losses", user_losses);
            PieChart.Data slice3 = new PieChart.Data("Ties", ties);
            scores.getData().addAll(slice1, slice2, slice3);

            /*Now we need to create a new Scene that will open
        when the user presses the chart button.*/
            Scene chartScene = new Scene(scores, 800, 400);
            Stage chartStage = new Stage();
            chartStage.setTitle("Game chart.");
            chartStage.setScene(chartScene);

            chartStage.show();
        });//End of chart button event handler.

    }//End of start method.



}//End of class.
/**/