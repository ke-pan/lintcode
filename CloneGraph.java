import java.util.*;
/**
 * Definition for undirected graph.
 */
  class UndirectedGraphNode {
     int label;
     ArrayList<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };

public class CloneGraph {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        nodes.add(node);
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode n = nodes.get(i);
            if (!map.containsKey(n)) {
                UndirectedGraphNode newNode = new UndirectedGraphNode(n.label);
                map.put(n, newNode);
                for (int j = 0; j < n.neighbors.size(); j++) {
                    nodes.add(n.neighbors.get(j));
                }
            }
        }

        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();

        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode n = nodes.get(i);
            if (!set.contains(n)){
                for (int j = 0; j < n.neighbors.size(); j++) {
                    map.get(n).neighbors.add(map.get(n.neighbors.get(j)));
                }
                set.add(n);
            }
        }

        return map.get(node);
    }
}
