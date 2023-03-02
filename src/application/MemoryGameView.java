package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MemoryGameView {
    
    private MemoryGameModel model;
    private GridPane cardsGrid;
    private Label scoreLabel;
    private Label timeLabel;
    private Button restartButton;

    public MemoryGameView(MemoryGameModel model) {
        // Initialiser les éléments visuels tels que les cartes, le score, le temps restant et le bouton de redémarrage
        // Ajouter des gestionnaires d'événements pour les interactions utilisateur
    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    public void updateTimeRemaining(int time) {
        timeLabel.setText("Time: " + time + "s");
    }

    public void updateCards(CardView card1, CardView card2) {
        card1.show();
        card2.show();
    }

    public void hideCards(CardView card1, CardView card2) {
        card1.hide();
        card2.hide();
    }

    public void disableCards(CardView card1, CardView card2) {
        card1.setDisable(true);
        card2.setDisable(true);
    }

    public void enableCards(CardView card1, CardView card2) {
        card1.setDisable(false);
        card2.setDisable(false);
    }

    public void endGame(int score, boolean isWin) {
        Alert alert = new Alert(.INFORMATION);
    alert.setTitle("Game Over");
    alert.setHeaderText(null);
    if (isWin) {
    alert.setContentText("Congratulations! You won the game with a score of " + score);
    } else {
    alert.setContentText("Game over! You lost the game with a score of " + score);
    }
    alert.showAndWait();
    }

    public void showErrorMessage(String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
    }

    public void reset() {
    for (CardView card : cards) {
    card.reset();
    card.setDisable(false);
    }
    scoreLabel.setText("Score: 0");
    timeLabel.setText("Time: " + gameTime + "s");
    }
}
