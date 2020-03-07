import java.awt.*;

public class MainPanel extends BackgroundPanel {
    public MainPanel() {
        super();
        setLayout(new GridBagLayout());
        setSize(800, 800);
    }

    @Override
    public void paint(Graphics g) {
        int x;
        super.paint(g);
        if (this.getHeight() <= this.getWidth())
            x = this.getHeight();
        else
            x = this.getWidth();
        GUI.setFontSize(x / (GUI.getNumOfCountries() + 2) / 2);
        GUI.setIconSize(x / (GUI.getNumOfCountries() + 3));
    }
}