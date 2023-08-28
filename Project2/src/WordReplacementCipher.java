// Jash Parekh
// WordReplacementCipher either decodes or encodes two words according to user input replacing one for the other
public class WordReplacementCipher extends BaseCipher{
    String to;
    String from;
//Getter for the to variable
    public String getTo() {
        return to;
    }
//Setter for the from variable
    public String getFrom() {
        return from;
    }
//Extends the basecipher class and assigns the variables to and from
    public WordReplacementCipher (String oldWord, String newWord){
        super("WordReplacementCipher");
        this.from = oldWord;
        this.to = newWord;
    }
    //Uses the replace function to change all instances of the from and to functions
    public String encrypt(String word) {
        word = word.replace(from, to);
        return word;
    }
   // Uses the replace function to change all instances of the to and from functions to decryot the code
    public String decrypt(String word) {
        word = word.replace(to, from);
        return word;
    }

    public String toString(){
        return "WordReplacementCipher(" + from + ", " + to + ")";
    }
//     Uses the baseCipher equals method to check and see if each object is a duplicate. When determined that
//     the module is not a duplicate, it checks to see if the to and from ints of two different objects are equal.
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (other == null) {
            return false;
        } else if (other instanceof WordReplacementCipher) {
            WordReplacementCipher cipher = (WordReplacementCipher) other;
            return to == cipher.getTo() && from == cipher.getFrom();
        } else {
            return false;
        }
    }




}
