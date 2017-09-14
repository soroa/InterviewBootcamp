package stacks_and_queues.redundant_braces;

import java.util.Stack;

public class Solution {
    public int braces(String a) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            String currenChar = a.substring(i, i + 1);
            switch (currenChar) {
                case "[":
                case "(":
                case "{":
                    stack.push(currenChar);
                    break;
                case "]":
                case "}":
                case ")":
                    if (!stack.empty() && stack.peek().equals("EX")) {
                        stack.pop();
                        stack.pop();//must be opening parenthesis
                        if(!stack.empty() && stack.peek().equals("OP")){
                            stack.pop();//pop operator
                            stack.pop();// pop number
                            stack.push("EX");
                        }else{
                            stack.push("N");
                        }
                    } else if(stack.peek().equals("N")){
                        return 1;
                    }
                    break;
                case "*":
                case "+":
                case "-":
                case "/":
                    stack.push("OP");
                    break;
                default:
                    if (!stack.empty() && stack.peek().equals("OP")) {
                        stack.pop();//op
                        stack.pop();//num or ex
                        stack.push("EX");
                    }else{
                        stack.push("N");
                    }
            }
        }
        return 0;

    }
}
