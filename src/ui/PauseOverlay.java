package ui;

import entities.Picture;
import entities.Player;
import gamestates.Gamestate;
import gamestates.Playing;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 * Class that controls the Paused Screen
 * @author Santi
 */
public class PauseOverlay {
    
    private Picture pausedBg;
    private final Playing playing;
    
    public PauseOverlay(Playing playing) {
        this.playing = playing;
        loadPausedBackground();
    }

    /**
     * creates the paused background
     */
    private void loadPausedBackground() {
        pausedBg = new Picture("src/images/paused.png", 0, 0, 1280, 1280);
                   //Player(String url, boolean machine, int x, int y, int height, int width)
    }

    /**
     * draws the game paused screen
     * @param g pencil to draw
     */
    public void draw(Graphics g) {
        pausedBg.render(g);
        g.setColor(Color.RED);
        g.drawString("PAUSED", 560, 240);
        g.setColor(Color.WHITE);
        g.drawString("Press SPACE or ESCAPE to resume playing", 520, 260);
        g.drawString("Press R to restart the game", 520, 280);
        g.drawString("Press K to quit game", 520, 300);
    }

}
