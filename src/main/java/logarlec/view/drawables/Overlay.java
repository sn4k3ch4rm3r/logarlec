package logarlec.view.drawables;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Overlay implements Drawable {
    protected BufferedImage sprite;

    public Overlay(BufferedImage sprite) {
        this.sprite = sprite;
    }

    @Override
    public void draw(Graphics2D g2d) {
        if (sprite == null) return;
        g2d.drawImage(sprite, null, null);
    }
}
