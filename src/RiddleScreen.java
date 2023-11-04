import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RiddleScreen
{
    private JFrame frame;
    private JPanel panel;
    private CardLayout cardLayout;
    public void initialize() {
        frame = new JFrame("Riddle Screen");
        panel = new JPanel();
        cardLayout = new CardLayout();

        JLabel welcomeMessage = new JLabel("Welcome to the riddle portion!");
        JButton nextButton = new JButton("Next");
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(new GridBagLayout());


        gbc.gridx = GridBagConstraints.CENTER;
        gbc.gridy = GridBagConstraints.CENTER;
        panel.add(nextButton, gbc);


        gbc.gridx = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        panel.add(welcomeMessage, gbc);


        nextButton.addActionListener(e ->
        {
            panel.removeAll();
            panel.revalidate();
            panel.repaint();
        });

        // Use null layout
        //frame.setLayout(null);

        // Adjust the button's location to be within the visible area

        Font largerFont = new Font(welcomeMessage.getFont().getName(), Font.PLAIN, 24);
        welcomeMessage.setFont(largerFont);

        frame.add(panel);        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) (screenSize.getWidth() - frame.getWidth()) / 2;
        int centerY = (int) (screenSize.getHeight() - frame.getHeight()) / 2;
        frame.setLocation(centerX, centerY);

        frame.setVisible(true);

    }




}
