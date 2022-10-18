package Models;

import java.awt.Rectangle;

/**
 *
 * @author Santi
 */
public class GeometricFigure {
    private int direction;
    private Rectangle hitbox;
    private boolean machine;

    public GeometricFigure() {
    }

    public GeometricFigure(int direction) {
        this.direction = direction;
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
    
    
}
