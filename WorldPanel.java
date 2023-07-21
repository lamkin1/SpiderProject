import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
public class WorldPanel extends JPanel implements ActionListener {
    private int x1, x2, y1, y2;
    World world = new World();

    //ConnectHelper connectHelper = new ConnectHelper();
    public WorldPanel() {
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.WHITE);

        JButton step = new JButton("Step");
        JButton turn = new JButton("Turn");
        JButton red = new JButton("Red");
        JButton blue = new JButton("Blue");
        JButton green = new JButton("Green");
        JButton black = new JButton("Black");

        red.setOpaque(true);
        blue.setOpaque(true);
        green.setOpaque(true);
        black.setOpaque(true);

        red.setBackground(Color.RED);
        blue.setBackground(Color.BLUE);
        green.setBackground(Color.GREEN);
        black.setBackground(Color.BLACK);

        step.addActionListener(this);
        turn.addActionListener(this);
        red.addActionListener(this);
        blue.addActionListener(this);
        green.addActionListener(this);
        black.addActionListener(this);

        this.add(step);
        this.add(turn);
        this.add(red);
        this.add(blue);
        this.add(green);
        this.add(black);
    }

    public void paintComponent(Graphics g) {
        // loop through struct that holds cells, spider, diamonds
        world.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().getName().equals("javax.swing.JButton")) {
            if (((JButton) e.getSource()).getText().equals("Run")) {
                System.out.println("selected run");
                world.run();
            }
        }
    }

}
