import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    public BackgroundPanel() {
        super();
        setBackground(Main.BACKGROUND_COLOR);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}