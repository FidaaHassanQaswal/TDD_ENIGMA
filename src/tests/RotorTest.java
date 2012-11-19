package tests;
import org.junit.*;
import Enigma.Rotor;

/**
 * Test class for testing the Rotor class.
 * User: Marthyn
 * Date: 19/11/12
 * Time: 12:01
 */
public class RotorTest {
    private final int RIGHT = 0;
    private final int LEFT = 1;


    //Test if the rotor's values are created correctly, also check if notch and positions are set correctly.
    @Test
    public void CreateRotorTest() {
        char[][] testarray = {{'A', 'A'}, {'B', 'J'},{'C', 'D'},{'D', 'K'},{'E', 'S'},{'F', 'I'},{'G', 'R'},{'H', 'U'},{'I', 'X'},{'J', 'B'},{'K', 'L'},{'L', 'H'},{'M', 'W'},{'N', 'T'},{'O', 'M'},{'P', 'C'},{'Q', 'Q'},{'R', 'G'},{'S', 'Z'},{'T', 'N'},{'U', 'P'},{'V', 'Y'},{'W', 'F'},{'X', 'V'},{'Y', 'O'},{'Z', 'E'}
                             ,{'A', 'A'}, {'B', 'J'},{'C', 'D'},{'D', 'K'},{'E', 'S'},{'F', 'I'},{'G', 'R'},{'H', 'U'},{'I', 'X'},{'J', 'B'},{'K', 'L'},{'L', 'H'},{'M', 'W'},{'N', 'T'},{'O', 'M'},{'P', 'C'},{'Q', 'Q'},{'R', 'G'},{'S', 'Z'},{'T', 'N'},{'U', 'P'},{'V', 'Y'},{'W', 'F'},{'X', 'V'},{'Y', 'O'},{'Z', 'E'}};
        Rotor rotor = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 1, 'Y');
        Assert.assertEquals('Y', rotor.notch);
        Assert.assertEquals(1, rotor.startPosition);
        Assert.assertEquals(1, rotor.currentPosition);
        Assert.assertArrayEquals(testarray, rotor.values);

    }

    //Test if the rotor shifts a position
    @Test
    public void ShiftRotorTest() {
        Rotor rotor = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 7, 'T');
        Assert.assertEquals(7, rotor.currentPosition);
        rotor.shiftRotor();
        Assert.assertEquals(8, rotor.currentPosition);
    }

    //Test if the rotor goes back to the original position after reset
    @Test
    public void ResetRotorsTest() {
        Rotor rotor = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 7, 'T');
        Assert.assertEquals(7, rotor.currentPosition);
        rotor.shiftRotor();
        rotor.shiftRotor();
        rotor.reset();
        Assert.assertEquals(7, rotor.currentPosition);

    }

    //Test if the right side of the rotor is correct
    @Test
    public void GetRightSideRotorTest() {
        char[] testarray = new char[] {'V','Z','N', 'T', 'O', 'W', 'Y', 'H', 'X', 'U', 'S', 'P', 'A', 'I', 'B', 'R', 'C', 'J', 'E', 'K', 'M', 'F', 'L', 'G', 'D', 'Q'};
        Rotor rotor = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 8, 'A');
        Assert.assertArrayEquals(rotor.getRightSide(), testarray);
    }

    //Test if the left side of the rotor is correct
    @Test
    public void GetLeftSideRotorTest() {
        char[] testarray = new char[] {'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'};
        Rotor rotor = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 14, 'Q');
        Assert.assertArrayEquals(rotor.getLeftSide(), testarray);
    }

    //Test the rotor's ability to convert a character back and forth.
    @Test
    public void ConvertCharTest() {
        Rotor rotor = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 12, 'Q');
        Assert.assertEquals(7, rotor.convert(3,LEFT));
        Assert.assertEquals(3, rotor.convert(7,RIGHT));
        Rotor rotor2 = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 2, 'E');
        Assert.assertEquals(20, rotor2.convert(3,LEFT));
        Assert.assertEquals(3, rotor2.convert(20,RIGHT));

    }

    //Test if the notch is reached after a couple of shifts
    @Test
    public void CheckIfLeftSideIsNotchAfterShiftingTest() {
        Rotor rotor = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 14, 'R');
        Assert.assertEquals(false, rotor.checkNotch());
        rotor.shiftRotor();
        Assert.assertEquals(false, rotor.checkNotch());
        rotor.shiftRotor();
        Assert.assertEquals(false, rotor.checkNotch());
        rotor.shiftRotor();
        Assert.assertEquals(true, rotor.checkNotch());
    }

}
