//Jash Parekh
// Project 03
/**
 * The Gibberisher class generates random strings
 * based on training data. It has a Trie of CharBag
 * objects called "model" and a generate method that
 * generates a random string based on the model. It
 * also has a train method that takes an array of strings
 * and uses them to train the model. The class has a private
 * helper method called getNextChar which returns the next
 * character to be added to the generated string.
 */
public class Gibberisher {
    private Trie<CharBag> model;
    private int segmentLength;
    private int sampleCount;
    public Gibberisher(int segmentLength) {
        this.segmentLength = segmentLength;
        this.model = new Trie<>();
        this.sampleCount = 0;
    }
    /**
     * Trains the model using the given input strings.
     * This method processes the input strings and updates the model with the
     * frequency of letter transitions. It segments the input strings into
     * segments of a fixed length, and adds the next letter following each segment
     * to the corresponding char bag in the model.
     * @param inputStrings the input strings to train the model on
     */
    public void train(String[] inputStrings) {
        for (int i = 0; i < inputStrings.length; i++) {
            String currentString = inputStrings[i];
            LetterSample[] currentSamples = LetterSample.toSamples(currentString, this.segmentLength);
            for (int j = 0; j < currentSamples.length; j++) {
                LetterSample currentSample = currentSamples[j];
                CharBag currentCharBag = model.get(currentSample.getSegment());
                if (currentCharBag == null) {
                    currentCharBag = new CharBag();
                    model.put(currentSample.getSegment(), currentCharBag);
                }
                currentCharBag.add(currentSample.getNextLetter());
            }
            sampleCount += currentSamples.length;
        }
    }
    public int getSampleCount() {
        return sampleCount;
    }
    /**
     * Generates text based on the trained model.
     * This method generates text by repeatedly selecting a random letter based on
     * the frequency of transitions from the current segment in the model. The
     * current segment is determined by taking the last `segmentLength` characters
     * of the generated text. If the generated text is not long enough to form a
     * full segment, the whole text is used as the current segment.
     * The generation process continues until the `STOP` character is encountered,
     * at which point the method returns the generated text without the `STOP`
     * character. If the `STOP` character is not encountered, the method may run
     * indefinitely.
     * @return the generated text, without the `STOP` character
     */
    public String generate() {
        boolean checker = true;
        String text = "";
        while (checker) {
            String currentSegment = "";
            if (text.length() <= segmentLength) {
                currentSegment = text;
            } else {
                currentSegment = text.substring(text.length() - segmentLength);
            }
            CharBag charModel = model.get(currentSegment);
            char nextChar = charModel.getRandomChar();
            text += nextChar;
            if (text.charAt(text.length() - 1) == LetterSample.STOP) {
                checker = false;
            }
        }
        return text.substring(0, text.length() - 1);
    }
}