package logarlec.view.drawables;

import java.awt.*;
import logarlec.Configuration;

public class GameView implements Drawable {
    private MapView mapView;
    private SideBarView sideBarView;

    /**
     * A játék nézetének konstruktora. Létrehozza a térkép alapján a MapView-t és a SideBarView-t.
     */
    public GameView(MapView mapView, SideBarView sideBarView) {
        this.mapView = mapView;
        this.sideBarView = sideBarView;
    }

    /**
     * A MapView és a SideBarView kirajzolása a megfelelő helyekre.
     * 
     * @param g2d A rajzolásra használt grafikus objektum.
     */
    @Override
    public void draw(Graphics2D g2d) {
        Graphics2D mapGraphics =
                (Graphics2D) g2d.create(0, 0, mapView.getWidth(), mapView.getHeight());
        mapView.draw(mapGraphics);
        mapGraphics.dispose();

        Graphics2D sideBarGraphics = (Graphics2D) g2d.create(mapView.getWidth(), 0,
                Configuration.WIDTH - mapView.getWidth(), Configuration.HEIGHT);
        sideBarView.draw(sideBarGraphics);
        sideBarGraphics.dispose();
    }
}
