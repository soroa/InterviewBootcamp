package stacks_and_queues.rpn;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public int evalRPN(ArrayList<String> a) {
        Stack<String> stack = new Stack();
        for (String el : a) {
            switch (el) {
                case "+":
                    stack.push(String.valueOf(Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop())));
                    break;
                case "-":
                    stack.push((String.valueOf(-1 * (Integer.parseInt(stack.pop()) - Integer.parseInt(stack.pop())))));
                    break;
                case "*":
                    stack.push(String.valueOf(Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop())));
                    break;
                case "/":
                    int denominator = Integer.parseInt(stack.pop());
                    int numerator = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(numerator / denominator));
                    break;
                default:
                    stack.push(el);

            }
        }
        return Integer.parseInt(stack.pop());
    }
}
