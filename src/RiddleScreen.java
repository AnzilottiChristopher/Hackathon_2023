import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RiddleScreen
{
    private JFrame mainFrame;
    private JPanel startPanel;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    public void initialize() {
        //Main Frame
        mainFrame = new JFrame("Riddle Screen");

        //Starting Panel
        startPanel = new JPanel();



        //Start messages
        JLabel welcomeMessage = new JLabel("Welcome to the riddle portion!");
        JButton nextButton = new JButton("Next");
        GridBagConstraints gbc = new GridBagConstraints();
        startPanel.setLayout(new GridBagLayout());

        //Moving things to center
        gbc.gridx = 0;
        gbc.gridy = 1;
        startPanel.add(nextButton, gbc);


        gbc.gridx = 0;
        gbc.gridy = 0;
        startPanel.add(welcomeMessage, gbc);


        //Creating Seperate panel
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        cardPanel.add(startPanel, "Card1");

        JPanel card2 = new JPanel();
        card2.add(new JLabel("Card 2 Content"));
        cardPanel.add(card2, "Card2");

        //Listening for button press and changing screen
        nextButton.addActionListener(e ->
        {
            startPanel.removeAll();
            startPanel.revalidate();
            startPanel.repaint();
            cardLayout.next(cardPanel);
        });



        // Adjust the button's location to be within the visible area

        //Adjusting font
        Font largerFont = new Font(welcomeMessage.getFont().getName(), Font.PLAIN, 24);
        welcomeMessage.setFont(largerFont);

        mainFrame.add(cardPanel);

        cardLayout.show(cardPanel, "Card1");

        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 800);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) (screenSize.getWidth() - mainFrame.getWidth()) / 2;
        int centerY = (int) (screenSize.getHeight() - mainFrame.getHeight()) / 2;
        mainFrame.setLocation(centerX, centerY);

        mainFrame.setVisible(true);

    }




}
