import java.awt.*;
import java.util.LinkedList;

public class World {
    private LevelHelper level = new LevelHelper();

    private LinkedList<Cell> cells = new LinkedList<>(); // should be from datasource
    private LinkedList<Block> blocks = new LinkedList<Block>(); // should be from datasource

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

    public boolean compare(){
        // compare elements from datasource data structures
    }
}
