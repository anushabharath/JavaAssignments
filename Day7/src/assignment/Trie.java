package assignment;

import java.util.HashMap;
import java.util.Map;

// Definition of a TrieNode
class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    // Constructor
    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

// Definition of the Trie
class Trie {
    private TrieNode root;

    // Constructor
    public Trie() {
        root = new TrieNode();
    }

    // Function to insert a word into the trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEndOfWord = true;
    }

    // Function to check if the given prefix exists in the trie
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) {
                return false;
            }
        }
        return true;
    }

    // Function to check if the word exists in the trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) {
                return false;
            }
        }
        return node.isEndOfWord;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("hello");
        trie.insert("world");

        System.out.println(trie.startsWith("hel")); // Output: true
        System.out.println(trie.startsWith("wor")); // Output: true
        System.out.println(trie.startsWith("hola")); // Output: false

        System.out.println(trie.search("hello")); // Output: true
        System.out.println(trie.search("hell")); // Output: false
    }
}

