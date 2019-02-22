package puzzle15;

import org.junit.Test;
import puzzle15.model.Board;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class AppTest {

    @Test
    public void winTest()   {
        int [] winningBoard = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
        Board boardMock = mock(Board.class);
        when(boardMock.getBoard()).thenReturn(winningBoard);

        assertFalse(App.shouldContinue(boardMock, null));
        verify(boardMock).isWin();

    }


    @Test
    public void luseTest()  {
        int [] notWinningBoard = {2,1,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
        Board boardMock = mock(Board.class);
        when(boardMock.getBoard()).thenReturn(notWinningBoard);
        when(boardMock.getMovesNum()).thenReturn(0);

        assertFalse(App.shouldContinue(boardMock, null));
        verify(boardMock).getMovesNum();

    }
}
