package list.reorder_list;

import javafx.util.Pair;
import list.ListNode;

import java.util.ArrayList;

public class Solution {
    public ListNode reorderList(ListNode a) {

        ListNode reversedList = reveresList(a);
        int count = findListLength(a);
        ListNode reorderedListDummyHead = new ListNode(-1);
        reorderedListDummyHead.next = a;
        ListNode redorderedListCursor = reorderedListDummyHead;
        for (int i = 0; i < count/2; i++) {
            redorderedListCursor.next = new ListNode(a.val);
            redorderedListCursor.next.next = new ListNode(reversedList.val);
            redorderedListCursor = redorderedListCursor.next.next;
            a = a.next;
            reversedList = reversedList.next;
        }
        if(reversedList!=null){
            redorderedListCursor.next = new ListNode(reversedList.val);
        }
        return reorderedListDummyHead.next;
    }

    public ListNode reveresList(ListNode a) {
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

    private int findListLength(ListNode list) {
        int count = 0;
        while (list != null) {
            count++;
            list = list.next;
        }
        return count;

    }

}
