package logarlec.view.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import logarlec.Configuration;
import logarlec.controller.util.SpriteManager;
import logarlec.view.utils.TextRenderer;

/**
 * Saját gomb osztály, a saját kinézet érdekében.
 */
public class Button extends JButton {

	public Button(String text) {
		super(text);
		this.setPreferredSize(new Dimension((int) (64 * 4 * Configuration.SCALE),
				(int) (16 * 4 * Configuration.SCALE)));
		this.setMaximumSize(getPreferredSize());
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		SpriteManager spriteManager = SpriteManager.getInstance();

		g.drawImage(spriteManager.getSprite(getModel().isRollover() ? "button-hover" : "button"), 0,
				0, getPreferredSize().width, getPreferredSize().height, null);

		BufferedImage textImage =
				TextRenderer.draw(super.getText(), (int) (16 * Configuration.SCALE));
		int x = (this.getPreferredSize().width - textImage.getWidth()) / 2;
		int y = (this.getPreferredSize().height - textImage.getHeight()) / 2;

		g.drawImage(textImage, x, y, null);
	}
}
