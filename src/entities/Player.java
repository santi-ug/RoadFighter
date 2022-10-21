package entities;

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
    private float playerSpeed = 5.0f;
    
    public Player() {
    }
    
    public Player(String url, boolean machine, int x, int y, int height, int width) {
        super(url, machine, x, y, height, width);
    }
    
    public void update() {
        updatePos();
    }
    
    public void render(Graphics g) {
        // anything in paintcomponents
        // -- gonna be the list that paints all items
    }
    
    private void updatePos() {

        if (left && !right) {
                x -= playerSpeed;
        } else if (right && !left) {
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
