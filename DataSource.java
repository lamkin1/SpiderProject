import java.util.ArrayList;

public class DataSource{
    private static DataSource instance;
    private int[] SpiderLocation = {0, 0};
    private ArrayList<Block> blocks = new ArrayList<>();
    private ArrayList<Cell> cells = new ArrayList<>();
    private ArrayList<Diamond> diamonds = new ArrayList<>();
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

    public int[] getSpiderLocation(){
        return SpiderLocation;
    }

    public void setLevel(int level){
        this.level = level;
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

    public void setDiamondArray(ArrayList<Diamond> Diamonds){
        for(Diamond D : Diamonds){
            diamonds.add(D);
        }
    }

    public void clearArrays(){
        blocks.clear();
        cells.clear();
        diamonds.clear();
    }
}
