public class Main
{
    public static void main(String[] args)
    {
        RiddleScreen riddleScreen = new RiddleScreen();

        riddleScreen.initialize(); 

        ReactionGame game = new ReactionGame(); 
        game.run();
    }
}