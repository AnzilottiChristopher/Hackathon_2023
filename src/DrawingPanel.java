
// import java.awt.BorderLayout;
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
// import javax.swing.JPanel;
// import javax.swing.JTextField;

// public class DrawingPanel extends JPanel {

//         private static final long serialVersionUID = 1L;
        
//         private boolean drawCircle;
        
//         public DrawingPanel() {
//             this.drawCircle = false;
//             this.setPreferredSize(new Dimension(300, 300));
//         }

//         public void setDrawCircle(boolean drawCircle) {
//             this.drawCircle = drawCircle;
//         }
        
//         @Override
//         protected void paintComponent(Graphics g) {
//             super.paintComponent(g);
            
//             if (drawCircle) {
//                 int centerX = getWidth() / 2;
//                 int centerY = getHeight() / 2;
//                 int radius = Math.min(getWidth(), getHeight()) * 9 / 20;
//                 int diameter = radius + radius;
//                 g.setColor(Color.MAGENTA);
//                 g.fillOval(centerX - radius, centerY - radius, diameter, diameter);
//             }
//         }
        
//     }