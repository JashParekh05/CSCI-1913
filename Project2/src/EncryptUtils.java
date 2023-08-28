//Jash Parekh
//Module uses for loop and creates a new array of encrypted or decrypted strings according to the cipher given by the object
public class EncryptUtils {
    //Module uses for loop and creates a new array of encrypted strings according to the cipher given by the object
    public static String[] encryptMany(BaseCipher cipher, String[] Ciphers){
        String [] encrypted = new String[Ciphers.length];
        for (int i = 0; i < Ciphers.length; i++){
            encrypted[i] = cipher.encrypt(Ciphers[i]);
        }
        return encrypted;
    }
    //Module uses for loop and creates a new array of decrypted strings according to the cipher given by the object
    public static String[] decryptMany(BaseCipher c, String[] Ciphers){
        String [] decrypted = new String[Ciphers.length];
        for (int i = Ciphers.length - 1; i >= 0 ; i--){
            decrypted[Ciphers.length - 1 - i] = c.decrypt(Ciphers[Ciphers.length - 1 - i]);
        }
        return decrypted;
    }
}
