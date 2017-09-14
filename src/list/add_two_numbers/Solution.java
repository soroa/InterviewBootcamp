package list.add_two_numbers;

import list.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {

        ListNode dummyHead = new ListNode(-1);
        ListNode resCursor = dummyHead;
        int carryOn = 0;
        while (true) {
            if (a == null) a = new ListNode(0);
            if (b == null) b = new ListNode(0);
            int res = a.val + b.val + carryOn;
            if(res==0 && (a.next==null && b.next==null)) break;
            carryOn = res/10;
            resCursor.next = new ListNode(res%10);
            resCursor = resCursor.next;
            a = a.next;
            b = b.next;
        }
        return dummyHead.next;

    }
}
