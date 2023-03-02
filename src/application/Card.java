package application;

import javafx.scene.image.Image;

public class Card {
    private int id;
    private Image image;
    private boolean isFlipped;
    private boolean isMatched;

    public Card(int id, Image image) {
        this.id = id;
        this.image = image;
        this.isFlipped = false;
        this.isMatched = false;
    }

    public int getId() {
        return id;
    }

    public Image getImage() {
        return image;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
    }
    
    public boolean isMatched() {
    	return isMatched;
    }
    
    public void setMatched(boolean matched) {
    	isMatched = matched;
    }
}
