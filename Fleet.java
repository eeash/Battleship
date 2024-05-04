public class Fleet
{
    // instance variables
    private Ship battleShip;
    private Ship aircraftCarrier;
    private Ship cruiser;
    private Ship sub;
    private Ship destroyer;

    public Fleet()
    {
        this.battleShip = new Battleship();
        this.aircraftCarrier = new AircraftCarrier();
        this.cruiser = new Cruiser();
        this.sub = new Sub();
        this.destroyer = new Destroyer();
    }

    public boolean updateFleet(ShipType type)
    {
        if (type == ShipType.ST_AIRCRAFT_CARRIER)
        {
            aircraftCarrier.hit();
            if (aircraftCarrier.getSunk())
            {
                return true;
            }
            else
                return false;
        }
        else if (type == ShipType.ST_BATTLESHIP)
        {
            battleShip.hit();
            if (battleShip.getSunk())
            {
                return true;
            }
            else
                return false;
        }
        else if (type == ShipType.ST_CRUISER)
        {
            cruiser.hit();
            if (cruiser.getSunk())
            {
                return true;
            }
            else
                return false;
        }
        else if (type == ShipType.ST_SUB)
        {
            sub.hit();
            if (sub.getSunk())
            {
                return true;
            }
            else
                return false;
        }
        else
        {
            destroyer.hit();
            if (destroyer.getSunk())
            {
                return true;
            }
            else
                return false;
        }
    }

    public boolean gameOver()
    {
        if (battleShip.getSunk() && aircraftCarrier.getSunk() &&
                cruiser.getSunk() && sub.getSunk() && destroyer.getSunk())
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}
