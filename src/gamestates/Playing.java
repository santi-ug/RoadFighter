package gamestates;

import controllers.Game;
import entities.Background;
import entities.BadCar;
import entities.Picture;
import entities.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import ui.GameOverOverlay;
import ui.PauseOverlay;


/**
 * Everything that has to occur when the game is running (on screen) happens here
 * @author Santi
 */
public class Playing extends State implements Statemethods {
    private Player player;
    private Background bg;
    private LinkedList<BadCar> badCars;
    
    private PauseOverlay pauseOverlay;
    private GameOverOverlay deadOverlay;
    private boolean paused = false;
    private boolean dead = false;
    public int km = 0;

    public Playing(Game game) {
        super(game);
        initClasses();
    }

    /**
     * initializes all the necessary classes including the 3 enemy cars, the player's car, the background and both the pause and game over overlay.
     */
    private void initClasses() {
        bg = new Background("src/images/background.png", 0, -570, 1280, 1280);
        player = new Player("src/images/playerCar.png", 580, 600, 100, 100);
                   //Player(String url, boolean machine, int x, int y, int height, int width)
        badCars = new LinkedList<>();
        BadCar bc1 = new BadCar("src/images/badCar.png", 100, 100);
        BadCar bc2 = new BadCar("src/images/badCar.png", 100, 100);
        BadCar bc3 = new BadCar("src/images/badCar.png", 100, 100);
        bc1.setX(bc1.randomIntValue(379, 775));
        bc1.setY(bc1.randomIntValue(-570, 0));
        
        bc2.setX(bc2.randomIntValue(379, 775));
        bc2.setY(bc2.randomIntValue(-570, 0));
        
        bc3.setX(bc2.randomIntValue(379, 775));
        bc3.setY(bc3.randomIntValue(-570, 0));
        
        badCars.add(bc1);
        badCars.add(bc2);
        badCars.add(bc3);
        pauseOverlay = new PauseOverlay(this);
        deadOverlay = new GameOverOverlay(this);
    }

    /**
     * returns player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * everytime this runs it updates the background, the cars, the player and the collisions as well as the KM score. (depending if the 'if's are met)
     */
    @Override
    public void update() {
        if (!paused && !dead) {
            bg.update();
            drawCars();
            if (CanMoveHere(player, badCars)) {
                player.update();
            } else {
                System.out.println("collided"); // MAKE DEATH SCREEN SHOW UP HERE
                dead = true;
            }
            km++;
        }
    }

    /**
     * checks for a collision between the player and any enemy car
     * @param p player
     * @param badCars linkedlist of the enemy cars
     */
    public static boolean CanMoveHere(Player p, LinkedList<BadCar> badCars) {
        boolean canMoveHere = true;
        int i = 0;
        while (canMoveHere && i < badCars.size()) {
            if (p.getHitbox().intersects(badCars.get(i).getHitbox())) canMoveHere = false;
            i++;
        }
        return canMoveHere;
    }

    /**
     * draws the cars
     */
    private void drawCars() {
        for (BadCar badCar : badCars) { badCar.update(); }
    }

    /**
     * draws the background, the enemy cars, and the player, as well as the score.
     *      if the screen is paused, it draws the pause overlay
     *      if the player died it draws the game over overlay
     * @param g pencil
     */
    @Override
    public void draw(Graphics g) {
        bg.render(g);       // draws bg
        for (BadCar badCar : badCars) badCar.render(g);
        player.render(g);   // draws player

        g.setColor(Color.WHITE);
        Font defFont = g.getFont();
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); // PLAY AROUND
        g.drawString("Total KM driven: " + Integer.toString(km * 10), 1000, 100);
        g.setFont(defFont);
        if (paused) pauseOverlay.draw(g);
        if (dead) deadOverlay.draw(g);
    }

    /**
     * actions when a specific key is pressed
     * @param e Key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                this.player.setRight(true);
                break;
            case KeyEvent.VK_LEFT:
                this.player.setLeft(true);
                break;
            case KeyEvent.VK_ESCAPE: // PAUSE / UNPAUSE 1
                if (!dead) {
                    paused = !paused;
                }
                break;
            case KeyEvent.VK_SPACE: // PAUSE / UNPAUSE 1
                paused = false;
                break;
            case KeyEvent.VK_R: // RESTART GAME
                resetGame();
                break;
            case KeyEvent.VK_K:
                Gamestate.state = Gamestate.QUIT;
                break;
        }
    }

    /**
     * actions when a specific key is released
     * @param e Key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT -> this.player.setRight(false);
            case KeyEvent.VK_LEFT -> this.player.setLeft(false);
        }
    }

    /**
     * unpauses the game
     */
    public void unpauseGame() {
        paused = false;
    }

    /**
     * resets the game to the inicial values for a clean restart
     */
    public void resetGame() {
        bg.reset(-0, 1280);
        player.reset(580, 600);
        for (BadCar badCar : badCars) {
            badCar.setX(379 + (badCar.randomIntValue(0, 5) * 50));
            badCar.setY(-160 + (badCar.randomIntValue(0, 2) * 100));
        }
        unpauseGame();
        dead = false;
        km = 0;
    }
}
