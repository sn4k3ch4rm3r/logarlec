package logarlec.view.drawables;

import logarlec.view.utils.I18n;
import logarlec.view.utils.TextRenderer;

import java.awt.*;

public class PlayerView implements Drawable {
    PersonView personView;
    InventoryView inventoryView;

    public PlayerView(PersonView personView, InventoryView inventoryView) {
        this.personView = personView;
        this.inventoryView = inventoryView;
    }

    @Override
    public void draw(Graphics2D g2d) {
        // TODO: Have named players or something.
        g2d.drawImage(TextRenderer.draw(I18n.getString("player"), 8), 8, 8, null);

        Graphics2D personGraphics = (Graphics2D) g2d.create(8, 20, 16, 16);
        personView.draw(personGraphics);
        personGraphics.dispose();

        Graphics2D inventoryGraphics = (Graphics2D) g2d.create(40, 20, 80, 16);
        inventoryView.draw(inventoryGraphics);
        inventoryGraphics.dispose();
    }
}
