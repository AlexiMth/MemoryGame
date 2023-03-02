package application;

import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class MemoryGameController {
    
    private MemoryGameModel model;
    private MemoryGameView view;
    
    @FXML
    private GridPane gp;
    
    @FXML
    ListView<Card> listView;
    
    ObservableList<Card> cardList = FXCollections.observableArrayList();
    
    @FXML
    private Button startButton;

    @FXML
    private void handleCardSelection(Card card) {
        // Gérer la sélection de cartes et mettre à jour le modèle et la vue en conséquence
        // Vérifier si le jeu est terminé
    }

    @FXML
    private void handleRestartButtonClick() {
        
    }
    
    @FXML
    private void handleStartButton(ActionEvent evt) {
    	gp = new GridPane();
    	Random generator = new Random();
    	
    }
    
    
}
