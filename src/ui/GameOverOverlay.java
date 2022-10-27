package ui;

import entities.Picture;
import gamestates.Playing;

import java.awt.*;

public class GameOverOverlay {

    private Picture diedBg;
    private Playing playing;

    public GameOverOverlay(Playing playing) {
        this.playing = playing;
        loadDiedBackground();
    }

    private void loadDiedBackground() {
        diedBg = new Picture("src/images/paused.png", 0, 0, 1280, 1280);
                    //Picture(String url, boolean machine, int x, int y, int height, int width)
    }

    public void update() {

    }
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
