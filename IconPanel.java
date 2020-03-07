import java.awt.*;
import java.awt.image.BufferedImage;

public class IconPanel extends BackgroundPanel {
    private BufferedImage img;
    private int n; // Integer part
    private double p; // Ratio
    private int num; // Number of Animals

    public IconPanel(BufferedImage img, int n, double p, int num) {
        super();
        this.img = img;
        this.n = n;
        this.p = p;
        this.num = num;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < n; i++)
            g.drawImage(img, i * GUI.getIconSize(), 0, GUI.getIconSize(), GUI.getIconSize(), this);
        if (p != 0) {
            BufferedImage dimg = FileUtil.cropImage(img, p);
            g.drawImage(dimg, n * GUI.getIconSize(), 0, (int) (GUI.getIconSize() * p), GUI.getIconSize(), this);
        }
        if (num != 0) {
            g.setFont(new Font("Calibri", Font.PLAIN, (int) (GUI.getFontSize() / 1.2)));
            g.drawString(String.valueOf(num), (int) ((n + p) * GUI.getIconSize()), GUI.getIconSize() / 2);
        }
    }
}