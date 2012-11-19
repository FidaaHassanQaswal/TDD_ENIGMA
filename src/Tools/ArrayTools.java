package Tools;

/**
 * Created with IntelliJ IDEA.
 * User: Marthyn
 * Date: 19/11/12
 * Time: 20:16
 * To change this template use File | Settings | File Templates.
 */
public class ArrayTools {

    public static int indexOf(char needle, char[] array)
    {
        for (int i=0; i<array.length; i++)
        {
            if (array[i] == needle) {
                return i;
            }
        }
        return -1;
    }
}
