import java.awt.*;
public class Diamond{
    private Color color;
    private Boolean hasDiamond = false;
    int x, y;
    public Diamond(Color color, int x, int y){
        this.color = color;
        this.x = x+15;
        this.y = y+15;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x,y,5,5);
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setColor(Color color) {
        this.color = color;
    }


}

