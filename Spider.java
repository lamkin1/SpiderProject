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
                this.y += 10;
                break;
            case "down":
                this.y -= 10;
                break;
            case "left":
                this.x -= 10;
                break;
            case "right":
                this.x += 10;
                break;
        }
        DataSource.getInstance().setSpiderLocation(this.x, this.y);
    }

    public void turn(){
        switch(this.direction){
            case "up":
                this.direction = "right";
                break;
            case "down":
                this.direction = "left";
                break;
            case "left":
                this.direction = "up";
                break;
            case "right":
                this.direction = "down";
                break;
        }
    }

    public void draw(Graphics g){
        g.setColor(Color.GRAY);
        switch(this.direction){
            case "up":
                g.fillOval(this.x, this.y, 15, 20);
                for (int i = 0; i < 4; i++) {
                    g.drawLine(this.x+2+i*3, this.y+10, this.x+2+i*3, this.y+30);
                    g.drawLine(this.x+15-2-i*3, this.y+10, this.x+15-2-i*3, this.y+30);
                }
                g.setColor(Color.WHITE);
                g.fillOval(this.x+3, this.y+7, 2, 2);
                g.fillOval(this.x+9, this.y+7, 2, 2);
                break;
            case "down":
                g.fillOval(this.x, this.y, 15, 20);
                for (int i = 0; i < 4; i++) {
                    g.drawLine(this.x+2+i*3, this.y+10, this.x+2+i*3, this.y-10);
                    g.drawLine(this.x+15-2-i*3, this.y+10, this.x+15-2-i*3, this.y-10);
                }
                g.setColor(Color.WHITE);
                g.fillOval(this.x+3, this.y+12, 2, 2);
                g.fillOval(this.x+9, this.y+12, 2, 2);
                break;
            case "left":
                g.fillOval(this.x, this.y, 20, 15);
                for (int i = 0; i < 4; i++) {
                    g.drawLine(this.x+10, this.y+2+i*3, this.x+30, this.y+2+i*3);
                    g.drawLine(this.x+10, this.y+15-2-i*3, this.x+30, this.y+15-2-i*3);
                }
                g.setColor(Color.WHITE);
                g.fillOval(this.x+7, this.y+3, 2, 2);
                g.fillOval(this.x+7, this.y+9, 2, 2);
                break;
            case "right":
                g.fillOval(this.x, this.y, 20, 15);
                for (int i = 0; i < 4; i++) {
                    g.drawLine(this.x+10, this.y+2+i*3, this.x-10, this.y+2+i*3);
                    g.drawLine(this.x+10, this.y+15-2-i*3, this.x-10, this.y+15-2-i*3);
                }
                g.setColor(Color.WHITE);
                g.fillOval(this.x+12, this.y+3, 2, 2);
                g.fillOval(this.x+12, this.y+9, 2, 2);
                break;
        }
    }


    public String getCell(){
        return this.color;
    }
}