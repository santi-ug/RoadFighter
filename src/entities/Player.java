package entities;

import controllers.GamePanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

/**
 *
 * @author Santi
 */
public class Player extends Picture{
    
    private boolean left, right;
    private float playerSpeed = 2.0f;
    
    public Player() {
    }
    
    public Player(String url, boolean machine, int x, int y, int height, int width) {
        super(url, machine, x, y, height, width);
    }
    
    public void update() {
        updatePos();
        updateHitbox();
    }
    
    @Override
    public void render(Graphics g) {
        // anything in paintcomponents
        // -- gonna be the list that paints all items
        
        g.drawImage(this.getImage(this), x, y, width, height, null);  
        drawHitbox(g);
    }
    
    private void updatePos() {
        
        if (left && !right && x > 378) {
                x -= playerSpeed;
        } else if (right && !left && x < 776) {
                x += playerSpeed;
        }
        
    }
    
    public void resetDirections() {
        left = false;
        right = false;
    }
    
    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
    
    
}
