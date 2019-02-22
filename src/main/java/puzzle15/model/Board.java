package puzzle15.model;

import puzzle15.exceptions.TileNotFoundException;

import java.util.Random;
import java.util.TreeSet;

public class Board {

    static final int BOARD_SIDE = 4;
    int [] array;
    //TODO: get max moves number from properties file
    private int movesNum = 50;

    public Board()  {
        array = this.init(BOARD_SIDE);
    }

    public int getMovesNum() {
        return movesNum;
    }

    /** init with random  numbers,
     *      then map the smallest one to 0,
     *      the next one to 1 and so on until the board is full
     * @param boardSide
     */
    int [] init(int boardSide) {
        array = new int[(int)Math.pow(boardSide, 2)];
        TreeSet<Integer> set = new TreeSet<Integer>();

        //generate random numbers
        Random randomGenerator = new Random();
        for (int i = 0; i < array.length; i++) {
            Integer value = randomGenerator.nextInt();

            //make sure the value is unique
            while (set.contains(value)) {
                value = randomGenerator.nextInt();
            }

            //save the value
            array[i] = value;
            set.add(value);
        }

        //map random numbers to 0..BOARD_SIDE
        for (int i = 0; i < array.length && !set.isEmpty(); i++) {
            int value = set.pollFirst();
            array[getIndex(value)] = i;
        }

        int [] arrayCopy = new int [array.length];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);

        return arrayCopy;
    }

    /**
     * @param valueToUpdate
     * @param newValue
     * @return the updated index; if the value not found returns -1
     */
    private int findValueAndUpdate(Integer valueToUpdate, int newValue) {
        for (int j=0; j< array.length; j++) {
            if (array[j] == valueToUpdate ) {
                array[j] = newValue;
                return j;
            }
        }

        return -1;
    }


    public int [] getBoard()   {

        int [] boardPresentation = new int [array.length];
        System.arraycopy(array, 0, boardPresentation, 0, array.length);

        return boardPresentation;
    }

    public void slide(int tileValue) throws TileNotFoundException {
        //TODO: make sure movesNUm >0
        if (isLegalSlide(tileValue))    {
            swapTiles(tileValue, 0);
            movesNum--;
        }

    }

    private void swapTiles(int value, int value2) throws TileNotFoundException {

        int index = findValueAndUpdate(value, value2);
        if (index == -1)    {
            throw new TileNotFoundException("no tile with value "+value+" found");
        }
        array[getIndex(value2)] = value;

    }

    public boolean isWin()  {

        for (int i=0; i< array.length-1; i++)  {
            if ( array[i] != i+1 )  {
                return false;
            }
        }

        System.out.println("Congratulations, you win!");
        return true;
    }

    /**
     * slide is legal if tiles are next to each other,
     * at the same column or at the same line
     * @param value
     * @return
     */
    boolean isLegalSlide(int value)  {
        int index = getIndex(value);

        int index2 = getIndex(0);

        boolean isLegal =  (Math.abs(index - index2) == BOARD_SIDE) ||
                (Math.abs(index-index2) == 1 && Math.max(index, index2) % BOARD_SIDE > 0 );

        if ( !isLegal ) {
            System.out.println("This slide is not legal!");
        }

        return isLegal;
    }

    private int getIndex(int value) {
        int index = -1;
        for (int i=0; i<array.length; i++)  {
            if (array[i] == value)  {
                index = i;
                break;
            }
        }
        return index;
    }

}
