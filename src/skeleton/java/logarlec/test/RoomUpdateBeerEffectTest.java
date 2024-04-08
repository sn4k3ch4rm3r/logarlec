package logarlec.test;

import logarlec.effects.BeerEffect;
import logarlec.effects.CleanEffect;
import logarlec.effects.GasEffect;
import logarlec.gameobjects.Room;
import logarlec.gameobjects.Student;
import logarlec.gameobjects.Teacher;
import logarlec.items.Camembert;
import logarlec.skeleton.Skeleton;

public class RoomUpdateBeerEffectTest extends TestCase {
    Room room;
    Student student;
    BeerEffect beerEffect;
    Camembert camembert;

    /**
     * Konstruktor, amely beállítja a teszteset nevét
     */
    public RoomUpdateBeerEffectTest() {
        super("Room: update beer effect");
    }

    @Override
    public void init() {
        room = Skeleton.createObject("room", Room.class);
        student = Skeleton.createObject("student", Student.class);
        room.enter(student);
        beerEffect = Skeleton.createObject("beerEffect", BeerEffect.class);
        student.addEffect(beerEffect);
        camembert = Skeleton.createObject("camembert", Camembert.class);
        student.addItem(camembert);
    }

    @Override
    public void run() {
        room.update(1);
    }
}