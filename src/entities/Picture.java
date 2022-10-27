package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * Father class for player, badcar and background
 * @author Santi
 */
public class Picture {
    String url;
    protected int x, y;
    protected int height;
    protected int width;
    protected Rectangle hitbox;
    
    public Picture(String url, int height, int width) {
        this.url = url;
        this.height = height;
        this.width = width;
        initHitbox();
    }
    
    public Picture(String url, int x, int y, int height, int width) {
        this.url = url;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        initHitbox();
    }

    public Picture(int x) {
        this.x = x;
    }

    /**
     * draws the image given through URL
     * @param g pencil
     */
    public void render(Graphics g) {
        g.drawImage(this.getImage(this), x, y, width, height, null);  
    }

    /**
     * returns a random number between the values given
     * @param min minimum value
     * @param max maximum value
     */
    public int randomIntValue(int min, int max) {
        return (int)(Math.random()*(max-min)+min);
    }

    /**
     * resets value to given through parameters
     * @param x new x value
     * @param y new y value
     */
    public void reset(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
    
    protected void drawHitbox(Graphics g) {
        // See hitbox
        g.setColor(Color.RED);
        g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }

    /**
     * initializes the hitbox
     */
    private void initHitbox() {
        this.hitbox = new Rectangle(x + 25, y, 50, height);
    }

    /**
     * updates the hitbox (offset due to smaller hitbox for more accuracy)
     */
    protected void updateHitbox() {
        this.hitbox.x = x + 25;
        this.hitbox.y = y;
    }

    /**
     * necessary action to draw the image - organization
     * @param p picture to change into image (to draw)
     */
    public Image getImage(Picture p) {
        Toolkit t = Toolkit.getDefaultToolkit();
        return t.getImage(p.getUrl());
    }
    
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the hitbox
     */
    public Rectangle getHitbox() {
        return hitbox;
    }

    
}
