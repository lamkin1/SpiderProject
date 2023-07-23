import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LevelHelper {
    private int level;
    private int size;
    private int spiderSpawn;
    private List<Integer> diamondCellList;
    private List<String> diamondColorList;
    public LevelHelper(){
        diamondCellList = new ArrayList<Integer>();
        diamondColorList = new ArrayList<String>();
    }

    //Level Format:
    //Line 1: n for nxn size
    //Line 2: List of cells that diamonds will be in
    //line 3: List of colors for the diamonds in the previous line
    //Line 4: Spider spawn cell

    public void load(int level){
        this.level = level;

        String fileName = "Level_" + level + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            size = Integer.parseInt(reader.readLine());
            String input = reader.readLine();
            for (int i = 0; i < input.split(",").length; i++){
                diamondCellList.add(Integer.parseInt(input.split(",")[i]));
            }
            System.out.println(diamondCellList);
            input = reader.readLine();
            for (int i = 0; i < input.split(",").length; i++){
                diamondColorList.add(input.split(",")[i]);
            }
            System.out.println(diamondColorList);
            spiderSpawn = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.err.println("Error reading file " + fileName + ": " + e.getMessage());
        }
        fillDataSource();

    }

    public int getLevel(){
        return level;
    }

    private void fillDataSource(){
        int x_default = 200;
        x_default -= size*13;
        int x = x_default;
        int y = 200;
        y -= size*13;
        ArrayList<Cell> cells = DataSource.getInstance().getCellArrayInstance();
        int x_length = 35;
        int y_length = 35;
        for(int i = 0; i < size; i++){
            for(int j = 0; j< size; j++){
                Cell c = new Cell(x, y);
                cells.add(c);
                x += x_length;
            }
            x = x_default;
            y += y_length;
        }
    }
}
