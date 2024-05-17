package logarlec.view.drawables;

import java.util.List;
import java.util.LinkedList;
import java.awt.Graphics2D;

public class MapView implements Drawable {
    List<TileView> tileViews;

    public MapView() {
        tileViews = new LinkedList<>();
    }

    public void addTileView(TileView tileView) {
        tileViews.add(tileView);
    }

    @Override
    public void draw(Graphics2D g2d) {
        for (TileView tileView : tileViews) {
            tileView.draw(g2d);
        }
    }
}
