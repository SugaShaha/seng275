package Piece;

public class IPieceFactory implements PieceFactory {

    public IPieceFactory () {
    }

    public int gameId() {
        return 0;
    }

    public Piece createPiece() {
        return new IPiece();
    }
}
