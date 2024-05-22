package logarlec.controller;

import logarlec.controller.util.FeedbackManager;
import logarlec.controller.util.InputHandler;
import logarlec.model.events.DropListener;
import logarlec.model.events.GameEndedListener;
import logarlec.model.gameobjects.Student;
import logarlec.model.items.Item;
import logarlec.model.items.Transistor;
import logarlec.model.util.Direction;
import logarlec.model.util.Entity;
import logarlec.model.util.Position;
import logarlec.view.drawables.PersonView;
import logarlec.view.drawables.PlayerView;
import logarlec.view.utils.I18n;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerController extends PersonController implements DropListener, GameEndedListener {
    private InventoryController inventoryController;
    private Map<Item, Position> linkedTransistors = new HashMap<>();

    private boolean dead = false;

    /**
     * A játékos nézete
     */
    private PlayerView playerView;
    /**
     * várunk-e inputot ehhez a játékoshoz
     */
    private volatile boolean thisPlayersTurn;

    /**
     * ezek határozzák meg, hogy mit lehet egy kör alatt tenni
     */
    private static final int maxMovesPerTurn = 3;
    private static final int maxItemUsesPerTurn = 1;
    private static final int maxItemDropsPerTurn = 1;

    private int movesThisTurn;
    private int itemUsesThisTurn;
    private int itemDropsThisTurn;
    private Item selectedTransistor;

    @Override
    public void onDrop(Item item) {
        GameController.getInstance().dropItem(entity, item);
        if (item instanceof Transistor) {
            linkedTransistors.put(((Transistor) item).getPair(), entity.getPosition());
        }
    }

    @Override
    public void onGameEnded() {
        GameController.getInstance().endGame();
    }

    /**
     * USE- éppen ki akarunk választani egy tárgyat használatra DROP - éppen ki akarunk választani
     * egy tárgyat eldobásra LINK - éppen ki akarunk választani két tranzisztort linkelésre NONE
     * -nem akarunk kiválasztani épp tárgyat
     */
    private enum InventoryInput {
        USE, DROP, LINK, NONE
    }

    private InventoryInput expectedInventoryInput;

    /**
     * Konstruktor
     *
     * @param entity Az entitás, amit vezérel
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

    public void turn() {
        if (dead)
            return;
        playerView.setActive(true);
        GameController.getInstance().updateView();
        movesThisTurn = 0;
        itemUsesThisTurn = 0;
        itemDropsThisTurn = 0;
        expectedInventoryInput = InventoryInput.NONE;
        // selectedTransistor = null;
        thisPlayersTurn = true;
        InputHandler.getInstance().setCurrentPlayer(this);
        while (thisPlayersTurn) {

        }
        InputHandler.getInstance().setCurrentPlayer(null);
        dead = ((Student) entity.getPerson()).isEliminated();
        if (dead) {
            playerView.setDead(true);
        }
        playerView.setActive(false);
        // playerView.setActive(false);
        // GameController.getInstance().updateView();
    }

    /**
     * Játékos irányítása billentyűzettel WASD - mozgatás jobbra, balra, fel, le Space - kör vége E
     * - Válassz itemet használatra Q - Válassz itemet eldobásra L - Válassz itemet linkelésre
     *
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
                FeedbackManager.setFeedback(I18n.getString("use-feedback"));
                expectedInventoryInput = InventoryInput.USE;
                break;
            case KeyEvent.VK_Q:
                FeedbackManager.setFeedback(I18n.getString("drop-feedback"));
                expectedInventoryInput = InventoryInput.DROP;
                break;
            case KeyEvent.VK_L:
                FeedbackManager.setFeedback(I18n.getString("link-feedback"));
                expectedInventoryInput = InventoryInput.LINK;
                break;
            case KeyEvent.VK_1:
                inventoryInput(1);
                break;
            case KeyEvent.VK_2:
                inventoryInput(2);
                break;
            case KeyEvent.VK_3:
                inventoryInput(3);
                break;
            case KeyEvent.VK_4:
                inventoryInput(4);
                break;
            case KeyEvent.VK_5:
                inventoryInput(5);
                break;
            default:
                break;
        }
        GameController.getInstance().updateView();
    }

    /**
     * A felhasználó lenyomott egy 1-5 közötti számot Ha előzőleg az item használatot választottuk,
     * az így kiválasztott itemet használjuk Ha előzőleg az item eldobást választottuk, az így
     * kiválasztott itemet eldobjuk Ha előzőleg a tranzisztor linkelést választottuk és még nem
     * választottunk linkelendő itemet, azt kiválasztjuk Ha előzőleg a tranzisztor linkelést
     * választottuk és már választottunk linkelendő itemet, linkeljük a most kiválasztottal az item
     * használat és linkelés az item használat számlálót növelik, az eldobás az eldobás számlálót
     *
     * @param index - a kiválasztott item indexe
     */
    private void inventoryInput(int index) {
        List<Item> items = inventoryController.getInventory().getItems();
        Item item = items.get(index - 1);
        if (item == null)
            return;

        switch (expectedInventoryInput) {
            case USE -> {
                if (itemUsesThisTurn < maxItemUsesPerTurn) {
                    item.use();
                    if (linkedTransistors.containsKey(item)) {
                        GameController.getInstance().moveEntity(entity,
                                linkedTransistors.get(item));
                    }
                    itemUsesThisTurn++;
                }
            }
            case DROP -> {
                if (itemDropsThisTurn < maxItemDropsPerTurn) {
                    if (!GameController.getInstance().dropItem(entity, item))
                        return;
                    entity.getPerson().dropItem(item);
                    itemDropsThisTurn++;
                }
            }
            case LINK -> {
                if (itemUsesThisTurn < maxItemUsesPerTurn) {
                    if (selectedTransistor == null) {
                        selectedTransistor = item;
                        itemUsesThisTurn++;
                    }
                    else if (selectedTransistor != item) {
                        selectedTransistor.useItem(item);
                        selectedTransistor = null;
                        itemUsesThisTurn++;
                    }
                }
            }
            case NONE -> {
            }
        }
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

    @Override
    public boolean isDead() {
        return dead;
    }
}
