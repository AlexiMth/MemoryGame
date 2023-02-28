package application;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class MemoryGameModel {
    private int score;
    private int timeRemaining;
    private ObservableList<Card> cards;
    private FilteredList<Card> remainingCards;

    public MemoryGameModel() {
        // initialisation du modèle
    }

    public void selectCard(Card card) {
        // traitement de la sélection d'une carte
    }

    public boolean checkMatch(Card card1, Card card2) {
        // vérification si deux cartes sont identiques
    	return false;
    }

    public boolean checkWin() {
        // vérification si toutes les cartes ont été trouvées
    	return false;
    }

    public int getScore() {
        return this.score;
    }

    public int getTimeRemaining() {
        return this.timeRemaining;
    }

    public ObservableList<Card> getCards() {
        // renvoie la liste observable de toutes les cartes
		return cards;
    }

    public FilteredList<Card> getRemainingCards() {
        // renvoie la liste filtrée de cartes restantes
		return remainingCards;
    }
}
