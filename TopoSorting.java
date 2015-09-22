import java.util.*;
/**
 * Definition for Directed graph.
 */
  class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 };

public class TopoSorting {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();

        if (graph == null || graph.size() == 0) {
            return result;
        }

        // find first node
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for (int i = 0; i < graph.size(); i++ ) {
            DirectedGraphNode node = graph.get(i);
            if (node.neighbors != null) {
                for (int j = 0; j < node.neighbors.size(); j++) {
                    DirectedGraphNode neighborNode = node.neighbors.get(j);
                    if (map.containsKey(neighborNode)) {
                        map.put(neighborNode, map.get(neighborNode) + 1);
                    } else {
                        map.put(neighborNode, 1);
                    }
                }
            }
        }

        for (int i = 0; i < graph.size(); i++ ) {
            DirectedGraphNode node = graph.get(i);
            if (!map.containsKey(node)) {
                result.add(node);
            }
        }

        // BFS
        for (int i = 0; i < result.size(); i++) {
            DirectedGraphNode node = result.get(i);
            for (int j = 0; j < node.neighbors.size(); j++) {
                DirectedGraphNode neighborNode = node.neighbors.get(j);
                map.put(neighborNode, map.get(neighborNode) - 1);
                if (map.get(neighborNode) == 0) {
                    result.add(neighborNode);
                }
            }
        }
        return result;
    }
}
