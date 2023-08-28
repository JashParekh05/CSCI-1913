//Jash Parekh
import java.util.Arrays;
// Super Cipher adds all ciphers into an array and combines the amount of ciphers used
public class SuperCipher extends BaseCipher{
    BaseCipher [] ciphers;
//Getter for the array of Ciphers
    public BaseCipher[] getCiphers() {
        return ciphers;
    }
//Constructor for superCipher Class
    public SuperCipher (BaseCipher [] c){
        super("SuperCipher");
        this.ciphers = c;
    }
    //Checks to see if each cipher is valid by using the base cipher class
    public boolean isValid(){
        for (int i = 0; i < ciphers.length; i++){
            if (!ciphers[i].isValid()){
                return false;
            }
        }
        return true;
    }
// Changes the string based on which ciphers are in the ciphers array and encrypts the message
    public String encrypt(String s){
        for (int i =0; i < ciphers.length; i++){
            s = ciphers[i].encrypt(s);
        }
        return s;
    }
// Changes the string based on which ciphers are in the ciphers array and decrypts the message
    public String decrypt(String s){
        for (int i = ciphers.length - 1; i >= 0; i--){
            s = ciphers[i].decrypt(s);
        }
        return s;
    }
// To string lists each individual cipher starting with SuperCipher( and uses "|" to break them up.
    public String toString(){
        String newString ="SuperCipher(";
        for (int i = 0; i < ciphers.length; i++) {
            if (i != ciphers.length - 1) {
                newString += ciphers[i].toString();
                newString += " | ";
            } else{
                newString += ciphers[i].toString();
            }
        }
        newString += ")";
        return newString;
    }
    // Uses the baseChiper equals method to check and see if each object is a duplicate. When determined that
    // the module is not a duplicate, it checks to see if cihper array is equal using the arrays.equal.
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (other == null) {
            return false;
        } else if (other instanceof SuperCipher) {
            SuperCipher cipher = (SuperCipher) other;
            return Arrays.equals(ciphers,cipher.getCiphers());
        } else {
            return false;
        }
    }

}
