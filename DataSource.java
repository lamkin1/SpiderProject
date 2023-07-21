import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class DataSource extends{
    private static DataSource instance;
    private int[] SpiderLocation = {0, 0};
    private int[] GameSize = {0, 0};
    private ArrayList<Block> blocks = new ArrayList<>;
    private ArrayList<Cell> cells = new ArrayList<Cell>;
    private int level;

    private DataSource(){
    }

    public static DataSource getInstance(){
        if(instance == null){
            instance = new DataSource();
        }
        return instance;
    }

    public void setSpiderLocation(int x, int y){
        SpiderLocation[0] = x;
        SpiderLocation[1] = y;
    }

    public void setGameSize(int width, int height){
        GameSize[0] = width;
        GameSize[1] = height;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int[] getSpiderLocation(){
        return SpiderLocation;
    }

    public int[] getGameSize(){
        return GameSize;
    }

    public int getLevel(){
        return level;
    }

    public ArrayList<Block> getBlockArrayInstance(){
        return blocks;
    }

    public ArrayList<Cell> getCellArrayInstance(){
        return cells;
    }
}
