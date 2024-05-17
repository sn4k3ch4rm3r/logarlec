package logarlec.view.drawables;

import logarlec.model.tiles.WallTile;

public class WallTileView extends TileView {
    private static final String[] types = {"wall-top", "wall-top-right", "wall-right",
            "wall-bottom-right", "wall-bottom", "wall-bottom-left", "wall-left", "wall-top-left"};

    public WallTileView(WallTile tile) {
        super(tile);
        // TODO: Set sprite
    }
}
