import java.awt.*;

public class Cell {
    private int id;
    Spider spider;
    private Boolean hasDiamond, hasSpider, isEmpty;
    private Color color = Color.black; // default is black

    public Cell(int id, Boolean hasDiamond, Boolean hasSpider, Boolean isEmpty){
        this.id = id;
        this.hasDiamond = hasDiamond;
        this.hasSpider = hasSpider;
        this.isEmpty = isEmpty;
        spider = new Spider(x, y, "up");
    }

    // 25 by 25 for block
    public void draw(Graphics g){
        g.setColor(this.color);
        g.drawRect(x, y, 25, 25);

        if (hasSpider){

            spider.draw(g);
        }

        if (hasDiamond){

        }
    }


    public int getId() {
        return id;
    }

    public Boolean gethasDiamond() {
        return hasDiamond;
    }

    public Boolean getisEmpty() {
        return isEmpty;
    }

    public Boolean getHasSpider() {
        return hasSpider;
    }

    public Color getColor() {
        return color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void sethasDiamond(Boolean hasDiamond) {
        this.hasDiamond = hasDiamond;
    }

    public void setisEmpty(Boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public void setSpider(Boolean spider) {
        this.spider = spider;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
