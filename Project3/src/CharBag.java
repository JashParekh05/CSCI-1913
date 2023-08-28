//Jash Parekh
//Project 03

/**
 * The CharBag class is a utility class that allows you to
 * store and manipulate a set of characters. It has a private
 * field counter that stores the count of each character in the
 * set, and a private field totalnums that stores the total number of characters in the set.
 * The class has several methods for adding and
 * removing characters from the set, as well as for
 * getting the count of a particular character and the
 * total size of the set. It also has a toString method
 * that returns a string representation of the letter counter,
 * and a getRandom method that returns a random character from
 * the set with a probability proportional to its count.
 */
public class CharBag {
    private int[] counter;
    private int totalnums;

    public CharBag() {
        this.counter = new int[27];
        this.totalnums = 0;
    }
    /**
     * Add a character to the letter counter.
     * If the character is an uppercase letter, it is converted to lowercase.
     * If the character is not a letter, it is counted as a STOP character.
     * Otherwise, the character is counted as a regular letter.
     * @param ch the character to add
     */

    public void add(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = Character.toLowerCase(ch);
        } else if (ch < 'a' || ch > 'z') {
            ch = LetterSample.STOP;
        }

        if (ch >= 'a' && ch <= 'z') {
            counter[ch - 'a']++;
        } else if (ch == LetterSample.STOP) {
            counter[26]++;
        }
        totalnums++;
    }
    /**
     * Remove a character from the letter counter.
     * If the character is an uppercase letter, it is converted to lowercase.
     * If the character is not a letter, it is treated as a STOP character.
     * If the character is a regular letter or a STOP character, and there is at least one
     * occurrence of it in the counter, it is removed and the total count is decremented.
     * Otherwise, this method has no effect.
     * @param ch the character to remove
     */
    public void remove(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = Character.toLowerCase(ch);
        } else if (ch < 'a' || ch > 'z') {
            ch = LetterSample.STOP;
        }

        if (ch >= 'a' && ch <= 'z' && counter[ch - 'a'] > 0) {
            counter[ch - 'a']--;
            totalnums--;
        } else if (ch == LetterSample.STOP && counter[26] > 0) {
            counter[26]--;
            totalnums--;
        }
    }
    /**
     * If the character is an uppercase letter, it is converted to lowercase.
     * If the character is not a letter, it is treated as a STOP character.
     * If the character is a regular letter or a STOP character, the count of occurrences
     * in the counter is returned. Otherwise, 0 is returned.
     *
     * @param ch the character to get the count for
     * @return the count of the character
     */
    public int getCount(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = Character.toLowerCase(ch);
        } else if (ch < 'a' || ch > 'z') {
            ch = LetterSample.STOP;
        }

        if (ch >= 'a' && ch <= 'z') {
            return counter[ch - 'a'];
        } else if (ch == LetterSample.STOP) {
            return counter[26];
        } else {
            return 0;
        }
    }
    public int getSize() {
        return totalnums;
    }
    /**
     * Returns a string representation of the letter counter.
     * The string consists of the letter counts in the following format:
     * "CharBag{a:x b:y ... z:z STOP:s}" where a, b, ..., z, STOP are the letters
     * and x, y, ..., z, s are their respective counts.
     */
    public String toString() {
        String s = "CharBag{";
        for (int i = 0; i < 26; i++) {
            s += (char) ('a' + i) + ":" + counter[i] + ", ";
        }
        s += LetterSample.STOP + ":" + counter[26] + "}";
        return s;
    }
    /**
     * Returns a random character from the letter counter.
     * The character is chosen randomly with a probability proportional to its count in the counter.
     * If the letter counter is empty, a STOP character is returned.
     *
     */
    public char getRandomChar() {
        if (totalnums == 0) {
            return LetterSample.STOP;
        }
        int index = (int) (Math.random() * totalnums);
        for (int i = 0; i < 26; i++) {
            if (index < counter[i]) {
                return (char) ('a' + i);
            }
            index -= counter[i];
        }
        return LetterSample.STOP;
    }
}
