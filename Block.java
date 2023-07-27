import java.awt.*;
import java.util.ArrayList;


//NEED TO IMPLEMENT STEP, TURN, PAINT, AND 1 LOOP BLOCK; LOOP BLOCK IS ONLY TIME TO USE DECORATOR
public abstract class Block{
    Block next = null;
    Block prev = null;
    private int x1, y1, x2, y2;


    public abstract void draw(Graphics g);

    public void moving(int x_diff, int y_diff){
        setX1(x_diff);
        setX2(x_diff + 30);
        setY1(y_diff);
        setY2(y_diff + 15);
    }


    public void shift(int y_diff){
        moving(this.getX1(), this.getY2());
    }


    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}
