package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.util.Duration;

public class MemoryGameController {
	
	private MemoryGameModel model;
	
	private int remainingTime;
    
    @FXML
    private GridPane gp;
    
    @FXML
    private Label time;
    
    private List<Card> cardList;
    private List<Card> selectedCardsList;
    
    private Image tabImg[] = {
    		new Image("file:src/resources/apple.png", 240, 240, false, false),
    		new Image("file:src/resources/poire.png", 240, 240, false, false),
    		new Image("file:src/resources/fraise.png", 240, 240, false, false),
    		new Image("file:src/resources/banane.png", 240, 240, false, false),
    };
    
    private int numberPair = 0;
    
    @FXML
    private Button startButton;
    
    @FXML
    private ChoiceBox<String> level;
    
    Timeline timeline;
    
    @FXML
    private void initialize() {
        level.setItems(FXCollections.observableArrayList("Difficile", "Facile"));
        cardList = new ArrayList<>();
        selectedCardsList = new ArrayList<>();
        selectedCardsList.clear();
    }


    @FXML
    private void handleCardSelection(Card card) {
        card.setFlipped(true);
        selectedCardsList.add(card);

        if (selectedCardsList.size() == 2) {
            Card card1 = selectedCardsList.get(0);
            Card card2 = selectedCardsList.get(1);

            if (card1.getImage() == card2.getImage()) {
                card1.setMatched(true);
                card2.setMatched(true);
                numberPair++;
            } else {
                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.seconds(1), event -> {
                            card1.setFlipped(false);
                            card2.setFlipped(false);
                            grid();
                        })
                );
                timeline.setCycleCount(1);
                timeline.play();
            }
            if (numberPair == cardList.size()-1 / 2) {
            	finishedGame();
            }

            selectedCardsList.clear();
        }

        grid();
    }

    @FXML
    private void handleRestartButtonClick() {
        
    }
    
    private void showTime() {
        // D??cr??menter le temps restant
        remainingTime--;
        
        // Mettre ?? jour le label du temps restant
        time.setText("Temps restant : " + remainingTime + " secondes");
        
        // V??rifier si le temps est ??coul??
        if (remainingTime == 0) {
            
            timeline.stop();

            Platform.runLater(() -> {
	            Alert alert = new Alert(AlertType.INFORMATION);
	            alert.setTitle("Fin de jeu");
	            alert.setHeaderText(null);
	            alert.setContentText("Le temps est ??coul?? !");
	            alert.showAndWait();
            });
        }
        
        if (numberPair == cardList.size()) {
        	timeline.stop();
        }
    }
    
    private void finishedGame() {    
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Fin du jeu");
        alert.setHeaderText(null);
        alert.setContentText("Vous avez gagn??!");
        alert.showAndWait();
    }


    
    public int getRemainingTime() {
    	return this.remainingTime;
    }
    
    @FXML
    private void handleStartButton(ActionEvent evt) {
        // R??cup??rer la difficult?? choisie
        // String difficulty = level.getValue();
        
        for (int i = 0; i < tabImg.length; i++) {
            Image img = tabImg[i];
            Card card1 = new Card(i, img);
            Card card2 = new Card(i, img);
            cardList.add(card1);
            cardList.add(card2);
        }
        
        numberPair = cardList.size() / 2;
        Collections.shuffle(cardList);
        setupGrid();
        grid();
        
        remainingTime = 180;
        
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> showTime()));
           
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        
        showTime();
    }
    
    private void setupGrid() {
    	gp.getColumnConstraints().clear();
    	gp.getRowConstraints().clear();
    	
    	for (int i = 0; i <= 2; i++) {
    		ColumnConstraints column = new ColumnConstraints();
    		column.setPercentWidth(100.0 / 3);
    		gp.getColumnConstraints().add(column);
    	}
	    for (int i = 0; i <= 3; i++) {
	        RowConstraints row = new RowConstraints();
	        row.setPercentHeight(100.0 / 3);
	        gp.getRowConstraints().add(row);
	    }
    }
    
    private void grid() {
        gp.getChildren().clear();
        
        //ImageView ivTest = new ImageView("file:src/resources/apple.png");
        //gp.add(ivTest, 1, 1);
        
        int rowIndex = 0;
        int columnIndex = 0;
        
        for (Card card : cardList) {
            ImageView iv = new ImageView();
            if (!card.isFlipped()) {
                iv.setImage(card.getBackImage());
                iv.setFitWidth(100);
                iv.setFitHeight(100);
                iv.setOnMouseClicked(event -> handleCardSelection(card));
            } else if (card.isFlipped() && !card.isMatched()) {
                iv.setImage(card.getImage());
                iv.setFitWidth(100);
                iv.setFitHeight(100);
            } else if (card.isMatched()) {
                iv.setImage(card.getImage());
                iv.setFitWidth(100);
                iv.setFitHeight(100);
                iv.setOpacity(0.5);
            }
            
            gp.add(iv, columnIndex, rowIndex);
            
            columnIndex++;
            if (columnIndex >= 2) { 
                columnIndex = 0;
                rowIndex++;
            }
        }
    }
    
    private void resetGame() {
        remainingTime = 0;
        selectedCardsList.clear();
        cardList.clear();
        for (int i = 0; i < tabImg.length; i++) {
            Image img = tabImg[i];
            Card card1 = new Card(i, img);
            Card card2 = new Card(i, img);
            cardList.add(card1);
            cardList.add(card2);
        }
        numberPair = cardList.size() / 2;
        Collections.shuffle(cardList);
        setupGrid();
        grid();
    }

    
    
}
