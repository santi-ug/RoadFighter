package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 *
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

    public void render(Graphics g) {
        g.drawImage(this.getImage(this), x, y, width, height, null);  
    }
    
    public int randomIntValue(int min, int max) {
        return (int)(Math.random()*(max-min)+min);
    }
    
    public void reset(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
    
    protected void drawHitbox(Graphics g) {
        // See hitbox
        g.setColor(Color.RED);
        g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }
    
    private void initHitbox() {
        this.hitbox = new Rectangle(x + 25, y, 50, height);
    }
    
    protected void updateHitbox() {
        this.hitbox.x = x + 25;
        this.hitbox.y = y;
    }
    
    public Image getImage(Picture p) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image img = t.getImage(p.getUrl());
        return img;
    }
    
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
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
