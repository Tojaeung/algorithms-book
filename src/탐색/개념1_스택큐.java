package 탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 개념1_스택큐 {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.pop();
        stack.push(1);
        stack.push(4);
        stack.pop();

        while (!stack.empty()) {
            System.out.println(stack.peek());
            stack.pop();
        }

        Queue<Integer> q = new LinkedList<>();

        q.offer(5);
        q.offer(2);
        q.offer(3);
        q.offer(7);
        q.poll();
        q.offer(1);
        q.offer(4);
        q.poll();

        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }

    }
}
