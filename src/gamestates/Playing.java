package gamestates;

import controllers.Game;
import entities.Picture;
import entities.Player;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author Santi
 */
public class Playing extends State implements Statemethods {
    private Player player;
    private Picture bg;
    
    public Playing(Game game) {
        super(game);
        initClasses();
    }
    
    private void initClasses() {
        bg = new Picture("src/images/background5.png", false, 0, 0, 1280, 1280);
        player = new Player("src/images/playerCar.png", false, 580, 600, 100, 100);
                   //Player(String url, boolean machine, int x, int y, int height, int width)
    }
    
    public void windowFocusLost() {
        player.resetDirections();
    } 
            
            
    public Player getPlayer() {
        return player;
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void draw(Graphics g) {
        bg.render(g);       // draw level
        player.render(g);   // draws player
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                this.player.setRight(true);
                break;
            case KeyEvent.VK_LEFT:
                this.player.setLeft(true);
                break;
            case KeyEvent.VK_ESCAPE:
                Gamestate.state = Gamestate.MENU;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                this.player.setRight(false);
                break;
            case KeyEvent.VK_LEFT:
                this.player.setLeft(false);
                break;
            
        }
    }
    
}
