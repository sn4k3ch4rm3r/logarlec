package logarlec.controller;

import logarlec.view.Window;
import logarlec.view.panels.GamePanel;
import logarlec.view.panels.MenuPanel;

public class Controller {
	private Window window;
	private GamePanel gamePanel;
	private MenuPanel menuPanel;

	public Controller() {
		window = new Window();
		gamePanel = new GamePanel();
		menuPanel = new MenuPanel(() -> startGame());

		window.setPanel(menuPanel);
	}

	public void startGame() {
		window.setPanel(gamePanel);
	}
}
