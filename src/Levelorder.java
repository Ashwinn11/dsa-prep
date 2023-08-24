
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Levelorder {
    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);
        tree.right.left = new Tree(6);
        tree.right.right = new Tree(7);
        System.out.println(levelorder(tree));

    }
    public static List<List<Integer>> levelorder (Tree tree) {
        Queue<Tree> queue = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        if (tree == null) return ans;
        queue.add(tree);
        while (!queue.isEmpty()){
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for ( int i =0;i<level;i++){
                if (queue.peek().left!=null) queue.add(queue.peek().left);
                if (queue.peek().right!=null) queue.add(queue.peek().right);
                list.add(queue.poll().data);
            }
            ans.add(list);
        }
        return ans;
    }
}
