import java.util.HashMap;

public class LRUCache {

    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity = 0;
    HashMap<Integer, Node> map = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    // O(1)
    public int get(int key) {
        if(map.containsKey(key)){
            // need to move this to top as this is used
            // insert
            Node temp = map.get(key);
            remove(temp);
            insert(temp);
            return temp.value;
        }
        return -1;
    }

    void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev= node.prev;
    }

    void insert(Node node){
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }
    // // O(1)
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // value is present we need to move it up so remove first
            remove(map.get(key));
        }
        if(capacity == map.size()){
            remove(tail.prev);
        }
        // tail.pre is least recently used
        insert(new Node(key, value));
    }

    class Node{
        Node prev, next;
        int key, value;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
