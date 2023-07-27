import javax.swing.*;
import javax.xml.crypto.Data;
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

    public void delete(ActionBlock ab){
        Rectangle trashcan = new Rectangle(x+30, y, 40, 45);
        Rectangle block = new Rectangle(ab.getX1(), ab.getY1(), ab.getX2()-ab.getX1(), ab.getY2()-ab.getY1());

        if(trashcan.intersects(block)){
            DataSource.getInstance().getBlockArrayInstance().remove(ab);
            DataSource.getInstance().getBlocksRunInstance().remove(ab);
        }
    }
}
