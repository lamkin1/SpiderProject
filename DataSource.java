import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;

public class DataSource extends Observable {
    private static DataSource instance;
    private int[] SpiderLocation = {0, 0};
    private int[] GameSize = {0, 0};
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
        setChanged();
        notifyObservers();
    }

    public void setGameSize(int width, int height){
        GameSize[0] = width;
        GameSize[1] = height;
        setChanged();
        notifyObservers();
    }

    public void setLevel(int level){
        this.level = level;
        setChanged();
        notifyObservers();
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
}
