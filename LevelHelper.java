import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class LevelHelper {
    private int level;
    private int size;
    private int spiderSpawn;
    private List<Integer> diamondCellList;
    private List<String> diamondColorList;
    private Spider spider;
    public LevelHelper(){
        diamondCellList = new ArrayList<Integer>();
        diamondColorList = new ArrayList<String>();
    }

    public void load(int level){
        this.level = level;
        diamondCellList.clear();
        diamondColorList.clear();
        DataSource.getInstance().clearArrays();

        String fileName = "Level_" + level + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            size = Integer.parseInt(reader.readLine());
            String input = reader.readLine();
            for (int i = 0; i < input.split(",").length; i++){
                diamondCellList.add(Integer.parseInt(input.split(",")[i]));
            }
            input = reader.readLine();
            for (int i = 0; i < input.split(",").length; i++){
                diamondColorList.add(input.split(",")[i]);
            }
            spiderSpawn = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.err.println("Error reading file " + fileName + ": " + e.getMessage());
        }
        fillDataSource();
    }

    private void fillDataSource(){
        Diamond d;
        Color color;
        int cellNum;

        int x_default = 200;
        x_default -= size*13;
        int x = x_default;
        int y_default = 200;
        y_default -= size*13;
        int y = y_default;
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

        HashMap<String, Color> colorMap = new HashMap<>();
        colorMap.put("red", Color.RED);
        colorMap.put("blue", Color.BLUE);
        colorMap.put("green", Color.GREEN);

        for(int i = 0; i < diamondCellList.size(); i++) {
            cellNum = diamondCellList.get(i);
            color = colorMap.get(diamondColorList.get(i));
            System.out.println(x_default);
            d = new Diamond(color,x_default + (x_length * (((cellNum % size)== 0) ? size-1 : ((cellNum % size) - 1))),y_default + (int) (y_length * ((Math.floor(cellNum % size) == 0) ? Math.floor(cellNum/size) - 1 : Math.floor(cellNum / size))));
            DataSource.getInstance().getDiamondArrayInstance().add(d);
        }

        int spiderCell = spiderSpawn;
        DataSource.getInstance().setSpiderLocation(x_default + 10 + x_length * (((spiderCell % size)== 0) ? size-1 : ((spiderCell % size) - 1)),x_default + (int) (y_length * ((Math.floor(spiderCell % size) == 0) ? Math.floor(spiderCell/size) - 1 : Math.floor(spiderCell / size))));
        DataSource.getInstance().setOgSpiderLocation(x_default + 10 + x_length * (((spiderCell % size)== 0) ? size-1 : ((spiderCell % size) - 1)),x_default + (int) (y_length * ((Math.floor(spiderCell % size) == 0) ? Math.floor(spiderCell/size) - 1 : Math.floor(spiderCell / size))));

        for(Cell cell : DataSource.getInstance().getCellArrayInstance()) {
            for (Diamond diamond : DataSource.getInstance().getDiamondArrayInstance()) {
                if((diamond.getX() > cell.getX() && diamond.getX() < (cell.getX() + 35)) && ((diamond.getY() > cell.getY()) && (diamond.getY() < (cell.getY() + 35)))){
                    cell.setHasDiamond(true);
                    cell.setDiamondColor(diamond.getColor());
                }
            }
        }
    }
}
