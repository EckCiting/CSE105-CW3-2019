import javax.swing.*;
import java.awt.*;

public class InnerLabel extends JLabel {
    public InnerLabel(String s) {
        super(s, JLabel.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setFont(new Font("Calibri", 0, GUI.getFontSize()));
    }
}