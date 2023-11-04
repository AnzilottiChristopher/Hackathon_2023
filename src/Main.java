
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main 
{
    public static void main(String[] args) {
        //SwingUtilities.invokeLater(new ReactionGame()); 

        ReactionGame game = new ReactionGame(); 
        game.run(); 
        
        //System.out.println(ReactionGame.getReactionTime());
    } 
    }
