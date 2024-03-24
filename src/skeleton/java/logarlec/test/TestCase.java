package logarlec.test;

/**
 * Absztrakt osztály, amely a teszteseteket reprezentálja
 */
public abstract class TestCase {
    /**
     * A teszteset neve
     */
    public String name;

    /**
     * Konstruktor, amely beállítja a teszteset nevét
     * @param name a teszteset neve
     */
    public TestCase(String name) {
        this.name = name;
    }

    /**
     * Absztrakt metódus a teszteset inicializálására
     */
    public abstract void init();

    /**
     * Absztrakt metódus a teszteset futtatására
     */
    public abstract void run();

}
