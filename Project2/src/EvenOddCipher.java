//Jash Parekh

/**
 * Class organizes or decodes a string based off of even or odd char index values
 */
public class EvenOddCipher extends BaseCipher {
    //constructor for evenOdd Cipher
    public EvenOddCipher() {
        super("EvenOddCipher");
    }
// Initalizes a new string to add on to the encrypt function. Uses and alternating for loop to add chars to the new
  //  string for even and odd index's. Returns the new word.
    public String encrypt(String word){
        String newWord = "";
        for (int i = 0; i < word.length(); i+=2){
                 newWord += word.charAt(i);
        }
        for (int i = 1; i< word.length(); i+=2){
            newWord += word.charAt(i);
        }
        return newWord;
    }

    /**
     *
     * @param word
     * Initializes three new strings to keep track of the even chars, odd, and the final decrypted char
     * If the word is even, the even chars are aquired from the first half of the array, and the odd
     * chars are aquired from the second. If the word is odd, the index is shifted once and the same
     * proccess is repeated. Then the module adds each even and odd char in sequental order to the newWord
     * accounting for if the word is even length or odd length.
     * then
     * @return String
     */
    public String decrypt(String word) {
        String newWordEven = "";
        String newWordOdd = "";
        String newWord = "";
        if (word.length() % 2 == 0) {
            for (int i = 0; i < word.length() / 2; i++) {
                newWordEven += word.charAt(i);
            }
            for (int n = word.length() / 2; n < word.length(); n++) {
                newWordOdd += word.charAt(n);
            }

        } else {
            for (int i = 0; i < word.length() / 2 + 1; i++) {
                newWordEven += word.charAt(i);
            }
            for (int n = word.length() / 2 + 1; n < word.length(); n++) {
                newWordOdd += word.charAt(n);
            }
        }
        if (newWordEven.length() > newWordOdd.length()) {
            for (int i = 0; i < newWordOdd.length(); i++) {
                String even = Character.toString(newWordEven.charAt(i));
                String odd = Character.toString(newWordOdd.charAt(i));
                newWord += even + odd;
            }
            newWord += newWordEven.charAt(newWordEven.length() - 1);
        } else {
            for (int i = 0; i < newWordEven.length(); i++) {
                String even = Character.toString(newWordEven.charAt(i));
                String odd = Character.toString(newWordOdd.charAt(i));
                newWord += even + odd;
            }
        }
        return newWord;
    }

    public String toString(){
        return "EvenOddCipher";
    }
//Checks to see if object evenodd is in the current object, returns true or false. ALso checks for null exceptions
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other instanceof EvenOddCipher) {
            return true;
        } else {
            return false;
        }
    }







}
