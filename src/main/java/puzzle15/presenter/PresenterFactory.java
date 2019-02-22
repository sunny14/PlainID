package puzzle15.presenter;

public class PresenterFactory {

    public static Presenter getPresenter()  {
        return new TerminalPresenter();
    }
}
