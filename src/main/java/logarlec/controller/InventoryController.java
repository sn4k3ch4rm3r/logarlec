package logarlec.controller;

import logarlec.model.events.InventoryChangeListener;
import logarlec.model.util.Inventory;
import logarlec.view.drawables.InventoryView;

public class InventoryController implements InventoryChangeListener {
    private InventoryView inventoryView;

    public InventoryController(Inventory inventory) {

    }

    public InventoryView getInventoryView() {
        return inventoryView;
    }

    public void onInventoryChanged(Inventory inentory) {
        GameController.getInstance();
    }

    @Override
    public void onInventoryChange() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onInventoryChange'");
    }
}
