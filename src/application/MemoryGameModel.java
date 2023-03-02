package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.image.Image;

public class MemoryGameModel {
    private int score;
    private int timeRemaining;
    private ObservableList<Card> cards;
    private FilteredList<Card> remainingCards;
    private Image im1;
    private Image im2;
    private Image im3;
    private List<Image> icons = List.of(im1, im2);

    public MemoryGameModel() {
        this.score = 0;
        this.timeRemaining = 180;
        this.cards = FXCollections.observableArrayList();
        this.remainingCards = new FilteredList<>(this.cards, card -> !card.isMatched());

        // Initialisation des cartes
        for (Image iconName : this.icons) {
            Card card1 = new Card(1, iconName);
            Card card2 = new Card(2, iconName);
            this.cards.add(card1);
            this.cards.add(card2);
        }
        Collections.shuffle(this.cards);
    }

    public void selectCard(Card card) {
        if (!card.isMatched() && !card.isFlipped()) {
            card.setFlipped(true);
            List<Card> flippedCards = new ArrayList<>();
            for (Card c : this.remainingCards) {
                if (c.isFlipped() && !c.isMatched()) {
                    flippedCards.add(c);
                }
            }
            if (flippedCards.size() == 2) {
                Card card1 = flippedCards.get(0);
                Card card2 = flippedCards.get(1);
                if (checkMatch(card1, card2)) {
                    card1.setMatched(true);
                    card2.setMatched(true);
                    this.score += 2;
                } else {
                    card1.setFlipped(false);
                    card2.setFlipped(false);
                }
            }
        }
    }

    public boolean checkMatch(Card card1, Card card2) {
        return card1.getImage().equals(card2.getImage());
    }

    public boolean checkWin() {
        for (Card card : this.cards) {
            if (!card.isMatched()) {
                return false;
            }
        }
        return true;
    }

    public int getScore() {
        return this.score;
    }

    public int getTimeRemaining() {
        return this.timeRemaining;
    }

    public ObservableList<Card> getCards() {
        return this.cards;
    }

    public FilteredList<Card> getRemainingCards() {
        return this.remainingCards;
    }
}
