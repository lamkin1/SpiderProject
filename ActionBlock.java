import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;

public class ActionBlock extends Block{
    private int x_len = 30, y_len = 15;
    private String name;
    private Color color;

    public void setX_len(int x_len) {
        this.x_len = x_len;
    }

    public void setY_len(int y_len) {
        this.y_len = y_len;
    }

    public int getX_len() {
        return x_len;
    }

    public int getY_len() {
        return y_len;
    }

    public ActionBlock(int x1, int y1, String action){
        super.blocks = DataSource.getInstance().getBlockArrayInstance();
        super.setX1(x1);
        super.setX2(x1 + x_len);
        super.setY1(y1);
        super.setY2(y1 + y_len);
        switch(action){
            case "Step":    name = "Step";
                            color = Color.GRAY;
                            break;
            case "Turn":    name = "Turn";
                            color = Color.GRAY;
                            break;
            case "Paint Red":   name = "Paint Red";
                            color = Color.RED;
                            break;
            case "Paint Blue":   name = "Paint Blue";
                            color = Color.BLUE;
                            break;
            case "Paint Green":   name = "Paint Green";
                            color = Color.GREEN;
                            break;
        }
    }

    public void run(){;}

    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(super.getX1(), super.getY1(), x_len, y_len);
    }

    public void connect(){
        int x_avg = (super.getX1()+super.getX2())/2;
        Block temp, temp2, transfer;
        boolean first = false;
        for(int i = 0; i < super.blocks.size(); i++){
            temp = super.blocks.get(i);
            if(this == temp){first = true;continue;}
            do{
                //System.out.println("this y1: " + this.getY1());
                //System.out.println("temp y2: " + temp.getY2());
                //System.out.println("x avg: " + x_avg);
                //System.out.println("temp x1: " + temp.getX1());
                //System.out.println("temp x2: " + temp.getX2());
                if((this.getY1() >= temp.getY2() - 5 && super.getY1() <= temp.getY2() + 5) && (x_avg >= temp.getX1() && x_avg <= temp.getX2())){
                    //System.out.println("hit");
                    this.setY1(temp.getY2());
                    this.setX1(temp.getX1());
                    this.setX2(temp.getX2());
                    this.setY2(this.getY1()+y_len);
                    if(temp.next != this) {
                        transfer = temp.next;
                        temp.next = this;
                        this.next = transfer;
                        temp2 = transfer;
                        do {
                            if (temp2 != null) {
                                temp2.shift(y_len);
                                temp2 = temp2.next;
                            }
                        } while (temp2 != null);
                    }
                    return;
                }
                temp = temp.next;
            }while(temp != null);
        }
        //SORT blocks array by y value
        if(!first){
            //need to remove the linked list from where it was dragged from
            //blocks.add(this); ??? what was I thinking here

        }
    }
}
