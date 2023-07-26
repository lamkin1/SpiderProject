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
        this.setPreferredSize(new Dimension(550, 500));//
        this.setBackground(Color.WHITE);

        JButton play = new JButton("Play");
        JButton reset = new JButton("Reset");
        speedSlider = new JSlider();

        play.addActionListener(this);
        reset.addActionListener(this); // e->world.reset()??

        this.add(play);
        this.add(reset);
        this.add(speedSlider);
    }

    public void clearBoard(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 550, 500);
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
            if (((JButton) e.getSource()).getText().equals("Reset")) {
                System.out.println("selected reset");
                LevelHelper levelHelper = new LevelHelper();
                int level = DataSource.getInstance().getLevel();
                levelHelper.load(level);
                repaint();
            }
        }
    }

}
