import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Practise {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
    }
    public static void reverseStack(Stack<Integer> stack) {
        Queue<Integer> queue = new LinkedList<>();
        int n = stack.size();
        for ( int i = 0;i<n;i++){
            queue.add(stack.pop());
        }
        for ( int i = 0;i<n;i++){
            stack.add(queue.poll());
        }
    }
}
