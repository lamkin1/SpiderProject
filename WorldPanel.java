import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.Comparator;

public class WorldPanel extends JPanel implements ActionListener {
    World world = new World();
    private JButton play;
    public WorldPanel() {
        this.setPreferredSize(new Dimension(700, 500));
        this.setBackground(Color.WHITE);

        play = new JButton("Play");

        play.addActionListener(this);

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
                for(Cell cell: DataSource.getInstance().getCellArrayInstance()){
                    cell.setColor(Color.BLACK);
                }
                world.play();
                Boolean res = world.compare();
                if (res){
                    showSuccessPopup();
                }
            }
        }
    }
    public void showSuccessPopup() {
        JOptionPane.showMessageDialog(this, "Congratulations! You may now move onto the next level!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
