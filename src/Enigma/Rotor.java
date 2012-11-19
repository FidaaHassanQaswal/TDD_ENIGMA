package Enigma;


import Tools.ArrayTools;
import Tools.Values;

/**
 * Rotor class.
 * User: Marthyn
 * Date: 19/11/12
 * Time: 12:05
 */
public class Rotor {

    public char[][] values = new char[52][2];
    public char[] alphabet = new char[] {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public int startPosition;
    public int currentPosition;
    public char notch;


    public Rotor(String rotorString, int startPosition, char notch) {
        char[] rotorValues = rotorString.toCharArray();
        for(int i =0; i<26; i++) {
            this.values[i] = new char[] {alphabet[i], rotorValues[i]};
        }
        for(int i =26; i<52; i++) {
            this.values[i] = new char[] {alphabet[i-26], rotorValues[i-26]};
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

    public void reset() {
        currentPosition = startPosition;
    }

    public int convert(int index, int side) {
        if(side== Values.LEFT) {
            return ArrayTools.indexOf(getLeftSide()[index], getRightSide());
        }
        else if (side==Values.RIGHT){
            return ArrayTools.indexOf(getRightSide()[index], getLeftSide());
        }
        return -1;

    }

    public boolean checkNotch() {
        if(getLeftSide()[0] == this.notch) {
            return true;
        }
        return false;
    }


}
