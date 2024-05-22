package logarlec.view.drawables;

import java.awt.Graphics2D;
import logarlec.controller.util.SpriteManager;
import logarlec.model.items.Transistor;

public class TransistorView extends ItemView {

    public TransistorView(Transistor transistor) {
        super(transistor, SpriteManager.getInstance().getSprite("transistor"));
    }

    @Override
    public void draw(Graphics2D g2d) {
        this.sprite = SpriteManager.getInstance()
                .getSprite(((Transistor) item).isActive() ? "transistor-active" : "transistor");
        super.draw(g2d);
    }
}
