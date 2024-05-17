package logarlec.view.drawables;

import logarlec.model.gameobjects.Student;
import logarlec.view.utils.TextRenderer;

import java.awt.*;

public class PlayerView implements Drawable {
    Student student;
    String name;
    PersonView personView;
    InventoryView inventoryView;

    public PlayerView(String name) {
        this.name = name;
    }

    @Override
    public void draw(Graphics2D g2d) {
        int width = g2d.getClipBounds().width;
        int height = g2d.getClipBounds().height;
        g2d.setColor(Color.WHITE);
        Graphics2D g = (Graphics2D) g2d.create(0, 0, width, 40);
        g.drawImage(TextRenderer.draw(name, 40), 0, 0, width, 40, null);
        g = (Graphics2D) g2d.create(0, (int) (height * 0.4), 60, 60);
        personView.draw(g);
        g = (Graphics2D) g2d.create(60, (int) (height * 0.4), width - 60, 60);
        inventoryView.draw(g);
    }
}
