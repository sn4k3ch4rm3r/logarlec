package logarlec.view;

public class DoorTileView extends TileView {
    /**
     * Nyitva van-e az ajtó.
     */
    private boolean isOpen = false;

    /**
     * Az ajtó orientációja: 0 - TOP, 1 - RIGHT, 2 - BOTTOM, 3 - LEFT

     */
    private int orientation = 0;

    /**
     * Az ajtó csempe konstruktora.
     * @param isOpen Nyitva van-e az ajtó.
     */
    public DoorTileView(boolean isOpen) {
        //this.type = "door";
        // TODO: temporary solution
        this.type = "floor";
        this.isOpen = isOpen;
    }
}
