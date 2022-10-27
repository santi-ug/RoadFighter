package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 * Necessary methods to have for anything that includes this interface (Playing, Menu states)
 * @author Santi
 */
public interface Statemethods {
    /**
     * anything in these types of functions are values that have to consistently be updated
     */
    void update();
    /**
     * anything in these types of functions eventually get drawn and shown on screen
     * @param g pencil to draw
     */
    void draw(Graphics g);
    /**
     * actions when a specific key is pressed
     * @param e Key event
     */
    void keyPressed(KeyEvent e);
    /**
     * actions when a specific key is released
     * @param e Key event
     */
    void keyReleased(KeyEvent e);
}
