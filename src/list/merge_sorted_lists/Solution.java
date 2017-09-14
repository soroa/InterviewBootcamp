package list.merge_sorted_lists;

import list.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummyHead = new ListNode(-1);
        ListNode resCursor = dummyHead;

        while (true) {
            if (a == null || b==null) {
                resCursor.next = a == null ? b : a;
                break;
            }
            if (a.val <= b.val) {
                resCursor.next = new ListNode(a.val);
                resCursor = resCursor.next;
                a = a.next;

            } else {
                resCursor.next = new ListNode(b.val);
                resCursor = resCursor.next;
                b = b.next;
            }
        }
        return dummyHead.next;
    }


}
