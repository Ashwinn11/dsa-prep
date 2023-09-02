import java.util.ArrayList;
import java.util.*;
public class Leftview {
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
        List<Integer> list = new ArrayList<>();
        leftview(root,list,0);
        System.out.println(list);

    }
    private static void leftview(TreeNode root,List<Integer> list,int level) {
        if (root == null) {
            return;
        }
        if(list.size() ==level) list.add(root.data);
        if(root.left!=null) leftview(root.left,list,level+1);
        if(root.right!=null) leftview(root.right,list,level+1);

    }
}
