package gamestates;

import controllers.Game;

/**
 * Parent for Playing and Menu states (mainly for organization)
 * @author Santi
 */
public class State {
    
    protected Game game;
    
    public State(Game game) {
        this.game = game;
    }

    /**
     * returns game
     */
    public Game getGame() { return game; }

}
