import java.util.ArrayList;
public class ComputerBoard extends Board
{
    public ComputerBoard(String s)
    {
        super(s);
    }

    public String makePlayerMove(Move move)
    {
        // check CellStatus of the player's move
        CellStatus playerMove = getLayout().get(move.row()).get(move.col());

        // if move hits aircraft carrier and sinks it
        if (playerMove == CellStatus.AIRCRAFT_CARRIER && getFleet().updateFleet(ShipType.ST_AIRCRAFT_CARRIER))
        {
            // change HIT values to SUNK
            // iterate through board
            for (ArrayList<CellStatus> cs : getLayout())
            {
                for (CellStatus cell : cs)
                {
                    // check each cell status
                    // if the cell is an aircraft carrier, change it to sunk
                    if (cell == CellStatus.AIRCRAFT_CARRIER_HIT)
                    {
                        cell = CellStatus.AIRCRAFT_CARRIER_SUNK;
                    }
                }
            }
            return "You sank my Aircraft Carrier!";
        }

        // if move hits battleship and sinks it
        else if (playerMove == CellStatus.BATTLESHIP && getFleet().updateFleet(ShipType.ST_BATTLESHIP))
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
            return "You sank my Battleship!";
        }

        // if move hits cruiser and sinks it
        else if (playerMove == CellStatus.CRUISER && getFleet().updateFleet(ShipType.ST_CRUISER))
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
            return "You sank my Cruiser!";
        }

        // if move hits destroyer and sinks it
        else if (playerMove == CellStatus.DESTROYER && getFleet().updateFleet(ShipType.ST_DESTROYER))
        {
            // change HIT values to SUNK
            // iterate through board
            for (ArrayList<CellStatus> cs : getLayout())
            {
                for (CellStatus cell : cs)
                {
                    // check each cell status
                    // CellStatus cellStat = getLayout().get(?).get(?);
                    // if the cell is an aircraft carrier, change it to sunk
                    if (cell == CellStatus.DESTROYER_HIT)
                    {
                        cell = CellStatus.DESTROYER_SUNK;
                    }
                }
            }
            return "You sank my Destroyer!";
        }

        // if move hits SUB and sinks it
        else if (playerMove == CellStatus.SUB && getFleet().updateFleet(ShipType.ST_SUB))
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
            return "You sank my Sub!";
        }
        else
        {
            applyMoveToLayout(move);
            return null;
        }


    }

    @Override
    public String toString()
    {
        String computerBoard = "";
        for (ArrayList<CellStatus> cs : getLayout())
        {
            for (CellStatus cell : cs)
            {
                computerBoard += cell.toString().charAt(0) + " ";
            }
            computerBoard += '\n';
        }
        return computerBoard;
    }
}
