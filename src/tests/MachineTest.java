package tests;
import org.junit.*;
import Enigma.Machine;

/**
 * Created with IntelliJ IDEA.
 * User: Marthyn
 * Date: 19/11/12
 * Time: 20:02
 * To change this template use File | Settings | File Templates.
 */
public class MachineTest {

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
