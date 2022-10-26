package ui;

import entities.Picture;
import entities.Player;
import gamestates.Gamestate;
import gamestates.Playing;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author Santi
 */
public class PauseOverlay {
    
    private Picture pausedBg;
    private Playing playing;
    
    public PauseOverlay(Playing playing) {
        this.playing = playing;
        loadPausedBackground();
    }
    
    private void loadPausedBackground() {
        pausedBg = new Picture("src/images/paused.png", false, 0, 0, 1280, 1280);
                   //Player(String url, boolean machine, int x, int y, int height, int width)
    }
    
    public void update() {
        
    }
    
    public void draw(Graphics g) {
        pausedBg.render(g);
        g.setColor(Color.RED);
        g.drawString("PAUSED", 560, 240);
        g.setColor(Color.WHITE);
        g.drawString("Press SPACE or ESCAPE to resume playing", 520, 260);
        g.drawString("Press R to restart the game", 520, 280);
        g.drawString("Press K to quit game", 520, 300);
    }
    
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                playing.unpauseGame();
                break;
            case KeyEvent.VK_SPACE:
                playing.unpauseGame();
                break;
            case KeyEvent.VK_M:
                Gamestate.state = Gamestate.MENU;
                break;
            case KeyEvent.VK_R:
                
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        
    }
    
}
