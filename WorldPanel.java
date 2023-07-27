import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.util.Comparator;

public class WorldPanel extends JPanel implements ActionListener {
    World world = new World();
    //need to update Spider spider so it gets drawn onto the cells
    Spider spider = new Spider(DataSource.getInstance().getSpiderLocation()[0],
            DataSource.getInstance().getSpiderLocation()[1], "up");

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
        //spider.draw(g);
        repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().getName().equals("javax.swing.JButton")) {
            if (((JButton) e.getSource()).getText().equals("Play")) {
                System.out.println("selected play");
                play();
            }
        }
    }

    public void play(){
        DataSource.getInstance().getBlocksRunInstance().sort(Comparator.comparing(Block::getY1));
        for(Block block : DataSource.getInstance().getBlocksRunInstance()){
            run(block);
            Block temp = block.next;
            while(temp != null){
                run(temp);
                temp = temp.next;
            }
        }
    }

    public void run(Block b){
        switch(((ActionBlock) b).getName()){
            case "Step":
                spider.move();
                break;
            case "Turn":
                System.out.println("turn");
                spider.turn();
                break;
            case "Paint Red":
                System.out.println("paint red");
                break;

        }
    }
}
