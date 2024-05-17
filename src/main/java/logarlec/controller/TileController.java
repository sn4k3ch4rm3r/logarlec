package logarlec.controller;

import logarlec.model.events.TileChangeListener;
import logarlec.model.tiles.FloorTile;
import logarlec.model.tiles.Tile;

public class TileController implements TileChangeListener{
    private FloorTile tile;
    private FloorTileView floorTileView;

    private TileChangeListener tileChangeListener;
    public TileController(FloorTile tile, FloorTileView floorTileView){
        this.tile = tile;
        this.floorTileView = tileView;

        tile.addOnChangeEventListener(this);
    }

    @Override
    public void onTileChanged(){
        floorTileView.setContents(tile.item, tile.person);
    }

}
