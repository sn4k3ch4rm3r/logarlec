package logarlec.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.imageio.ImageIO;
import javax.security.sasl.SaslException;
import javax.swing.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class SpriteManager {
    private int spriteSheetWidth;
    private int spriteSheetHeight;
    private int spriteWidth;
    private int spriteHeight;
    private static Map<String, BufferedImage> spriteImages;
    private static final String configPath = "configurations/SpriteConfiguration.xml";

    /**
     * Betölti a megadott elérési útvonalon található sprite-okat.
     */
    public void loadSprites() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        String spritePath = null;
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(configPath);

            doc.getDocumentElement().normalize();

            var generalInfo = doc.getElementsByTagName("generalInfo").item(0).getAttributes();

            this.spriteSheetWidth = Integer.parseInt(generalInfo.getNamedItem("spriteSheetWidth").getNodeValue());
            this.spriteSheetHeight = Integer.parseInt(generalInfo.getNamedItem("spriteSheetHeight").getNodeValue());
            this.spriteWidth = Integer.parseInt(generalInfo.getNamedItem("spriteWidth").getNodeValue());
            this.spriteHeight = Integer.parseInt(generalInfo.getNamedItem("spriteHeight").getNodeValue());
            spritePath = doc.getElementsByTagName("spritePath").item(0).getTextContent();

            var sprites = doc.getElementsByTagName("sprite");

            for(int i = 0; i < sprites.getLength(); i++) {
                var sprite = sprites.item(i);
                var spriteAttributes = sprite.getAttributes();
                String spriteName = spriteAttributes.getNamedItem("name").getNodeValue();
                BufferedImage spriteImage = ImageIO.read(new File(spritePath));
                Element element = (Element)sprite;
                int x = Integer.parseInt(element.getElementsByTagName("x").item(0).getTextContent());
                int y = Integer.parseInt(element.getElementsByTagName("y").item(0).getTextContent());

                spriteImage = spriteImage.getSubimage(x, y, spriteWidth, spriteHeight);
                spriteImages.put(spriteName, spriteImage);
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class SpriteManagerTest {
    public static void main(String[] args) {
        SpriteManager spriteManager = new SpriteManager();
        spriteManager.loadSprites();
    }
}