package puzzle15.model;

import org.junit.Test;
import puzzle15.exceptions.TileNotFoundException;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void initTest()    {
        Board a = new Board();
        Board b = new Board();

        assertNotNull(a.array);
        assertNotNull(b.array);
        assertNotEquals(a.array, b.array);

        for (int value: a.array)    {
            assertTrue(value <= (Math.pow(Board.BOARD_SIDE, 2)-1) && value >=0);
        }
    }

    @Test
    public void illegalSlideTest() throws TileNotFoundException {
        Board board = new Board();
        int [] boardBefore = board.getBoard();
        int movesLimitBefore = board.getMovesNum();
        board.slide(0);

        assertArrayEquals(boardBefore, board.getBoard());
        assertEquals(movesLimitBefore, board.getMovesNum());
    }

    @Test
    public void legalHorisontalSlideTest() throws TileNotFoundException {
        Board board = new Board();
        int [] innerArray = {2,1,3,4,5,6,7,8,9,10,11,12,13,14,15,0};

        board.setBoard(innerArray);
        board.slide(15);

        int [] expectedArray = {2,1,3,4,5,6,7,8,9,10,11,12,13,14, 0, 15};
        assertArrayEquals(expectedArray, board.getBoard());

    }

    @Test
    public void legalVerticalSlideTest() throws TileNotFoundException {
        Board board = new Board();
        int [] innerArray = {2,1,3,4,5,6,7,8,9,10,11,12,13,14,15,0};

        board.setBoard(innerArray);
        board.slide(12);

        int [] expectedArray = {2,1,3,4,5,6,7,8,9,10,11,0,13,14, 15, 12};
        assertArrayEquals(expectedArray, board.getBoard());

    }
}
