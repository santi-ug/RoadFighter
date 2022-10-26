package entities;

import java.awt.Graphics;

/**
 *
 * @author Santi
 */
public class BadCar extends Picture{
    
    private float carSpeed = 2.0f;
    
    public BadCar(String url, boolean machine, int height, int width) {
        super(url, machine, height, width);
    }
    
    public void update() {
        updatePos();
        updateHitbox();
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(this.getImage(this), x, y, width, height, null);  
        drawHitbox(g);
    }
    
    private void updatePos() {
        if (y < 700) {
                y += carSpeed;
        } else {
                x = 379 + (this.randomIntValue(0, 5) * 50);
                y = -160 + (this.randomIntValue(0, 2) * 50);
        }
        
    }
}