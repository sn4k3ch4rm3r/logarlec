package logarlec.controller;

import logarlec.model.items.Item;
import logarlec.model.items.Transistor;
import logarlec.model.util.Direction;
import logarlec.model.util.Entity;
import logarlec.view.drawables.PersonView;
import logarlec.view.drawables.PlayerView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

/**
 * A játékos vezérlője
 */
public class PlayerController extends PersonController{
    /**
     * Az inventory vezérlője
     */
    private InventoryController inventoryController;
    /**
     * A játékos nézete
     */
    private PlayerView playerView;
    /**
     * várunk-e inputot ehhez a játékoshoz
     */
    private boolean thisPlayersTurn;

    /**
     * ezek határozzák meg, hogy mit lehet egy kör alatt tenni
     */
    private static final int maxMovesPerTurn = 3;
    private static final int maxItemUsesPerTurn = 1;
    private static final int maxItemDropsPerTurn = 1;

    private int movesThisTurn;
    private int itemUsesThisTurn;
    private int itemDropsThisTurn;

    /**
     * USE- éppen ki akarunk választani egy tárgyat használatra
     * DROP - éppen ki akarunk választani egy tárgyat eldobásra
     * LINK - éppen ki akarunk választani két tranzisztort linkelésre
     * NONE -nem akarunk kiválasztani épp tárgyat
     */
    private static enum InventoryInput {
        USE, DROP, LINK, NONE
    }
    private InventoryInput expectedInventoryInput;

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

    /**
     * Játékos irányítása billentyűzettel
     * @param e - ez tárolja a lenyomott billentyűt
     */
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                move(Direction.UP);
                break;
            case KeyEvent.VK_S:
                move(Direction.DOWN);
                break;
            case KeyEvent.VK_A:
                move(Direction.LEFT);
                break;
            case KeyEvent.VK_D:
                move(Direction.RIGHT);
                break;
            case KeyEvent.VK_SPACE:
                endTurn();
                break;
            case KeyEvent.VK_E:
                useItem();
                break;
            case KeyEvent.VK_Q:
                dropItem();
                break;
            case KeyEvent.VK_L:
                linkTransistors();
                break;
            default:
        }
    }

    /**
     * kettő az inventory-ban szereplő tranzisztor linkelése
     */
    private void linkTransistors() {
        /*
        if (itemUsesThisTurn >= maxItemUsesPerTurn) {
            return;
        }

        List<Item> items = entity.getPerson().getInventory().getItems();
        List<Transistor> transistors = (List<Transistor>) items.stream().filter(item -> item instanceof Transistor);
        if (transistors.size() >= 2) {
            transistors.get(0).link(transistors.get(1));
            itemUsesThisTurn++;
        }
        */
    }

    /**
     * item kiválasztása eldobásra és az item eldobása
     */
    private void dropItem() {

    }

    /**
     * item kiválasztása használatra és az item használata
     */
    private void useItem() {
    }

    public void setThisPlayersTurn() {
        movesThisTurn = 0;
        itemUsesThisTurn = 0;
        itemDropsThisTurn = 0;
        expectedInventoryInput = InventoryInput.NONE;
    }

    /**
     * nem vár többé inputot, és szól a GameControllernek, hogy jöhet a következő játékos
     */
    private void endTurn() {
        thisPlayersTurn = false;
    }

    @Override
    public void move(Direction direction) {
        if (movesThisTurn < maxMovesPerTurn) {
            movesThisTurn++;
            super.move(direction);
        }
    }

}
