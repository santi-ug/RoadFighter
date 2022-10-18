package Models;

import java.awt.Color;

/**
 *
 * @author Santi
 */
public class Polygon extends GeometricFigure {
    private int x[];
    private int y[];

    public Polygon() {
    }

    public Polygon(int direction, Color borderColor, Color fillColor, int[] x, int[] y) {
        super(direction, borderColor, fillColor);
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public int[] getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int[] x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int[] getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int[] y) {
        this.y = y;
    }
    
    
    
}
