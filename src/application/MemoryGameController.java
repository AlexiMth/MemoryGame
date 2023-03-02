package application;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoryGameController {
    private ObservableList<Card> cartes;
    private FilteredList<Card> cartesRestantes;
    private int score;
    private int pairesRestantes;

    public ObservableList<Card> getCartesRestantes() {
        return cartesRestantes;
    }

    public void choisirCarte(Card carte) {
    	
    }
}
