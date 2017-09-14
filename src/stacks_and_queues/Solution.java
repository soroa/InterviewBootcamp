package stacks_and_queues;

import java.util.Stack;

public class Solution {
    public int isValid(String a) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            String currentParanthesis = a.substring(i, i + 1);
            switch (currentParanthesis) {
                case "[":
                case "(":
                case "{":
                    stack.push(currentParanthesis);
                    break;
                case "]":
                    if (stack.isEmpty() || !stack.pop().equals("[")) {
                        return 0;
                    }
                    break;
                case "}":
                    if (stack.isEmpty() || !stack.pop().equals("{")) {
                        return 0;
                    }
                    break;
                case ")":
                    if (stack.isEmpty() || !stack.pop().equals("(")) {
                        return 0;
                    }
                    break;
            }
        }
        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}

