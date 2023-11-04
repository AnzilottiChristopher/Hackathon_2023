import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Question extends JFrame implements ActionListener{

    private int width = 1000;
    private int height = 500;

    private JRadioButton answerButton1;
    private JRadioButton answerButton2;
    private JRadioButton answerButton3;
    private JRadioButton answerButton4;


    Question(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // JLabel heading = new JLabel("Question Number");
        // heading.setBounds(width/2,height/10, 300, 45);
        // // can change the color of the heading and font 
        // add(heading);

        // create questions here
        createQuestion("1. Which do you prefer?");
        createAnswers("Leveling up over the course of a game", "Figuring out tough puzzles", "Jumping over and around obstacles", "Shooting other players");

        setSize(width, height);
        setLocation(200, 150);
        setVisible(true);
    }

    public void createQuestion(String question){

        JLabel questionLabel = new JLabel(question);
        questionLabel.setBounds(100, 50, 900, 30);
        questionLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(questionLabel);

        setVisible(true);
    }

    public void createAnswers(String answer, String answer2, String answer3, String answer4){

        // first answer
        answerButton1 = new JRadioButton(answer);
        answerButton1.setBounds(100, 100, 900, 30);

        add(answerButton1);

        // second answer
        answerButton2 = new JRadioButton(answer2);
        answerButton2.setBounds(100, 150, 900, 30);

        add(answerButton2);

        // third answer
        answerButton3 = new JRadioButton(answer3);
        answerButton3.setBounds(100, 200, 900, 30);

        add(answerButton3);

        // fourth answer
        answerButton4 = new JRadioButton(answer4);
        answerButton4.setBounds(100, 250, 900, 30);

        add(answerButton4);

        ButtonGroup groupOptions = new ButtonGroup();
        groupOptions.add(answerButton1);
        groupOptions.add(answerButton2);
        groupOptions.add(answerButton3);
        groupOptions.add(answerButton4);



    }






    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
    public static void main(String[] args){
        new Question();
    }
    
}
