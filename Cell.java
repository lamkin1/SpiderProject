import java.awt.*;

public class Cell {
    private int x, y;
    Spider spider;
    Diamond d;
    private Boolean hasDiamond, hasSpider, isEmpty;
    private Color color = Color.black;

    public Cell(int x, int y, Boolean hasDiamond, Boolean hasSpider, Boolean isEmpty, Color diamondColor){
        this.x = x;
        this.y = y;
        this.hasDiamond = hasDiamond;
        this.hasSpider = hasSpider;
        this.isEmpty = isEmpty;
        spider = new Spider(x, y, "up");
        d = new Diamond(diamondColor, x, y);
    }

    // 25 by 25 for block
    public void draw(Graphics g){
        g.setColor(this.color);
        g.drawRect(x, y, 25, 25);

        if (hasSpider){
            spider.draw(g);
        }

        if (hasDiamond){
            d.draw(g);
        }
    }

    public int getX() {return x;}

    public int getY() {return y;}



    public Boolean getHasDiamond() {
        return hasDiamond;
    }

    public Boolean getIsEmpty() {
        return isEmpty;
    }

    public Boolean getHasSpider() {
        return hasSpider;
    }

    public Color getColor() {
        return color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void setHasDiamond(Boolean hasDiamond) {
        this.hasDiamond = hasDiamond;
    }

    public void setHsEmpty(Boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public void setSpider(Boolean spider) {
        this.hasSpider = spider;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
