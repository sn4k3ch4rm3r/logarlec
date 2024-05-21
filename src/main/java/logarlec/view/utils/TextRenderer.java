package logarlec.view.utils;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.List;
import java.util.LinkedList;

public class TextRenderer {
	private static Font font;

	static {
		try {
			InputStream is =
					TextRenderer.class.getClassLoader().getResourceAsStream("PublicPixel.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

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
		g.setFont(font.deriveFont((float) size));
		g.drawString(text, 0, size);

		return img;
	}

	public static BufferedImage drawCentered(String text, int size, int width) {
		BufferedImage img = new BufferedImage(width, size, BufferedImage.TYPE_INT_ARGB);
		BufferedImage txt = draw(text, size);
		Graphics g = img.createGraphics();
		g.drawImage(txt, (width - txt.getWidth()) / 2, 0, null);
		g.dispose();
		return img;
	}

	public static BufferedImage drawWrapped(String text, int size, int maxWidth) {
		String[] words = text.split(" ");
		List<String> lines = new LinkedList<>();
		StringBuilder currentLine = new StringBuilder();
		for (String word : words) {
			if ((currentLine.length() + word.length()) * size <= maxWidth) {
				currentLine.append(word + " ");
			}
			else {
				lines.add(currentLine.toString());
				currentLine = new StringBuilder(word + " ");
			}
		}
		if (!currentLine.isEmpty()) {
			lines.add(currentLine.toString());
		}

		BufferedImage img =
				new BufferedImage(maxWidth, lines.size() * (size + 1), BufferedImage.TYPE_INT_ARGB);
		Graphics g = img.createGraphics();
		for (int i = 0; i < lines.size(); i++) {
			g.drawImage(draw(lines.get(i), size), 0, i * (size + 1), null);
		}
		g.dispose();

		return img;
	}
}
