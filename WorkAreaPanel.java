import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class WorkAreaPanel extends JPanel implements MouseListener, MouseMotionListener, ActionListener {
    private int x1, x2, y1, y2;
    private BlockSpawner step;
    private BlockSpawner paintRed;
    private BlockSpawner paintBlue;
    private BlockSpawner paintGreen;
    private BlockSpawner turn;

    int offsetX, offsetY;

    private ActionBlock selectedActionBlock;

    JPanel buttonPanel = new JPanel();
    ArrayList<Block> blocks;

    //private Block chosenBlock;
    //ConnectHelper connectHelper = new ConnectHelper();
    public WorkAreaPanel() {
        addMouseListener(this);
        addMouseMotionListener(this);
        this.setPreferredSize(new Dimension(500, 500));
        setLayout(new BorderLayout());

        blocks = DataSource.getInstance().getBlockArrayInstance();

        this.setBackground(Color.WHITE);
        step = new BlockSpawner(450, 100, Color.ORANGE, "Step");
        turn = new BlockSpawner(450, 100, Color.ORANGE, "Turn");
        paintRed = new BlockSpawner(450, 100, Color.RED, "Paint Red");
        paintRed.setBackground(Color.RED);
        paintRed.setOpaque(true);
        paintRed.setBorderPainted(false);
        paintBlue = new BlockSpawner(450, 100, Color.BLUE, "Paint Blue");
        paintBlue.setBackground(Color.BLUE);
        paintBlue.setOpaque(true);
        paintBlue.setBorderPainted(false);
        paintGreen = new BlockSpawner(450, 100, Color.GREEN, "Paint Green");
        paintGreen.setBackground(Color.GREEN);
        paintGreen.setOpaque(true);
        paintGreen.setBorderPainted(false);

        buttonPanel.add(step);
        buttonPanel.add(turn);
        buttonPanel.add(paintRed);
        buttonPanel.add(paintBlue);
        buttonPanel.add(paintGreen);

        step.addActionListener(this);
        paintRed.addActionListener(this);
        paintBlue.addActionListener(this);
        paintGreen.addActionListener(this);
        turn.addActionListener(this);

        buttonPanel.setLayout(new GridLayout(6, 1));

        this.add(buttonPanel, BorderLayout.EAST);

    }

    public void paintComponent(Graphics g) {
        for(Block block: blocks){
            System.out.println("drawing");
            block.draw(g);
        }
    }

//    public void delete(ParentBlock parentBlock){
//
//    }


    @Override
    public void mousePressed(MouseEvent e) {
        //x_len = 30, y_len = 15;
        x1 = e.getX();
        y1 = e.getY();

        for(Block block: blocks){
            if (block instanceof ActionBlock && (block.getX1() <= x1 && x1 <= block.getX1() + 30) && (block.getY1() <= y1 && y1 <= block.getY1() + 15)) { // change to follow if inside block
                System.out.println("block pressed");
                selectedActionBlock = (ActionBlock) block;
                offsetX = x1 - selectedActionBlock.getX1();
                offsetY = y1 - selectedActionBlock.getY1();
                break;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();

        System.out.println("here in dragged");

        int x_diff = x2 - offsetX;
        int y_diff = y2 - offsetY;

        selectedActionBlock.setX1(x_diff);
        selectedActionBlock.setY1(y_diff);

        //selectedActionBlock.moving(x_diff, y_diff);

        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        selectedActionBlock = null;
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
                System.out.println("making step block");
                ActionBlock ab = new ActionBlock(300, 50, "Step");
                blocks.add(ab);
                repaint();
            }

            if (((JButton) e.getSource()).getText().equals("Turn")) {
                System.out.println("making turn block");
                ActionBlock ab = new ActionBlock(300, 100, "Turn");
                blocks.add(ab);
                repaint();
            }

            if (((JButton) e.getSource()).getText().equals("Paint Red")) {
                System.out.println("making paint block");
                ActionBlock ab = new ActionBlock(300, 150, "Paint");
                blocks.add(ab);
                repaint();
            }

            if (((JButton) e.getSource()).getText().equals("Paint Blue")) {
                System.out.println("making paint block");
                ActionBlock ab = new ActionBlock(300, 150, "Paint");
                blocks.add(ab);
                repaint();
            }

            if (((JButton) e.getSource()).getText().equals("Paint Green")) {
                System.out.println("making paint block");
                ActionBlock ab = new ActionBlock(300, 150, "Paint");
                blocks.add(ab);
                repaint();
            }
        }

    }
}
