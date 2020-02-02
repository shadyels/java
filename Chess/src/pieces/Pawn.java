package pieces;

import board.Board;
import board.BoardUtils;
import board.Move;
import shared.Alliance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pawn extends Piece {
    private final int[] CANDINDATE_MOVE_COORDINATE = {7, 8, 9, 16};

    public Pawn(final int piecePosition, final Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public List<Move> calculateLegalMoves(Board board) {
        final List<Move> legalMoves = new ArrayList<>();

        for (final int currentCandidateOffset : CANDINDATE_MOVE_COORDINATE) {
            int candidateDestinationCoordinate = this.piecePosition + (this.pieceAlliance.getDirection() * currentCandidateOffset);

            if (!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                continue;
            }

            //NORMAL PAWN MOVE
            if (currentCandidateOffset == 8 && !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                legalMoves.add(new Move.NormalMove(board, this, candidateDestinationCoordinate)); //TODO here: PROMOTIONS!!
            }
            //DOUBLE JUMP AT THE BEGINNING OF THE GAME
            else if (currentCandidateOffset == 16 && this.isFirstMove() &&
                (
                    (BoardUtils.SECOND_ROW[this.piecePosition] && this.pieceAlliance.isBlack()) ||
                        (BoardUtils.SEVENTH_ROW[this.piecePosition] && this.pieceAlliance.isWhite())
                )
            ) {
                final int behindCandidateDestinationCoordinate = this.piecePosition + (this.pieceAlliance.getDirection() * 8);
                if (!board.getTile(behindCandidateDestinationCoordinate).isTileOccupied() &&
                    !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                    legalMoves.add(new Move.NormalMove(board, this, candidateDestinationCoordinate));
                }
            }
            //PAWN ATTACK MOVE
            else if (currentCandidateOffset == 7 &&
                !(
                    (BoardUtils.EIGHT_COLUMN[this.piecePosition] && this.pieceAlliance.isWhite()) ||
                    (BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceAlliance.isBlack())
                )
            ) {
                if (board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                    final Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();
                    if (this.pieceAlliance != pieceOnCandidate.pieceAlliance) {
                        //TODO add attack move (attack into a pawn promotion is still missing)
                        legalMoves.add(new Move.AttackMove(board, this, candidateDestinationCoordinate, pieceOnCandidate));
                    }
                }
            } else if (candidateDestinationCoordinate == 9 &&
                !(
                    (BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceAlliance.isWhite()) ||
                    (BoardUtils.EIGHT_COLUMN[this.piecePosition] && this.pieceAlliance.isBlack())
                )) {
                final Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();
                if (this.pieceAlliance != pieceOnCandidate.pieceAlliance) {
                    //TODO add attack move (attack into a pawn promotion is still missing)
                    legalMoves.add(new Move.AttackMove(board, this, candidateDestinationCoordinate, pieceOnCandidate));
                }
            }
        }
        return Collections.unmodifiableList(legalMoves);
    }


}
