package Models;

import java.awt.Color;

/**
 *
 * @author Santi
 */
public abstract class StandardFigure extends GeometricFigure {
    private int x;
    private int y;

    public StandardFigure() {
    }

    public StandardFigure(int direction, int x, int y) {
        super(direction, null, null);
        this.x = x;
        this.y = y;
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
    
}
