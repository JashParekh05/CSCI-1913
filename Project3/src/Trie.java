//Jash Parekh
//Project 03

/**
 * The Trie class is a data structure that implements a trie (prefix tree)
 * and holds data of any type. It has a root node and several methods for
 * interacting with the trie, including getNode, which returns the TrieNode
 * corresponding to a given String in the trie, get, which returns the data
 * associated with a given String in the trie, and put, which associates a
 * value with a given String in the trie.
 * @param <T>
 */

public class Trie<T> {
    private TrieNode<T> root;

    public Trie() {
        root = new TrieNode<>();
    }
    /**
     * @param key the key to search for in the Trie
     * @return the TrieNode corresponding to the given key, or null if the key is not in the Trie
     * Uses for loop to traverse through currentNode and assigns each node a char
     */
    private TrieNode<T> getNode(String key) {
        TrieNode<T> currentNode = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            TrieNode<T> child = currentNode.children[c - 'a'];
            if (child == null) {
                child = new TrieNode<>();
                currentNode.children[c - 'a'] = child;
            }
            currentNode = child;
        }
        return currentNode;
    }


    public TrieNode<T> getRoot(){
        return root;
    }
    /**
     * Returns the data associated with the given key in the Trie.
     * @param s the key to search for in the Trie
     * @return the data associated with the key, or null if the key is not in the Trie
     */
    public T get(String s) {
        TrieNode<T> node = getNode(s);
        return node.getData();
    }

    /**
     * If the key is already in the Trie, the existing value is overwritten.
     * If the key is not in the Trie, it is added along with the value.
     * @param s the key to associate the value with
     * @param value the value to associate with the key
     */
    public void put(String s, T value) {
        TrieNode<T> node = getNode(s);
        node.setData(value);
    }
}
