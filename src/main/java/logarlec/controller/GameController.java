package logarlec.controller;

import java.util.Map;
import java.util.List;
import logarlec.controller.util.GameBuilder;
import logarlec.controller.util.GameRebuilder;
import logarlec.model.Game;
import logarlec.model.items.Item;
import logarlec.model.util.Direction;
import logarlec.model.util.Entity;
import logarlec.model.util.Position;
import logarlec.view.Renderer;
import logarlec.view.drawables.Drawable;
import logarlec.view.drawables.GameView;
import logarlec.view.panels.GamePanel;
import logarlec.view.utils.Palette;


public class GameController implements Runnable {
    private static GameController instance;
    private Game game;
    private Map<Object, Drawable> modelViews;
    private List<PersonController> personControllers;

    private GamePanel panel;
    private Renderer renderer;

    private GameView gameView;

    private GameBuilder builder;

    private GameController(GameBuilder builder) {
        this.builder = builder;
        game = builder.getGameState();
        modelViews = builder.getModelViews();
        personControllers = builder.getPersonControllers();
        gameView = builder.getGameView();
        panel = builder.getPanel();
        renderer = builder.getRenderer();
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
        renderer.clear(Palette.getColor(26));
        renderer.render(gameView);

        panel.repaint();
    }

    public void moveEntity(Entity entity, Direction direction) {
        game.moveEntity(entity, direction);
    }

    public void moveEntity(Entity entity, Position position) {
        game.moveEntity(entity, position);
    }

    public boolean dropItem(Entity entity, Item item) {
        return game.dropItem(entity, item);
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        GameRebuilder rebuilder = new GameRebuilder(game, builder);
        rebuilder.rebuildGame(1);
        while (true) {
            for (PersonController person : personControllers) {
                person.turn();
            }
            game.update(1);
            updateView();
        }
    }
}
