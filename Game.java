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
        Game.setSize(1000,600);
        Game.setVisible(true);
        Game.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().getName().equals("JButton")) {
            if (((JButton) e.getSource()).getText().equals("1")) {
                lh.load(1);
                worldPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("2")) {
                System.out.println("level 2 loaded");
                lh.load(2);
                worldPanel.repaint();
            }
            if (((JButton) e.getSource()).getText().equals("3")) {
                lh.load(3);
            }
            if (((JButton) e.getSource()).getText().equals("4")) {
                lh.load(4);
            }
            if (((JButton) e.getSource()).getText().equals("5")) {
                lh.load(5);
            }
            if (((JButton) e.getSource()).getText().equals("6")) {
                lh.load(6);
            }
        }
    }
}
