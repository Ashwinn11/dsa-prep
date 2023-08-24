import java.util.*;
import java.util.LinkedList;

public class InOrder {
    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);
        tree.right.left = new Tree(6);
        tree.right.right = new Tree(7);
        System.out.println(inorder(tree));
    }

    private static List<Integer> inorder(Tree node) {
        List<Integer> ans = new LinkedList<>();
        Stack<Tree> stack = new Stack<>();
        while (true){
            if(node!=null){
                stack.push(node);
                node = node.left;
            }
            else {
                if (stack.isEmpty()) break;
                node = stack.peek();
                ans.add(node.data);
                stack.pop();
                node = node.right;
            }
        }
        return ans;

    }
}
