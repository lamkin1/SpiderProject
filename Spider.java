import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Spider {
    private int x;
    private int y;
    private String direction;
    private BufferedImage spiderImage;

    public Spider(int x, int y, String direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
        try {
            spiderImage = ImageIO.read(new File("spider_north.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move(){
        switch(this.direction){
            case "up":
                this.y -= 35;
                break;
            case "down":
                this.y += 35;
                break;
            case "left":
                this.x -= 35;
                break;
            case "right":
                this.x += 35;
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
        if (spiderImage != null) {
            g.drawImage(spiderImage, x-5, y+5, 25, 25, null);
        }
    }
}