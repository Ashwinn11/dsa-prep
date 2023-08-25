import java.util.Stack;

public class Stackreverse {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
    }

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int val = stack.pop();
        reverseStack(stack);
        insert(stack,val);
    }
    private static void insert(Stack<Integer> stack, int val){
        if (stack.isEmpty()){
            stack.push(val);
            return;
        }
        int num = stack.pop();
        insert(stack,val);
        stack.push(num);
    }
}
