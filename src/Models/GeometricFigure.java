package Models;

import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author Santi
 */
public class GeometricFigure {
    private Color borderColor;
    private Color fillColor;
    private int direction;
    private Rectangle hitbox;
    private boolean machine;

    public GeometricFigure() {
    }

    public GeometricFigure(int direction, Color borderColor, Color fillColor) {
        this.direction = direction;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
        this.machine = true;
    }

    /**
     * @return the direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(int direction) {
        this.direction = direction;
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

    /**
     * @return the borderColor
     */
    public Color getBorderColor() {
        return borderColor;
    }

    /**
     * @param borderColor the borderColor to set
     */
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    /**
     * @return the fillColor
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * @param fillColor the fillColor to set
     */
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
    
    
}
