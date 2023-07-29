import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;
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
                rotateImage(90);
                break;
            case "down":
                this.direction = "left";
                rotateImage(90);
                break;
            case "left":
                this.direction = "up";
                rotateImage(90);
                break;
            case "right":
                this.direction = "down";
                rotateImage(90);
                break;
        }
    }

    public void rotateImage(double angle) {
        double rotationRequired = Math.toRadians(angle);
        double locationX = spiderImage.getWidth() / 2;
        double locationY = spiderImage.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        // Drawing the rotated image at the required drawing locations
        spiderImage = op.filter(spiderImage, null);
    }

    public void draw(Graphics g){
        if (spiderImage != null) {
            g.drawImage(spiderImage, x-5, y+5, 25, 25, null);
        }
    }

    public void setspiderX(int x){
        this.x = x;
    }

    public void setSpiderY(int y){
        this.y = y;
    }
}