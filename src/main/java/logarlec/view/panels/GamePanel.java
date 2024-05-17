package logarlec.view.panels;

import logarlec.controller.util.SpriteManager;
import logarlec.view.drawables.GameView;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel {
    private GameView gameView;

    public GamePanel() {
        SpriteManager.getInstance().loadSprites();
        this.gameView = new GameView();
        this.setSize(800, 600);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        gameView.draw(g2d);
    }
}
