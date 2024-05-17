package logarlec.view.drawables;

import java.awt.Graphics2D;
import logarlec.controller.util.SpriteManager;
import logarlec.model.tiles.FloorTile;

public class FloorTileView extends TileView {

    ItemView item;
    PersonView person;

    /**
     * A padló csempe konstruktora.
     */
    public FloorTileView(FloorTile tile) {
        super(tile);
        this.sprite = SpriteManager.getInstance().getSprite("floor");
    }

    public void draw(Graphics2D g2d) {
        super.draw(g2d);
        Graphics2D tileGraphics = getGraphicsContext(g2d);
        if (item != null) {
            item.draw(tileGraphics);
        }
        if (person != null) {
            person.draw(tileGraphics);
        }
        tileGraphics.dispose();
    }

    public void setContents(ItemView item, PersonView person) {
        this.item = item;
        this.person = person;
    }
}
