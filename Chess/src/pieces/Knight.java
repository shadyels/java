package pieces;

import board.Board;
import board.BoardUtils;
import board.Move;
import board.Tile;
import shared.Alliance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knight extends Piece {

    public final static int[] CANDIDATE_MOVE_COORDINATES = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Knight(int piecePosition, Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public List<Move> calculateLegalMoves(Board board) {
        int candidateDestinationCoordinate;
        final List<Move> legalMoves = new ArrayList<>();

        for (final int currentCandidate : CANDIDATE_MOVE_COORDINATES) {
            candidateDestinationCoordinate = this.piecePosition + currentCandidate;

            if(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);

                if(!candidateDestinationTile.isTileOccupied()){
                    legalMoves.add(new Move()); // change this after defining Move
                } else {
                    final Piece pieceAtLocation = candidateDestinationTile.getPiece();
                    final Alliance pieceAlliance = pieceAtLocation.getPieceAlliance();

                    if(this.pieceAlliance !=  pieceAlliance) {
                        legalMoves.add(new Move());
                    }
                }
            }
        }
        return Collections.unmodifiableList(legalMoves);
    }

    private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && ((candidateOffset == - 17) || (candidateOffset == -10) || (candidateOffset == 6) || (candidateOffset == 15));
    }
}
