package puzzle15.presenter;

public class TerminalPresenter implements Presenter {

    private static String GREETING = "Dear friend!\nHere is the board state:\n";
    private static String CLOSING = "\n\n\nYou are limited to %d moves.\nPlease type the TILE VALUE that you'd like to swap with 0.\nOtherwise please type 'q' to quit.\n\n\n";

    /**
     * converts the string of values to a matrix, sends the matrix to stdout
     * @param tiles
     */
    public void present(int [] tiles, int movesNum) {

        System.out.println(GREETING);

        int modulu = (int)Math.sqrt(tiles.length);
        for (int i=0; i<tiles.length; i++ ) {
            if (i % modulu == 0)    {
                System.out.print("\n");
            }
            System.out.print(tiles[i]+" ");
        }


        System.out.format(CLOSING, movesNum);
    }
}
