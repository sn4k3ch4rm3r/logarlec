package logarlec.model.events;

import logarlec.model.util.Inventory;

public interface InventoryChangeListener {
    public void onInventoryChange(Inventory inventory);
}
