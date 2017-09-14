package list.delete_duplicates;

import list.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode a) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = a;
        ListNode cursor = dummyHead;
        while (cursor.next != null && cursor.next.next != null) {
            if (cursor.next.val == cursor.next.next.val) {
                while (cursor.next.val == cursor.next.next.val) {
                    cursor.next.next = cursor.next.next.next;
                    if (cursor.next.next == null) break;
                }
                cursor.next = cursor.next.next;
            }else{
                cursor = cursor.next;
            }
        }
        return dummyHead.next;
    }
}

