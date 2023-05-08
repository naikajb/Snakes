package first_try;

public class Positions {

    public Players player;
    private boolean empty = true;
    protected  int number;

    /**
     * constructor initializes player's name and the number of the position
     * @param position
     */
    Positions(int position) {
        player = new Players(" ");
        number = position;
    }


    /**
     *
     * @param start
     */
    public void setStart(int start)
    {
        number = start;
    }

    /**
     *
     * @return position of the player
     */
    public int getNumber()
    {
        return number;
    }

    //TODO should every position have a player on it?

    /**
     * places a player on the position
     * @param player
     */
    public void placePlayer(Players player){
        if (empty){
            this.player = player;
            empty = false;
        }else{

        }
    }

}

class Ladder extends Positions
{
    private int newNumber;

    /**
     * builds ladder with a bottom and top value
     * @param start is bottom of the ladder
     * @param end is top of the ladder
     */
    Ladder(int start, int end)
    {
        super(0);
        number = start;
        newNumber = end;
    }

    /**
     * @return the value of top of the ladder
     */
    public int getNewNumber(){
        return newNumber;
    }

    /**
     * prints out the move made by ladder and returns to where it went
     * @return value top of ladder
     */
    public int move(){
        System.out.println("then up to " + newNumber);
        return newNumber;
    }
}

class Snake extends Positions{

    private int newNumber;

    /**
     * builds snake with a bottom and top value
     * @param start top of the snake
     * @param end bottom of the snake
     */
    Snake(int start, int end)
    {
        super(0);
        number = start;
        newNumber = end;
    }

    /**
     * @return the bottom of the snake
     */
    public int getNewNumber(){
        return newNumber;
    }

    /**
     * prints out the move made by snake and returns to where it went
     * @return value top of ladder
     */
    public int move(){
        System.out.println("then down to " + newNumber);
        return newNumber;
    }
}