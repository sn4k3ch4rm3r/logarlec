package logarlec.view.drawables;

import java.util.List;
import logarlec.Configuration;
import java.util.LinkedList;
import java.awt.Graphics2D;

public class MapView implements Drawable {
    List<TileView> tileViews;

    private int width;
    private int height;

    public MapView(int width, int height) {
        tileViews = new LinkedList<>();
        this.width = width;
        this.height = height;
    }

    public void addTileView(TileView tileView) {
        tileViews.add(tileView);
    }

    public int getWidth() {
        return width * Configuration.TILE_SIZE;
    }

    public int getHeight() {
        return height * Configuration.TILE_SIZE;
    }

    @Override
    public void draw(Graphics2D g2d) {
        for (TileView tileView : tileViews) {
            tileView.draw(g2d);
        }
    }
}
