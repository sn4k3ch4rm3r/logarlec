package logarlec.view.drawables;

import java.awt.*;

public interface Drawable {
    /**
     * A nézet kirajzolása az elérhető területre.
     * @param g2d A rajzolásra használt grafikus objektum.
     */
    void draw(Graphics2D g2d);
}
