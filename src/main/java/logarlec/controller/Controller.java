package logarlec.controller;

import logarlec.Configuration;
import logarlec.controller.util.InputHandler;
import logarlec.controller.util.MapDataLoader;
import logarlec.view.Renderer;
import logarlec.view.Window;
import logarlec.view.panels.GamePanel;
import logarlec.view.panels.MenuPanel;

/**
 * A játék vezérlője
 */
public class Controller {
	/**
	 * Az ablak, amiben a játék megjelenik
	 */
	private Window window;
	/**
	 * A játék panelje
	 */
	private GamePanel gamePanel;
	/**
	 * A menü panelje
	 */
	private MenuPanel menuPanel;
	/**
	 * A játék megjelenítője
	 */
	private Renderer gameRenderer;

	/**
	 * Konstruktor
	 */
	public Controller() {
		window = new Window();

		menuPanel = new MenuPanel(() -> startGame());
		window.setPanel(menuPanel);

		gameRenderer = new Renderer(Configuration.WIDTH, Configuration.HEIGHT);
		gamePanel = new GamePanel(gameRenderer);

		InputHandler.initialize();
	}

	/**
	 * A játék indítása
	 */
	public void startGame() {
		window.setPanel(gamePanel);
		gamePanel.setFocusable(true);
		gamePanel.requestFocus();
		gamePanel.addKeyListener(InputHandler.getInstance());
		GameController gameController = new MapDataLoader().loadMapData(0).setPanel(gamePanel)
				.setRenderer(gameRenderer).build();
		gameController.start();
	}
}
