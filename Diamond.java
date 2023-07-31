import java.awt.*;
public class Diamond{
    private Color color;
    private Boolean hasDiamond;
    int x, y;
    public Diamond(Color color, int x, int y){
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g){
        //g.setColor(color);
        //g.fillRect(x,y,10,10);

        int size = 5;
        int centerX = x + 17;
        int centerY = y + 17;

        int[] xPoints = {centerX, centerX + size, centerX, centerX - size};
        int[] yPoints = {centerY - size, centerY, centerY + size, centerY};

        // Set the color you want to use for drawing the diamond
        g.setColor(color);

        // Draw the diamond using two filled triangles
        g.fillPolygon(xPoints, yPoints, 4);

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHasDiamond(Boolean hasDiamond) {
        this.hasDiamond = hasDiamond;
    }

    public Boolean getHasDiamond(){
        return this.hasDiamond;
    }

}

