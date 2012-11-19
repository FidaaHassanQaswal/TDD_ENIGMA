import Enigma.Machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: Marthyn
 * Date: 19/11/12
 * Time: 21:11
 * To change this template use File | Settings | File Templates.
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
