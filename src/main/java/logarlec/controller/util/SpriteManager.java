package logarlec.controller.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import logarlec.Configuration;
import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SpriteManager {
    private static SpriteManager instance;
    private Map<String, BufferedImage> spriteImages;

    private SpriteManager() {
        spriteImages = new HashMap<>();
    }

    public static SpriteManager getInstance() {
        if (instance == null) {
            instance = new SpriteManager();
        }
        return instance;
    }

    /**
     * Betölti és feldarabolja a spritesheet-et és eltárolja a különböző sprite-okat név alapján.
     */
    public void loadSprites() {
        try {
            InputStream inputStream =
                    getClass().getClassLoader().getResourceAsStream(Configuration.SPRITE_PATH);
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            String spritePath = root.getAttribute("spritesheet");
            NodeList sprites = root.getElementsByTagName("sprite");
            BufferedImage spriteSheet =
                    ImageIO.read(getClass().getClassLoader().getResource(spritePath));

            for (int i = 0; i < sprites.getLength(); i++) {
                Node sprite = sprites.item(i);
                NamedNodeMap spriteAttributes = sprite.getAttributes();

                String spriteName = spriteAttributes.getNamedItem("name").getNodeValue();
                int x = Integer.parseInt(spriteAttributes.getNamedItem("x").getNodeValue());
                int y = Integer.parseInt(spriteAttributes.getNamedItem("y").getNodeValue());

                int spriteWidth =
                        Integer.parseInt(spriteAttributes.getNamedItem("width").getNodeValue());
                int spriteHeight =
                        Integer.parseInt(spriteAttributes.getNamedItem("height").getNodeValue());

                BufferedImage image = spriteSheet.getSubimage(x, y, spriteWidth, spriteHeight);
                spriteImages.put(spriteName, image);
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Visszaad egy képet név alapján
     * 
     * @param name A sprite neve
     * @return <code>BufferedImage</code> a sprite.
     */
    public BufferedImage getSprite(String name) {
        return spriteImages.get(name);
    }
}
