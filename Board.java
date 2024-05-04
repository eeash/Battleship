import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public abstract class Board
{
    private ArrayList<ArrayList<CellStatus>> layout;
    private Fleet fleet;
    public static final int SIZE = 10;

    /* Board constructor takes filename as parameter, initializes
    layout, initially sets all cells to CellStatus.NOTHING. Gets
    information from file and adds ships to the layout. Initializes
    fleet.
    @param String s filename
     */
    public Board(String s)
    {
        // initialize fleet
        fleet = new Fleet();

        // initialize layout, sets all cells to CellStatus.NOTHING
        layout = new ArrayList<ArrayList<CellStatus>>();
        for (int i = 0; i < SIZE; i++)
        {
            ArrayList<CellStatus> col = new ArrayList<>();
            for (int x = 0; x < SIZE; x++)
            {
                col.add(CellStatus.NOTHING);
            }
            layout.add(col);

        }

        try
        {
            // create file and scanner objects from filename provided
            File file = new File(s);
            Scanner inputFile = new Scanner(file);

            // go through file, separating ship type, start, and end points
            // for rows and cols.
            while (inputFile.hasNextLine())
            {
                String fullLine = inputFile.nextLine();
                String[] positions = fullLine.split(" ");
                String shipType = positions[0];
                char startRow = positions[1].charAt(0);
                int startCol = Integer.parseInt(positions[1].substring(1)) - 1;
                char endRow = positions[2].charAt(0);
                int endCol = Integer.parseInt(positions[2].substring(1)) - 1;

                // turn startRow and endRow letters into numbers
                int startRowInt;
                int endRowInt;

                // start row
                if (startRow == 'A')
                {
                    startRowInt = 0;
                }
                else if (startRow == 'B')
                {
                    startRowInt = 1;
                }
                else if (startRow == 'C')
                {
                    startRowInt = 2;
                }
                else if (startRow == 'D')
                {
                    startRowInt = 3;
                }
                else if (startRow == 'E')
                {
                    startRowInt = 4;
                }
                else if (startRow == 'F')
                {
                    startRowInt = 5;
                }
                else if (startRow == 'G')
                {
                    startRowInt = 6;
                }
                else if (startRow == 'H')
                {
                    startRowInt = 7;
                }
                else if (startRow == 'I')
                {
                    startRowInt = 8;
                }
                else
                {
                    startRowInt = 9;
                }

                // end row
                if (endRow == 'A')
                {
                    endRowInt = 0;
                }
                else if (endRow == 'B')
                {
                    endRowInt = 1;
                }
                else if (endRow == 'C')
                {
                    endRowInt = 2;
                }
                else if (endRow == 'D')
                {
                    endRowInt = 3;
                }
                else if (endRow == 'E')
                {
                    endRowInt = 4;
                }
                else if (endRow == 'F')
                {
                    endRowInt = 5;
                }
                else if (endRow == 'G')
                {
                    endRowInt = 6;
                }
                else if (endRow == 'H')
                {
                    endRowInt = 7;
                }
                else if (endRow == 'I')
                {
                    endRowInt = 8;
                }
                else
                {
                    endRowInt = 9;
                }

                // use collected info to create ship at specified location
                for (int i = startRowInt; i <= endRowInt; i++)
                {
                    for (int x = startCol; x <= endCol; x++)
                    {
                        // check ship type and place correct ship on layout
                        if (shipType.equals("A"))
                        {
                            layout.get(i).set(x, CellStatus.AIRCRAFT_CARRIER);
                        }
                        else if (shipType.equals("B"))
                        {
                            layout.get(i).set(x, CellStatus.BATTLESHIP);
                        }
                        else if (shipType.equals("C"))
                        {
                            layout.get(i).set(x, CellStatus.CRUISER);
                        }
                        else if (shipType.equals("D"))
                        {
                            layout.get(i).set(x, CellStatus.DESTROYER);
                        }
                        else
                        {
                            layout.get(i).set(x, CellStatus.SUB);
                        }
                    }
                }
            }
            inputFile.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
    }

    public CellStatus applyMoveToLayout(Move move)
    {
        CellStatus currentStatus = layout.get(move.row()).get(move.col());
        if (currentStatus == CellStatus.NOTHING)
        {
            layout.get(move.row()).set(move.col(), CellStatus.NOTHING_HIT);
        }
        else if (currentStatus == CellStatus.AIRCRAFT_CARRIER)
        {
            layout.get(move.row()).set(move.col(), CellStatus.AIRCRAFT_CARRIER_HIT);
        }
        else if (currentStatus == CellStatus.BATTLESHIP)
        {
            layout.get(move.row()).set(move.col(), CellStatus.BATTLESHIP_HIT);
        }
        else if (currentStatus == CellStatus.CRUISER)
        {
            layout.get(move.row()).set(move.col(), CellStatus.CRUISER_HIT);
        }
        else if (currentStatus == CellStatus.DESTROYER)
        {
            layout.get(move.row()).set(move.col(), CellStatus.DESTROYER_HIT);
        }
        else if (currentStatus == CellStatus.SUB)
        {
            layout.get(move.row()).set(move.col(), CellStatus.SUB_HIT);
        }
        return currentStatus;
    }

    public boolean moveAvailable(Move move)
    {
        // create variable for the selected cell's current status
        CellStatus currentStatus = layout.get(move.row()).get(move.col());

        // if current status isn't hit or sunk, the move is available,
        // return true
        if (currentStatus == CellStatus.NOTHING)
        {
            return true;
        }
        else if (currentStatus == CellStatus.AIRCRAFT_CARRIER)
        {
            return true;
        }
        else if (currentStatus == CellStatus.BATTLESHIP)
        {
            return true;
        }
        else if (currentStatus == CellStatus.CRUISER)
        {
            return true;
        }
        else if (currentStatus == CellStatus.DESTROYER)
        {
            return true;
        }
        else if (currentStatus == CellStatus.SUB)
        {
            return true;
        }
        // otherwise, return false
        else
        {
            return false;
        }
    }

    public ArrayList<ArrayList<CellStatus>> getLayout()
    {
        return layout;
    }

    public Fleet getFleet()
    {
        return fleet;
    }

    public boolean gameOver()
    {
        if (fleet.gameOver())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
