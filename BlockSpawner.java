import java.awt.*;
import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JButton;

public class BlockSpawner extends JButton{
    private int x1, y1, x2, y2;
    private Color color;
     public BlockSpawner(int x1, int y1, Color color, String name){
         super(name);
         this.x1 = x1;
         this.y1 = y1;
         this.color = color;
         this.setBackground(color);
    }

    public void action(){

    }

    public void draw(Graphics g){
    }


}
