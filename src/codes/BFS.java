import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You're given a Node class that has a name and an array of optional children nodes. When put together, nodes from an acyclic
 * tree-like structure.
 * Implement the breathFirstSearch method on the Node class, which takes in an empty array, traverses the tree using the Breadth-first Search
 * approach (specifically navigating the tree from the left to right), stores all of the nodes' names in the input array and returns it.
 *           A
 *        /  |  \
 *       B   c   D
 *      / \     / \
 *     E   F   G   H
 *        / \   \
 *       I   J   K
 */
public class BFS {
    
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();
    
        public Node(String name) {
            this.name = name;
        }
    
        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);
        
            while (!queue.isEmpty()) {
                Node current = queue.poll();
                array.add(current.name);
                queue.addAll(current.children);
            }
            return array;
        }
    
        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
