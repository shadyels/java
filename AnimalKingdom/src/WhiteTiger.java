import java.awt.*;

public class WhiteTiger extends Critter {
    private boolean hasInfected;

    public WhiteTiger(){
        this.hasInfected = false;
    }

    public Color getColor(){
        return Color.WHITE;
    }

    public String toString(){
        if(hasInfected) {
            return "TGR";
        } else {
            return "tgr";
        }
    }
    // always infect if an enemy is in front, otherwise if a wall is in front or to the right, then turn left, otherwise if a fellow Tiger is in front, then turn right, otherwise hop.
    public Action getMove(CritterInfo info){
        if(info.getFront() == Neighbor.OTHER){
            this.hasInfected = true;
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME){
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }

    }
}
