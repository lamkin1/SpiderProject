import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.*;
public class WorldPanel extends JPanel implements ActionListener {
    World world = new World();
    JSlider speedSlider;

    //ConnectHelper connectHelper = new ConnectHelper();
    public WorldPanel() {
        this.setPreferredSize(new Dimension(600, 500));//
        this.setBackground(Color.WHITE);

        JButton play = new JButton("Play");
        JButton reset = new JButton("Reset");
        speedSlider = new JSlider();

        play.addActionListener(this);
        play.setFocusPainted(false);
        play.setBackground(Color.GREEN);
        play.setOpaque(true);
        play.setBorderPainted(false);

        this.add(play);

        this.add(speedSlider);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        world.draw(g);
        repaint();
    }


    public void stateChanged(ChangeEvent e)
    {
        System.out.println(speedSlider.getValue());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().getName().equals("javax.swing.JButton")) {
            if (((JButton) e.getSource()).getText().equals("Play")) {
                System.out.println("selected play");
                world.run();
            }
        }
    }

}
