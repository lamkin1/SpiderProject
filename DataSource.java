import java.util.LinkedList;
import java.util.Observable;

public class DataSource extends Observable {
    private static DataSource instance;
    private int SpiderX;
    private int SpiderY;
    private int GameWidth;
    private int GameHeight;

    private DataSource(){
    }

    public static DataSource getInstance(){
        if(instance == null){
            instance = new DataSource();
        }
        return instance;
    }

    public void setSpiderX(int x){
        SpiderX = x;
    }
    public int getSpiderX(){
        return SpiderX;
    }
    public void setSpiderY(int y){
        SpiderY = y;
    }
    public int getSpiderY(){
        return SpiderY;
    }
    public void setGameWidth(int width){
        GameWidth = width;
    }
    public int getGameWidth(){
        return GameWidth;
    }
    public void setGameHeight(int height){
        GameHeight = height;
    }
    public int getGameHeight(){
        return GameHeight;
    }
}
