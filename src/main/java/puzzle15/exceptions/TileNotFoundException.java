package puzzle15.exceptions;

public class TileNotFoundException extends Exception {

    public TileNotFoundException()  {
        super();
    }

    public TileNotFoundException(String message){
        super(message);
    }
}
