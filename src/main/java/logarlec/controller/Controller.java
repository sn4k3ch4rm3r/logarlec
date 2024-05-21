package logarlec.controller;

import logarlec.Configuration;
import logarlec.controller.util.MapDataLoader;
import logarlec.view.Renderer;
import logarlec.view.Window;
import logarlec.view.panels.GamePanel;
import logarlec.view.panels.MenuPanel;

public class Controller {
	private Window window;
	private GamePanel gamePanel;
	private MenuPanel menuPanel;
	private Renderer gameRenderer;

	public Controller() {
		window = new Window();

		menuPanel = new MenuPanel(() -> startGame());
		window.setPanel(menuPanel);

		gameRenderer = new Renderer(Configuration.WIDTH, Configuration.HEIGHT);
		gamePanel = new GamePanel(gameRenderer);
	}

	public void startGame() {
		window.setPanel(gamePanel);
		GameController gameController = new MapDataLoader().loadMapData().setPanel(gamePanel)
				.setRenderer(gameRenderer).build();
		gameController.updateView();
	}
}
