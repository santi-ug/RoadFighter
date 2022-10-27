package entities;

import java.awt.Graphics;

/**
 *
 * @author Santi
 */
public class Background extends Picture{
    
    private final float bgSpeed = 5.0f;
    
    public Background(String url, int x, int y, int height, int width) {
        super(url, x, y, height, width);
    }
    
    public void update() {
        updatePos();
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(this.getImage(this), x, y, width, height, null);
    }
    
    private void updatePos() {
        
        if (y < 0) {
                y += bgSpeed;
        } else {
                y = -560;
        }
        
    }
}
