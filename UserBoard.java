import java.util.ArrayList;
import java.util.Random;

public class UserBoard extends Board
{
    private ArrayList<Move> moves;
    private Random rand;

    public UserBoard(String s)
    {
        super(s);
        rand = new Random();
        // create arraylist
        moves = new ArrayList<Move>();
        // add all possible moves to arraylist
        for (int i = 0; i < 10; i++)
        {
            for (int x = 0; x < 10; x++)
            {
                moves.add(new Move(i,x));
            }
        }
    }

    public String[] makeComputerMove()
    {
        String[] computerString = new String[2];
        int randomIndex = rand.nextInt(moves.size());
        // selects random move for the computer
        Move computerMove = moves.get(randomIndex);
        moves.remove(computerMove);
        computerString[0] = computerMove.toString();

        // check CellStatus of the computer's move
        CellStatus computerMoveStat = getLayout().get(computerMove.row()).get(computerMove.col());

        // if move hits aircraft carrier and sinks it
        if (computerMoveStat == CellStatus.AIRCRAFT_CARRIER)
        {
            if(getFleet().updateFleet(ShipType.ST_AIRCRAFT_CARRIER))
            {
                // change HIT values to SUNK
                for (ArrayList<CellStatus> cs : getLayout()) {
                    for (CellStatus cell : cs) {
                        // check each cell status
                        // if the cell is an aircraft carrier, change it to sunk
                        if (cell == CellStatus.AIRCRAFT_CARRIER_HIT) {
                            cell = CellStatus.AIRCRAFT_CARRIER_SUNK;
                        }
                    }
                }
                computerString[1] = "You sank my Aircraft Carrier!";
                System.out.println(computerString[1]);
            }
            return computerString;
        }

        // if move hits battleship and sinks it
        else if (computerMoveStat == CellStatus.BATTLESHIP && getFleet().updateFleet(ShipType.ST_BATTLESHIP))
        {
            // change HIT values to SUNK
            // iterate through board
            for (ArrayList<CellStatus> cs : getLayout())
            {
                for (CellStatus cell : cs)
                {
                    // check each cell status
                    // if the cell is a battleship, change it to sunk
                    if (cell == CellStatus.BATTLESHIP_HIT)
                    {
                        cell = CellStatus.BATTLESHIP_SUNK;
                    }
                }
            }
            computerString[1] = "You sank my Battleship!";
            return computerString;
        }

        // if move hits cruiser and sinks it
        else if (computerMoveStat == CellStatus.CRUISER && getFleet().updateFleet(ShipType.ST_CRUISER))
        {
            // change HIT values to SUNK
            // iterate through board
            for (ArrayList<CellStatus> cs : getLayout())
            {
                for (CellStatus cell : cs)
                {
                    // check each cell status
                    // if the cell is a battleship, change it to sunk
                    if (cell == CellStatus.BATTLESHIP_HIT)
                    {
                        cell = CellStatus.BATTLESHIP_SUNK;
                    }
                }
            }
            computerString[1] = "You sank my Cruiser!";
            return computerString;
        }

        // if move hits destroyer and sinks it
        else if (computerMoveStat == CellStatus.DESTROYER && getFleet().updateFleet(ShipType.ST_DESTROYER))
        {
            // change HIT values to SUNK
            // iterate through board
            for (ArrayList<CellStatus> cs : getLayout())
            {
                for (CellStatus cell : cs)
                {
                    // check each cell status
                    // if the cell is an aircraft carrier, change it to sunk
                    if (cell == CellStatus.DESTROYER_HIT)
                    {
                        cell = CellStatus.DESTROYER_SUNK;
                    }
                }
            }
            computerString[1] = "You sank my Destroyer!";
            System.out.println(computerString[1]);
            return computerString;
        }

        // if move hits SUB and sinks it
        else if (computerMoveStat == CellStatus.SUB && getFleet().updateFleet(ShipType.ST_SUB))
        {
            // change HIT values to SUNK
            // iterate through board
            for (ArrayList<CellStatus> cs : getLayout())
            {
                for (CellStatus cell : cs)
                {
                    // check each cell status
                    // if the cell is an aircraft carrier, change it to sunk
                    if (cell == CellStatus.SUB_HIT)
                    {
                        cell = CellStatus.SUB_SUNK;
                    }
                }
            }
            computerString[1] = "You sank my Sub!";
            return computerString;
        }
        else
        {
            applyMoveToLayout(computerMove);
            computerString[1] = null;
            return computerString;
        }
    }

    @Override
    public String toString()
    {
        {
            String userBoard = "";
            for (ArrayList<CellStatus> cs : getLayout())
            {
                for (CellStatus cell : cs)
                {
                    userBoard += cell.toString().charAt(1) + " ";
                }
                userBoard += '\n';
            }
            return userBoard;
        }
    }
}
