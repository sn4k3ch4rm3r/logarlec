package logarlec.view.drawables;

import logarlec.controller.util.SpriteManager;
import logarlec.model.tiles.WallTile;

public class WallTileView extends TileView {



    public WallTileView(WallTile tile) {
        super(tile);
    }

    public void setVariation(String variation) {
        this.sprite = SpriteManager.getInstance().getSprite("wall-" + variation);
    }
}
