import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
public class Game extends JFrame implements ActionListener{
    private WorldPanel worldPanel;
    private WorkAreaPanel workAreaPanel;
    private LevelHelper lh = new LevelHelper();
    private Spider spider;
    int[] spiderLoc;
    public Game(){
        super("Spider World");

        Border blackline = BorderFactory.createLineBorder(Color.black);

        DataSource.getInstance().setLevel(1);
        lh.load(1);

        JPanel mainPanel = new JPanel(new BorderLayout());

        setLayout(new BorderLayout());

        worldPanel = new WorldPanel();
        workAreaPanel = new WorkAreaPanel();

        JPanel levels = new JPanel();

        JButton level1 = new JButton("1");
        level1.addActionListener(this);
        levels.add(level1);

        JButton level2 = new JButton("2");
        level2.addActionListener(this);
        levels.add(level2);

        JButton level3 = new JButton("3");
        level3.addActionListener(this);
        levels.add(level3);

        JButton level4 = new JButton("4");
        level4.addActionListener(this);
        levels.add(level4);

        JButton level5 = new JButton("5");
        level5.addActionListener(this);
        levels.add(level5);

        JButton level6 = new JButton("6");
        level6.addActionListener(this);
        levels.add(level6);

        JButton level7 = new JButton("7");
        level7.addActionListener(this);
        levels.add(level7);

        JButton level8 = new JButton("8");
        level8.addActionListener(this);
        levels.add(level8);

        JButton level9 = new JButton("9");
        level9.addActionListener(this);
        levels.add(level9);

        JButton level10 = new JButton("10");
        level10.addActionListener(this);
        levels.add(level10);

        JButton level11 = new JButton("11");
        level11.addActionListener(this);
        levels.add(level11);

        JButton level12 = new JButton("12");
        level12.addActionListener(this);
        levels.add(level12);

        JButton level13 = new JButton("13");
        level13.addActionListener(this);
        levels.add(level13);

        JButton level14 = new JButton("14");
        level14.addActionListener(this);
        levels.add(level14);

        JButton level15 = new JButton("15");
        level15.addActionListener(this);
        levels.add(level15);

        JButton reset = new JButton("Reset");
        reset.setBackground(Color.GRAY);
        reset.setOpaque(true);
        reset.setBorderPainted(false);
        reset.setFocusPainted(false);
        reset.addActionListener(this);
        levels.add(reset);

        JButton directions = new JButton("Directions");
        directions.setBackground(Color.GRAY);
        directions.setOpaque(true);
        directions.setBorderPainted(false);
        directions.setFocusPainted(false);
        directions.addActionListener(this);
        levels.add(directions);

        workAreaPanel.setBorder(blackline);
        worldPanel.setBorder(blackline);
        levels.setBorder(blackline);

        mainPanel.add(levels, BorderLayout.NORTH);
        mainPanel.add(worldPanel,BorderLayout.WEST);
        mainPanel.add(workAreaPanel,BorderLayout.EAST);

        add(mainPanel);

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPopup("Welcome to Spider World! Use the blocks to move your spider to correctly color the grid based on the diamonds.");
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public static void main(String[] args) {
        Game Game = new Game();
        Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//
        Game.setSize(1400,600);
        Game.setVisible(true);
        Game.setResizable(false);
    }

    private void showPopup(String instructions) {

        JDialog popup = new JDialog(this, "Directions", true);

        popup.setSize(800, 300);
        popup.setLocationRelativeTo(this);

        String htmlInstructions = "<html>" + instructions.replace("\n", "<br>") + "</html>";

        JTextPane directionsPane = new JTextPane();
        directionsPane.setContentType("text/html");
        directionsPane.setText(htmlInstructions);
        directionsPane.setEditable(false);
        directionsPane.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        directionsPane.setAlignmentY(JComponent.CENTER_ALIGNMENT);

        JScrollPane scrollPane = new JScrollPane(directionsPane);
        popup.add(scrollPane, BorderLayout.CENTER);

        popup.setVisible(true);
    }

    private void setSpiderLoc(){
        spider = worldPanel.world.getSpider();
        spiderLoc = DataSource.getInstance().getSpiderLocation();
        spider.setspiderX(spiderLoc[0]);
        spider.setSpiderY(spiderLoc[1]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().getName().equals("javax.swing.JButton")) {
            if (((JButton) e.getSource()).getText().equals("1")) {
                DataSource.getInstance().setLevel(1);
                lh.load(1);
                setSpiderLoc();
                checkRotate(1);
                DataSource.getInstance().clearBlocks();
                worldPanel.repaint();
                workAreaPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("2")) {
                DataSource.getInstance().setLevel(2);
                lh.load(2);
                setSpiderLoc();
                checkRotate(2);
                DataSource.getInstance().clearBlocks();
                worldPanel.repaint();
                workAreaPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("3")) {
                DataSource.getInstance().setLevel(3);
                lh.load(3);
                setSpiderLoc();
                checkRotate(3);
                DataSource.getInstance().clearBlocks();
                worldPanel.repaint();
                workAreaPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("4")) {
                DataSource.getInstance().setLevel(4);
                lh.load(4);
                setSpiderLoc();
                checkRotate(4);
                DataSource.getInstance().clearBlocks();
                worldPanel.repaint();
                workAreaPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("5")) {
                DataSource.getInstance().setLevel(5);
                lh.load(5);
                setSpiderLoc();
                checkRotate(5);
                DataSource.getInstance().clearBlocks();
                worldPanel.repaint();
                workAreaPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("6")) {
                DataSource.getInstance().setLevel(6);
                lh.load(6);
                setSpiderLoc();
                checkRotate(6);
                DataSource.getInstance().clearBlocks();
                worldPanel.repaint();
                workAreaPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("7")) {
                DataSource.getInstance().setLevel(7);
                lh.load(7);
                setSpiderLoc();
                checkRotate(7);
                DataSource.getInstance().clearBlocks();
                worldPanel.repaint();
                workAreaPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("8")) {
                DataSource.getInstance().setLevel(8);
                lh.load(8);
                setSpiderLoc();
                checkRotate(8);
                DataSource.getInstance().clearBlocks();
                worldPanel.repaint();
                workAreaPanel.repaint();
                showPopup("This level introduces loops! The repeat block contains other blocks. \nThe blocks stacked inside the repeat block will be performed over and over until the spider is at the wall. \nAnother way of describing it is that the nested blocks will be performed as many times as necessary for the spider to reach the wall. ");
            }
            if (((JButton) e.getSource()).getText().equals("9")) {
                DataSource.getInstance().setLevel(9);
                lh.load(9);
                setSpiderLoc();
                checkRotate(9);
                DataSource.getInstance().clearBlocks();
                worldPanel.repaint();
                workAreaPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("10")) {
                DataSource.getInstance().setLevel(10);
                lh.load(10);
                setSpiderLoc();
                checkRotate(10);
                DataSource.getInstance().clearBlocks();
                worldPanel.repaint();
                workAreaPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("11")) {
                DataSource.getInstance().setLevel(11);
                lh.load(11);
                setSpiderLoc();
                checkRotate(11);
                DataSource.getInstance().clearBlocks();
                worldPanel.repaint();
                workAreaPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("12")) {
                DataSource.getInstance().setLevel(12);
                lh.load(12);
                setSpiderLoc();
                checkRotate(12);
                DataSource.getInstance().clearBlocks();
                worldPanel.repaint();
                workAreaPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("13")) {
                DataSource.getInstance().setLevel(12);
                lh.load(13);
                setSpiderLoc();
                checkRotate(13);
                DataSource.getInstance().clearBlocks();
                worldPanel.repaint();
                workAreaPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("14")) {
                DataSource.getInstance().setLevel(14);
                lh.load(14);
                setSpiderLoc();
                checkRotate(14);
                DataSource.getInstance().clearBlocks();
                worldPanel.repaint();
                workAreaPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("15")) {
                DataSource.getInstance().setLevel(15);
                lh.load(15);
                setSpiderLoc();
                checkRotate(15);
                DataSource.getInstance().clearBlocks();
                worldPanel.repaint();
                workAreaPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("Reset")) {
                DataSource.getInstance().clearBlocks();
                int level = DataSource.getInstance().getLevel();
                lh.load(level);
                setSpiderLoc();
                checkRotate(level);
                worldPanel.repaint();
                workAreaPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("Directions")) {
                showPopup("Use the blocks to move the spider across the game board.\n The spider has the following behaviors: step, turn, and paint.\nSet up the blocks in a sequence for completing the level.\n\n If you have loops, use them to minimize the repeated code1");
            }
        }
    }

    private void checkRotate(int level){
        String d = spider.getDirection();
        if(level == 1 || level == 2 || level == 3){
            switch(d){
                case "up":
                    break;
                case "down":
                    spider.rotateImage(180);
                    break;
                case "right":
                    spider.rotateImage(270);
                    break;
                case "left":
                    spider.rotateImage(90);
                    break;
            }
            spider.setDirection("up");
        } else if(level == 4 || level == 5 || level == 9){
            switch(d){
                case "up":
                    spider.rotateImage(180);
                    break;
                case "down":
                    break;
                case "right":
                    spider.rotateImage(90);
                    break;
                case "left":
                    spider.rotateImage(270);
                    break;
            }
            spider.setDirection("down");
        } else if(level == 6 || level == 7 || level == 8 || level == 10 || level == 11 || level == 13 || level == 14 || level == 15){
            switch(d){
                case "up":
                    spider.rotateImage(90);
                    break;
                case "down":
                    spider.rotateImage(270);
                    break;
                case "right":
                    break;
                case "left":
                     spider.rotateImage(180);
                    break;
            }
            spider.setDirection("right");
        } else if(level == 12){
            switch(d){
                case "up":
                    spider.rotateImage(270);
                    break;
                case "down":
                    spider.rotateImage(90);
                    break;
                case "right":
                    spider.rotateImage(180);
                    break;
                case "left":
                    break;
            }
            spider.setDirection("left");
        }
    }
}
