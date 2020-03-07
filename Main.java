import java.awt.Color;
import java.util.ArrayList;

public class Main {

    /* The programme can build the Pictograph automatically after following rules:
     *
     * 1. Change the data according to the following format
     *    First line: Animal Name (1 word) + " populations in " + Location
     *    Other lines: Country Name + ',' + Number of Animals
     *
     * 2. Choose a suitable picture to represent the animal
     *
     * 3. Choose your favourite color
     *
     */

    public static final Color BACKGROUND_COLOR = new Color(102, 204, 255);
    public static final String ICON = "res/elephant.png";

    public static void main(String[] args) {
        ArrayList<String> content = new ArrayList<>();
        content = FileUtil.readFile("res/Animal_Data.csv");
        GUI.setGUI(content);
        GUI.drawGUI();
    }

}