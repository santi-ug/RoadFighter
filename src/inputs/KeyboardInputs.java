package inputs;

import controllers.GamePanel;
import gamestates.Gamestate;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * actions for specific key inputs related to screen switches
 * @author Santi
 */
public class KeyboardInputs implements KeyListener {
    
    private final GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    /**
     * not used but obligational to have
     * @param e Key event
     */
    @Override
    public void keyTyped(KeyEvent e) {}

    /**
     * opens menu / starts playing
     * @param e Key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (Gamestate.state) {
            case MENU:
                gamePanel.getGame().getMenu().keyPressed(e);
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().keyPressed(e);
            default:
                break;
        }
    }

    /**
     * opens menu / starts playing
     * @param e Key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        switch (Gamestate.state) {
            case MENU:
                gamePanel.getGame().getMenu().keyReleased(e);
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().keyReleased(e);
            default:
                break;
        }
    }
    
}
