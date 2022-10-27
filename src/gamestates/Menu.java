package gamestates;

import controllers.Game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 * in charge of controlling the initial menu and anything that has to occur / be drawn when it is active
 * @author Santi
 */
public class Menu extends State implements Statemethods {
    
    public Menu(Game game) {
        super(game);
    }

    /**
     * this function is here due to statemethods having it (makes it obligational)
     */
    @Override
    public void update() {}

    /**
     * draws the menu screen
     * @param g pencil
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1280, 720);
        g.setColor(Color.RED);
        g.drawString("Press ENTER to start playing", 520, 240);
        g.setColor(Color.WHITE);
        g.drawString("Press K to quit game", 520, 260);
    }

    /**
     * actions when a specific key is pressed
     * @param e Key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Gamestate.state = Gamestate.PLAYING;
        }
        if (e.getKeyCode() == KeyEvent.VK_K) {
            Gamestate.state = Gamestate.QUIT;
        }
    }

    /**
     * this function is here due to statemethods having it (makes it obligational)
     * @param e Key event
     */
    @Override
    public void keyReleased(KeyEvent e) {}
}
