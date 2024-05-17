package logarlec.view.drawables;

import logarlec.controller.util.SpriteManager;

import java.awt.*;

public class FloorTileView extends TileView {

    ItemView item;
    PersonView person;
    /**
     * A padló csempe konstruktora.
     */
    public FloorTileView() {
        this.type = "floor";
    }

    public void draw(Graphics2D g2d) {
        super.draw(g2d);
        if (item != null) {
            item.draw(g2d);
        }
        if (person != null) {
            person.draw(g2d);
        }
    }

    public void setContents(ItemView item, PersonView person) {
        this.item = item;
        this.person = person;
    }
}
