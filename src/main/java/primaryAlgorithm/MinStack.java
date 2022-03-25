package primaryAlgorithm;

import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MinStack {
    Element pre;
    Element top;
    Element base;
    public static class Element{
        int ele;
        Element next;
    }


    public MinStack() {
        top = new Element();
        base = top;
    }

    public void push(int val) {
        top.ele = val;
        top.next = pre;
        pre = top;
        top = new Element();
    }

    public void pop() {
        if(pre == null){
            throw new NullPointerException();
        }
        pre = pre.next;
    }

    public int top() {
        try {
            return pre.ele;
        }catch (NullPointerException n){
            throw new NullPointerException();
        }
    }

    public int getMin() {
        try {
            Element temp = pre;
            int min = Integer.MAX_VALUE;
            while (temp != null) {
                if (temp.ele < min) {
                    min = temp.ele;
                }
                temp = temp.next;
            }
            return min;
        }catch (NullPointerException n){
            throw new NullPointerException();
        }
    }



    public static void main(String[] args) {
        Stack<Integer>stack0 = new Stack<>();
        stack0.push(-9);
        stack0.push(8);
        stack0.push(5);
        System.out.println(stack0.peek());
        System.out.println(stack0.pop());
        int min = Integer.MAX_VALUE;
        //lambda表达式中引用的局部外部变量必须是final的 不允许改变
        stack0.forEach((s)->{

        });
        for(var x:stack0){
            if(x<min){
                min = x;
            }
        }
//        primaryAlgorithm.MinStack stack = new primaryAlgorithm.MinStack();
//        stack.push(6);
////        stack.push(-9);
////        stack.push(8);
////        stack.push(5);
////        stack.push(-5);
//        System.out.println(stack.getMin());
//        System.out.println(stack.top());
//
//        stack.pop();
//        //System.out.println(stack.top());
    }
}
