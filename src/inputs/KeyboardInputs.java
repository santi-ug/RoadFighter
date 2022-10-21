package inputs;

import controllers.GamePanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Santi
 */
public class KeyboardInputs implements KeyListener {
    
    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                System.out.println("RIGHT");
                this.gamePanel.getGame().getPlayer().setRight(true);
                break;
            case KeyEvent.VK_LEFT:
                this.gamePanel.getGame().getPlayer().setLeft(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                this.gamePanel.getGame().getPlayer().setRight(false);
                break;
            case KeyEvent.VK_LEFT:
                this.gamePanel.getGame().getPlayer().setLeft(false);
                break;
            
        }
    }
    
}
