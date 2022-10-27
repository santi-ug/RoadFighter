package entities;

import controllers.GamePanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

/**
 * has any information about the player and is the class that gives it specific characteristics
 * @author Santi
 */
public class Player extends Picture{
    
    private boolean left, right;

    public Player(String url, int x, int y, int height, int width) {
        super(url,x, y, height, width);
    }

    /**
     * updates the position and the hitbox
     */
    public void update() {
        updatePos();
        updateHitbox();
    }

    /**
     * draws the player and CAN draw the hitbox to show where it is (for teacher)
     * @param g pencil
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(this.getImage(this), x, y, width, height, null);  
        //drawHitbox(g);
    }

    /**
     * updates the position for when the left or right arrow key is pressed the player moves
     */
    private void updatePos() {
        float playerSpeed = 2.0f;
        if (left && !right && x > 378) {
                x -= playerSpeed;
        } else if (right && !left && x < 776) {
                x += playerSpeed;
        }
    }

    /**
     * resets the directions for when both are held or one isn't being held (smoother movement)
     */
    public void resetDirections() {
        left = false;
        right = false;
    }

    /**
     * setter for left
     * @param left parameter to set for left
     */
    public void setLeft(boolean left) {
        this.left = left;
    }

    /**
     * setter for right
     * @param right parameter to set for right
     */
    public void setRight(boolean right) {
        this.right = right;
    }
}