//Jash Parekh
//Project 03

/**
 * The TrieNode class is a data structure that represents a node in
 * a trie (prefix tree). It holds data of any type and has an array of child
 * TrieNodes. The class has methods for accessing and modifying its data and children,
 * including getData, getChildren, setData, and getChild. getChild takes a lowercase
 * letter and returns the child TrieNode associated with it, creating a new TrieNode if none exists.
 */

public class TrieNode<T> {
    private T data;
    //for use in trie getNode class
    protected TrieNode<T>[] children;

    public TrieNode() {
        this.data = null;
        this.children = new TrieNode[26];
    }

    public T getData() {
        return data;
    }

    public TrieNode<T>[] getChildren(){
        return children;
    }

    public void setData(T data) {
        this.data = data;
    }
    /**
     * Retrieves the child TrieNode associated with the given letter.
     * If the current TrieNode does not have a child corresponding to the given letter,
     * a new TrieNode is created and added as a child of the current TrieNode.
     * If the letter is not a lowercase letter, null is returned.
     * @param letter the letter to retrieve the child TrieNode for
     * @return the child TrieNode associated with the given letter, or null if the letter is not a lowercase letter
     */
    public TrieNode<T> getChild(char letter) {
        if (letter < 'a' || letter > 'z') {
            return null;
        }
        int index = letter - 'a';
        TrieNode<T> child = children[index];
        if (child == null) {
            child = new TrieNode<>();
            children[index] = child;
        }
        return child;
    }
}