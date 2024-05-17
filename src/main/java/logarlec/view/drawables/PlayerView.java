package logarlec.view.drawables;

import logarlec.model.gameobjects.Student;

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
        // Temp
        g2d.drawString(name, 0, 0);
        Graphics2D g = (Graphics2D) g2d.create(0, (int) (height * 0.4), 60, 60);
        personView.draw(g);
        g = (Graphics2D) g2d.create(60, (int) (height * 0.4), width - 60, 60);
        inventoryView.draw(g);
    }
}
