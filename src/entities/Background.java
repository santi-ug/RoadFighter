package entities;

import java.awt.Graphics;

/**
 * controls anything that has to do with the background
 * @author Santi
 */
public class Background extends Picture{

    public Background(String url, int x, int y, int height, int width) {
        super(url, x, y, height, width);
    }

    /**
     * calls all updates and runs them
     */
    public void update() {
        updatePos();
    }

    /**
     * draws the background
     * @param g pencil
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(this.getImage(this), x, y, width, height, null);
    }

    /**
     * updates the position constantly because the background is moving to give the driving effect
     */
    private void updatePos() {
        
        if (y < 0) {
            float bgSpeed = 5.0f;
            y += bgSpeed;
        } else {
                y = -560;
        }
        
    }
}