package logarlec.view.drawables;

import logarlec.model.gameobjects.Person;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class PersonView implements Drawable {
    Person person;
    BufferedImage sprite;

    public PersonView(Person person, BufferedImage sprite) {
        this.person = person;
        this.sprite = sprite;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(sprite, null, null);
    }
}
