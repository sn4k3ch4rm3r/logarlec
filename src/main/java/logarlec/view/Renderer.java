package logarlec.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import logarlec.view.drawables.Drawable;

public class Renderer {
	private BufferedImage screenBuffer;

	public Renderer(int width, int height) {
		screenBuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}

	public void clear(Color color) {
		Graphics2D graphics = screenBuffer.createGraphics();
		graphics.setColor(color);
		graphics.fillRect(0, 0, screenBuffer.getWidth(), screenBuffer.getHeight());
		graphics.dispose();
	}

	public synchronized void render(Drawable view) {
		Graphics2D graphics = screenBuffer.createGraphics();
		view.draw(graphics);
		graphics.dispose();
	}

	public synchronized BufferedImage getScreenBuffer() {
		return screenBuffer;
	}
}
