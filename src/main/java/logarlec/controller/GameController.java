package logarlec.controller;

import java.util.Map;
import java.util.List;
import logarlec.controller.util.GameBuilder;
import logarlec.model.Game;
import logarlec.model.util.Direction;
import logarlec.model.util.Entity;
import logarlec.view.drawables.Drawable;
import logarlec.view.drawables.MapView;


public class GameController {
    private static GameController instance;
    private Game game;
    private Map<Object, Drawable> modelViews;
    private List<PersonController> personControllers;

    private MapView mapView;

    private GameController(GameBuilder builder) {
        game = builder.getGameState();
        modelViews = builder.getModelViews();
        personControllers = builder.getPersonControllers();
        mapView = builder.getMapView();
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

    public Drawable getModelView(Object object) {
        return modelViews.get(object);
    }

    public void updateView() {
        // TODO
    }

    public void moveEntity(Entity entity, Direction direction) {
        game.moveEntity(entity, direction);
    }
}
