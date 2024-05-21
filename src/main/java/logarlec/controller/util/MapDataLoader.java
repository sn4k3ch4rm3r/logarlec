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
            readInVariableData(doc, 0);

            // A tárgyak beolvasása
            loadItems();

            // A személyek beolvasása
            loadPeople(doc);
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
    private void readInVariableData(Document doc, int configId) {
        // A room taggel rendelkező elemek listázása
        NodeList configurations = doc.getElementsByTagName("configuration");
        for (int i = 0; i < configurations.getLength(); i++) {
            Node node = configurations.item(i);
            // Ha a node egy elem
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                // A room elem attribútumainak beolvasása
                int id = Integer.parseInt(element.getAttribute("id"));
                if (id == configId) {
                    NodeList rooms = element.getElementsByTagName("room");
                    for (int j = 0; j < rooms.getLength(); j++) {
                        Node roomNode = rooms.item(j);
                        if (roomNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element roomElement = (Element) roomNode;
                            // A room elem attribútumainak beolvasása
                            int roomId = Integer.parseInt(roomElement.getAttribute("id"));
                            int x = Integer.parseInt(roomElement.getAttribute("x"));
                            int y = Integer.parseInt(roomElement.getAttribute("y"));
                            int width = Integer.parseInt(roomElement.getAttribute("width"));
                            int height = Integer.parseInt(roomElement.getAttribute("height"));
                            int capacity = Integer.parseInt(roomElement.getAttribute("capacity"));
                            // A room elem attribútumainak beolvasása
                            gameBuilder.addRoom(roomId, capacity, new Position(x, y), width, height);
                        }
                    }
                    NodeList items = element.getElementsByTagName("item");
                    for (int j = 0; j < items.getLength(); j++) {
                        Node itemNode = items.item(j);
                        if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element itemElement = (Element) itemNode;
                            int x = Integer.parseInt(itemElement.getAttribute("x"));
                            int y = Integer.parseInt(itemElement.getAttribute("y"));
                            String type = itemElement.getAttribute("type");
                            this.items.put(new Position(x, y), type);
                        }
                    }

                    NodeList doors = element.getElementsByTagName("door");
                    for (int j = 0; j < doors.getLength(); j++) {
                        node = doors.item(j);
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element itemElement = (Element) node;
                            int to = Integer.parseInt(itemElement.getAttribute("to"));
                            int from = Integer.parseInt(itemElement.getAttribute("from"));
                            int x0 = Integer.parseInt(itemElement.getAttribute("x0"));
                            int y0 = Integer.parseInt(itemElement.getAttribute("y0"));
                            int x1 = Integer.parseInt(itemElement.getAttribute("x1"));
                            int y1 = Integer.parseInt(itemElement.getAttribute("y1"));
                            boolean oneway = Boolean.parseBoolean(itemElement.getAttribute("oneway"));

                            gameBuilder.addDoor(from, to, new Position(x0, y0), new Position(x1, y1), oneway);
                        }
                    }
                }

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
    private void loadPeople(Document doc){
        NodeList persons = doc.getElementsByTagName("person");
        for (int i = 0; i < persons.getLength(); i++) {
            Node personNode = persons.item(i);
            if (personNode.getNodeType() == Node.ELEMENT_NODE) {
                Element personElement = (Element) personNode;
                int x = Integer.parseInt(personElement.getAttribute("x"));
                int y = Integer.parseInt(personElement.getAttribute("y"));
                String type = personElement.getAttribute("type");
                this.people.put(new Position(x, y), type);
            }
        }

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
