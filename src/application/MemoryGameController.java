package application;

public class MemoryGameController {
    private MemoryGameModel model;
    private Main view;

    public MemoryGameController(MemoryGameModel model, Main view) {
        this.model = model;
        this.view = view;
        // initialisation du contrôleur
    }

    public void handleCardSelection(Card card) {
        // gestion de la sélection d'une carte
    }

    public void handleRestartGame() {
        // gestion du redémarrage du jeu
    }	
}
