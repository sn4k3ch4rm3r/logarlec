package logarlec.controller;

import java.util.List;
import java.util.Map;

import logarlec.model.Game;
import logarlec.model.gameobjects.GameObject;
import logarlec.model.gameobjects.Room;
import logarlec.model.tiles.Tile;
import logarlec.model.util.Direction;
import logarlec.model.util.Entity;
import logarlec.model.util.Position;


public class GameController {
    private static GameController instance;
    private PlayerController currentPlayer;
    private Renderer renderer;
    private Game game;
    private List<PlayerController> players;
    private List<Room> rooms;
    private List<RoomView> roomViews;
    private Map<Object, Drawable> modelViews;

    public void addModelView(GameObject object, Drawable representation){
        modelViews.put(object, representation);
    }

    public Drawable getModelView(Object object){
        return modelViews.get(object);
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void addRoomView(RoomView roomView){
        roomViews.add(roomView);
    }

    public void setTile(Tile tile, Position position){
        game.setTile(tile, position);
    }

    public Tile getTile(Position position){
        game.getTile(position);
    }

    public PlayerController getCurrentPlayer(){
        return currentPlayer;
    }

    public void addEntity(Entity entity){
        //TODO
    }
    public void addPlayerController(PlayerController player){   
        players.add(player);
    }

    public void updateView(){
        //TODO
    }

    public static GameController getInstance(){
        if(instance == null){
            instance = new GameController();
        }
        return instance;
    }

    public void moveEntity(Entity entity, Direction direction){
        game.moveEntity(entity, direction);
    }
}
