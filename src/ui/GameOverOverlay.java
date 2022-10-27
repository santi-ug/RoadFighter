package ui;

import entities.Picture;
import gamestates.Playing;

import java.awt.*;

/**
 * Class that controls the Game Over screen
 */
public class GameOverOverlay {

    private Picture diedBg;
    private final Playing playing;

    public GameOverOverlay(Playing playing) {
        this.playing = playing;
        loadDiedBackground();
    }

    /**
     * creates the game over background
     */
    private void loadDiedBackground() {
        diedBg = new Picture("src/images/paused.png", 0, 0, 1280, 1280);
                    //Picture(String url, boolean machine, int x, int y, int height, int width)
    }

    /**
     * draws the game over screen
     * @param g pencil to draw
     */
    public void draw(Graphics g) {
        diedBg.render(g);
        Font defFont = g.getFont();
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); // PLAY AROUND
        g.drawString("SCORE: " + Integer.toString(playing.km * 10), 525, 360);
        g.setFont(defFont);
        g.setColor(Color.RED);
        g.drawString("YOU DIED", 560, 240);
        g.setColor(Color.WHITE);
        g.drawString("Press R to try again", 540, 280);
        g.drawString("Press K to quit game", 535, 300);
    }

}
