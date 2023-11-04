import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

// code ripped from stackoverflow solution --> https://stackoverflow.com/questions/67723374/getting-reaction-time-after-pressing-a-key-game

public class ReactionGame implements Runnable {

    private ArrayList rTimes;

    private long reactionTime;
    
    private DrawingPanel drawingPanel;
    
    private JTextField reactionTimeField;
    

//constructor
    public ReactionGame() {
        this.reactionTime = 0L; 

        this.rTimes = new ArrayList<>();
    }
//end of constructor





    @Override
    public void run() {
        JFrame frame = new JFrame("Reaction Time Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(createUpperPanel(), BorderLayout.BEFORE_FIRST_LINE);
        this.drawingPanel = new DrawingPanel();
        frame.add(drawingPanel, BorderLayout.CENTER);
        frame.add(createButtonPanel(), BorderLayout.AFTER_LAST_LINE);
        
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    //end of run



    private JPanel createUpperPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        JPanel innerPanel = new JPanel(new FlowLayout());
        
        String instructions = "This game will test your reaction time. To play "
                + "the game, left-click on the Submit button.  After a random time "
                + "from 2 - 4 seconds, a circle will appear.  Left-click the "
                + "Submit button again.  Your reaction time will be displayed "
                + "above where the circle was.\n\n"
                + "Left-click the Submit button to start each round of the game.";
        JTextArea textArea = new JTextArea(7, 40);
        textArea.setEditable(false);
        textArea.setText(instructions);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        innerPanel.add(textArea);
        
        panel.add(innerPanel, BorderLayout.BEFORE_FIRST_LINE);
        
        innerPanel = new JPanel(new FlowLayout());
        
        JLabel label = new JLabel("Reaction Time:");
        innerPanel.add(label);
        
        reactionTimeField = new JTextField(5);
        reactionTimeField.setEditable(false);
        updateReactionTime();
        innerPanel.add(reactionTimeField);
        
        label = new JLabel("seconds");
        innerPanel.add(label);
        
        panel.add(innerPanel, BorderLayout.AFTER_LAST_LINE);
        
        return panel;
    }
    
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        JButton button = new JButton("Submit");
        button.addActionListener(new ButtonListener());
        panel.add(button);
        
        return panel;
    }
    
    public void setReactionTime(long reactionTime) {
        this.reactionTime = reactionTime;
    }

    public void drawCircle() {
        drawingPanel.setDrawCircle(true);
        drawingPanel.repaint();
    }
    
    public void eraseCircle() {
        drawingPanel.setDrawCircle(false);
        drawingPanel.repaint();
    }
    
    public void updateReactionTime() {
        double time = 0.001 * reactionTime;
        reactionTimeField.setText(String.format("%.3f", time)); 
        
        rTimes.add(time); //to index through, and store
        
        System.out.println(rTimes);


    } 

    public double getReactionTime(){
        return 0.001 * reactionTime;

    }
    


    /**
     * separate class for DrawingPanel
     */
    public class DrawingPanel extends JPanel {

        private static final long serialVersionUID = 1L;
        
        private boolean drawCircle;
        
        public DrawingPanel() {
            this.drawCircle = false;
            this.setPreferredSize(new Dimension(300, 300)); //size of Jpanel
        }

        public void setDrawCircle(boolean drawCircle) {
            this.drawCircle = drawCircle;
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            if (drawCircle) {
                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;
                int radius = Math.min(getWidth(), getHeight()) * 9 / 20;
                int diameter = radius + radius;
                g.setColor(Color.MAGENTA);
                g.fillOval(centerX - radius, centerY - radius, diameter, diameter);
            }
        }
        
    }
   //end of DrawingPanel 




/**
 * class for ButtonListener 
 */

    public class ButtonListener implements ActionListener {
        
        private int state;
        
        private long startTime;
        
        private final Random random;
        
        private Timer timer;
        
        public ButtonListener() {
            this.state = 1;
            this.random = new Random();
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            switch (state) {
            case 1:
                int delay = random.nextInt(2000) + 2000;
                timer = new Timer(delay, new TimerListener(this));
                timer.start();
                state = 2;
                break;
            case 2:
                setEndTime(System.currentTimeMillis());
                eraseCircle();
                state = 1;
                break;
            }
        }

        public int getState() {
            return state;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public void setEndTime(long endTime) {
            long elapsedTime = endTime - startTime;
            setReactionTime(elapsedTime);
            updateReactionTime();
        }
        
    }
   //end of ButtonListener  





    /**
     * class for TimerListener
     */
    public class TimerListener implements ActionListener {
        
        private final ButtonListener listener;

        public TimerListener(ButtonListener listener) {
            this.listener = listener;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            Timer timer = (Timer) event.getSource();
            timer.stop();
            
            if (listener.getState() == 2) {
                listener.setStartTime(System.currentTimeMillis());
                drawCircle();
            }
        }
        
    } 
}









// public class ReactionGame {   

//     private long reactionTime;  

//     final JFrame parent = new JFrame();
//     private JButton button = new JButton();


//     public ReactionGame(){

        

//         button.setText("Welcome to the Reaction Time Test! \n Click anywhere on the screen to begin your reaction time test!" ); 
//         button.setBounds(600, 50, 100, 100);
//         parent.add(button);
//         parent.pack(); //not sure what this
//         parent.setVisible(true); 

//         parent.setBounds(500, 100, 800, 800); 

//         // button.addActionListener(new java.awt.event.ActionListener() {
//         //     @Override
//         //     public void actionPerformed(java.awt.event.ActionEvent evt) {
//         //         String name = JOptionPane.showInputDialog(parent,
//         //                 "What is your name?", null);
//         //     }
//         // }); 
//         this.reactionTime = 0L;
//     }

// public static void initialize()
//     {
        

        
//     } 

//     public void setReactionTime(long reactionTime) {
//         this.reactionTime = reactionTime;
//     }

//     public void drawCircle() {
//         drawingPanel.setDrawCircle(true);
//         drawingPanel.repaint();
//     }
    
//     public void eraseCircle() {
//         drawingPanel.setDrawCircle(false);
//         drawingPanel.repaint();
//     }
    
//     public void updateReactionTime() {
//         double time = 0.001 * reactionTime;
//         reactionTimeField.setText(String.format("%.3f", time));
//     }

    
// }
