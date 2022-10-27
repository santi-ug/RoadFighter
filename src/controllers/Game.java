package controllers;

import entities.Picture;
import entities.Player;
import gamestates.Gamestate;
import gamestates.Menu;
import gamestates.Playing;
import java.awt.Graphics;

/**
 * Controls the games runnable ability. ( uses threads )
 * @author Santi
 */
public class Game implements Runnable {

    private GameWindow gameWindow;
    private final GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 144;
    private final int UPS_SET = 200;

    private Playing playing;
    private Menu menu;

    public Game() {
            initClasses();

            gamePanel = new GamePanel(this);
            gameWindow = new GameWindow(gamePanel);
            gamePanel.requestFocus();

            startGameLoop();
    }

    /**
     * initializes the states
     */
    private void initClasses() {
        menu = new Menu(this);
        playing = new Playing(this);
    }

    /**
     * creates the thread and runs the game (starts it)
     */
    private void startGameLoop() {
            gameThread = new Thread(this);
            gameThread.start();
    }

    /**
     * contains a switch that defines what will occur depending on the state (menu, playing, quit)
     */
    public void update() {
        switch (Gamestate.state) {
            case MENU -> menu.update();
            case PLAYING -> playing.update();
            case QUIT -> System.exit(0);
            default -> {
            }
        }
    }

    /**
     * contains a switch that defines what will be drawn depending on the state (menu, playing)
     * @param g pencil
     */
    public void render(Graphics g) {
        switch (Gamestate.state) {
            case MENU -> menu.draw(g);
            case PLAYING -> playing.draw(g);
            default -> {
            }
        }
    }

    /**
     * IMPORTANT function that allows the entire program to run due to the 'Runnable' implementation
     */
    @Override
    public void run() {
            double timePerFrame = 1000000000.0 / FPS_SET; double timePerUpdate = 1000000000.0 / UPS_SET;
            long previousTime = System.nanoTime();
            int frames = 0; int updates = 0;
            long lastCheck = System.currentTimeMillis();
            double deltaU = 0; double deltaF = 0;

            infoChecker(timePerFrame, timePerUpdate, previousTime, frames, updates, lastCheck, deltaU, deltaF);
    }

    /**
     * checks necessary information and limits FPS for a higher quality experience
     * @param timePerFrame  how long each frame will last in nanoseconds
     * @param timePerUpdate how long each update will last in nanoseconds
     * @param previousTime  last time (in nanoseconds)
     * @param frames        amount of frames
     * @param updates       amount of updates
     * @param lastCheck     makes sure the checks occur every 1000 milliseconds (1 second)
     * @param deltaU        change in time for updates
     * @param deltaF        change in time for frames
     */
    public void infoChecker(double timePerFrame, double timePerUpdate, long previousTime, int frames, int updates, long lastCheck, double deltaU, double deltaF) {
        while (true) {
            long currentTime = System.nanoTime();
            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;
            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }
            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }
            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    /**
     * resets the directions when the window loses focus (meaning that movement will no longer occur if the window is not focused
     */
    public void windowFocusLost() {
        if (Gamestate.state == Gamestate.PLAYING) {
            playing.getPlayer().resetDirections();
        }
    }

    /**
     * returns menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * returns playing
     */
    public Playing getPlaying() {
        return playing;
    }
    
}