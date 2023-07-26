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

    private TrashCan trashCan;

    int offsetX, offsetY;

    private ActionBlock selectedActionBlock;

    JPanel buttonPanel = new JPanel();
    ArrayList<Block> blocks;

    //private Block chosenBlock;
    //ConnectHelper connectHelper = new ConnectHelper();
    public WorkAreaPanel() {
        addMouseListener(this);
        addMouseMotionListener(this);
        this.setPreferredSize(new Dimension(750, 500));
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

        trashCan = new TrashCan(40, 450);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Block block: blocks){
            block.draw(g);
        }
        trashCan.draw(g);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //x_len = 30, y_len = 15;
        x1 = e.getX();
        y1 = e.getY();

        for(Block block: blocks){
            if (block instanceof ActionBlock && (block.getX1() <= x1 && x1 <= block.getX1() + 30) && (block.getY1() <= y1 && y1 <= block.getY1() + 15)) { // change to follow if inside block
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

        int x_diff = x2 - offsetX;
        int y_diff = y2 - offsetY;

        if (selectedActionBlock != null){
            int blockLength = selectedActionBlock.getX_len();
            int blockHeight = selectedActionBlock.getY_len();
            if (x_diff > 40 && x_diff + blockLength < 80 && y_diff > 435 && y_diff + blockHeight < 495){
                trashCan.delete(selectedActionBlock);
            }

            selectedActionBlock.moving(x_diff, y_diff);

            Block temp = selectedActionBlock.next;
            int shift_y = selectedActionBlock.getY_len();
            while(temp != null){
                temp.moving(x_diff, y_diff + shift_y);
                shift_y += selectedActionBlock.getY_len();
                temp = temp.next;
            }
        }

        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (selectedActionBlock != null){
            selectedActionBlock.connect();
            repaint();
            selectedActionBlock = null;
        }
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
                ActionBlock ab = new ActionBlock(375, 50, "Step");
                blocks.add(ab);
                repaint();
            }

            if (((JButton) e.getSource()).getText().equals("Turn")) {
                System.out.println("making turn block");
                ActionBlock ab = new ActionBlock(375, 125, "Turn");
                blocks.add(ab);
                repaint();
            }

            if (((JButton) e.getSource()).getText().equals("Paint Red")) {
                System.out.println("making paint block");
                ActionBlock ab = new ActionBlock(375, 200, "Paint Red");
                blocks.add(ab);
                repaint();
            }

            if (((JButton) e.getSource()).getText().equals("Paint Blue")) {
                System.out.println("making paint block");
                ActionBlock ab = new ActionBlock(375, 275, "Paint Blue");
                blocks.add(ab);
                repaint();
            }

            if (((JButton) e.getSource()).getText().equals("Paint Green")) {
                System.out.println("making paint block");
                ActionBlock ab = new ActionBlock(375, 350, "Paint Green");
                blocks.add(ab);
                repaint();
            }
        }

    }
}
