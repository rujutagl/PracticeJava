package Graph;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Integer, Node> map = new HashMap<>();
        return cloneGraph(node, map);
    }

    private Node cloneGraph(Node node, HashMap<Integer, Node> map){
        if(map.containsKey(node.val)) return map.get(node.val);
        Node copy = new Node(node.val);
        map.put(node.val, copy);
        for(Node neighbour : node.neighbors) copy.neighbors.add(cloneGraph(neighbour, map));
        return copy;
    }
}
