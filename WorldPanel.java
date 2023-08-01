import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.Comparator;

public class WorldPanel extends JPanel implements ActionListener {
    World world = new World();
    Boolean success = false;
    private JButton play;

    //ConnectHelper connectHelper = new ConnectHelper();
    public WorldPanel() {
        this.setPreferredSize(new Dimension(700, 500));
        this.setBackground(Color.WHITE);

        play = new JButton("Play");

        play.addActionListener(this);
//        play.setFocusPainted(false);
//        play.setBackground(Color.GREEN);
//        play.setOpaque(true);
//        play.setBorderPainted(false);

        this.add(play);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        world.draw(g);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().getName().equals("javax.swing.JButton")) {
            if (((JButton) e.getSource()).getText().equals("Play")) {
                System.out.println("selected play");
                world.play();
                Boolean res = world.compare();
                if (res){
                    success = true;
//                    LevelHelper lh = new LevelHelper();
//                    lh.load(DataSource.getInstance().getLevel() + 1);
                }
            }
        }
    }

    public boolean returnSuccess(){
        return success;
    }
}
