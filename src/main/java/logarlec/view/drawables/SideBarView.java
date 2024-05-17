package logarlec.view.drawables;

import java.awt.*;
import java.util.List;

public class SideBarView implements Drawable {
    List<PlayerView> players;
    @Override
    public void draw(Graphics2D g2d) {
        int i = 0;
        int width = g2d.getClipBounds().width;
        for (PlayerView player : players) {
            Graphics2D g = (Graphics2D) g2d.create(i * 100, 0, width, 100);
            player.draw(g);
            i++;
        }
    }
}
