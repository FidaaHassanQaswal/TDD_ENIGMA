package tests;
import org.junit.*;
import Enigma.Rotor;

/**
 * Created with IntelliJ IDEA.
 * User: Marthyn
 * Date: 19/11/12
 * Time: 12:01
 * To change this template use File | Settings | File Templates.
 */
public class RotorTest {


    @Test
    public void CreateRotorTest() {
        char[][] testarray = {{'A', 'A'}, {'B', 'J'},{'C', 'D'},{'D', 'K'},{'E', 'S'},{'F', 'I'},{'G', 'R'},{'H', 'U'},{'I', 'X'},{'J', 'B'},{'K', 'L'},{'L', 'H'},{'M', 'W'},{'N', 'T'},{'O', 'M'},{'P', 'C'},{'Q', 'Q'},{'R', 'G'},{'S', 'Z'},{'T', 'N'},{'U', 'P'},{'V', 'Y'},{'W', 'F'},{'X', 'V'},{'Y', 'O'},{'Z', 'E'}
                             ,{'A', 'A'}, {'B', 'J'},{'C', 'D'},{'D', 'K'},{'E', 'S'},{'F', 'I'},{'G', 'R'},{'H', 'U'},{'I', 'X'},{'J', 'B'},{'K', 'L'},{'L', 'H'},{'M', 'W'},{'N', 'T'},{'O', 'M'},{'P', 'C'},{'Q', 'Q'},{'R', 'G'},{'S', 'Z'},{'T', 'N'},{'U', 'P'},{'V', 'Y'},{'W', 'F'},{'X', 'V'},{'Y', 'O'},{'Z', 'E'}};
        Rotor rotor = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 1, 'Y');

        Assert.assertArrayEquals(testarray, rotor.values);

    }

    @Test
    public void ShiftRotorTest() {
        Rotor rotor = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 7, 'T');
        Assert.assertEquals(7, rotor.currentPosition);
        rotor.shiftRotor();
        Assert.assertEquals(8, rotor.currentPosition);
    }

    @Test
    public void GetRightSideRotor() {
        char[] testarray = new char[] {'V','Z','N', 'T', 'O', 'W', 'Y', 'H', 'X', 'U', 'S', 'P', 'A', 'I', 'B', 'R', 'C', 'J', 'E', 'K', 'M', 'F', 'L', 'G', 'D', 'Q'};
        Rotor rotor = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 8, 'A');
        Assert.assertEquals(rotor.getRightSide()[1], testarray[1]);
    }

    @Test
    public void GetLeftSideRotor() {
        char[] testarray = new char[] {'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'};
        Rotor rotor = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 14, 'Q');
        Assert.assertEquals(rotor.getLeftSide()[1], testarray[1]);
    }
}
