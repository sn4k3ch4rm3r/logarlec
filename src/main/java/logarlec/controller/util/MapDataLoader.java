package logarlec.controller.util;

import logarlec.Configuration;
import logarlec.model.util.Position;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.*;

/**
 * A pálya adatainak .xml fájlból való betöltését végző osztály
 */
public class MapDataLoader {

    /**
     * A beolvasott tárgyak listája
     */
    private Map<Position, String> items;
    /**
     * A beolvasott személyek listája
     */
    private Map<Position, String> people;

    GameBuilder gameBuilder;

    public GameBuilder loadMapData() {
        // Tárolók inicializálása
        items = new HashMap<>();
        people = new HashMap<>();

        // gameBuilder inicializálása
        gameBuilder = new GameBuilder(23, 24);

        try {
            // Az UTF-8 kódolásó fájl beolvasásához steraemet kell használni
            InputStream inputStream =
                    getClass().getClassLoader().getResourceAsStream(Configuration.MAP_PATH);
            assert inputStream != null;
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");

            // A DOM parser létrehozása
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            // A dokumentum normalizálása ez nem kötelező, csak ajánlott lépés
            doc.getDocumentElement().normalize();

            // A szobák beolvasása az xml fájlból
            readRooms(doc);

            // Az ajtók beolvasása az xml fájlból
            readDoors(doc);

            // A tárgyak beolvasása
            loadItems();

            // A személyek beolvasása
            loadPeople();
            return gameBuilder;
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * A szobák beolvasása az xml fájlból
     *
     * @param doc a beolvasott xml fájl
     */
    private void readRooms(Document doc) {
        // A room taggel rendelkező elemek listázása
        NodeList tiles = doc.getElementsByTagName("room");
        for (int i = 0; i < tiles.getLength(); i++) {
            Node node = tiles.item(i);
            // Ha a node egy elem
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                int id = Integer.parseInt(element.getAttribute("id"));
                int x = Integer.parseInt(element.getAttribute("x"));
                int y = Integer.parseInt(element.getAttribute("y"));
                int width = Integer.parseInt(element.getAttribute("width"));
                int height = Integer.parseInt(element.getAttribute("height"));
                int capacity = Integer.parseInt(element.getAttribute("capacity"));

                gameBuilder.addRoom(id, capacity, new Position(x, y), width, height);

                NodeList children = element.getChildNodes();
                for (int j = 0; j < children.getLength(); j++) {
                    Node child = children.item(j);
                    if (child.getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) child;
                        String childType = childElement.getTagName();
                        if (childType.equals("item")) {
                            int x0 = Integer.parseInt(childElement.getAttribute("x"));
                            int y0 = Integer.parseInt(childElement.getAttribute("y"));
                            String subType = childElement.getAttribute("type");
                            items.put(new Position(x0, y0), subType);
                        }
                        else if (childType.equals("person")) {
                            int x0 = Integer.parseInt(childElement.getAttribute("x"));
                            int y0 = Integer.parseInt(childElement.getAttribute("y"));
                            String subType = childElement.getAttribute("type");
                            people.put(new Position(x0, y0), subType);
                        }
                    }
                }

            }
        }
    }

    /**
     * Az ajtók beolvasása az xml fájlból
     *
     * @param doc a beolvasott xml fájl
     */
    private void readDoors(Document doc) {
        NodeList doors = doc.getElementsByTagName("door");
        for (int i = 0; i < doors.getLength(); i++) {
            Node node = doors.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                int to = Integer.parseInt(element.getAttribute("to"));
                int from = Integer.parseInt(element.getAttribute("from"));
                int x0 = Integer.parseInt(element.getAttribute("x0"));
                int y0 = Integer.parseInt(element.getAttribute("y0"));
                int x1 = Integer.parseInt(element.getAttribute("x1"));
                int y1 = Integer.parseInt(element.getAttribute("y1"));
                boolean oneway = Boolean.parseBoolean(element.getAttribute("oneway"));

                gameBuilder.addDoor(from, to, new Position(x0, y0), new Position(x1, y1), oneway);
            }
        }
    }

    /**
     * A tárgyak betöltése és létrehozása
     */
    private void loadItems() {
        for (Map.Entry<Position, String> entry : items.entrySet()) {
            Position position = entry.getKey();
            String type = entry.getValue();
            switch (type) {
                case "AirFreshener":
                    gameBuilder.addAirFreshener(position);
                    break;
                case "Beer":
                    gameBuilder.addBeer(position);
                    break;
                case "Camembert":
                    gameBuilder.addCamembert(position);
                    break;
                case "CodeOfStudies":
                    gameBuilder.addCodeOfStudies(position);
                    break;
                case "Mask":
                    gameBuilder.addMask(position);
                    break;
                case "SlideRule":
                    gameBuilder.addSlideRule(position);
                    break;
                case "WetRag":
                    gameBuilder.addWetRag(position);
                    break;
                case "Transistor":
                    gameBuilder.addTransistor(position);
                    break;
                case "FakeCodeOfStudies":
                    gameBuilder.addFakeCodeOfStudies(position);
                    break;
                case "FakeMask":
                    gameBuilder.addFakeMask(position);
                    break;
                case "FakeSlideRule":
                    gameBuilder.addFakeSlideRule(position);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid item type");
            }
        }
    }

    /**
     * A személyek betöltése és létrehozása
     */
    private void loadPeople() {
        for (Map.Entry<Position, String> entry : people.entrySet()) {
            Position position = entry.getKey();
            String type = entry.getValue();
            switch (type) {
                case "Teacher":
                    gameBuilder.addTeacher(position);
                    break;
                case "Janitor":
                    gameBuilder.addJanitor(position);
                    break;
                case "Player":
                    gameBuilder.addPlayer(position);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid person type");
            }
        }
    }
}
