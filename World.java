import javax.xml.crypto.Data;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class World {
    private ArrayList<Cell> cells = DataSource.getInstance().getCellArrayInstance();
    private ArrayList<Block> blocks = DataSource.getInstance().getBlockArrayInstance();
    private boolean allCorrect = false;
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
        //need to finish working on this
        for(Cell cell : DataSource.getInstance().getCellArrayInstance()){
            if(cell.getHasDiamond()){
                if(cell.getColor() != cell.getDiamondColor()){
                    return false;
                }
            }
        }
        System.out.println("true hit");
        allCorrect = true;
        return true;

    }

//    public boolean compare(){
//        //have to change this
//        String filePath = "C:\\Users\\miona\\Desktop\\testing for spider\\src\\Level_2.txt";
//
//        List<NumberColorPair> numberColorPairs = new ArrayList<>();
//
//        try (FileReader fileReader = new FileReader(filePath);
//             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
//
//            bufferedReader.readLine();
//
//            String line2 = bufferedReader.readLine();
//            String[] numbers = line2.split(",");
//            int[] intNumbers = new int[numbers.length];
//            for (int i = 0; i < numbers.length; i++) {
//                intNumbers[i] = Integer.parseInt(numbers[i]);
//            }
//
//            // Read and parse line 3
//            String line3 = bufferedReader.readLine();
//            String[] colors = line3.split(",");
//
//            // Pair the numbers and colors together and add to the list
//            for (int i = 0; i < intNumbers.length && i < colors.length; i++) {
//                NumberColorPair pair = new NumberColorPair(intNumbers[i], colors[i]);
//                numberColorPairs.add(pair);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        for (NumberColorPair pair : numberColorPairs) {
//            if(cells.get(pair.getNumber() - 1).getColor().equals(pair.getColor())){
//                allCorrect = true;
//            }
//            else{
//                allCorrect = false;
//            }
//        }
//        System.out.println("Success, can move to next level");
//        return allCorrect;
//    }

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
            System.out.println("works");
        }
    }

    public boolean run(Block b){
        Boolean returned = false;
        switch( b.getName()){

            case "Step":
                //System.out.println("step");
                returned = spider.move();
                return returned;
            case "Turn":
                //System.out.println("turn");
                spider.turn();
                break;
            case "Paint Red":
                //System.out.println("paint red");
                for(Cell cell : DataSource.getInstance().getCellArrayInstance()){
                    if(cell.getX() == (spider.getSpiderX()-10) && cell.getY() == spider.getSpiderY()){
                        cell.setColor(Color.red);
                        break;
                    }
                }
                break;
            case "Paint Blue":
                //System.out.println("paint blue");
                for(Cell cell : DataSource.getInstance().getCellArrayInstance()){
                    if(cell.getX() == (spider.getSpiderX()-10) && cell.getY() == spider.getSpiderY()){
                        cell.setColor(Color.blue);
                        break;
                    }
                }
                break;
            case "Paint Green":
                //System.out.println("paint green");
                for(Cell cell : DataSource.getInstance().getCellArrayInstance()){
                    if(cell.getX() == (spider.getSpiderX()-10) && cell.getY() == spider.getSpiderY()){
                        cell.setColor(Color.green);
                        break;
                    }
                }
                break;
            case "Loop Block":
                System.out.println("looping");
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

    public Boolean getAllCorrect(){
        return allCorrect;
    }

}
