package board;

import pieces.*;
import shared.Alliance;

import java.util.*;

public class Board {
    private final List<Tile> gameBoard;
    private final Collection<Piece> whitePieces;
    private final Collection<Piece> blackPieces;

    private Board(Builder builder) {
        this.gameBoard = createGameBoard(builder);
        this.whitePieces = calculateActivePieces(this.gameBoard, Alliance.WHITE);
        this.blackPieces = calculateActivePieces(this.gameBoard, Alliance.BLACK);

        //list of moves for each alliance, all pieces
        final Collection<Move> whiteStandardLegalMoves = calculateLegalMoves(this.whitePieces);
        final Collection<Move> blackStandardLegalMoves = calculateLegalMoves(this.blackPieces);
    }

    @Override
    public String toString(){
        final StringBuilder builder = new StringBuilder();

    }

    private Collection<Move> calculateLegalMoves(final Collection<Piece> pieces) {
        final List<Move> legalMoves = new ArrayList<>();

        for(final Piece piece : pieces){
            legalMoves.addAll(piece.calculateLegalMoves(this));
        }

        return Collections.unmodifiableList(legalMoves);
    }

    private static Collection<Piece> calculateActivePieces(final List<Tile> gameBoard, final Alliance alliance) {
        final List<Piece> activePieces = new ArrayList<>();

        for (final Tile tile : gameBoard) {
            if (tile.isTileOccupied()) {
                final Piece piece = tile.getPiece();
                if (piece.getPieceAlliance() == alliance) {
                    activePieces.add(piece);
                }
            }
        }

        return Collections.unmodifiableList(activePieces);
    }

    private static List<Tile> createGameBoard(final Builder builder) {
        final Tile[] tiles = new Tile[BoardUtils.NUM_TILES];
        for (int i = 0; i < BoardUtils.NUM_TILES; i++) {
            tiles[i] = Tile.createTile(i, builder.boardConfig.get(i));
        }
        return Collections.unmodifiableList(Arrays.asList(tiles));
    }

    public static Board createStandardBoard() {
        // INITIAL POSITIONS FOR CHESS PIECES
        final Builder builder = new Builder();

        //--BLACK PIECES
        builder.setPiece(new Rook(0, Alliance.BLACK))
            .setPiece(new Knight(1, Alliance.BLACK))
            .setPiece(new Bishop(2, Alliance.BLACK))
            .setPiece(new Queen(3, Alliance.BLACK))
            .setPiece(new King(4, Alliance.BLACK))
            .setPiece(new Bishop(5, Alliance.BLACK))
            .setPiece(new Knight(6, Alliance.BLACK))
            .setPiece(new Rook(7, Alliance.BLACK))
            .setPiece(new Pawn(8, Alliance.BLACK))
            .setPiece(new Pawn(9, Alliance.BLACK))
            .setPiece(new Pawn(10, Alliance.BLACK))
            .setPiece(new Pawn(11, Alliance.BLACK))
            .setPiece(new Pawn(12, Alliance.BLACK))
            .setPiece(new Pawn(13, Alliance.BLACK))
            .setPiece(new Pawn(14, Alliance.BLACK))
            .setPiece(new Pawn(15, Alliance.BLACK));

        //--WHITE PIECES
        builder.setPiece(new Pawn(48, Alliance.WHITE))
            .setPiece(new Pawn(49, Alliance.WHITE))
            .setPiece(new Pawn(50, Alliance.WHITE))
            .setPiece(new Pawn(51, Alliance.WHITE))
            .setPiece(new Pawn(52, Alliance.WHITE))
            .setPiece(new Pawn(53, Alliance.WHITE))
            .setPiece(new Pawn(54, Alliance.WHITE))
            .setPiece(new Pawn(55, Alliance.WHITE))
            .setPiece(new Rook(56, Alliance.WHITE))
            .setPiece(new Knight(57, Alliance.WHITE))
            .setPiece(new Bishop(58, Alliance.WHITE))
            .setPiece(new Queen(59, Alliance.WHITE))
            .setPiece(new King(60, Alliance.WHITE))
            .setPiece(new Bishop(61, Alliance.WHITE))
            .setPiece(new Knight(62, Alliance.WHITE))
            .setPiece(new Rook(63, Alliance.WHITE));

        //WHITE MOVES FIRST
        builder.setMoveMaker(Alliance.WHITE);

        //BUILD THE BOARD
        return builder.build();
    }

    public Tile getTile(final int tileCoordinate) {
        return gameBoard.get(tileCoordinate);
    }

    public static class Builder {
        Map<Integer, Piece> boardConfig;
        Alliance nextMoveMaker;

        public Builder() {
            //ADD CONSTRUCTOR
        }

        public Builder setPiece(final Piece piece) {
            this.boardConfig.put(piece.getPiecePosition(), piece);
            return this;
        }

        public Builder setMoveMaker(final Alliance nextMoveMaker) {
            this.nextMoveMaker = nextMoveMaker;
            return this;
        }

        public Board build() {
            return new Board(this);
        }
    }
}
