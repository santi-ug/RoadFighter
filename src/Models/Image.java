package Models;

/**
 *
 * @author Santi
 */
public class Image extends StandardFigure {
    private String url;
    private int height;
    private int width;

    public Image() {
    }

    public Image(int direction, int x, int y, String url, int height, int width) {
        super(direction, x, y);
        this.url = url;
        this.height = height;
        this.width = width;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    
    
}
