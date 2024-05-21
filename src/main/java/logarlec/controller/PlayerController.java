package logarlec.controller;

import logarlec.model.util.Entity;
import logarlec.view.drawables.PersonView;
import logarlec.view.drawables.PlayerView;

public class PlayerController extends PersonController {
    private InventoryController inventoryController;
    private PlayerView playerView;

    public PlayerController(Entity entity, PersonView personView) {
        super(entity, personView);
        inventoryController = new InventoryController(entity.getPerson().getInventory());
        playerView = new PlayerView(personView, inventoryController.getInventoryView());
    }

    public PlayerView getPlayerView() {
        return playerView;
    }

    public void turn() {
        playerView.setActive(true);
        GameController.getInstance().updateView();
        while (true) {
        }
        // playerView.setActive(false);
        // GameController.getInstance().updateView();
    }
}
