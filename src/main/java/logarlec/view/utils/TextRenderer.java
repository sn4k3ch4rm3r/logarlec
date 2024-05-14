package logarlec.view.utils;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class TextRenderer {
	/**
	 * Szöveg kirajzolása, a tervben is használt 8x8 pixeles betűtípussal.
	 * 
	 * @param text A kirajzolandó szöveg
	 * @param size Betűméret. Annak érdekében, hogy a betűtípus ne torzuljon 8 többszöröse kell
	 *        legyen.
	 * @return <code>BufferedImage</code>, amire a szöveg ki van rajzolva.
	 */
	public static BufferedImage draw(String text, int size) {
		BufferedImage img =
				new BufferedImage(size * text.length(), size, BufferedImage.TYPE_INT_ARGB);

		Graphics g = img.getGraphics();
		// TODO: load font from resources
		g.setFont(new Font("Public Pixel", Font.PLAIN, size));
		g.drawString(text, 0, size);

		return img;
	}
}
