import java.awt.*;

public class Cell {
    private int x, y;
    private Color color = Color.black;
    private Boolean hasDiamond = false;
    private Color diamondColor;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillRect(x, y, 35, 35);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, 35, 35);
    }

    public int getX() {return x;}

    public int getY() {return y;}

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setHasDiamond(Boolean hasDiamond) {
        this.hasDiamond = hasDiamond;
    }

    public Boolean getHasDiamond() {
        return hasDiamond;
    }

    public Color getDiamondColor() {
        return diamondColor;
    }

    public void setDiamondColor(Color diamondColor) {
        this.diamondColor = diamondColor;
    }
}
