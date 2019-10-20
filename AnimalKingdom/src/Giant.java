import java.awt.*;

public class Giant extends Critter{
    private int moves;
    private String move = "fee";


    public Color getColor(){
        return Color.GRAY;
    }
    public String toString() {
        if(moves % 24 == 0){
            move = "fee";
        } else if(moves % 18 == 0){
            move = "fie";
        } else if(moves % 12 == 0){
            move = "foe";
        } else if(moves % 6 == 0){
            move = "fum";
        }

        return move;
    }

    public Action getMove(CritterInfo info){
        this.moves++;

        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }

    }
}
