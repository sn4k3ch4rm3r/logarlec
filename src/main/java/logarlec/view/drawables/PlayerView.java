package logarlec.view.drawables;

import logarlec.controller.util.SpriteManager;
import logarlec.view.utils.I18n;
import logarlec.view.utils.TextRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerView implements Drawable {
    private PersonView personView;
    private InventoryView inventoryView;
    private BufferedImage highlight;
    private boolean isActive;
    private boolean isDead;

    public PlayerView(PersonView personView, InventoryView inventoryView) {
        this.personView = personView;
        this.inventoryView = inventoryView;
        this.highlight = SpriteManager.getInstance().getSprite("highlight");
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(TextRenderer.draw(I18n.getString("player"), 8), 8, 8, null);

        if (isActive) {
            g2d.drawImage(highlight, null, null);
        }

        Graphics2D personGraphics = (Graphics2D) g2d.create(8, 20, 16, 16);
        personView.draw(personGraphics);
        personGraphics.dispose();

        Graphics2D inventoryGraphics = (Graphics2D) g2d.create(40, 20, 80, 16);
        inventoryView.draw(inventoryGraphics);
        inventoryGraphics.dispose();

        if (isDead) {
            g2d.setColor(Color.RED);
            g2d.drawLine(0, 0, 128, 40);
            g2d.drawLine(0, 40, 128, 0);
        }
    }

    public void setActive(boolean value) {
        isActive = value;
    }

    public void setDead(boolean value) {
        isDead = value;
    }
}
