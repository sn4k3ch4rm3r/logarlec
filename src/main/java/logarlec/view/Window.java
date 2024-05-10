package logarlec.view;

import javax.swing.JFrame;
import logarlec.view.panels.GamePanel;
import logarlec.view.panels.MenuPanel;

public class Window extends JFrame {
	private MenuPanel menuPanel;
	private GamePanel gamePanel;

	public Window() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Slide Regulae");

		menuPanel = new MenuPanel();
		this.setContentPane(menuPanel);
		this.pack();

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void startGame() {
		// TODO: A játék elindítása
		gamePanel = new GamePanel();
		this.setContentPane(gamePanel);
		this.pack();
	}
}
