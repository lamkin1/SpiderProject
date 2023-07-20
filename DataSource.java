import java.util.LinkedList;
import java.util.Observable;

public class DataSource extends Observable {
    private static DataSource instance;

    private DataSource(){
    }

    public static DataSource getInstance(){
        if(instance == null){
            instance = new DataSource();
        }
        return instance;
    }


}
