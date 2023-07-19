import java.awt.*;

public class Cell {
    private int id;
    private Boolean diamond, spider, empty;
    private Color color = Color.black; // default is black

    public Cell(int id, Boolean diamond, Boolean spider, Boolean empty){
        this.id = id;
        this.diamond = diamond;
        this.spider = spider;
        this.empty = empty;
    }

    public int getId() {
        return id;
    }

    public Boolean getDiamond() {
        return diamond;
    }

    public Boolean getEmpty() {
        return empty;
    }

    public Boolean getSpider() {
        return spider;
    }

    public Color getColor() {
        return color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDiamond(Boolean diamond) {
        this.diamond = diamond;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    public void setSpider(Boolean spider) {
        this.spider = spider;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
