
// import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.FlowLayout;
// import java.awt.Graphics;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.Random;

// import javax.swing.BorderFactory;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JPanel;
// import javax.swing.JTextArea;
// import javax.swing.JTextField;
// import javax.swing.SwingUtilities;
// import javax.swing.Timer;


// public class ButtonListener implements ActionListener {
        
//         private int state;
        
//         private long startTime;
        
//         private final Random random;
        
//         private Timer timer;
        
//         public ButtonListener() {
//             this.state = 1;
//             this.random = new Random();
//         }

//         @Override
//         public void actionPerformed(ActionEvent event) {
//             switch (state) {
//             case 1:
//                 int delay = random.nextInt(2000) + 2000;
//                 timer = new Timer(delay, new TimerListener(this));
//                 timer.start();
//                 state = 2;
//                 break;
//             case 2:
//                 setEndTime(System.currentTimeMillis());
//                 eraseCircle();
//                 state = 1;
//                 break;
//             }
//         }

//         public int getState() {
//             return state;
//         }

//         public void setStartTime(long startTime) {
//             this.startTime = startTime;
//         }

//         public void setEndTime(long endTime) {
//             long elapsedTime = endTime - startTime;
//             setReactionTime(elapsedTime);
//             updateReactionTime();
//         }
        
//     }
