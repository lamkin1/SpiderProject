import javax.xml.crypto.Data;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class World {
    private Spider spider = new Spider(DataSource.getInstance().getSpiderLocation()[0],DataSource.getInstance().getSpiderLocation()[1],"up");

    public void draw(Graphics g){
        for(Cell cell : DataSource.getInstance().getCellArrayInstance()){
            cell.draw(g);
        }

        for(Diamond diamond : DataSource.getInstance().getDiamondArrayInstance()){
            diamond.draw(g);
        }
        spider.draw(g);

    }

    public boolean compare(){
        for(Cell cell : DataSource.getInstance().getCellArrayInstance()){
            if(cell.getHasDiamond()){
                if(cell.getColor() != cell.getDiamondColor()){
                    return false;
                }
            }
        }
        return true;

    }

    public void play(){
        spiderPlayStart();
        DataSource.getInstance().getBlocksRunInstance().sort(Comparator.comparing(Block::getY1));
        for(Block block : DataSource.getInstance().getBlocksRunInstance()){
            run(block);
            Block temp = block.next;
            while(temp != null){
                run(temp);
                temp = temp.next;
            }
        }
        Boolean b = compare();
        if(b == false){
        }
    }

    public boolean run(Block b){
        Boolean returned = false;
        switch( b.getName()){

            case "Step":
                returned = spider.move();
                return returned;
            case "Turn":
                spider.turn();
                break;
            case "Paint Red":
                for(Cell cell : DataSource.getInstance().getCellArrayInstance()){
                    if(cell.getX() == (spider.getSpiderX()-10) && cell.getY() == spider.getSpiderY()){
                        cell.setColor(Color.red);
                        break;
                    }
                }
                break;
            case "Paint Blue":
                for(Cell cell : DataSource.getInstance().getCellArrayInstance()){
                    if(cell.getX() == (spider.getSpiderX()-10) && cell.getY() == spider.getSpiderY()){
                        cell.setColor(Color.blue);
                        break;
                    }
                }
                break;
            case "Paint Green":
                for(Cell cell : DataSource.getInstance().getCellArrayInstance()){
                    if(cell.getX() == (spider.getSpiderX()-10) && cell.getY() == spider.getSpiderY()){
                        cell.setColor(Color.green);
                        break;
                    }
                }
                break;
            case "Loop Block":
                Block block = ((LoopBlockDecorator)b).decoratedBlock;
                if(block == null){break;}
                returned = false;
                Block temp = block;
                while(returned == false) {
                    System.out.println(temp.getName());
                    returned = run(temp);
                    temp = temp.next;
                    if(temp == null){
                        temp = block;
                    }
                }
                break;
        }
        return false;
    }

    public Spider getSpider(){
        return spider;
    }

    public void spiderPlayStart(){
        String d = spider.getDirection();
        int level = DataSource.getInstance().getLevel();
        spider.setspiderX(DataSource.getInstance().getOgSpiderLocation()[0]);
        spider.setSpiderY(DataSource.getInstance().getOgSpiderLocation()[1]);
        if(level == 1 || level == 2 || level == 3){
            switch(d){
                case "up":
                    break;
                case "down":
                    spider.rotateImage(180);
                    break;
                case "right":
                    spider.rotateImage(270);
                    break;
                case "left":
                    spider.rotateImage(90);
                    break;
            }
            spider.setDirection("up");
        } else if(level == 4 || level == 5 || level == 9){
            switch(d){
                case "up":
                    spider.rotateImage(180);
                    break;
                case "down":
                    break;
                case "right":
                    spider.rotateImage(90);
                    break;
                case "left":
                    spider.rotateImage(270);
                    break;
            }
            spider.setDirection("down");
        } else if(level == 6 || level == 7 || level == 8 || level == 10 || level == 11 || level == 13 || level == 14 || level == 15){
            switch(d){
                case "up":
                    spider.rotateImage(90);
                    break;
                case "down":
                    spider.rotateImage(270);
                    break;
                case "right":
                    break;
                case "left":
                    spider.rotateImage(180);
                    break;
            }
            spider.setDirection("right");
        } else if(level == 12){
            switch(d){
                case "up":
                    spider.rotateImage(270);
                    break;
                case "down":
                    spider.rotateImage(90);
                    break;
                case "right":
                    spider.rotateImage(180);
                    break;
                case "left":
                    break;
            }
            spider.setDirection("left");
        }
    }
}
