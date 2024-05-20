package logarlec.controller;

import java.util.Map;
import logarlec.controller.util.GameBuilder;
import logarlec.model.Game;
import logarlec.model.gameobjects.GameObject;
import logarlec.model.tiles.Tile;
import logarlec.model.util.Direction;
import logarlec.model.util.Entity;
import logarlec.model.util.Position;
import logarlec.view.drawables.Drawable;


public class GameController {
    private static GameController instance;
    private Game game;
    private Map<Object, Drawable> modelViews;

    private GameController(GameBuilder builder) {
        // TODO
    }

    public static void initialize(GameBuilder builder) {
        instance = new GameController(builder);
    }

    public static GameController getInstance() {
        if (instance == null) {
            throw new IllegalStateException("GameController is not yet initialized.");
        }
        return instance;
    }

    public void addModelView(GameObject object, Drawable representation) {
        modelViews.put(object, representation);
    }

    public Drawable getModelView(Object object) {
        return modelViews.get(object);
    }

    public Tile getTile(Position position) {
        return game.getTile(position);
    }

    public void addEntity(Entity entity) {
        // TODO
    }

    public void updateView() {
        // TODO
    }

    public void moveEntity(Entity entity, Direction direction) {
        game.moveEntity(entity, direction);
    }
}
