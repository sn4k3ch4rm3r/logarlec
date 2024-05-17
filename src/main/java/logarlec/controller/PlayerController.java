package logarlec.controller;

import logarlec.model.util.Entity;

public class PlayerController extends PersonController{
    private InventoryController inventoryController;
    private PlayerView playerView;
    
    public PlayerController(Entity entity, PersonView personView){
        super(entity, personView);
        inventoryController = new InventoryController(entity.getPerson().getInventory());
        playerView = new PlayerView(personView, inventoryController.getInventoryView());
    }

    
}
