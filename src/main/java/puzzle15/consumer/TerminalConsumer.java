package puzzle15.consumer;


import java.util.Scanner;

public class TerminalConsumer implements Consumer {

    Scanner scanner = new Scanner(System. in);

    /**
     * gets input from stdin
     * @return
     */
    public String consume() {
         return scanner. nextLine();
    }
}
