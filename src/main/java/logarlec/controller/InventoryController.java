package logarlec.controller;

import logarlec.model.events.InventoryChangeListener;
import logarlec.model.util.Inventory;
import logarlec.view.drawables.InventoryView;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onInventoryChange'");
    }

    public Inventory getInventory() {
        return inventory;
    }
}
