package tests;
import org.junit.Test;
import static org.junit.Assert.*;
import Enigma.Reflector;

/**
 * Test class for testing the reflector class
 * User: Marthyn
 * Date: 19/11/12
 * Time: 11:04
 */
public class ReflectorTest {


    //Test if the reflector returns the correct values
    @Test
    public void ReflectorConvertCharacterToIndex() {
        Reflector reflector = new Reflector();
        assertEquals(reflector.reflect(3), 7);
        assertEquals(reflector.reflect(7), 3);
        assertEquals(reflector.reflect(5), 18);
    }


}
