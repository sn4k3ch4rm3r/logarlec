package logarlec.controller.util;

import logarlec.model.util.Position;

public class ExtendedDoor {
    int toID;
    int fromID;
    Position to;
    Position from;
    Boolean oneway;

    public ExtendedDoor(int to, int from, int x0, int y0, int x1, int y1, Boolean oneway){
        this.toID = to;
        this.fromID = from;
        this.to = new Position(x0, y0);
        this.from = new Position(x1, y1);
        this.oneway = oneway;
    }
}
