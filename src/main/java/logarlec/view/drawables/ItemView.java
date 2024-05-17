package logarlec.view.drawables;

import logarlec.model.items.Item;

import java.awt.*;

public class ItemView implements Drawable {
    Item item;

    public ItemView(Item item) {
        this.item = item;
    }

    @Override
    public void draw(Graphics2D g2d) {

    }
}
