package logarlec.controller;

import logarlec.model.events.InventoryChangeListener;
import logarlec.model.items.Item;
import logarlec.model.util.Inventory;
import logarlec.view.drawables.InventoryView;
import logarlec.view.drawables.ItemView;

/**
 * Az inventory vezérlője
 */
public class InventoryController implements InventoryChangeListener {
    /**
     * Az inventory nézete
     */
    private InventoryView inventoryView;
    private Inventory inventory;

    /**
     * Konstruktor
     *
     * @param inventory Az inventory, melyet vezérel
     */
    public InventoryController(Inventory inventory) {
        inventoryView = new InventoryView();
        this.inventory = inventory;
        inventory.addOnChangeEventListener(this);
    }

    /**
     * Az inventory nézetének lekérdezése
     *
     * @return Az inventory nézete
     */
    public InventoryView getInventoryView() {
        return inventoryView;
    }

    @Override
    public void onInventoryChange() {
        inventoryView.clearItems();
        for (Item item : inventory.getItems()) {
            inventoryView.addItem((ItemView) GameController.getInstance().getModelView(item));
        }
    }

    public Inventory getInventory() {
        return inventory;
    }
}
