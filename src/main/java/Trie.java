import edu.princeton.cs.algs4.Queue;

import javax.swing.plaf.PanelUI;

// Modified code from Sedgwik book
public class Trie {
    private static int R = 256;//radix
    private Node root;

    public Trie() {
        root = new Node();
    }

    private static class Node {
        private Node[] next = new Node[R];
        private boolean endOfWord = false;
    }


    public boolean search(String word) {
        Node x = search(root, word, 0);
        return (x == null) ? false : true;
    }

    private Node search(Node x, String word, int d) {
        if (x == null) return null;
        if (d == word.length() && x.endOfWord == false) return null;
        if (d == word.length()) return x;
        char c = word.charAt(d);
        return search(x.next[c], word, d + 1);
    }

    public void insert(String key) {
        root = insert(root, key, 0);
    }

    private Node insert(Node x, String key, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.endOfWord = true;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = insert(x.next[c], key, d + 1);
        return x;
    }

    public boolean startsWith(String pre) {
        return startsWith(root, pre, 0);
    }

    private boolean startsWith(Node x, String pre, int d) {
        if (x == null) return false;
        if (d == pre.length()) return true;
        char c = pre.charAt(d);
        return startsWith(x.next[c], pre, d + 1);
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        System.out.println("Inserting apple.");
        t.insert("apple");
        System.out.println("apple exists: " + t.search("apple"));
        System.out.println("app exists:  " + t.search("app"));
        System.out.println("Starts with \"app\": " + t.startsWith("app"));
        System.out.println("Inserting app.");
        t.insert("app");
        System.out.println("app exists: " + t.search("app"));
    }

}
