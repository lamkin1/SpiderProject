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
    private int limitTop;
    private int limitBottom;
    private int limitRight;
    private int limitLeft;
    private String direction = "up";
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
        Cell c1 = DataSource.getInstance().getCellArrayInstance().get(0);
        limitTop = c1.getY();
        limitLeft = c1.getX();
        int size = DataSource.getInstance().getCellArrayInstance().size();
        limitBottom = c1.getY() + (int)Math.sqrt(size)*35;
        limitRight = c1.getX() + (int)Math.sqrt(size)*35;
        System.out.println(c1.getX());
        System.out.println(size);
    }

    public Boolean move(){
        Boolean b = false;
        switch(this.direction){
            case "up":
                this.y -= 35;
                b = limitSpider();
                break;
            case "down":
                this.y += 35;
                b = limitSpider();
                break;
            case "left":
                this.x -= 35;
                b = limitSpider();
                break;
            case "right":
                this.x += 35;
                b = limitSpider();
                break;
        }
        DataSource.getInstance().setSpiderLocation(this.x, this.y);
        System.out.println("Spider X: " + this.x + ", Spider Y: " + this.y);
        return b;
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

    public int getSpiderX(){return this.x;}
    public int getSpiderY(){return this.y;}

    public void setDirection(String s){
        this.direction = s;
    }

    public String getDirection(){
        return this.direction;
    }

    public Boolean limitSpider(){
        if(this.x >= this.limitRight){
            this.x = this.limitRight - 25;
            return true;
        }
        if(this.x <= this.limitLeft){
            this.x = this.limitLeft + 10;
            return true;
        }
        if(this.y >= this.limitBottom){
            this.y = this.limitBottom - 35;
            return true;
        }
        if(this.y < this.limitTop){
            this.y = this.limitTop;
            return true;
        }
        return false;
    }
}