import java.util.*;
/**
 * Definition for ListNode.
 */
  class ListNode {
     int val;
     ListNode next;
     ListNode(int val) {
         this.val = val;
         this.next = null;
     }
 }

public class MergeList {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        int i = 0;
        int size = lists.size() - 1;
        while (i < size) {
            lists.add(merge2Lists(lists.get(i++), lists.get(i++)));
            size = lists.size() - 1;
        }

        return lists.get(i);

    }

    private ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode node = result;

        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 == null) {
            node.next = list2;
        } else {
            node.next = list1;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ArrayList<ListNode> lists = new ArrayList<ListNode>();
        ListNode l = new ListNode(2);
        lists.add(l);
        lists.add(null);
        lists.add(new ListNode(-1));
        MergeList s = new MergeList();
        l = s.mergeKLists(lists);
        while(l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}
