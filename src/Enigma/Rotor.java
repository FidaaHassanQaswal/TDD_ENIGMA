package Enigma;


/**
 * Created with IntelliJ IDEA.
 * User: Marthyn
 * Date: 19/11/12
 * Time: 12:01
 * To change this template use File | Settings | File Templates.
 */
public class Rotor {

    public char[][] values = new char[52][2];
    public char[] alfabet = new char[] {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public int startPosition;
    public int currentPosition;
    public char notch;

    private final int RIGHT = 0;
    private final int LEFT = 1;

    public Rotor(String rotorString, int startPosition, char notch) {
        char[] rotorValues = rotorString.toCharArray();
        for(int i =0; i<26; i++) {
            this.values[i] = new char[] {alfabet[i], rotorValues[i]};
        }
        for(int i =26; i<52; i++) {
            this.values[i] = new char[] {alfabet[i-26], rotorValues[i-26]};
        }
        this.currentPosition = startPosition;
        this.startPosition = startPosition;
        this.notch = notch;


    }

    public void shiftRotor() {
        currentPosition++;
    }

    public char[] getRightSide() {
        char[] array = new char[26];
        int arrayPosition = currentPosition;
        for(int i = 0; i<26; i++) {
            if(arrayPosition>25) {
                array[i] = values[arrayPosition-26][1];

            }
            else{
                array[i] = values[arrayPosition][1];

            }
            arrayPosition++;
        }
        return array;
    }

    public char[] getLeftSide() {
        char[] array = new char[26];
        int arrayPosition = currentPosition;
        for(int i = 0; i<26; i++) {
            if(arrayPosition>25) {
                array[i] = values[arrayPosition-26][0];
            }
            else{
                array[i] = values[arrayPosition][0];
            }
            arrayPosition++;
        }
        return array;
    }

    public int convert(int index, int side) {
        if(side==0) {
            return indexOf(getRightSide()[index], getLeftSide());
        }
        else{
            return indexOf(getRightSide()[index], getLeftSide());
        }

    }

    public static int indexOf(char needle, char[] haystack)
    {
        for (int i=0; i<haystack.length; i++)
        {
            if (haystack[i] == needle) {
                return i;
            }
        }

        return -1;
    }
}
