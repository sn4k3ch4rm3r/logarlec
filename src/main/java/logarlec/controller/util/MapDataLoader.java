package logarlec.controller.util;

import logarlec.Configuration;
import logarlec.model.gameobjects.Person;
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
import java.util.List;
import java.util.Map;

public class MapDataLoader {
    private Boolean[][] walls;
    private Map<Position, String> items;
    private Map<Position, String> people;

    public void loadMapData() {
        walls = new Boolean[Configuration.MAP_WIDTH][Configuration.MAP_HEIGHT];
        items = new HashMap<Position, String>();
        people = new HashMap<Position, String>();
        try{
            InputStream inputStream =
                    getClass().getClassLoader().getResourceAsStream(Configuration.MAP_PATH);
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            doc.getDocumentElement().normalize();

            //Read the doors from the xml file
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
                }
            }

            //Read the walls and floors from the xml file
            NodeList tiles = doc.getElementsByTagName("tile");
            for (int i = 0; i < tiles.getLength(); i++) {
                Node node = tiles.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    int x = Integer.parseInt(element.getAttribute("x"));
                    int y = Integer.parseInt(element.getAttribute("y"));
                    String type = element.getAttribute("type");
                    if(type.equals("wall")) {
                        walls[x][y] = true;
                    }

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



        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        MapDataLoader mapDataLoader = new MapDataLoader();
        mapDataLoader.loadMapData();
    }
}
