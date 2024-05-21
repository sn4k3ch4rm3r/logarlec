package logarlec.controller;

import logarlec.model.util.Entity;
import logarlec.view.drawables.PersonView;
import logarlec.view.drawables.PlayerView;

/**
 * A játékos vezérlője
 */
public class PlayerController extends PersonController {
    /**
     * Az inventory vezérlője
     */
    private InventoryController inventoryController;
    /**
     * A játékos nézete
     */
    private PlayerView playerView;

    /**
     * Konstruktor
     *
     * @param entity    Az entitás, amit vezérel
     * @param personView A nézet, amit frissít
     */
    public PlayerController(Entity entity, PersonView personView) {
        super(entity, personView);
        inventoryController = new InventoryController(entity.getPerson().getInventory());
        playerView = new PlayerView(personView, inventoryController.getInventoryView());
    }

    /**
     * Az inventory vezérlőjének lekérdezése
     *
     * @return Az inventory vezérlője
     */
    public PlayerView getPlayerView() {
        return playerView;
    }
}
