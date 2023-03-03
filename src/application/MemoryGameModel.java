package application;

import java.util.List;
import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;

public class MemoryGameModel {
    
    private int score;
    private int remainingTime;

    public int getScore() {
        return score;
    }

    public int getRemainingTime() {
        return remainingTime;
    }
}