package logarlec.view.drawables;

import java.awt.*;
import java.util.List;

public class InventoryView implements Drawable {
    List<ItemView> items;

    @Override
    public void draw(Graphics2D g2d) {

    }

    public void clearItem() {
        items.clear();
    }

    public void addItem(ItemView item) {
        items.add(item);
    }
}
