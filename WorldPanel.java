import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.*;
public class WorldPanel extends JPanel implements ActionListener, MouseListener {
    World world = new World();
    JSlider speedSlider;

    private JButton play;

    //ConnectHelper connectHelper = new ConnectHelper();
    public WorldPanel() {
        this.setPreferredSize(new Dimension(600, 500));
        this.setBackground(Color.WHITE);

        play = new JButton("Play");
        speedSlider = new JSlider();

        play.addActionListener(this);
//        play.setFocusPainted(false);
//        play.setBackground(Color.GREEN);
//        play.setOpaque(true);
//        play.setBorderPainted(false);

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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("entered play button");
        //play.setBorderPainted(true);
        play.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 5), // Outer border (shadow effect)
                BorderFactory.createEmptyBorder(6, 12, 6, 12)    // Inner border (main button border)
        ));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        play.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 12)); // Only the inner border (main button border)
        //play.setBorderPainted(false);
    }
}
