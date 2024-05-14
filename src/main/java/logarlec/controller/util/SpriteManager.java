package logarlec.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Map;

public class SpriteManager {
    private int spriteSheetWidth;
    private int spriteSheetHeight;
    private static Map<String, BufferedImage> spriteImages;
    private static final String configPath = "configurations/SpriteConfiguration.xml";

    /**
     * Betölti a megadott elérési útvonalon található sprite-okat.
     */
    public void loadSprites() {
        String spritePath;
        try {

            InputStream inputStream= new FileInputStream(configPath);
            Reader reader = new InputStreamReader(inputStream,"UTF-8");
            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            spritePath = root.getElementsByTagName("config").item(0).getAttributes()
                    .getNamedItem("sheetPath").getNodeValue();
            spriteSheetWidth = Integer.parseInt(root.getElementsByTagName("config").item(0).getAttributes()
                    .getNamedItem("sheetWidth").getNodeValue());
            spriteSheetHeight = Integer.parseInt(root.getElementsByTagName("config").item(0).getAttributes()
                    .getNamedItem("sheetHeight").getNodeValue());

            var sprites = root.getElementsByTagName("sprite");

            for(int i = 0; i < sprites.getLength(); i++) {
                var sprite = sprites.item(i);
                var spriteAttributes = sprite.getAttributes();
                String spriteName = spriteAttributes.getNamedItem("name").getNodeValue();
                BufferedImage spriteImage = ImageIO.read(new File(spritePath));
                int x = Integer.parseInt(spriteAttributes.getNamedItem("x").getNodeValue());
                int y = Integer.parseInt(spriteAttributes.getNamedItem("y").getNodeValue());

                int spriteWidth = Integer.parseInt(spriteAttributes.getNamedItem("width").getNodeValue());
                int spriteHeight = Integer.parseInt(spriteAttributes.getNamedItem("height").getNodeValue());

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