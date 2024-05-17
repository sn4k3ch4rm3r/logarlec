package logarlec.view;

public class WallTileView extends TileView {
    private static final String[] types = {"wall-top", "wall-top-right", "wall-right", "wall-bottom-right", "wall-bottom", "wall-bottom-left", "wall-left", "wall-top-left"};
    /**
     * A fal csempe kirajzolása.
     * @param type A fal csempe típusa: 0 - TOP, 1, TOP-RIGHT, 2 - RIGHT, 3 - BOTTOM-RIGHT, 4 - BOTTOM, 5 - BOTTOM-LEFT, 6 - LEFT, 7 - TOP-LEFT
     */
    public WallTileView(int type) {
        this.type = types[type];
    }
}
