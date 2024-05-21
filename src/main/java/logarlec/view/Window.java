package logarlec.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import logarlec.view.utils.I18n;

public class Window extends JFrame {

	public Window() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle(I18n.getString("slide-rule"));

		this.setVisible(true);
	}

	public void setPanel(JPanel panel) {
		this.setContentPane(panel);
		this.pack();
		this.setLocationRelativeTo(null);
	}
}
