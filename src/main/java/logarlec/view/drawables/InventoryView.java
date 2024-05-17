package logarlec.view.drawables;

import logarlec.controller.util.SpriteManager;

import java.awt.*;
import java.util.List;

public class InventoryView implements Drawable {
    List<ItemView> items;

    @Override
    public void draw(Graphics2D g2d) {
        int width = g2d.getClipBounds().width / 5;
        int height = g2d.getClipBounds().height;
        for (int i = 0; i < 5; i++) {
            Graphics2D g = (Graphics2D) g2d.create(i * width, 0, width, height);
            g.drawImage(SpriteManager.getInstance().getSprite("inventory-slot"), 0, 0, width,
                    height, null);
            if (i < items.size()) {
                items.get(i).draw(g);
            }
            g.dispose();
        }
    }

    public void clearItem() {
        items.clear();
    }

    public void addItem(ItemView item) {
        items.add(item);
    }
}
