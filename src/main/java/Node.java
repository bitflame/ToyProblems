public class Node {
    int source;
    int destination;
    int minimumDistance;
    int ancestor;
    Node next;
    int hash = -1;

    Node(int src, int dest, int minDist, int ances) {
        source = src;
        destination = dest;
        minimumDistance = minDist;
        ancestor = ances;
    }

    Node(int src, int dest) {
        source = src;
        destination = dest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return source == node.source && destination == node.destination;
    }

    @Override
    public int hashCode() {
        // M = 97
        int hash = 17;
        hash = (31 * hash + ((Integer) source).hashCode() & 0x7fffffff) % 97;
        hash = (31 * hash + ((Integer) destination).hashCode() & 0x7fffffff) % 97;
        this.hash = hash;
        return hash;
    }
}