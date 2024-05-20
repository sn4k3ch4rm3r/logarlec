package logarlec.model.events;

public interface TileChangeListener {
    /**
     * egy megfigyelt csempe állapota megváltozott, erre reagál az objektum
     * 
     * @param tile
     */
    public void onTileChanged();
}
