import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import Piece.*;

class PieceTest {

    static Piece p;
    static PlayingField pf;

    @BeforeAll
     static void createPiece () {
        p = new IPiece();
        p.setX(22);
        p.setY(12);
    }

    @Test
    void getTotalPieces() {
        assertEquals(Piece.getTotalPieces(), 7);
    }

    @Test
    void getX() {
        Piece p = new IPiece();
        p.setX(3);
        assertEquals(p.getX(), 3);

    }

    @Test
    void getY() {
        Piece p = new IPiece();
        p.setY(5);
        assertEquals(p.getY(), 5);
    }

    @Test
    void moveLeft() {
        Piece p = new IPiece();
        p.setX(3);

        int x = p.getX();
        p.moveLeft();
        assertEquals (p.getX(), x - 1);
    }

    @Test
    void moveRight() {
        Piece p = new IPiece();
        p.setX(3);

        int x = p.getX();
        p.moveRight();
        assertEquals (p.getX(), x + 1);
    }

    @Test
    void moveDown() {
        Piece p = new IPiece();
        p.setY(3);

        int y = p.getY();
        p.moveDown();
        assertEquals (p.getY(), y + 1);
    }

    @Test
    void moveUp() {
        Piece p = new IPiece();
        p.setY(3);

        int y = p.getY();
        p.moveUp();
        assertEquals (p.getY(), y - 1);
    }

    @Test
    void getType() {
        Piece p;
        p = new IPiece();
        assertEquals(p.getType(), Piece.PieceType.PIECE_I);
        p = new TPiece();
        assertEquals(p.getType(), Piece.PieceType.PIECE_T);
        p = new LPiece();
        assertEquals(p.getType(), Piece.PieceType.PIECE_L);
        p = new JPiece();
        assertEquals(p.getType(), Piece.PieceType.PIECE_J);
        p = new OPiece();
        assertEquals(p.getType(), Piece.PieceType.PIECE_O);
        p = new SPiece();
        assertEquals(p.getType(), Piece.PieceType.PIECE_S);
        p = new ZPiece();
        assertEquals(p.getType(), Piece.PieceType.PIECE_Z);
    }

    @Test
    void testMoveThreeTimes() {
        Piece p = new IPiece(); 
        p.setY(4);
        p.moveDown();
        p.moveDown(); 
        p.moveDown(); 
        // 4 + 3 = 7
        assertEquals (p.getY(), 7);
    }

    @Test
    void rotateLeft() {
        Piece p = new IPiece();
        p.rotateLeft();
        assertEquals(p.getRotation(), 3);

        p = new JPiece();
        p.rotateLeft();
        assertEquals(p.getRotation(), 3);

        p = new LPiece();
        p.rotateLeft();
        assertEquals(p.getRotation(), 3);

        p = new OPiece();
        p.rotateLeft();
        assertEquals(p.getRotation(), 0);

        p = new SPiece();
        p.rotateLeft();
        assertEquals(p.getRotation(), 3);

        p = new ZPiece();
        p.rotateLeft();
        assertEquals(p.getRotation(), 3);

        p = new TPiece();
        p.rotateLeft();
        assertEquals(p.getRotation(), 3);
    }

    @Test
    void rotateRight() {
        Piece p = new ZPiece();
        p.rotateRight();
        assertEquals(p.getRotation(), 1);
    }

    @Test
    void isCovering() {
        Piece p = new IPiece();
        for (int i = 0; i < 4; i++){
            assertTrue(p.isCovering(i, 1));
        }

        p = new JPiece();
        assertTrue(p.isCovering(0, 0));
        assertTrue(p.isCovering(0, 1));
        assertTrue(p.isCovering(1, 1));
        assertTrue(p.isCovering(2, 1));

        p = new LPiece();
        assertTrue(p.isCovering(0, 1));
        assertTrue(p.isCovering(1, 1));
        assertTrue(p.isCovering(2, 1));
        assertTrue(p.isCovering(2, 0));

        p = new OPiece();
        assertTrue(p.isCovering(1, 0));
        assertTrue(p.isCovering(1, 1));
        assertTrue(p.isCovering(2, 1));
        assertTrue(p.isCovering(2, 0));

        p = new SPiece();
        assertTrue(p.isCovering(0, 1));
        assertTrue(p.isCovering(1, 1));
        assertTrue(p.isCovering(1, 0));
        assertTrue(p.isCovering(2, 0));

        p = new ZPiece();
        assertTrue(p.isCovering(0, 0));
        assertTrue(p.isCovering(1, 0));
        assertTrue(p.isCovering(1, 1));
        assertTrue(p.isCovering(2, 1));

        p = new TPiece();
        assertTrue(p.isCovering(0, 1));
        assertTrue(p.isCovering(1, 1));
        assertTrue(p.isCovering(1, 0));
        assertTrue(p.isCovering(2, 1));
    }
}
