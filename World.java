import java.awt.*;
import java.util.ArrayList;

public class World {
    private LevelHelper level = new LevelHelper();
    private DataSource dataSource = DataSource.getInstance();
    private ArrayList<Cell> cells = dataSource.getCellArrayInstance();
    private ArrayList<Block> blocks = dataSource.getBlockArrayInstance();

    public void draw(Graphics g){
        for(Cell cell : cells){
            cell.draw(g);
        }
    }

    public void run(){
        for(Block block : blocks){
            block.run();
        }
    }

    /*
    public boolean compare(){
        // compare elements from datasource data structures
    }*/
}
