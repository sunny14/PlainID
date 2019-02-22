package puzzle15.model;

import org.junit.Test;
import org.mockito.Mock;
import puzzle15.exceptions.TileNotFoundException;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    //TODO: test a legal slide
    @Test
    public void movesLimitTest()    {
        //TODO
    }
}
