package first.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Design an algorithm and write code
 * to count the amount of duplicate characters in a string
 * without using any additional buffer.
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 */



public class PlainID {

    public static void main( String [] args )   {

        int repeatedCharacters = 0;

        //create an input array
        //TODO: fix hard-coded string to args[0]
        char [] charArray = "Abab0990; ".toCharArray();

       // repeatedCharacters = getRepeatedCharactersNCompexity(charArray);

        System.out.println(repeatedCharacters+" repeated characters found");

    }


    private static int getRepeatedCharactersNSquareCompexity(char[] charArray) {

        int repeatedCharacters = 0;
        int length = charArray.length;
        for (int i = 0; i< length; i++)  {

            boolean isRepetitionFound = false;

            for (int j = i+1; (j < length) && (i != j); j++)  {
                if (charArray[j] == 0)  {
                    continue;
                }

                if (charArray[i] == charArray[j])   {
                    charArray[j] = 0;
                    isRepetitionFound = true;
                }
            }

            if (isRepetitionFound)   {
                charArray[i] = 0;
                repeatedCharacters++;
            }
        }
        return repeatedCharacters;
    }

    private static int getRepeatedCharactersNCompexity(char[] charArray) {



        Map<Character, Integer> map = new HashMap<Character, Integer>();

        //create a map with count
        for (char ch: charArray)  {

            if (!map.containsKey(ch))    {
                map.put(ch, 1);
            }
            else {
                map.put(ch, map.get(ch)+1);
            }
        }

        int repeatedCharacters = 0;
        for (Character ch: map.keySet())    {

            if (map.get(ch) >1 ) {
                repeatedCharacters++;
            }
        }

        return repeatedCharacters;
    }


    @Test
    public void getRepeatedCharactersNSquareCompexityTest()  {

        char [] charArray = "Abab0990; ".toCharArray();
        int repeatedCharacters = getRepeatedCharactersNSquareCompexity(charArray);

        assertEquals(3, repeatedCharacters);

    }

    @Test
    public void getRepeatedCharactersNCompexityTest()  {

        char [] charArray = "Abab0990; ".toCharArray();
        int repeatedCharacters = getRepeatedCharactersNCompexity(charArray);

        assertEquals(3, repeatedCharacters);

    }
}