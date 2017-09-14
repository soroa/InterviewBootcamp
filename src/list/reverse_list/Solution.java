package list.reverse_list;

import list.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode a) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (a != null) {
            list.add(a);
            a = a.next;
        }
        for (int i = list.size() - 1; i > 0; i--) {
            list.get(i).next = list.get((i - 1));
        }
        list.get(0).next = null;
        return list.get(list.size());
    }


    public ListNode revereList2(ListNode a) {
        if (a == null) return null;
        if (a.next == null) {
            return a;
        }
        ListNode next = null;
        ListNode prev = a.next;
        while (a.next != null) {
            a.next = next;
            next = a;
            a = prev;
            prev = prev.next;
        }
        a.next = next;
        return a;
    }

}
