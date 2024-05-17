package logarlec.view.drawables;

import logarlec.controller.util.SpriteManager;

import java.awt.*;

public abstract class TileView implements Drawable {
    String type;

    /**
     * A csempe kirajzolása.
     * @param g2d A rajzolásra használt grafikus objektum.
     */
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setPaint(Color.RED);
        g2d.drawImage(SpriteManager.getInstance().getSprite(type), 0, 0, g2d.getClipBounds().width, g2d.getClipBounds().height, null);
    }
}
