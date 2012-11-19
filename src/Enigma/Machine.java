package Enigma;

import Tools.ArrayTools;

/**
 * Machine class
 * User: Marthyn
 * Date: 19/11/12
 * Time: 20:10
 */
import Tools.Values;

public class Machine {
    private Rotor rotorLeft = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 12, 'Q');
    private Rotor rotorMiddle = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 2, 'E');
    private Rotor rotorRight = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 10, 'V');
    private Reflector reflector = new Reflector();
    private char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public Machine() {

    }

    public String convert(String text) {
        StringBuffer convertedString = new StringBuffer();

        if(text.length()==1){
            convertedString.append(process(text.charAt(0)));
        }
        else if(text.contains(" ")) { //Contains spaces, multiple words
            String[] words = text.split(" ");
            for(String word : words) {
                char[] letters = word.toCharArray();
                for(char letter : letters) {
                    convertedString.append((process(letter)));
                }
                convertedString.append(" ");//Add whitespace
            }
        }
        else { //No spaces, text contains 1 word
            char[] letters = text.toCharArray();
            for(char letter : letters) {
                convertedString.append((process(letter)));
            }
        }
        return convertedString.toString().trim();
    }

    public void resetRotors() {
        rotorRight.reset();
        rotorMiddle.reset();
        rotorLeft.reset();
    }

    public char process(char input) {
        int index = ArrayTools.indexOf(input, alphabet);
        rotorRight.shiftRotor();
        index = rotorRight.convert(index,Values.LEFT);
        index = rotorMiddle.convert(index,Values.LEFT);
        index = rotorLeft.convert(index,Values.LEFT);
        index = reflector.reflect(index);
        index = rotorLeft.convert(index,Values.RIGHT);
        index = rotorMiddle.convert(index,Values.RIGHT);
        index = rotorRight.convert(index,Values.RIGHT);

        rotorsShift();

        return alphabet[index];
    }

    public void rotorsShift() {
        if(rotorRight.checkNotch()) {
            rotorMiddle.shiftRotor();
        }
        if(rotorMiddle.checkNotch()){
            rotorMiddle.shiftRotor();
            rotorLeft.shiftRotor();
        }
        if(rotorLeft.checkNotch()) {
            rotorLeft.shiftRotor();
        }
    }
}
