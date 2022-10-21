package Inputs;

import Controllers.GamePanel;
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
                
            case KeyEvent.VK_LEFT:
                
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
