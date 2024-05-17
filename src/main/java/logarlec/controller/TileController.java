package logarlec.controller;

import logarlec.model.events.TileChangeListener;
import logarlec.model.gameobjects.Person;
import logarlec.model.items.Item;
import logarlec.model.tiles.FloorTile;
import logarlec.view.drawables.FloorTileView;
import logarlec.view.drawables.ItemView;
import logarlec.view.drawables.PersonView;

public class TileController implements TileChangeListener {
    private FloorTile tile;
    private FloorTileView tileView;

    public TileController(FloorTile tile, FloorTileView view) {
        this.tile = tile;
        this.tileView = view;

        tile.addOnChangeEventListener(this);
    }

    @Override
    public void onTileChanged() {
        Item item = tile.getItem();
        Person person = tile.getPerson();

        GameController gameController = GameController.getInstance();
        PersonView personView = (PersonView) gameController.getModelView(person);
        ItemView itemView = (ItemView) gameController.getModelView(item);

        tileView.setContents(itemView, personView);
    }

}
