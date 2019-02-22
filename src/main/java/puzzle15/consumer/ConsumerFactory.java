package puzzle15.consumer;

public class ConsumerFactory {

    public static Consumer getConsumer()  {
        return new TerminalConsumer();
    }
}
