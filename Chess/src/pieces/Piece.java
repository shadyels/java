package pieces;

import board.Board;
import board.Move;
import shared.Alliance;

import java.util.List;

public abstract class Piece {
    protected final int piecePosition;
    protected final Alliance pieceAlliance;


    public Piece(int piecePosition, Alliance pieceAlliance) {
        this.piecePosition = piecePosition;
        this.pieceAlliance = pieceAlliance;
    }

    public abstract List<Move> calculateLegalMoves(final Board board);

    public Alliance getPieceAlliance() {
        return pieceAlliance;
    }
}
