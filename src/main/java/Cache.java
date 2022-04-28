public class Cache {

    int M = 97; // table size
    private Node[] table;

    private Cache() {
        table = new Node[M];
    }

    private Node get(Integer source, Integer destination) {
        Node node = new Node(source, destination);
        Node revNode = new Node(destination, source);
        if (table[node.hashCode()] != null) {
            for (Node x = table[node.hash]; x != null; x = x.next) {
                if (x.source == source && x.destination == destination) return x;
            }
        } else if (table[revNode.hashCode()] != null) {
            for (Node x = table[revNode.hash]; x != null; x = x.next) {
                if (x.source == destination && x.destination == source) return x;
            }
        }
        return null;
    }

    private void updateNode(Node node) {
        int hash = node.hashCode();
        for (Node x = table[hash]; x != null; x = x.next) {
            if ((x.source == node.source && x.destination == node.destination) || (x.destination == node.source && x.source == node.destination)) {
                node.next = table[hash].next;
                table[hash] = node;
            }
        }
    }

    private void put(Node node) {
        if (table[node.hashCode()] == null) {
            Node first = node;
            table[node.hash] = first;
        } else {
            node.next = table[node.hash];
            table[node.hash] = node;
        }
    }

    public static void main(String[] args) {
        Cache cache = new Cache();
        // new node with min dist 10, ancestor 12
        Node n = new Node(1, 2, 10, 12);
        cache.put(n);
        cache.updateNode(new Node(1, 2, 8, 12));
    }
}