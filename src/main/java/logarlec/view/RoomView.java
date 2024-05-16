package logarlec.view;

import logarlec.controller.util.TileType;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RoomView implements Drawable {
    private List<List<TileView>> tileViews = new ArrayList<>();

    /**
     * A szoba nézet konstruktora. Létrehozza a szoba csempéinek nézetét.
     * @param tileTypes A szoba csempéi.
     */
    public RoomView(List<List<TileType>> tileTypes) {
        for (int i = 0; i < tileTypes.size(); i++) {
            List<TileView> row = new ArrayList<>();
            for (int j = 0; j < tileTypes.get(i).size(); j++) {
                switch (tileTypes.get(i).get(j)) {
                    case WALL:
                        if (i > 0 && tileTypes.get(i - 1).get(j) == TileType.FLOOR)
                            row.add(new WallTileView(4));
                        else if (i < tileTypes.size() - 1 && tileTypes.get(i + 1).get(j) == TileType.FLOOR)
                            row.add(new WallTileView(0));
                        else if (j > 0 && tileTypes.get(i).get(j - 1) == TileType.FLOOR)
                            row.add(new WallTileView(2));
                        else if (j < tileTypes.get(i).size() - 1 && tileTypes.get(i).get(j + 1) == TileType.FLOOR)
                            row.add(new WallTileView(6));
                        else if (i > 0 && j > 0 && tileTypes.get(i - 1).get(j - 1) == TileType.FLOOR)
                            row.add(new WallTileView(3));
                        else if (i > 0 && j < tileTypes.get(i).size() - 1 && tileTypes.get(i - 1).get(j + 1) == TileType.FLOOR)
                            row.add(new WallTileView(5));
                        else if (i < tileTypes.size() - 1 && j < tileTypes.get(i).size() - 1 && tileTypes.get(i + 1).get(j + 1) == TileType.FLOOR)
                            row.add(new WallTileView(7));
                        else if (i < tileTypes.size() - 1 && j > 0 && tileTypes.get(i + 1).get(j - 1) == TileType.FLOOR)
                            row.add(new WallTileView(1));
                        else
                            row.add(new WallTileView(0));
                        break;
                    case FLOOR:
                        row.add(new FloorTileView());
                        break;
                    default:
                        row.add(null);
                        break;
                }
            }
            tileViews.add(row);
        }
    }

    /**
     * A szoba csempéinek kirajzolása.
     * @param g2d A rajzolásra használt grafikus objektum.
     */
    @Override
    public void draw(Graphics2D g2d) {
        Dimension bounds = g2d.getClipBounds().getSize();
        int x = bounds.height / tileViews.size();
        int y = bounds.width / tileViews.getFirst().size();
        int i = 0;
        int j = 0;
        for (List<TileView> row : tileViews) {
            for (TileView tileView : row) {
                Graphics2D g = (Graphics2D) g2d.create(x * j, y * i, x, y);
                if (tileView != null)
                    tileView.draw(g);
                j++;
            }
            j = 0;
            i++;
        }
    }
}
