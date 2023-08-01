import javax.swing.*;
import java.awt.*;
public class TrashCan extends JPanel {
    private int x;
    private int y;

    public TrashCan(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(this.x, this.y, 40, 45);
        g.fillRect(this.x, this.y-15, 40, 10 );
    }

    public void delete(Block b){
        Rectangle trashcan = new Rectangle(x+30, y, 40, 45);
        Rectangle block = new Rectangle(b.getX1(), b.getY1(), b.getX2()-b.getX1(), b.getY2()-b.getY1());

        if(trashcan.intersects(block)){
            DataSource.getInstance().getBlocksRunInstance().remove(b);
            DataSource.getInstance().getBlockArrayInstance().remove(b);
        }
    }
}

