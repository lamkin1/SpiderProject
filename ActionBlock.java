import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;

public class ActionBlock extends Block{
    private int x_len = 10, y_len = 5;
    private String name;
    private Color color;

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
            case "Paint":   name = "Paint";
                            color = Color.ORANGE;
                            break;
        }
    }

    public void run(){;}

    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(super.getX1(), super.getY1(), super.getX2(), super.getY2());
    }

    public void connect(){
        int x_avg = super.getX1()+super.getX2()/2;
        Block temp, temp2, transfer;
        boolean hit = false;
        boolean first = false;
        for(int i = 0; i < super.blocks.size(); i++){
            temp = super.blocks.get(i);
            if(this == temp){first = true;}
            do{
                if((this.getY1() >= temp.getY2() - 2 && super.getY1() <= temp.getY2() + 2) && (x_avg >= temp.getX1() && x_avg <= temp.getX2())){
                    this.setY1(temp.getY2());
                    this.setX1(temp.getX1());
                    this.setX2(temp.getX2());
                    this.setY2(this.getY1()+y_len);
                    transfer = temp.next;
                    temp.next = this;
                    this.next = transfer;
                    temp2 = transfer;
                    do{
                        temp2.shift(y_len);
                        temp2 = temp2.next;
                    }while(temp2 != null);
                    return;
                }
                temp = temp.next;
            }while(temp != null);
        }
        //SORT blocks array by y value
        if(!first){
            //need to remove the linked list from where it was dragged from
            blocks.add(this);
        }


    }





}