import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
public class Game extends JFrame implements ActionListener{
    private WorldPanel worldPanel;
    private WorkAreaPanel workAreaPanel;
    private LevelHelper lh = new LevelHelper();

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


        JButton level7 = new JButton("7");
        level7.addActionListener(this);
        levels.add(level7);

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

        workAreaPanel.setBorder(blackline);
        worldPanel.setBorder(blackline);
        levels.setBorder(blackline);

        mainPanel.add(levels, BorderLayout.NORTH);
        mainPanel.add(worldPanel,BorderLayout.WEST);
        mainPanel.add(workAreaPanel,BorderLayout.EAST);

        add(mainPanel);
    }

    public static void main(String[] args) {
        Game Game = new Game();
        Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game.setSize(1100,600);
        Game.setVisible(true);
        Game.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().getName().equals("javax.swing.JButton")) {
            if (((JButton) e.getSource()).getText().equals("1")) {
                DataSource.getInstance().setLevel(1);
                lh.load(1);
                worldPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("2")) {
                DataSource.getInstance().setLevel(2);
                lh.load(2);
                worldPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("3")) {
                DataSource.getInstance().setLevel(3);
                lh.load(3);
                worldPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("4")) {
                DataSource.getInstance().setLevel(4);
                lh.load(4);
                worldPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("5")) {
                DataSource.getInstance().setLevel(5);
                lh.load(5);
                worldPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("6")) {
                DataSource.getInstance().setLevel(6);
                lh.load(6);
                worldPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("7")) {
                DataSource.getInstance().setLevel(7);
                lh.load(7);
                worldPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("8")) {
                DataSource.getInstance().setLevel(8);
                lh.load(8);
                worldPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("9")) {
                DataSource.getInstance().setLevel(9);
                lh.load(9);
                worldPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("10")) {
                DataSource.getInstance().setLevel(10);
                lh.load(10);
                worldPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("11")) {
                DataSource.getInstance().setLevel(11);
                lh.load(11);
                worldPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("12")) {
                DataSource.getInstance().setLevel(12);
                lh.load(12);
                worldPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("13")) {
                DataSource.getInstance().setLevel(12);
                lh.load(13);
                worldPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("14")) {
                DataSource.getInstance().setLevel(14);
                lh.load(14);
                worldPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("15")) {
                DataSource.getInstance().setLevel(15);
                lh.load(15);
                worldPanel.repaint();
            }

        }
    }
}
