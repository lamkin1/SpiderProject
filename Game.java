import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
public class Game extends JFrame{
    WorldPanel worldPanel;

    public Game(){
        super("Spider World");
        Border blackline = BorderFactory.createLineBorder(Color.black);

        JPanel mainPanel = new JPanel(new BorderLayout());
        setLayout(new BorderLayout());

        worldPanel = new WorldPanel();
        WorkAreaPanel workAreaPanel = new WorkAreaPanel();

        JPanel levels = new JPanel();
        JButton level1 = new JButton("1");
        levels.add(level1);

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


}
