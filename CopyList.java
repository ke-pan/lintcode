import java.util.*;
/**
 * Definition for singly-linked list with a random pointer.
 */
 class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 };

public class CopyList {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode node = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode result = new RandomListNode(0);
        RandomListNode resultNode = result;

        while(node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            resultNode.next = newNode;
            resultNode = resultNode.next;
            map.put(node, resultNode);
            node = node.next;
        }
        node = head;
        resultNode = result.next;
        while(node != null) {
            resultNode.random = map.get(node.random);
            node = node.next;
            resultNode = resultNode.next;
        }

        return result.next;
    }
}
