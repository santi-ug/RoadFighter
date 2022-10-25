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
    private String url;
    private boolean machine;
    protected int x, y;
    protected int height;
    protected int width;
    protected Rectangle hitbox;

    public Picture() {
    }
    
    public Picture(String url, boolean machine, int x, int y, int height, int width) {
        this.url = url;
        this.machine = machine;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        initHitbox();
    }
    
    public void render(Graphics g) {
        g.drawImage(this.getImage(this), x, y, width, height, null);  
    }
    
    protected void drawHitbox(Graphics g) {
        // See hitbox
        g.setColor(Color.RED);
        g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }
    
    private void initHitbox() {
        this.hitbox = new Rectangle(x, y, width, height);
    }
    
    protected void updateHitbox() {
        this.hitbox.x = x;
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
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the machine
     */
    public boolean isMachine() {
        return machine;
    }

    /**
     * @param machine the machine to set
     */
    public void setMachine(boolean machine) {
        this.machine = machine;
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
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the hitbox
     */
    public Rectangle getHitbox() {
        return hitbox;
    }

    /**
     * @param hitbox the hitbox to set
     */
    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    
    
}
