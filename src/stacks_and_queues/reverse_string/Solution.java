package stacks_and_queues.reverse_string;

import java.util.Stack;

public class Solution {
    public String reverseString(String a) {
        Stack<String> stack = new Stack();
        for (int i = 0; i < a.length(); i++) {
            stack.push(a.substring(i, i + 1));
        }
        String res = "";
        for (int i = 0; i < a.length(); i++) {
            res = res.concat(stack.pop());
        }
        return res;
    }
}

