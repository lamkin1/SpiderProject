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
    private BlockSpawner loop;
    private boolean deleted = false;

    private TrashCan trashCan;

    int offsetX, offsetY;

    private Block selectedBlock;

    JPanel buttonPanel = new JPanel();

    //private Block chosenBlock;
    //ConnectHelper connectHelper = new ConnectHelper();
    public WorkAreaPanel() {
        addMouseListener(this);
        addMouseMotionListener(this);
        this.setPreferredSize(new Dimension(700, 500));
        setLayout(new BorderLayout());

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
        loop = new BlockSpawner(450, 100, Color.MAGENTA, "Loop");
        loop.setBackground(Color.MAGENTA);
        loop.setOpaque(true);
        loop.setBorderPainted(false);

        buttonPanel.add(step);
        buttonPanel.add(turn);
        buttonPanel.add(paintRed);
        buttonPanel.add(paintBlue);
        buttonPanel.add(paintGreen);
        buttonPanel.add(loop);

        step.addActionListener(this);
        paintRed.addActionListener(this);
        paintBlue.addActionListener(this);
        paintGreen.addActionListener(this);
        turn.addActionListener(this);
        loop.addActionListener(this);

        buttonPanel.setLayout(new GridLayout(6, 1));

        this.add(buttonPanel, BorderLayout.EAST);

        trashCan = new TrashCan(40, 450);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Block block: DataSource.getInstance().getBlockArrayInstance()){
            block.draw(g);
            Block temp = block.next;
            while(temp!= null){
                temp.draw(g);
                temp = temp.next;
            }
        }
        trashCan.draw(g);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //x_len = 30, y_len = 15;
        x1 = e.getX();
        y1 = e.getY();
        deleted = false;

        for(Block block: DataSource.getInstance().getBlockArrayInstance()){
            if (((block instanceof ActionBlock) || (block instanceof LoopBlockDecorator))&& (block.getX1() <= x1 && x1 <= block.getX1() + 70) && (block.getY1() <= y1 && y1 <= block.getY1() + 15)) { // change to follow if inside block
                if(block.getName() == "Loop Block"){selectedBlock = (LoopBlockDecorator) block;}
                else{selectedBlock = (ActionBlock) block;}
                offsetX = x1 - selectedBlock.getX1();
                offsetY = y1 - selectedBlock.getY1();
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

        if (selectedBlock != null){
            int blockLength = selectedBlock.getX_len();
            int blockHeight = selectedBlock.getY_len();
            if (((x_diff > 40 || x_diff + blockLength < 60) && (y_diff > 435 || y_diff + blockHeight < 495)) && (!deleted)){
                trashCan.delete(selectedBlock);
                deleted = true;
            }
            for(int i = 0; i < DataSource.getInstance().getBlocksRunInstance().size();i++) {
                System.out.println(DataSource.getInstance().getBlocksRunInstance().get(i).getName());
            }
            System.out.println("donezo");


            selectedBlock.moving(x_diff, y_diff);

            Block temp = selectedBlock.next;
            int shift_y = selectedBlock.getY_len();
            while(temp != null){
                temp.moving(x_diff, y_diff + shift_y);
                shift_y += selectedBlock.getY_len();
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
        if (selectedBlock != null){
            selectedBlock.connect();
            repaint();
            selectedBlock = null;
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
                DataSource.getInstance().getBlockArrayInstance().add(ab);
                DataSource.getInstance().getBlocksRunInstance().add(ab);
                repaint();
            }

            if (((JButton) e.getSource()).getText().equals("Turn")) {
                System.out.println("making turn block");
                ActionBlock ab = new ActionBlock(375, 125, "Turn");
                DataSource.getInstance().getBlockArrayInstance().add(ab);
                DataSource.getInstance().getBlocksRunInstance().add(ab);
                repaint();
            }

            if (((JButton) e.getSource()).getText().equals("Paint Red")) {
                System.out.println("making paint block");
                ActionBlock ab = new ActionBlock(375, 200, "Paint Red");
                DataSource.getInstance().getBlockArrayInstance().add(ab);
                DataSource.getInstance().getBlocksRunInstance().add(ab);
                repaint();
            }

            if (((JButton) e.getSource()).getText().equals("Paint Blue")) {
                System.out.println("making paint block");
                ActionBlock ab = new ActionBlock(375, 275, "Paint Blue");
                DataSource.getInstance().getBlockArrayInstance().add(ab);
                DataSource.getInstance().getBlocksRunInstance().add(ab);
                repaint();
            }

            if (((JButton) e.getSource()).getText().equals("Paint Green")) {
                System.out.println("making paint block");
                ActionBlock ab = new ActionBlock(375, 350, "Paint Green");
                DataSource.getInstance().getBlockArrayInstance().add(ab);
                DataSource.getInstance().getBlocksRunInstance().add(ab);
                repaint();
            }

            if (((JButton) e.getSource()).getText().equals("Loop")) {
                System.out.println("making paint block");
                LoopBlockDecorator b = new LoopBlockDecorator(375, 425);
                DataSource.getInstance().getBlockArrayInstance().add(b);
                DataSource.getInstance().getBlocksRunInstance().add(b);
                repaint();
            }
        }

    }
}
