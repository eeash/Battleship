import java.lang.reflect.Array;

public class Game
{
    private ComputerBoard computer;
    private UserBoard player;

    public Game()
    {
        computer = new ComputerBoard("compFleet.txt");
        player = new UserBoard("userFleet.txt");
    }

    public String[] makeComputerMove()
    {
        return player.makeComputerMove();
    }

    public String makePlayerMove(String playerMove)
    {
        Move playerMoveMove = new Move(playerMove);
        return computer.makePlayerMove(playerMoveMove);
    }

    public boolean userDefeated()
    {
        if (player.gameOver())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean computerDefeated()
    {
        if (computer.gameOver())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String toString()
    {
        return String.format("User Board:\n%s\nComputer Board:\n%s",
                player.toString(), computer.toString());
    }
}
