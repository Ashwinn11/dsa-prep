import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Preorder {
    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);
        tree.right.left = new Tree(6);
        tree.right.right = new Tree(7);
        System.out.println(preorder(tree));
    }

    private static List<Integer> preorder(Tree tree) {
        List<Integer> list = new LinkedList<>();
        Stack<Tree> stack = new Stack<>();
        if (tree == null) return list;
        stack.push(tree);
        while (!stack.isEmpty()){
            tree = stack.pop();
            list.add(tree.data);
            if (tree.right!=null) stack.push(tree.right);
            if (tree.left!=null) stack.push(tree.left);

        }
        return list;
    }
}
