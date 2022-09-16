public class Trie {
    private static int R = 256;//radix
    private Node root;

    private static class Node {
        private Node[] next = new Node[R];
        private Object val;
    }

    private void size() {
        for (char c = 0; c < R; c++) {
            System.out.print(" " + c);
        }
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.size();
    }

}
