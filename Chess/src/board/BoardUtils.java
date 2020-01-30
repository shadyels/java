package board;

public class BoardUtils {
    public static final boolean[] FIRST_COLUMN = null;

    public static boolean isValidTileCoordinate(int coordinate) {
        return coordinate >= 0 && coordinate < 64;
    }
}
