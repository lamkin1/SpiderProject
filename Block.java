import java.awt.*;
import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;


//NEED TO IMPLEMENT STEP, TURN, PAINT, AND 1 LOOP BLOCK; LOOP BLOCK IS ONLY TIME TO USE DECORATOR
public abstract class Block{
    Block next = null;
    private int x1, y1, x2, y2;
    ArrayList<Block> blocks;

    public abstract void draw(Graphics g);

    public void moving(int x_diff, int y_diff){
        x1 = x1 + x_diff;
        x2 = x2 + x_diff;
        y1 = y1 + y_diff;
        y2 = y2 + y_diff;
    }


    public void shift(int y_diff){
        moving(0, y_diff);
    }


    public abstract void run();

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
