import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.*;
class Tuple {
    TreeNode node;
    int level;
    Tuple(TreeNode node , int level){
        this.node = node;
        this.level = level;
    }
}
public class RightView {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);
        List<Integer> list = new ArrayList<>(rightview(root));
        System.out.println(list);

    }
    private static List<Integer> rightview(TreeNode root) {
        Queue<Tuple> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        queue.add(new Tuple(root,0));
        while(!queue.isEmpty()){
            Tuple temp = queue.poll();
            TreeNode node = temp.node;
            int level = temp.level;
            map.put(level, node.data);
            if(node.left!=null) queue.add(new Tuple(node.left,level+1));
            if(node.right!=null) queue.add(new Tuple(node.right,level+1));
        }
        ans.addAll(map.values());
        return ans;
    }
}
