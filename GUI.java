import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GUI {

    private static String animalName = "Animal";
    private static String key;
    private static String myTitle = "Animal populations ";
    private static int numOfCountries = 0;
    private static int key_base = 1;
    private static int sum = 0;
    private static ArrayList<Data> data = new ArrayList<Data>();
    private static int fontSize = 42;
    private static int iconSize = 80;

    public static void setFontSize(int n) {
        fontSize = n;
    }

    public static void setIconSize(int n) {
        iconSize = n;
    }

    public static int getFontSize() {
        return fontSize;
    }

    public static int getIconSize() {
        return iconSize;
    }

    public static String getCountryName(int i) {
        return data.get(i).getCountryName();
    }

    public static int getAnimalNumber(int i) {
        return data.get(i).getAnimalNumber();
    }

    public static int getNumOfCountries() {
        return numOfCountries;
    }

    public static String getMyTitle() {
        return myTitle;
    }


    public static void setGUI(ArrayList<String> content) {
        myTitle = content.get(0); // First line is Title.
        String[] firstLine = content.get(0).split(" ");
        animalName = firstLine[0]; // First word of the first line is Animal name

        // Get the settings from the rest content
        for (int i = 1; i < content.size(); i++) {
            String[] restLine = content.get(i).split(",");
            int number = Integer.parseInt(restLine[1]);
            Data d = new Data(restLine[0], number);
            // Set the data automatically
            data.add(d);
            numOfCountries++;
            sum += number;
        }
        // Calculate the base
        int avg = sum / numOfCountries;
        while (avg / 10 != 0) {
            avg /= 10;
            key_base *= 10;
        }
        key = "= " + key_base + " " + animalName;
    }

    public static void drawGUI() {
        MainFrame frame = new MainFrame();
        MainPanel main = new MainPanel();
        BufferedImage img = FileUtil.readImage(Main.ICON);

        // Initialization for GridBagLayout
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;

        // Add top label
        InnerLabel top = new InnerLabel(getMyTitle());
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        main.add(top, constraints);

        // Add axis label
        //   left side
        constraints.gridwidth = 1;
        constraints.gridy = 1;
        InnerLabel CountryName = new InnerLabel("Country Name");
        constraints.weightx = 1;
        constraints.gridx = 0;
        main.add(CountryName, constraints);
        //   right side
        constraints.gridwidth = 3;
        InnerLabel AnimalNumber = new InnerLabel("Number of the " + animalName);
        constraints.weightx = 2;
        constraints.gridx = 1;
        main.add(AnimalNumber, constraints);

        // Add the mid content
        for (int i = 0; i < numOfCountries; i++) {
            constraints.gridy = i + 2;

            // Add country names at the left side
            InnerLabel left = new InnerLabel(getCountryName(i));
            constraints.gridwidth = 1;
            constraints.weightx = 1;
            constraints.gridx = 0;
            main.add(left, constraints);

            // Add animal number at the right side
            int n = getAnimalNumber(i) / key_base;
            double ratio = (getAnimalNumber(i) - n * key_base) * 1.0 / (1.0 * key_base); // Ratio that less than 1 key / 1 key

            IconPanel iconPanel = new IconPanel(img, n, ratio, data.get(i).getAnimalNumber());
            constraints.gridy = i + 2;
            constraints.gridwidth = 2;
            constraints.weightx = 2;
            constraints.gridx = 1;
            main.add(iconPanel, constraints);
        }

        // Add key panel
        constraints.weightx = 1;
        constraints.gridy = numOfCountries + 2;
        constraints.gridwidth = 1;
        InnerLabel key_text1 = new InnerLabel("       Key:");
        InnerLabel key_text2 = new InnerLabel(key + "(s)       ");
        key_text1.setBorder(null);
        key_text2.setBorder(null);
        IconPanel key_icon = new IconPanel(img, 1, 0, 0);
        key_icon.setBorder(null);

        //   combine text1, icon, text2 to key_panel
        InnerPanel keyPanel = new InnerPanel();
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        keyPanel.setLayout(new GridBagLayout());
        constraints.weightx = 1;
        constraints.gridx = 0;
        keyPanel.add(key_text1, constraints);
        constraints.weightx = 2;
        constraints.gridx = 1;
        keyPanel.add(key_icon, constraints);
        constraints.weightx = 0.5;
        constraints.gridx = 2;
        keyPanel.add(key_text2, constraints);

        //    add key_panel
        constraints.gridx = 0;
        constraints.gridy = numOfCountries + 4;
        constraints.gridwidth = 4;
        main.add(keyPanel, constraints);

        // Add all
        frame.add(main);
        frame.setVisible(true);
    }
}