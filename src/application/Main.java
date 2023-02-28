package application;
	
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private MemoryGameModel model;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MemoryGame.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init() throws Exception {
		super.init();
	}
	
	@Override
	public void stop() throws Exception {
		super.stop();
	}
	
    public void updateCards(List<Card> cards) {
        // mise à jour des cartes dans l'interface utilisateur
    }
    
    public void updateScore(int score) {
        // mise à jour du score dans l'interface utilisateur
    }

    public void updateTime(int timeRemaining) {
        // mise à jour du temps restant dans l'interface utilisateur
    }
}
