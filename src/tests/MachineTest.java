package tests;
import org.junit.*;
import Enigma.Machine;

/**
 * Test class for testing the machine class.
 * User: Marthyn
 * Date: 19/11/12
 * Time: 20:02
 */
public class MachineTest {

    //Test the Enigma machine with a letter, a word and a sentence
    @Test
    public void ConvertTextTest() {
         Machine enigma = new Machine();
         Assert.assertEquals("X", enigma.convert("Q"));
         enigma.resetRotors();
         Assert.assertEquals("Q", enigma.convert("X"));
         enigma.resetRotors();
         Assert.assertEquals("YZDMDMQVR", enigma.convert("LUFTWAFFE"));
         enigma.resetRotors();
         Assert.assertEquals("LUFTWAFFE", enigma.convert("YZDMDMQVR"));
         enigma.resetRotors();
         Assert.assertEquals("YZDMDMQVR SKOLDSFXTV JGNVLAYIT", enigma.convert("LUFTWAFFE BOMBADIERT ROTTERDAM"));
         enigma.resetRotors();
         Assert.assertEquals("LUFTWAFFE BOMBADIERT ROTTERDAM", enigma.convert("YZDMDMQVR SKOLDSFXTV JGNVLAYIT"));
     }
}
