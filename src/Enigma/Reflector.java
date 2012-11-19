package Enigma;

/**
 * Created with IntelliJ IDEA.
 * User: Marthyn
 * Date: 19/11/12
 * Time: 11:07
 * To change this template use File | Settings | File Templates.
 */
public class Reflector {

    String[] characters = new String[] {"A","B","C","D","E","F","G","D","I","J","K","G","M","K","M","I","E","B","F","T","C","V","V","J","A","T"};

    public int reflect(int index) {
        String characterToFind = characters[index];
        for(int i = 0; i < characters.length; i++) {
            if(characters[i].equals(characterToFind) && i != index){
                return i;
            }
        }
        return -1;
    }


}
