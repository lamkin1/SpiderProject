import java.awt.Color;

public class NumberColorPair {
    private int number;
    private String color;
    private Color c;

    public NumberColorPair(int number, String color) {
        this.number = number;
        this.color = color.toLowerCase();
        this.c = getColorByName(color);
    }

    private Color getColorByName(String colorName) {
        switch (colorName.toLowerCase()) {
            case "red":
                return Color.RED;
            case "green":
                return Color.GREEN;
            case "blue":
                return Color.BLUE;
            // Add more cases for other predefined colors as needed
            default:
                return null; // Return null for unsupported color names
        }
    }

    public int getNumber() {
        return number;
    }

    public Color getColor() {
        return c;
    }

    @Override
    public String toString() {
        return "Number: " + number + ", Color: " + color;
    }
}