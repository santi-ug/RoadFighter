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
        diedBg = new Picture("src/images/paused.png", false, 0, 0, 1280, 1280);
                    //Picture(String url, boolean machine, int x, int y, int height, int width)
    }

    public void update() {

    }
    public void draw(Graphics g) {
        diedBg.render(g);
        g.setColor(Color.RED);
        g.drawString("YOU DIED", 560, 240);
        g.setColor(Color.WHITE);
        g.drawString("Press R to try again", 520, 280);
        g.drawString("Press K to quit game", 520, 300);
    }

}
