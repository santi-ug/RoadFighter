package entities;

import java.awt.Graphics;

/**
 * class that controls all the badcar characteristcs
 * @author Santi
 */
public class BadCar extends Picture{

    public BadCar(String url, int height, int width) {
        super(url, height, width);
    }

    public BadCar(int x) {
        super(x);
    }

    /**
     * updates the bad cars position and hitbox
     */
    public void update() {
        updatePos(700);
        updateHitbox();
    }

    /**
     * draws the enemy car (and hitbox if need - (for teacher))
     * @param g pencil
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(this.getImage(this), x, y, width, height, null);  
        //drawHitbox(g);
    }

    /**
     * generalizes a function to randomize the x and y positions
     * @param yVal height minimum until it resets
     */
    public void updatePos(int yVal) {
        if (y < yVal) {
            float carSpeed = 2.0f;
            y += carSpeed;
        } else {
                x = 379 + (this.randomIntValue(0, 5) * 65);
                y = -160 + (this.randomIntValue(0, 2) * 70);
        }
    }
}