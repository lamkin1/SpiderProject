import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
public class Game extends JFrame{

    public Game(){
        super("Spider World");
        Border blackline = BorderFactory.createLineBorder(Color.black);
        // main panel
        JPanel main = new JPanel(new BorderLayout());

        // west panel
        setLayout(new BorderLayout());
        JPanel gridPanel = new JPanel(); // change to WorldPanel
        // WorldPanel worldPanel = new WorldPanel();

        // Buttons (go into WorldPanel)
        JButton step = new JButton("Step");
        JButton turn = new JButton("Turn");
        JButton red = new JButton("Red");
        JButton blue = new JButton("Blue");
        JButton green = new JButton("Green");
        JButton black = new JButton("Black");


        red.setBackground(Color.RED);
        blue.setBackground(Color.BLUE);
        green.setBackground(Color.GREEN);
        black.setBackground(Color.BLACK);

        gridPanel.add(step);
        gridPanel.add(turn);
        gridPanel.add(red);
        gridPanel.add(blue);
        gridPanel.add(green);
        gridPanel.add(black);


        WorkAreaPanel workAreaPanel = new WorkAreaPanel();


        JPanel levels = new JPanel();
        JButton level1 = new JButton("1");
        levels.add(level1);

        gridPanel.setBorder(blackline);
        workAreaPanel.setBorder(blackline);
        levels.setBorder(blackline);

        main.add(gridPanel,BorderLayout.WEST);
        main.add(workAreaPanel,BorderLayout.EAST);
        main.add(levels, BorderLayout.NORTH);

        //main.add(worldPanel,BorderLayout.WEST);
        //main.add(workAreaPanel,BorderLayout.EAST);

        // work area (center)
        add(main);
    }

    public static void main(String[] args) {
        Game Game = new Game();
        Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game.setSize(800,600);
        Game.setVisible(true);
        Game.setResizable(false);
    }


}
