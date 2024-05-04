import java.util.Random;
import java.util.Scanner;

public class BattleshipDriver
{
    public static void main(String[] args)
    {
        // create game
        Game game = new Game();

        // create random object
        Random random = new Random();
        int randomNumber = random.nextInt(2);

        boolean playerGoesFirst;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to Battleship!");
        System.out.println(game.toString());

        // 50/50 to decide who goes first
        if (randomNumber == 0)
        {
            playerGoesFirst = true;
            System.out.println("You won the coin toss and get to go first.");

        }
        else
        {
            playerGoesFirst = false;
        }


        while (!game.userDefeated() && !game.computerDefeated())
        {
            if (playerGoesFirst)
            {
                System.out.print("Your turn: ");
                String userMove = keyboard.nextLine();
                // Move userMove = new Move(keyboard.nextLine());
                game.makePlayerMove(userMove);
            }
            else
            {
                System.out.println("Computer's turn. Press any key to continue.");
                game.makeComputerMove();
                System.out.println("Computer Chose: " + game.makeComputerMove()[0]);
            }

            System.out.println(game.toString());
            // update board
            // display board

            // change value to alternate turns
            playerGoesFirst = !playerGoesFirst;

            if (game.userDefeated())
            {
                System.out.println("You lost!");
            }
            if (game.computerDefeated())
            {
                System.out.println("You won!");
            }
        }
    }
}
