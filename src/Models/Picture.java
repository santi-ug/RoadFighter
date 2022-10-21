package Models;

import java.awt.Rectangle;

/**
 *
 * @author Santi
 */
public class Picture {
    private String url;
    private boolean machine;
    private int x;
    private int y;
    private int height;
    private int width;
    private Rectangle hitbox;

    public Picture() {
    }
    
    public Picture(String url, boolean machine, int x, int y, int height, int width) {
        this.url = url;
        this.machine = machine;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    
    public void updateHitbox() {
        this.getHitbox().setLocation(this.getX(), this.getY());
    }

    public void moveR(int dist) {
        this.setX(this.getX() + dist);
        updateHitbox();
    }
    
    public void moveL(int dist) {
        this.setX(this.getX() - dist);
        updateHitbox();
    }
    
    public void moveUp(int dist) {
        this.setY(this.getY() - dist);
        updateHitbox();
    }
    
    public void moveDown(int dist) {
        this.setY(this.getY() + dist);
        updateHitbox();
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
