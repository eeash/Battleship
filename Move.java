public class Move
{
    // instance variables
    private int row;
    private int col;

    /* Move constructor creates a move object from 2 integers
    @param int r for row value
    @param int c for column value
     */
    public Move(int r, int c)
    {
        this.row = r;
        this.col = c;
    }

    /*
    secondary constructor that creates a move object from a string
    consisting of a letter and a number e.g. F5
    @param String s
     */
    public Move(String s)
    {
        // select the first character of the string
        String rowStr = s.substring(0,1);

        // assign letter to associated number
        if (rowStr.equals("A"))
        {
            this.row = 0;
        }
        else if (rowStr.equals("B"))
        {
            this.row = 1;
        }
        else if (rowStr.equals("C"))
        {
            this.row = 2;
        }
        else if (rowStr.equals("D"))
        {
            this.row = 3;
        }
        else if (rowStr.equals("E"))
        {
            this.row = 4;
        }
        else if (rowStr.equals("F"))
        {
            this.row = 5;
        }
        else if (rowStr.equals("G"))
        {
            this.row = 6;
        }
        else if (rowStr.equals("H"))
        {
            this.row = 7;
        }
        else if (rowStr.equals("I"))
        {
            this.row = 8;
        }
        else
        {
            this.row = 9;
        }

        // assigns number portion of string to column
        this.col = Integer.parseInt(s.substring(1)) - 1;
    }

    public int row()
    {
        return this.row;
    }

    public int col()
    {
        return this.col;
    }

    /*
    toString returns a 2-3 character string consisting of a letter in
    the range A-J followed by a number in the range 1-10.
    @return string representing move values
     */
    @Override
    public String toString()
    {
        // assign integer value from row to associated letter
        String rowToString;
        if (this.row == 0)
        {
            rowToString = "A";
        }
        else if (this.row == 1)
        {
            rowToString = "B";
        }
        else if (this.row == 2)
        {
            rowToString = "C";
        }
        else if (this.row == 3)
        {
            rowToString = "D";
        }
        else if (this.row == 4)
        {
            rowToString = "E";
        }
        else if (this.row == 5)
        {
            rowToString = "F";
        }
        else if (this.row == 6)
        {
            rowToString = "G";
        }
        else if (this.row == 7)
        {
            rowToString = "H";
        }
        else if (this.row == 8)
        {
            rowToString = "I";
        }
        else
        {
            rowToString = "J";
        }
        // return formatted string from row letter and col integer
        return String.format("%s%d",
                rowToString, col() + 1);
    }

}
