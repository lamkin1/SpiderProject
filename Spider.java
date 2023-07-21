import java.awt.*;

public class Spider {
    private int x;
    private int y;
    private String direction;
    private String color;

    public Spider(int x, int y, String direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void move(){
        switch(this.direction){
            case "up":
                this.y += 1;
                break;
            case "down":
                this.y -= 1;
                break;
            case "left":
                this.x -= 1;
                break;
            case "right":
                this.x += 1;
                break;
        }
    }

    public void setDirection(String d){
        switch(d){
            case "up":
                this.direction = "up";
                break;
            case "down":
                this.direction = "down";
                break;
            case "left":
                this.direction = "left";
                break;
            case "right":
                this.direction = "right";
                break;
        }
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        switch(this.direction){
            case "up":
                g.fillOval(this.x, this.y, 15, 20);
                //still need to draw legs
                g.setColor(Color.WHITE);
                g.fillOval(this.x-2, this.y+10, 2, 2);
                g.fillOval(this.x+2, this.y+10, 2, 2);
                break;
            case "down":
                g.fillOval(this.x, this.y, 15, 20);

                g.setColor(Color.WHITE);
                g.fillOval(this.x-2, this.y-10, 2, 2);
                g.fillOval(this.x+2, this.y-10, 2, 2);
                break;
            case "left":
                g.fillOval(this.x, this.y, 20, 15);

                g.setColor(Color.WHITE);
                g.fillOval(this.x-10, this.y+2, 2, 2);
                g.fillOval(this.x-10, this.y-2, 2, 2);
                break;
            case "right":
                g.fillOval(this.x, this.y, 20, 15);

                g.setColor(Color.WHITE);
                g.fillOval(this.x+10, this.y+2, 2, 2);
                g.fillOval(this.x+10, y-2, 2, 2);
                break;
        }
    }

    public String getCell(){
        //spider sets cell's color
        return this.color;
    }
}