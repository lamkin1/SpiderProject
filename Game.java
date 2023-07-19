import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
public class Game extends JFrame implements ActionListener{

    public Game(){
        super("Spider World");
        Border blackline = BorderFactory.createLineBorder(Color.black);
        // main panel
        JPanel main = new JPanel(new BorderLayout());

        // west panel
        setLayout(new BorderLayout());
        JPanel gridPanel = new JPanel();

        // Buttons
        JButton step = new JButton("Step");
        JButton turn = new JButton("Turn");
        JButton red = new JButton("Red");
        JButton blue = new JButton("Blue");
        JButton green = new JButton("Green");
        JButton black = new JButton("Black");

        step.addActionListener(this);
        turn.addActionListener(this);
        red.addActionListener(this);
        blue.addActionListener(this);
        green.addActionListener(this);
        black.addActionListener(this);

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

        JPanel blockPanel = new JPanel();

        JButton temp = new JButton("hi");
        blockPanel.add(temp);

        gridPanel.setBorder(blackline);
        blockPanel.setBorder(blackline);

        main.add(gridPanel,BorderLayout.WEST);
        main.add(blockPanel,BorderLayout.EAST);

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

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().getClass().getName().equals("javax.swing.JCheckBox")) {

        }
    }
}
