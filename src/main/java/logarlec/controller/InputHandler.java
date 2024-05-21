package logarlec.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * ez kezeli a billentyűzet bemenetét
 */
public class InputHandler implements KeyListener {

    private static InputHandler instance;
    private PlayerController currentPlayer = null;

    private InputHandler(){}

    public static void initialize() {
        instance = new InputHandler();
    }

    public static InputHandler getInstance() {
        if (instance == null) {
            throw new IllegalStateException("InputHandler is not yet initialized.");
        }
        return instance;
    }

    /**
     * Szólunk az aktuális játékosról
     * @param currentPlayer - az aktuális játékos
     */
    public void setCurrentPlayer(PlayerController currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        currentPlayer.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
