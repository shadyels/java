import java.awt.*;
import java.util.Random;

public class Tiger extends Critter {
    private int moves;
    private Random rand = new Random();
    private int colorIndex = rand.nextInt(3);

    public Color getColor(){ //FIX COLORS
            Color[] colors = new Color[3];
            colors[0] = Color.RED;
            colors[1] = Color.GREEN;
            colors[2] = Color.BLUE;

            if(moves % 3 == 0) {
                colorIndex = rand.nextInt(3);
            }

            return colors[colorIndex];
    }

    public String toString(){
        return "TGR";
    }

    public Action getMove(CritterInfo info){
        this.moves++;

        if(info.getFront() == Neighbor.OTHER){
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
