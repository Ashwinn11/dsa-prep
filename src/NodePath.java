import java.util.*;

class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right;
    BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
public class NodePath {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.right.left = new BinaryTreeNode(6);
        root.left.right.right = new BinaryTreeNode(7);
        root.right = new BinaryTreeNode(3);
        List<Integer> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        allRootToLeaf(root,4,ans,list);
        System.out.println(list);
    }
    public static void allRootToLeaf(BinaryTreeNode root, int target,List<Integer> ans,List<Integer>list) {
        if ( root == null){
            return;
        }
        ans.add(root.data);
        if ( root.data == target){
            list.addAll(ans);
            return;
        }
        allRootToLeaf(root.left,target,ans,list);
        allRootToLeaf(root.right,target,ans,list);
        ans.remove(ans.size()-1);

    }
}
