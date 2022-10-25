package gamestates;

import controllers.Game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author Santi
 */
public class Menu extends State implements Statemethods {
    
    public Menu(Game game) {
        super(game);
    }
    
    @Override
    public void update() {
        
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1280, 720);
        g.setColor(Color.RED);
        g.drawString("Press ENTER to start playing", 520, 240);
        g.setColor(Color.WHITE);
        g.drawString("Press K to quit game", 520, 260);
    }
    // g.drawString("Press SPACE to resume playing", 520, 240);
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Gamestate.state = Gamestate.PLAYING;
        }
        if (e.getKeyCode() == KeyEvent.VK_K) {
            Gamestate.state = Gamestate.QUIT;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
