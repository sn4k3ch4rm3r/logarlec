package logarlec.controller.util;

import logarlec.Configuration;
import logarlec.model.gameobjects.Person;
import logarlec.model.gameobjects.Room;
import logarlec.model.items.Item;
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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapDataLoader {
    class ExtendedRoom {
        public Room room;
        public Integer id;
        public Position position;
        public Integer width;
        public Integer height;

        public ExtendedRoom(Room room,Integer id, Position position, Integer width, Integer height) {
            this.room = room;
            this.id = id;
            this.position = position;
            this.width = width;
            this.height = height;
        }
    }
    private List<ExtendedRoom> rooms;
    private Map<Position, String> items;
    private Map<Position, String> people;

    public void loadMapData() {
        rooms = new LinkedList<>();
        items = new HashMap<>();
        people = new HashMap<>();

        try{
            InputStream inputStream =
                    getClass().getClassLoader().getResourceAsStream(Configuration.MAP_PATH);
            assert inputStream != null;
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            doc.getDocumentElement().normalize();

            //Read the rooms from the xml file
            readRooms(doc);

            //Read the doors from the xml file
            readDoors(doc);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readRooms(Document doc) {
        NodeList tiles = doc.getElementsByTagName("room");
        for (int i = 0; i < tiles.getLength(); i++) {
            Node node = tiles.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                int id = Integer.parseInt(element.getAttribute("id"));
                int x = Integer.parseInt(element.getAttribute("x"));
                int y = Integer.parseInt(element.getAttribute("y"));
                int width = Integer.parseInt(element.getAttribute("width"));
                int height = Integer.parseInt(element.getAttribute("height"));

                Component<Room, RoomView> component = ObjectFactory.createRoom(10, new Position(x, y), width, height);

                ExtendedRoom room = new ExtendedRoom(component.getModel(), id, new Position(x, y), width, height);
                rooms.add(room);


                NodeList children = element.getChildNodes();
                for(int j = 0; j < children.getLength(); j++) {
                    Node child = children.item(j);
                    if(child.getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) child;
                        String childType = childElement.getTagName();
                        if(childType.equals("item")) {
                            String subType = childElement.getAttribute("type");
                            items.put(new Position(x, y), subType);
                        } else if(childType.equals("person")) {
                            String subType = childElement.getAttribute("type");
                            people.put(new Position(x, y), subType);
                        }
                    }
                }

            }
        }
    }

    private void readDoors(Document doc) {
        NodeList doors = doc.getElementsByTagName("door");
        for (int i = 0; i < doors.getLength(); i++) {
            Node node = doors.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String to = element.getAttribute("to");
                String from = element.getAttribute("from");
                int x0 = Integer.parseInt(element.getAttribute("x0"));
                int y0 = Integer.parseInt(element.getAttribute("y0"));
                int x1 = Integer.parseInt(element.getAttribute("x1"));
                int y1 = Integer.parseInt(element.getAttribute("y1"));

                Room room0 = null;
                Room room1 = null;

                for(ExtendedRoom room : rooms) {
                    if(room.id == Integer.parseInt(from)) {
                        room0 = room.room;
                    } else if(room.id == Integer.parseInt(to)) {
                        room1 = room.room;
                    }
                }

                if(room0 == null || room1 == null) {
                    throw new RuntimeException("Room not found");
                }

                ObjectFactory.createDoor( room0, room1, new Position(x0, y0), new Position(x1, y1));
            }
        }
    }

    public static void main(String[] args) {
        MapDataLoader mapDataLoader = new MapDataLoader();
        mapDataLoader.loadMapData();
    }
}
