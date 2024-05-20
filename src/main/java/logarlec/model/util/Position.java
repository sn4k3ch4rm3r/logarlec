package logarlec.model.util;

public class Position {
    public int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position add(Direction direction, int amount) {
        return new Position(x + direction.getX() * amount, y + direction.getY() * amount);
    }

    @Override
    public boolean equals(Object other) {
        Position otherPos = (Position) other;
        return this.x == otherPos.x && this.y == otherPos.y;
    }
}
