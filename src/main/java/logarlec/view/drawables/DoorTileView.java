package logarlec.view.drawables;

import java.awt.Graphics2D;
import logarlec.controller.util.SpriteManager;
import logarlec.model.tiles.DoorTile;
import logarlec.model.util.Direction;

public class DoorTileView extends TileView {
    /**
     * Az ajtó csempe konstruktora.
     * 
     * @param isOpen Nyitva van-e az ajtó.
     */
    public DoorTileView(DoorTile doorTile, Direction direction) {
        super(doorTile);
        String spriteName = "door-";
        switch (direction) {
            case UP:
                spriteName += "up";
                break;
            case DOWN:
                spriteName += "down";
                break;
            case LEFT:
                spriteName += "left";
                break;
            case RIGHT:
                spriteName += "right";
                break;
            default:
                break;
        }
        if (!doorTile.getDoor().isOneWay()
                || doorTile.getDoor().getFromRoom() == doorTile.getRoom()) {
            spriteName += "-open";
        }
        this.sprite = SpriteManager.getInstance().getSprite(spriteName);
    }

    @Override
    public void draw(Graphics2D g2d) {
        if (!((DoorTile) tile).getDoor().isHidden()) {
            super.draw(g2d);
        }
    }
}
