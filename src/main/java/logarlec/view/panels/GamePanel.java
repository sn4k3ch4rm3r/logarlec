package logarlec.view.panels;

import logarlec.Configuration;
import logarlec.view.Renderer;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

public class GamePanel extends JPanel {
    private Renderer renderer;

    public GamePanel(Renderer renderer) {
        this.renderer = renderer;
        this.setDoubleBuffered(true);
        this.setPreferredSize(
                new Dimension(Configuration.WINDOW_WIDTH, Configuration.WINDOW_HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(renderer.getScreenBuffer(), 0, 0,
                getPreferredSize().width, getPreferredSize().height, null);
    }
}
