import Enigma.Machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main class for Enigma Machine, reads input and prints out the converted string.
 * User: Marthyn
 * Date: 19/11/12
 * Time: 21:11
 */
public class Main {

    public static void main(String [ ] args) {
        BufferedReader in = new BufferedReader( new InputStreamReader( System.in ));
        Machine Enigma = new Machine();
        String input;
        System.out.println("Enter a string to encrypt/decrypt");
        try{
            while(true) {
                input = in.readLine();
                if(input.equalsIgnoreCase("EXIT")){System.exit(0);}
                System.out.println(Enigma.convert(input));
                Enigma.resetRotors();
            }
        }
        catch(IOException e){
            System.exit(0);
        }
    }

}
