import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class World {
    private LevelHelper level = new LevelHelper();
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
        //have to change this
        String filePath = "C:\\Users\\miona\\Desktop\\testing for spider\\src\\Level_2.txt";

        List<NumberColorPair> numberColorPairs = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            bufferedReader.readLine();

            String line2 = bufferedReader.readLine();
            String[] numbers = line2.split(",");
            int[] intNumbers = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                intNumbers[i] = Integer.parseInt(numbers[i]);
            }

            // Read and parse line 3
            String line3 = bufferedReader.readLine();
            String[] colors = line3.split(",");

            // Pair the numbers and colors together and add to the list
            for (int i = 0; i < intNumbers.length && i < colors.length; i++) {
                NumberColorPair pair = new NumberColorPair(intNumbers[i], colors[i]);
                numberColorPairs.add(pair);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (NumberColorPair pair : numberColorPairs) {
            if(cells.get(pair.getNumber() - 1).getColor().equals(pair.getColor())){
                allCorrect = true;
            }
            else{
                allCorrect = false;
            }
        }
        System.out.println("Success, can move to next level");
        return allCorrect;
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
                System.out.println("step");
                spider.move();
                break;
            case "Turn":
                System.out.println("turn");
                spider.turn();
                break;
            case "Paint Red":
                System.out.println("paint red");
                break;
            case "Paint Blue":
                System.out.println("paint blue");
                break;
            case "Paint Green":
                System.out.println("paint green");
                break;
        }
    }

    public Spider getSpider(){
        return spider;
    }
}
