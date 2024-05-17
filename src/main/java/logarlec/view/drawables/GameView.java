package logarlec.view.drawables;

import java.awt.*;

public class GameView implements Drawable {
    private MapView mapView;
    //private SideBarView sideBarView;
    //private Game game;

    /**
     * A játék nézetének konstruktora. Létrehozza a térkép alapján a MapView-t és a SideBarView-t.
     */
    public GameView() {
        //MapDataLoader mapDataLoader = new MapDataLoader();
        //mapDataLoader.loadMapData();
        //mapView = new MapView(mapDataLoader.getTiles().clone());
    }

    /**
     * A MapView és a SideBarView kirajzolása a megfelelő helyekre.
     * @param g2d A rajzolásra használt grafikus objektum.
     */
    @Override
    public void draw(Graphics2D g2d) {
        Graphics2D mapGraphics = (Graphics2D) g2d.create(0, 0, g2d.getClipBounds().width - 200, g2d.getClipBounds().height);
        mapView.draw(mapGraphics);
    }
}
