package logarlec.view.drawables;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;

import logarlec.controller.util.SpriteManager;
import logarlec.model.tiles.FloorTile;

public class FloorTileView extends TileView {

    ItemView item;
    PersonView person;
    List<Overlay> overlays = new LinkedList<>();

    /**
     * A padló csempe konstruktora.
     */
    public FloorTileView(FloorTile tile) {
        super(tile);
        this.sprite = SpriteManager.getInstance().getSprite("floor-clean");
    }

    public void draw(Graphics2D g2d) {
        if(tile.getRoom().isClean()) {
            this.sprite = SpriteManager.getInstance().getSprite("floor-clean");
        } 
        else{
            this.sprite = SpriteManager.getInstance().getSprite("floor");
        }
        super.draw(g2d);
        Graphics2D tileGraphics = getGraphicsContext(g2d);
        if (item != null) {
            item.draw(tileGraphics);
        }
        if (person != null) {
            person.draw(tileGraphics);
        }
        for (Overlay o : overlays) {
            o.draw(tileGraphics);
        }
        tileGraphics.dispose();
    }

    public void setContents(ItemView item, PersonView person) {
        this.item = item;
        this.person = person;
    }

    public void addOverlay(Overlay o) {
        overlays.add(o);
    }

    public void clearOverlays() {
        overlays.clear();
    }
}
