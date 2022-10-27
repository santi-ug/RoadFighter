package gamestates;

/**
 * types of states the game can be found in, therefore making it easier for functions to act when one is active through switches
 * @author Santi
 */
public enum Gamestate {
    
    PLAYING, MENU, QUIT;
    
    public static Gamestate state = MENU;
    
}
