package controllers;

import entities.Picture;
import entities.Player;
import gamestates.Gamestate;
import gamestates.Menu;
import gamestates.Playing;
import java.awt.Graphics;

/**
 *
 * @author Santi
 */
public class Game implements Runnable {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
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

    private void initClasses() {
        menu = new Menu(this);
        playing = new Playing(this);
    }

    private void startGameLoop() {
            gameThread = new Thread(this);
            gameThread.start();
    }

    public void update() {
        switch (Gamestate.state) {
            case MENU -> menu.update();
            case PLAYING -> playing.update();
            case QUIT -> System.exit(0);
            default -> {
            }
        }
    }

    public void render(Graphics g) {
        switch (Gamestate.state) {
            case MENU -> menu.draw(g);
            case PLAYING -> playing.draw(g);
            default -> {
            }
        }
    }

    @Override
    public void run() {

            double timePerFrame = 1000000000.0 / FPS_SET;
            double timePerUpdate = 1000000000.0 / UPS_SET;

            long previousTime = System.nanoTime();

            int frames = 0;
            int updates = 0;
            long lastCheck = System.currentTimeMillis();

            double deltaU = 0;
            double deltaF = 0;

            infoChecker(timePerFrame, timePerUpdate, previousTime, frames, updates, lastCheck, deltaU, deltaF);

    }

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

    public void windowFocusLost() {
        if (Gamestate.state == Gamestate.PLAYING) {
            playing.getPlayer().resetDirections();
        }
    } 
    
    public Menu getMenu() {
        return menu;
    }
    
    public Playing getPlaying() {
        return playing;
    }
    
}