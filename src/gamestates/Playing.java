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

import static utils.HelpMethods.CanMoveHere;

/**
 *
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
    
    public void windowFocusLost() {
        player.resetDirections();
    }    
            
    public Player getPlayer() {
        return player;
    }
    
    public Background getBackground() {
        return bg;
    }
    
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
                deadOverlay.update();
            }
            km++;
        } else {
            pauseOverlay.update();
        }
    }

    private void drawCars() {
        for (int i = 0; i < badCars.size(); i++) {
            badCars.get(i).update();
        }
    }

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

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                this.player.setRight(false);
                break;
            case KeyEvent.VK_LEFT:
                this.player.setLeft(false);
                break;
        }
    }
    
    public void unpauseGame() {
        paused = false;
    }
    
    public void resetGame() {
        bg.reset(-0, 1280);
        player.reset(580, 600);
        for (int i = 0; i < badCars.size(); i++) {
            badCars.get(i).setX(379 + (badCars.get(i).randomIntValue(0, 5) * 50));
            badCars.get(i).setY(-160 + (badCars.get(i).randomIntValue(0, 2) * 100));
        }
        unpauseGame();
        dead = false;
        km = 0;
    }
    
}
