import java.awt.*;

public class LoopBlockDecorator extends Block{
    protected Block decoratedBlock;
    private int x_len = 30, y_len = 15;

    public LoopBlockDecorator(Block decoratedBlock,int x1, int y1){
        this.decoratedBlock = decoratedBlock;
        super.setName("Loop Block");
        super.setX1(x1);
        super.setX2(x1 + x_len);
        super.setY1(y1);
        super.setY2(y1 + y_len);
        super.setColor(Color.MAGENTA);
    }

    public LoopBlockDecorator(int x1, int y1){
        super.setName("Loop Block");
        super.setX1(x1);
        super.setX2(x1 + x_len);
        super.setY1(y1);
        super.setY2(y1 + y_len);
        super.setColor(Color.MAGENTA);
    }

    public void draw(Graphics g){
        g.setColor(super.getColor());
        g.fillRect(super.getX1(), super.getY1(), x_len, y_len);
        g.setColor(Color.black);
        g.drawString(super.getName(), super.getX1(), super.getY1() + 10);
    }

    public void add(Block b){
        decoratedBlock = b;
    }

    public void connect(){
        int x_avg = (super.getX1()+super.getX2())/2;
        Block temp, temp2, transfer;
        boolean first, reconnecting = false;
        if(DataSource.getInstance().getBlocksRunInstance().contains(this)){first = true;}else{first = false;}
        for(int i = 0; i < DataSource.getInstance().getBlockArrayInstance().size(); i++){
            temp = DataSource.getInstance().getBlockArrayInstance().get(i);
            if(this == temp){continue;}
            do{
                if((this.getY1() >= temp.getY2() - 5 && super.getY1() <= temp.getY2() + 5) && (x_avg >= temp.getX1() && x_avg <= temp.getX2())){
                    //System.out.println("hit");
                    DataSource.getInstance().getBlocksRunInstance().remove(this);
                    this.setY1(temp.getY2());
                    this.setX1(temp.getX1());
                    this.setX2(temp.getX2());
                    this.setY2(this.getY1()+y_len);
                    Block shift_temp = this.decoratedBlock;
                    int y_temp = this.getY1() + y_len;
                    while(shift_temp != null){
                        shift_temp.setY1(y_temp);
                        shift_temp.setX1(temp.getX1());
                        y_temp += y_len;
                    }

                    if(temp.next != this) {
                        Block anchor;
                        anchor = this;
                        while(anchor.next != null){anchor = anchor.next;}
                        transfer = temp.next;
                        this.prev = temp;
                        temp.next = this;
                        anchor.next = transfer;
                        temp2 = transfer;
                        do {
                            //DOESN'T SHIFT PROPERLY FOR MORE THAN 1 BLOCK BEING ADDED IN THE MIDDLE
                            if (temp2 != null) {
                                temp2.shift(y_len);
                                temp2.setX1(temp.getX1());
                                temp2 = temp2.next;
                            }
                        } while (temp2 != null);
                    }else{reconnecting = true;}
                    if(DataSource.getInstance().getBlocksRunInstance().contains(this)){
                        first = true;
                    }
                    break;
                }
                temp = temp.next;
            }while(temp != null);
        }
        //SORT blocks array by y value
        if(!first && !reconnecting){
            System.out.println("hit");
            prev.next = null;
            prev = null;
            DataSource.getInstance().getBlocksRunInstance().add(this);
        }
    }

}
