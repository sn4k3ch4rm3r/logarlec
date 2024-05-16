package logarlec.view;

public class WallTileView extends TileView {
    /**
     * A fal csempe kirajzolása.
     * @param type A fal csempe típusa: 0 - TOP, 1, TOP-RIGHT, 2 - RIGHT, 3 - BOTTOM-RIGHT, 4 - BOTTOM, 5 - BOTTOM-LEFT, 6 - LEFT, 7 - TOP-LEFT
     */
    public WallTileView(int type) {
        switch (type) {
            case 0:
                this.type = "wall-top";
                break;
            case 1:
                this.type = "wall-top-right";
                break;
            case 2:
                this.type = "wall-right";
                break;
            case 3:
                this.type = "wall-bottom-right";
                break;
            case 4:
                this.type = "wall-bottom";
                break;
            case 5:
                this.type = "wall-bottom-left";
                break;
            case 6:
                this.type = "wall-left";
                break;
            case 7:
                this.type = "wall-top-left";
                break;
            default:
                this.type = "wall";
                break;
        }
    }
}
