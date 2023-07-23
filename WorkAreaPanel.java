import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
public class WorkAreaPanel extends JPanel implements MouseListener, MouseMotionListener{
    private int x1, x2, y1, y2;
    private BlockSpawner bs;
    //private Block chosenBlock;
    //ConnectHelper connectHelper = new ConnectHelper();
    public WorkAreaPanel(){
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.WHITE);
        bs = new BlockSpawner(450, 100, Color.ORANGE, "Block");
        this.add(bs);
    }

    public void paintComponent(Graphics g){
        bs.draw(g);
    }

//    public void delete(ParentBlock parentBlock){
//
//    }


    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {
        // call connect
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}
}
