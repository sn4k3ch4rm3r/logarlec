package logarlec.view.drawables;

import logarlec.controller.util.SpriteManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class InventoryView implements Drawable {
    List<ItemView> items;
    BufferedImage inventorySlot;

    public InventoryView() {
        items = new LinkedList<>();
        inventorySlot = SpriteManager.getInstance().getSprite("inventory-slot");
    }

    @Override
    public void draw(Graphics2D g2d) {
        for (int i = 0; i < 5; i++) {
            Graphics2D slotGraphics = (Graphics2D) g2d.create(i * 16, 0, 16, 16);
            slotGraphics.drawImage(inventorySlot, 0, 0, null);
            if (i < items.size()) {
                items.get(i).draw(slotGraphics);
            }
            slotGraphics.dispose();
        }
    }

    public void clearItem() {
        items.clear();
    }

    public void addItem(ItemView item) {
        items.add(item);
    }

    public List<ItemView> getItems() {
        return items;
    }
}
