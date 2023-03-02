package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class MemoryGameController {
    
    private MemoryGameModel model;
    private MemoryGameView view;
    
    @FXML
    private GridPane gp;
    
    @FXML
    ListView<Card> listView;
    
    private List<Card> cardList;
    private List<Card> selectedCardsList;
    private Image tabImg[];
    private int numberPair;
    
    @FXML
    private Button startButton;
    
    @FXML
    private ChoiceBox level;
    
    @FXML
    public void initialize() {
    	level.setItems(FXCollections.observableArrayList("Difficile", "Facile"));
    	cardList = new ArrayList<>();
    	selectedCardsList = new ArrayList<>();
    	selectedCardsList.clear();
    	
    	for (int i = 0; i < 6; i++) {
    		Image img = tabImg[i];
            Card card1 = new Card(i, img);
            Card card2 = new Card(i, img);
            cardList.add(card1);
            cardList.add(card2);
    	}
    	
    	numberPair = cardList.size() / 2;
    	Collections.shuffle(cardList);
    	setupGrid();
    	Grid();
    	
    }

    @FXML
    private void handleCardSelection(Card card) {
        // Gérer la sélection de cartes et mettre à jour le modèle et la vue en conséquence
        // Vérifier si le jeu est terminé
    	card.setFlipped(true);
    }

    @FXML
    private void handleRestartButtonClick() {
        
    }
    
    @FXML
    private void handleStartButton(ActionEvent evt) {

    }
    
    private void setupGrid() {
    	gp.getColumnConstraints().clear();
    	gp.getRowConstraints().clear();
    	
    	for (int i = 0; i <= 2; i++) {
    		ColumnConstraints column = new ColumnConstraints();
    		column.setPercentWidth(100.0 / 2);
    		gp.getColumnConstraints().add(column);
    	}
	    for (int i = 0; i <= 3; i++) {
	        RowConstraints row = new RowConstraints();
	        row.setPercentHeight(100.0 / 3);
	        gp.getRowConstraints().add(row);
	    }
    }
    
    private void Grid() {
    	
    	gp.getChildren().clear();
    	
    	int rowIndex = 0;
    	int columnIndex = 0;
    	
    	for (Card card : cardList) {
    		
    		ImageView iv = new ImageView();
    		
    		if (!card.isFlipped()) {
    			iv.setImage(card.getBackImage());
    			iv.setFitWidth(100);
    			iv.setFitWidth(100);
    			iv.setOnMouseClicked(event -> handleCardSelection(card));
    		} else if (card.isFlipped() && !card.isMatched()) {
    			iv.setImage(card.getImage());
    			iv.setFitWidth(100);
    			iv.setFitHeight(100);
    		} else if (card.isMatched()) {
	            iv.setImage(card.getImage());
	            iv.setFitWidth(100);
	            iv.setFitHeight(100);
	            iv.setOpacity(0);
    		}
    		
    		gp.add(iv, columnIndex, rowIndex);
    		
	        columnIndex++;
	        if (columnIndex >= 3) {
	            columnIndex = 0;
	            rowIndex++;
	        }
    	}
    	
    }
    
    
}
