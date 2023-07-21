import java.awt.*;
import java.util.LinkedList;

public class World {
    private int level;
    private LinkedList<Cell> cells = new LinkedList<>();
    private LinkedList<Block> blocks = new LinkedList<Block>();

    public void draw(Graphics g){
        for(Cell cell : cells){
            cell.draw(g);
        }
    }

    public void run(){
        for(Block block : Blocks){
            block.run();
        }
    }

    public boolean compare(){
        // compare elements from datasource data structures
    }
}
