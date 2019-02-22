package puzzle15;

import puzzle15.consumer.Consumer;
import puzzle15.consumer.ConsumerFactory;
import puzzle15.exceptions.TileNotFoundException;
import puzzle15.model.Board;
import puzzle15.presenter.Presenter;
import puzzle15.presenter.PresenterFactory;

public class App {

    private static final String EXIT = "q";
    private static final String ERROR_MESSAGE = "This input is invalid, please try again";

    public static void main(String [] args) {

        //define vars
        Board board = new Board();
        Presenter presenter = PresenterFactory.getPresenter();
        Consumer consumer = ConsumerFactory.getConsumer();

        String input;
        do {
            presenter.present(board.getBoard(), board.getMovesNum());
            input = consumer.consume();
            if (input == null || input.isEmpty() || input.equals(EXIT)) {
                continue;
            }

            try {
                board.slide(Integer.valueOf(input));
            }catch (NumberFormatException ex)   {
                System.out.println(ERROR_MESSAGE);
            } catch (TileNotFoundException e) {
                System.out.println(ERROR_MESSAGE);
            }
        }
        while(shouldContinue(board, input));

        System.out.println("The game is over!");

    }

    static boolean shouldContinue(Board board, String input) {
        return !board.isWin() && board.getMovesNum() > 0 && !input.equals(EXIT);
    }
}
