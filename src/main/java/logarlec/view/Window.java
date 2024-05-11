package logarlec.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

	public Window() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Slide Regulae");

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void setPanel(JPanel panel) {
		this.setContentPane(panel);
		this.pack();
	}
}
