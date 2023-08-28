//Jash Parekh
// Caesar Cipher class moves char value 1-25 indexes based on user input. Class decodes or encodes string
public class CaesarCipher extends BaseCipher{
    private int keyVal;
    /*
    Caesar Cipher constructor with int parameter outlining how much the message is moved
     */
    public CaesarCipher(int value){
        super("CaesarCipher");
        keyVal = value;
    }

    public int getKeyVal(){
        return keyVal;
    }

    /*
    Checks to see if keyValue is in the accepted range
    */
    public boolean isValid(){
        return (keyVal >= 1 && keyVal < 26);
    }
    /*
    Takes the message and converts all chars to lowercase. Initializes a new
    string to add updated chars to. Using a for loop, each chars ascii value is found
    and checked to see if it is an accepted character. If it is, then the ascii value is
    added on to the chars. If ascii value is less than in the range, it resets the character.
    The value is converted back to a char and added on to the string.
    Returns new string.
    */
    public String encrypt(String secMessage){
        secMessage = secMessage.toLowerCase();
        String encString = "";
        char letter;
        for (int i = 0; i < secMessage.length(); i++) {
            letter = secMessage.charAt(i);
            int c = letter;
            if (c >= 32 && c <= 64 ) {
                char a = (char) c;
                encString += a;
            } else {
                c += keyVal;
                if (c > 122) {
                    c -= 26;
                }
                char a = (char) c;
                encString += a;
            }
        }
        return encString;
    }
    /*
    Takes the message and converts all chars to lowercase. Initializes a new
    string to add updated chars to. Using a for loop, each chars ascii value is found
    and checked to see if it is an accepted character. If it is, then the ascii value is
    subtracted on to the chars. If ascii value is less than in the range, it resets the character.
    The value is converted back to a char and added on to the string.
    Returns new string.
    */
    public String decrypt(String name){
        name = name.toLowerCase();
        String encString = "";
        char letter;
        for (int i = 0; i < name.length(); i++) {
            letter = name.charAt(i);
            int c = letter;
            if (c >= 32 && c <= 64) {
                char a = (char) c;
                encString += a;
            } else {
                c -= keyVal;
                if (c < 97) {
                    c += 26;
                }
                char a = (char) c;
                encString += a;
            }
        }
        return encString;
    }
    /*
    Message toString: outlining what Caesar number is.
    */
    public String toString() {
        return "Caesar(" + keyVal + ')';
    }

//    public boolean equals(CaesarCipher c){
//        if (c == null) {
//            return false;
////        }
////
////        return (this.keyVal == c.getKeyVal());
////    }
//    public boolean equals(Object other) {
//        return super.equals(other);
//    }
public boolean equals(Object other) {
    if (other == this) {
        return true;
    } else if (other == null) {
        return false;
    } else if (other instanceof CaesarCipher) {
        CaesarCipher cipher = (CaesarCipher) other;
        return cipher.keyVal == this.keyVal;
    } else {
        return false;
    }
}


}
