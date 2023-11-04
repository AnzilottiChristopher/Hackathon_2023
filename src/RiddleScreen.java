import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
public class RiddleScreen
{
    public void initialize()
    {
        JFrame frame = new JFrame("Riddle Screen");
        JPanel panel = new JPanel();

        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setSize(800, 800);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int centerX = (int) (screenSize.getWidth() - frame.getWidth()) / 2;
        int centerY = (int) (screenSize.getHeight() - frame.getHeight()) / 2;

        frame.setLocation(centerX, centerY);

        frame.setVisible(true);

    }
}
