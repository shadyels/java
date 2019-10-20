import java.awt.*;
import java.util.EmptyStackException;

public class Bear extends Critter {
    private int moves = 0;
    private boolean polar;

    public Bear(boolean polar){
        this.polar = polar;
    }

    public Color getColor(){
        if(polar){
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    public String toString(){
        if(this.moves % 2 == 0){
            return "\\";
        } else {
            return "/";
        }
    }

    public Action getMove(CritterInfo info){
        this.moves++;

        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }

    }
}
