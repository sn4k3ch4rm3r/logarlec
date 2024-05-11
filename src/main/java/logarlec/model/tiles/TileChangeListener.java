package logarlec.model.tiles;

public interface TileChangeListener {
    /**
     * egy megfigyelt csempe állapota megváltozott, erre reagál az objektum
     * @param tile
     */
    public void onTileChanged(Tile tile);
}
