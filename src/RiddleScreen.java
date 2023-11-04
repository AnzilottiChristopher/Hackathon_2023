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
        JButton nextButton = new JButton("Start");
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
        card2.add(new JLabel("Riddle"));
        cardPanel.add(card2, "Card2");

        //Listening for button press and changing screen
        nextButton.addActionListener(e ->
        {
            startPanel.removeAll();
            startPanel.revalidate();
            startPanel.repaint();
            Riddle();
        });



        // Adjust the button's location to be within the visible area

        //Adjusting font
        Font largerFont = new Font(welcomeMessage.getFont().getName(), Font.PLAIN, 24);
        welcomeMessage.setFont(largerFont);

        mainFrame.add(cardPanel);

        cardLayout.show(cardPanel, "Card1");

        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(1000, 800);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) (screenSize.getWidth() - mainFrame.getWidth()) / 2;
        int centerY = (int) (screenSize.getHeight() - mainFrame.getHeight()) / 2;
        mainFrame.setLocation(centerX, centerY);

        mainFrame.setVisible(true);

    }

    private void Riddle()
    {
        cardLayout.next(cardPanel);

        //Setting main panel
        JPanel riddlePanel = new JPanel();
        riddlePanel.setLayout(new BorderLayout());

        //Creating Buttons
        JButton correctAnswer = new JButton("None");
        JButton falseAnswer = new JButton("5");

        //Buttons Sizes
//        Dimension buttonSize = new Dimension(50, 50);
//        correctAnswer.setPreferredSize(buttonSize);
//        falseAnswer.setPreferredSize(buttonSize);

        correctAnswer.addActionListener(e ->
        {
            Variables.puzzle = Variables.puzzle + 5;
            ReactionGame reactionGame = new ReactionGame();
            mainFrame.dispose();
            reactionGame.run();
            //System.out.println(Variables.puzzle);
        });
        falseAnswer.addActionListener(e ->
        {
            Variables.puzzle = Variables.puzzle - 5;
            ReactionGame reactionGame = new ReactionGame();
            mainFrame.dispose();
            reactionGame.run();
        });

        JTextArea riddle = new JTextArea("In a certain city, 5% of all the people in town have unlisted phone numbers. " +
                "If you select 100 names at random from that city's phone directory, how many people selected " +
                "will have unlisted phone numbers?");

        Font largerFont = new Font(riddle.getFont().getName(), Font.PLAIN, 24);

        //Font stuff
        riddle.setFont(largerFont);
        riddle.setWrapStyleWord(true);
        riddle.setLineWrap(true);
        riddle.setOpaque(false);
        riddle.setEditable(false);
        riddle.setFocusable(false);


        //Adding components
        riddlePanel.add(riddle, BorderLayout.NORTH);
        riddlePanel.add(correctAnswer, BorderLayout.EAST);
        riddlePanel.add(falseAnswer, BorderLayout.WEST);

        //Adding riddlePanel to cardPanel
        cardPanel.add(riddlePanel, "RiddleCard");

        //Showing riddleCard
        cardLayout.show(cardPanel, "RiddleCard");
    }



}
