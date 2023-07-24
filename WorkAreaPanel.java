import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class WorkAreaPanel extends JPanel implements MouseListener, MouseMotionListener, ActionListener {
    private int x1, x2, y1, y2;
    private BlockSpawner step;
    private BlockSpawner paint;
    private BlockSpawner turn;

    JPanel buttonPanel = new JPanel();
    DataSource dataSource;
    ArrayList<Block> blocks;

    //private Block chosenBlock;
    //ConnectHelper connectHelper = new ConnectHelper();
    public WorkAreaPanel() {
        this.setPreferredSize(new Dimension(500, 500));
        setLayout(new BorderLayout());

        dataSource = DataSource.getInstance();
        blocks = dataSource.getBlockArrayInstance();

        this.setBackground(Color.WHITE);
        step = new BlockSpawner(450, 100, Color.ORANGE, "Step");
        turn = new BlockSpawner(450, 100, Color.ORANGE, "Turn");
        paint = new BlockSpawner(450, 100, Color.ORANGE, "Paint");


        buttonPanel.add(step);
        buttonPanel.add(turn);
        buttonPanel.add(paint);

        step.addActionListener(this);
        paint.addActionListener(this);
        turn.addActionListener(this);

        buttonPanel.setLayout(new GridLayout(6, 1));

        this.add(buttonPanel, BorderLayout.EAST);
    }

    public void paintComponent(Graphics g) {
        for(Block block: blocks){
            block.draw(g);
        }
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
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // call connect
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {//
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().getName().equals("BlockSpawner")) {
            if (((JButton) e.getSource()).getText().equals("Step")) {
                ActionBlock ab = new ActionBlock(300, 50, "Step");
                blocks.add(ab);
                repaint();
            }

            if (((JButton) e.getSource()).getText().equals("Turn")) {
                ActionBlock ab = new ActionBlock(300, 100, "Turn");
                blocks.add(ab);
                repaint();
            }

            if (((JButton) e.getSource()).getText().equals("Paint")) {
                ActionBlock ab = new ActionBlock(300, 150, "Paint");
                blocks.add(ab);
                repaint();
            }
        }
    }
}
