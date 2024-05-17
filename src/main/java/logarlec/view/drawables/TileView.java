package logarlec.view.drawables;

import logarlec.model.tiles.Tile;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public abstract class TileView implements Drawable {
    private Tile tile;
    protected BufferedImage sprite;

    public TileView(Tile tile) {
        this.tile = tile;
    }

    protected Graphics2D getGraphicsContext(Graphics2D graphics) {
        return (Graphics2D) graphics.create(tile.getPosition().x, tile.getPosition().y,
                sprite.getWidth(), sprite.getHeight());
    }

    /**
     * A csempe kirajzolása.
     * 
     * @param g2d A rajzolásra használt grafikus objektum.
     */
    @Override
    public void draw(Graphics2D g2d) {
        Graphics2D tileGraphics = getGraphicsContext(g2d);
        tileGraphics.drawImage(sprite, null, null);
        tileGraphics.dispose();
    }
}
