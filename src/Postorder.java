import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Postorder {
    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);
        tree.right.left = new Tree(6);
        tree.right.right = new Tree(7);
        System.out.println(postorder(tree)); // using 1 stack and finally reversing the list
        System.out.println(postorder2(tree)); // using 2 stack because another stack helps not to reverse anything.
    }

    private static List<Integer> postorder(Tree tree) {
        Stack<Tree> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();

        stack.push(tree);
        while (!stack.isEmpty()){
            tree = stack.pop();
            list.add(tree.data);
            if (tree.left!=null) stack.push(tree.left);
            if(tree.right!=null) stack.push(tree.right);
        }
        int start = 0;
        int end = list.size()-1;

        while(start<=end){
            int temp = list.get(start);
            list.set(start,list.get(end));
            list.set(end,temp);
            start++;
            end--;
        }
        return list;

    }
    private static List<Integer> postorder2 (Tree tree){
        Stack<Tree> stack1 = new Stack<>();
        Stack<Tree> stack2 = new Stack<>();
        List<Integer> list = new LinkedList<>();

        stack1.push(tree);
        while (!stack1.isEmpty()){
            tree = stack1.pop();
            stack2.push(tree);
            if (tree.left!=null) stack1.push(tree.left);
            if(tree.right!=null) stack1.push(tree.right);
        }
        while(!stack2.isEmpty()){
            list.add(stack2.pop().data);
        }
        return list;

    }
}
