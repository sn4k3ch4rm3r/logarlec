package logarlec.controller;

import logarlec.model.util.Direction;

public class AiController extends PersonController{

    public void turn(){
        Direction direction = Direction.values()[(int)(Math.random() * Direction.values().length)];
        move(direction);
    }
}
