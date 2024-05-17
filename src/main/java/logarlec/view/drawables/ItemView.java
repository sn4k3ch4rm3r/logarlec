package logarlec.view.drawables;

import logarlec.model.items.Item;
import logarlec.model.util.Position;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ItemView implements Drawable {
    Item item;
    BufferedImage sprite;

    public ItemView(Item item, BufferedImage sprite) {
        this.item = item;
        this.sprite = sprite;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Position position = new Position((g2d.getClipBounds().width - sprite.getWidth()) / 2,
                (g2d.getClipBounds().height - sprite.getHeight()) / 2);
        g2d.drawImage(sprite, position.x, position.y, null);
    }
}
