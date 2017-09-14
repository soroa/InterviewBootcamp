package list.list_interesection;

import list.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        if (a == null || b == null) return null;
        if (a.next == null || b.next == null) return null;
        if (a == b) return a;
        int lengthA = findListLength(a);
        int lengthB = findListLength(b);
        int difference = Math.abs(lengthA - lengthB);
        ListNode longest = lengthA >= lengthB ? a : b;
        ListNode shorter = lengthA > lengthB ? b : a;
        for (int i = 0; i < difference; i++) {
            longest = longest.next;
        }
        while (longest!= null && shorter!= null) {
            if (longest== shorter) {
                return longest;
            }else{
                longest = longest.next;
                shorter = shorter.next;
            }
        }
        return null;

    }

    private int findListLength(ListNode list) {
        int count = 0;
        while (list != null) {
            count++;
            list = list.next;
        }
        return count;

    }


}

