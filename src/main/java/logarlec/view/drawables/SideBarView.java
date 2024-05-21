package logarlec.view.drawables;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import logarlec.controller.util.SpriteManager;
import logarlec.view.utils.I18n;
import logarlec.view.utils.TextRenderer;

public class SideBarView implements Drawable {
	private List<PlayerView> players;
	private BufferedImage infoBox;
	private BufferedImage spaceIcon;

	private String feedback;

	public SideBarView() {
		players = new LinkedList<>();
		SpriteManager spriteManager = SpriteManager.getInstance();
		infoBox = spriteManager.getSprite("sidebar-info");
		spaceIcon = spriteManager.getSprite("space");
		feedback = "";
	}

	public void addPlayerView(PlayerView view) {
		players.add(view);
	}

	public void setFeedback(String value) {
		feedback = value;
	}

	@Override
	public void draw(Graphics2D g2d) {
		for (int i = 0; i < players.size(); i++) {
			Graphics2D g = (Graphics2D) g2d.create(8, i * 44, 128, 44);
			players.get(i).draw(g);
			g.dispose();
		}

		Graphics2D infoBoxGraphics = (Graphics2D) g2d.create(8, 200, 128, 176);
		infoBoxGraphics.drawImage(infoBox, null, null);

		infoBoxGraphics.drawImage(
				TextRenderer.drawCentered(I18n.getString("controls"), 8, 128), 0, 4,
				null);

		infoBoxGraphics.drawImage(
				TextRenderer.draw("W - " + I18n.getString("up"), 8), 4, 16, null);
		infoBoxGraphics.drawImage(
				TextRenderer.draw("A - " + I18n.getString("left"), 8), 4, 25, null);
		infoBoxGraphics.drawImage(
				TextRenderer.draw("S - " + I18n.getString("down"), 8), 4, 34, null);
		infoBoxGraphics.drawImage(
				TextRenderer.draw("D - " + I18n.getString("right"), 8), 4, 43, null);
		infoBoxGraphics.drawImage(
				TextRenderer.draw("Q - " + I18n.getString("drop"), 8), 4, 52, null);
		infoBoxGraphics.drawImage(
				TextRenderer.draw("E - " + I18n.getString("use"), 8), 4, 61, null);
		infoBoxGraphics.drawImage(
				TextRenderer.draw("L - " + I18n.getString("link"), 8), 4, 70, null);
		infoBoxGraphics.drawImage(
				TextRenderer.draw("  - " + I18n.getString("done"), 8), 4, 79, null);
		infoBoxGraphics.drawImage(spaceIcon, 4, 79, null);

		infoBoxGraphics.drawImage(
				TextRenderer.drawCentered(I18n.getString("feedback"), 8, 128), 0, 96, null);
		infoBoxGraphics.drawImage(
				TextRenderer.drawWrapped(feedback, 8, 120), 4, 108, null);

		infoBoxGraphics.dispose();
	}
}
