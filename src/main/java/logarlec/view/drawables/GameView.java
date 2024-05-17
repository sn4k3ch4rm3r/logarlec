package logarlec.view.drawables;

import java.awt.*;

public class GameView implements Drawable {
    private MapView mapView;
    private SideBarView sideBarView;

    /**
     * A játék nézetének konstruktora. Létrehozza a térkép alapján a MapView-t és a SideBarView-t.
     */
    public GameView() {

    }

    /**
     * A MapView és a SideBarView kirajzolása a megfelelő helyekre.
     * 
     * @param g2d A rajzolásra használt grafikus objektum.
     */
    @Override
    public void draw(Graphics2D g2d) {
        Graphics2D mapGraphics = (Graphics2D) g2d.create(0, 0, g2d.getClipBounds().width - 200,
                g2d.getClipBounds().height);
        mapView.draw(mapGraphics);
        mapGraphics.dispose();

        Graphics2D sideBarGraphics = (Graphics2D) g2d.create(g2d.getClipBounds().width - 200, 0,
                200, g2d.getClipBounds().height);
        sideBarView.draw(sideBarGraphics);
        sideBarGraphics.dispose();
    }
}
