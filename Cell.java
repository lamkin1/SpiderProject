import java.awt.*;

public class Cell {
    private int x, y;

    private Color color = Color.black;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;

    }

    // 25 by 25 for block
    public void draw(Graphics g){
        // maybe better to draw in world and get info from data source
        g.setColor(this.color);
        g.drawRect(x, y, 25, 25);

    }

    public int getX() {return x;}

    public int getY() {return y;}



    public Color getColor() {
        return color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void setColor(Color color) {
        this.color = color;
    }
}
