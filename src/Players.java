package first_try;

import javax.swing.text.Position;

//--------------------------------------------------
//COMP 249
//Assignment #1
//Written by: Naika Jean-Baptiste ID:40227367
//--------------------------------------------------
public class Players {
    private String name;

    //public first_try.Positions positions;
    private int position;

    /**
     * initializes initial position and name of players
     * @param name
     */
    public Players(String name) {
        this.name = name;
        position = 0;
    }

    /**
     *
     * @return name of player
     */
    public String getName(){
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param position
     */
    //TODO idk if this goes here of if it should be in the position class
    public void move(Position position){
        if(position instanceof Ladder){
            this.position = ((Ladder) position).getNewNumber();
        }else if (position instanceof Snake){
            this.position = ((Snake) position).getNewNumber();
        }else{
            //this.position = position.getNumber();
        }
    }

    /**
     *
     * @param position
     */
    public void setPosition(int position){
        if(position < 100) {
            this.position = position;
        }else{
            this.position = position % 100;
        }
    }

    /**
     *
     * @return
     */
    public int getPosition(){
        return position;
    }
}
