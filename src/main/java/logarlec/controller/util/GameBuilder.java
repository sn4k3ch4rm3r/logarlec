package logarlec.controller.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import logarlec.controller.AiController;
import logarlec.controller.GameController;
import logarlec.controller.PersonController;
import logarlec.controller.PlayerController;
import logarlec.controller.TileController;
import logarlec.model.Game;
import logarlec.model.gameobjects.Janitor;
import logarlec.model.gameobjects.Person;
import logarlec.model.gameobjects.Room;
import logarlec.model.gameobjects.Student;
import logarlec.model.gameobjects.Teacher;
import logarlec.model.items.AirFreshener;
import logarlec.model.items.Beer;
import logarlec.model.items.Camembert;
import logarlec.model.items.CodeOfStudies;
import logarlec.model.items.FakeCodeOfStudies;
import logarlec.model.items.FakeMask;
import logarlec.model.items.FakeSlideRule;
import logarlec.model.items.Item;
import logarlec.model.items.Mask;
import logarlec.model.items.SlideRule;
import logarlec.model.items.Transistor;
import logarlec.model.items.WetRag;
import logarlec.model.tiles.DoorTile;
import logarlec.model.tiles.FloorTile;
import logarlec.model.tiles.Tile;
import logarlec.model.tiles.WallTile;
import logarlec.model.util.Direction;
import logarlec.model.util.Door;
import logarlec.model.util.Entity;
import logarlec.model.util.Position;
import logarlec.view.Renderer;
import logarlec.view.drawables.DoorTileView;
import logarlec.view.drawables.Drawable;
import logarlec.view.drawables.FloorTileView;
import logarlec.view.drawables.GameView;
import logarlec.view.drawables.ItemView;
import logarlec.view.drawables.MapView;
import logarlec.view.drawables.PersonView;
import logarlec.view.drawables.SideBarView;
import logarlec.view.drawables.TileView;
import logarlec.view.drawables.TransistorView;
import logarlec.view.drawables.WallTileView;
import logarlec.view.panels.GamePanel;

public class GameBuilder {
	private SpriteManager spriteManager;

	private Game game;
	private Map<Object, Drawable> modelViews;
	private MapView mapView;
	private SideBarView sideBarView;
	private List<PersonController> personControllers;
	private GamePanel panel;
	private Renderer renderer;

	private Map<Integer, Room> rooms;
	private List<TileController> tileControllers;
	private int teacherCount;
	private int playerCount;

	/**
	 * A GameBuilder konstruktora
	 * 
	 * @param mapWidth A pálya szélessége
	 * @param mapHeight A pálya magassága
	 */
	public GameBuilder(int mapWidth, int mapHeight) {
		spriteManager = SpriteManager.getInstance();

		game = new Game(mapWidth, mapHeight);
		modelViews = new HashMap<>();
		mapView = new MapView(mapWidth, mapHeight);
		sideBarView = new SideBarView();
		personControllers = new LinkedList<>();

		rooms = new HashMap<>();
		tileControllers = new LinkedList<>();
		teacherCount = 0;
		playerCount = 0;
	}

	/**
	 * Szoba hozzáadása a játékhoz.
	 * 
	 * @param id A szoba azonosítója, ajtó létrehozásához van rá szükség.
	 * @param capacity A szoba kapacitása.
	 * @param position A szoba bal felső sarkának helye.
	 * @param width A szoba szélessége.
	 * @param height A szoba magassága.
	 * @return A GameBuilder példány.
	 */
	public GameBuilder addRoom(int id, int capacity, Position position, int width, int height) {
		Room room = new Room(capacity);
		game.addRoom(room);
		rooms.put(id, room);
		for (int x = position.x; x < width + position.x; x++) {
			for (int y = position.y; y < height + position.y; y++) {
				TileView view;
				Tile tile;
				if (x == position.x || x == position.x + width - 1 || y == position.y
						|| y == position.y + height - 1) {
					WallTile wallTile = new WallTile(new Position(x, y), room);
					WallTileView wallView = new WallTileView(wallTile);

					if (x == position.x && y == position.y) {
						wallView.setVariation("top-left");
					}
					else if (x == position.x + width - 1 && y == position.y) {
						wallView.setVariation("top-right");
					}
					else if (x == position.x && y == position.y + height - 1) {
						wallView.setVariation("bottom-left");
					}
					else if (x == position.x + width - 1 && y == position.y + height - 1) {
						wallView.setVariation("bottom-right");
					}
					else if (y == position.y) {
						wallView.setVariation("top");
					}
					else if (y == position.y + height - 1) {
						wallView.setVariation("bottom");
					}
					else if (x == position.x) {
						wallView.setVariation("left");
					}
					else if (x == position.x + width - 1) {
						wallView.setVariation("right");
					}

					tile = wallTile;
					view = wallView;
				}
				else {
					FloorTile floorTile = new FloorTile(new Position(x, y), room);
					tile = floorTile;
					view = new FloorTileView(floorTile);
					tileControllers.add(new TileController(floorTile, (FloorTileView) view));
				}
				addTile(tile, view);
			}
		}
		return this;
	}

	/**
	 * Ajtó hozzáadása a játékhoz.
	 * 
	 * @param fromRoomId A kiinduló szoba azonosítója.
	 * @param toRoomId A másik szoba azonosítója.
	 * @param from Az ajtó kiinduló mezőjének pozíciója.
	 * @param to Az ajtó másik mezőjének pozíciója.
	 * @return A GameBuilder példány.
	 */
	public GameBuilder addDoor(int fromRoomId, int toRoomId, Position from, Position to,
			boolean oneWay) {
		Room fromRoom = rooms.get(fromRoomId);
		Room toRoom = rooms.get(toRoomId);

		Door door = new Door(fromRoom, toRoom);
		door.setOneWay(oneWay);

		DoorTile fromTile = new DoorTile(from, fromRoom, door);
		DoorTile toTile = new DoorTile(to, toRoom, door);

		Direction direction = null;
		for (Direction dir : Direction.values()) {
			if (from.add(dir, 1).equals(to)) {
				direction = dir;
			}
		}
		if (direction == null) {
			throw new IllegalArgumentException(
					"The specified to and from tiles are not next to each other.");
		}

		fromTile.setDestination(game.getTile(to.add(direction.getOpposite(), 1)));
		toTile.setDestination(game.getTile(from.add(direction, 1)));

		DoorTileView fromView = new DoorTileView(fromTile, direction);
		DoorTileView toView = new DoorTileView(toTile, direction.getOpposite());

		addTile(fromTile, fromView);
		addTile(toTile, toView);

		return this;
	}

	/**
	 * Játékos hozzáadása.
	 * 
	 * @param position A játékos pozíciója.
	 * @return A GameBuilder példány.
	 */
	public GameBuilder addPlayer(Position position) {
		Student person = new Student();
		PersonView view = new PersonView(person,
				spriteManager.getSprite(String.format("player-%d", ++playerCount)));
		Entity entity = new Entity(position, person);
		PlayerController controller = new PlayerController(entity, view);

		modelViews.put(person, view);
		personControllers.add(controller);
		game.addEntity(entity);
		sideBarView.addPlayerView(controller.getPlayerView());
		return this;
	}

	/**
	 * Oktató hozzáadása.
	 * 
	 * @param position Az oktató pozíciója.
	 * @return A GameBuilder példány.
	 */
	public GameBuilder addTeacher(Position position) {
		return addPerson(position, new Teacher(), AiController::new,
				String.format("teacher-%d", ++teacherCount));
	}

	/**
	 * Takarító hozzáadása
	 * 
	 * @param position A takarító pozíciója.
	 * @return A GameBuilder példány.
	 */
	public GameBuilder addJanitor(Position position) {
		return addPerson(position, new Janitor(), AiController::new, "janitor");
	}

	/**
	 * Légfrissítő tárgy hozzáadása.
	 * 
	 * @param position A tárgy pozíciója
	 * @return A GameBuilder példány.
	 */
	public GameBuilder addAirFreshener(Position position) {
		return addItem(position, new AirFreshener(), "air-freshener");
	}

	/**
	 * Sör tárgy hozzáadása.
	 * 
	 * @param position A tárgy pozíciója
	 * @return A GameBuilder példány.
	 */
	public GameBuilder addBeer(Position position) {
		return addItem(position, new Beer(), "beer");
	}

	/**
	 * Camembert tárgy hozzáadása.
	 * 
	 * @param position A tárgy pozíciója
	 * @return A GameBuilder példány.
	 */
	public GameBuilder addCamembert(Position position) {
		return addItem(position, new Camembert(), "camembert");
	}

	/**
	 * TVSZ tárgy hozzáadása.
	 * 
	 * @param position A tárgy pozíciója
	 * @return A GameBuilder példány.
	 */
	public GameBuilder addCodeOfStudies(Position position) {
		return addItem(position, new CodeOfStudies(), "code-of-studies");
	}

	/**
	 * Maszk tárgy hozzáadása.
	 * 
	 * @param position A tárgy pozíciója
	 * @return A GameBuilder példány.
	 */
	public GameBuilder addMask(Position position) {
		return addItem(position, new Mask(), "mask");
	}

	/**
	 * Logarléc tárgy hozzáadása.
	 * 
	 * @param position A tárgy pozíciója
	 * @return A GameBuilder példány.
	 */
	public GameBuilder addSlideRule(Position position) {
		return addItem(position, new SlideRule(), "slide-rule");
	}

	/**
	 * Nedves rongy tárgy hozzáadása.
	 * 
	 * @param position A tárgy pozíciója
	 * @return A GameBuilder példány.
	 */
	public GameBuilder addWetRag(Position position) {
		return addItem(position, new WetRag(), "wet-rag");
	}

	/**
	 * Tranzisztor tárgy hozzáadása.
	 * 
	 * @param position A tárgy pozíciója
	 * @return A GameBuilder példány.
	 */
	public GameBuilder addTransistor(Position position) {
		Transistor transistor = new Transistor();
		TransistorView view = new TransistorView(transistor);

		modelViews.put(transistor, view);
		game.addItem(transistor, position);
		return this;
	}

	/**
	 * Hamis TVSZ tárgy hozzáadása.
	 * 
	 * @param position A tárgy pozíciója
	 * @return A GameBuilder példány.
	 */
	public GameBuilder addFakeCodeOfStudies(Position position) {
		return addItem(position, new FakeCodeOfStudies(), "code-of-studies");
	}

	/**
	 * Hamis maszk tárgy hozzáadása.
	 * 
	 * @param position A tárgy pozíciója
	 * @return A GameBuilder példány.
	 */
	public GameBuilder addFakeMask(Position position) {
		return addItem(position, new FakeMask(), "mask");
	}

	/**
	 * Hamis logarléc tárgy hozzáadása.
	 * 
	 * @param position A tárgy pozíciója
	 * @return A GameBuilder példány.
	 */
	public GameBuilder addFakeSlideRule(Position position) {
		return addItem(position, new FakeSlideRule(), "slide-rule");
	}


	public GameBuilder setPanel(GamePanel gamePanel) {
		this.panel = gamePanel;
		return this;
	}

	public GameBuilder setRenderer(Renderer renderer) {
		this.renderer = renderer;
		return this;
	}

	/**
	 * A játékállapot, vezérlők és nézetek megépítése.
	 * 
	 * @return GameController, játékra készen.
	 */
	public GameController build() {
		GameController.initialize(this);
		for (TileController tileController : tileControllers) {
			tileController.initialize();
		}
		return GameController.getInstance();
	}

	private void addTile(Tile tile, TileView view) {
		game.putTile(tile);
		mapView.addTileView(view);
		modelViews.put(tile, view);
	}

	private GameBuilder addPerson(Position position, Person person,
			BiFunction<Entity, PersonView, PersonController> controllerFactory, String spriteName) {
		PersonView view = new PersonView(person, spriteManager.getSprite(spriteName));
		Entity entity = new Entity(position, person);
		PersonController controller = controllerFactory.apply(entity, view);

		modelViews.put(person, view);
		personControllers.add(controller);
		game.addEntity(entity);
		return this;
	}

	private GameBuilder addItem(Position position, Item item, String spriteName) {
		ItemView view = new ItemView(item, spriteManager.getSprite(spriteName));
		modelViews.put(item, view);
		game.addItem(item, position);
		return this;
	}

	public Game getGameState() {
		return game;
	}

	public Map<Object, Drawable> getModelViews() {
		return modelViews;
	}

	public List<PersonController> getPersonControllers() {
		return personControllers;
	}

	public GameView getGameView() {
		return new GameView(mapView, sideBarView);
	}

	public GamePanel getPanel() {
		return panel;
	}

	public Renderer getRenderer() {
		return renderer;
	}
}
