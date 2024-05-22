package logarlec.controller;

import logarlec.model.effects.GasEffect;
import logarlec.model.effects.JanitorEffect;
import logarlec.model.events.EffectAppliedListener;
import logarlec.model.events.TileChangeListener;
import logarlec.model.gameobjects.Person;
import logarlec.model.items.Item;
import logarlec.model.tiles.FloorTile;
import logarlec.view.drawables.FloorTileView;
import logarlec.view.drawables.ItemView;
import logarlec.view.drawables.PersonView;
import logarlec.view.utils.OverlayFactory;

/**
 * A mező vezérlője
 */
public class TileController implements TileChangeListener, EffectAppliedListener {
    /**
     * A mező, amit vezérel
     */
    private FloorTile tile;
    /**
     * A vezérlet mező nézete
     */
    private FloorTileView tileView;

    /**
     * Konstruktor
     *
     * @param tile A mező, amit vezérel
     * @param view A nézet, amit frissít
     */
    public TileController(FloorTile tile, FloorTileView view) {
        this.tile = tile;
        this.tileView = view;
    }

    /**
     * A mező inicializálása
     */
    public void initialize() {
        tile.addOnChangeEventListener(this);
        onTileChanged();
    }

    /**
     * A mező megválzosá eseményének kezelése
     */
    @Override
    public void onTileChanged() {
        Item item = tile.getItem();
        Person person = tile.getPerson();

        GameController gameController = GameController.getInstance();
        PersonView personView = (PersonView) gameController.getModelView(person);
        ItemView itemView = (ItemView) gameController.getModelView(item);

        tileView.setContents(itemView, personView);
    }

    @Override
    public void onClearTile() {
        tileView.clearOverlays();
    }

    @Override
    public void onEffectApplied(GasEffect effect) {
        tileView.addOverlay(OverlayFactory.createOverlay(effect));
    }

    @Override
    public void onEffectApplied(JanitorEffect effect) {
        tileView.addOverlay(OverlayFactory.createOverlay(effect));
    }
}
