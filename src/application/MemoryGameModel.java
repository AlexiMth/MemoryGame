package application;

import java.util.List;

public class MemoryGameModel {
    
    private List<Card> cards;
    private int score;
    private int remainingTime;

    public MemoryGameModel(int numberOfCards) {
        // Initialiser les cartes et les mélanger
        // Initialiser les scores et le temps restant
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getScore() {
        return score;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void selectCard(Card card) {
        // Gérer la sélection de cartes et la vérification si elles sont assorties ou non
        // Mettre à jour le score et le temps restant
    }

    public boolean isGameOver() {
        // Vérifier si toutes les paires ont été trouvées ou si le temps est écoulé
    	return false;
    }
}
