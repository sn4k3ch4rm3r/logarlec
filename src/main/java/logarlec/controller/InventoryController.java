package logarlec.controller;

import logarlec.model.util.Inventory;

public class InventoryController {
    private InventoryView inventoryView;

    public InventoryController(Inventory inventory){
        
    }
    public InventoryView getInventoryView() {
        return inventoryView;
    }

    public void onInventoryChanged(Inventory inentory){
        GameController.getInstance();
    }
}
