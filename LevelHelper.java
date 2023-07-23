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
    //

    public void load(int level){
        this.level = level;

        String fileName = "Level_" + level + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;
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
        } catch (IOException e) {
            System.err.println("Error reading file " + fileName + ": " + e.getMessage());
        }

    }

    public int getLevel(){
        return level;
    }

    //
}
