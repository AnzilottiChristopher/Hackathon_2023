import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


// This is the start page for the quiz
public class Quiz extends JFrame implements ActionListener{

    private int width = 1000;
    private int height = 500;
    private JButton start;

    Quiz(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Quiz Portion!");
        heading.setBounds(width/2,height/10, 300, 45);
        // can change the color of the heading and font 
        add(heading);

        JButton start = new JButton("Start");
        start.setBounds(width/2, height/10 + height/10, 120, 25);
        start.setBackground(Color.LIGHT_GRAY);
        start.setForeground(Color.BLACK);
        start.addActionListener(this);
        add(start);

        setSize(width, height);
        setLocation(200, 150);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
                Question question1 = new Question();
                this.setVisible(false);
            
        }


    public static void main(String[] args){
        new Quiz();
    }

    
    
}
