import java.util.*;
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
class Self{
    TreeNode node;
    int level;
    Self (TreeNode node , int level){
        this.node = node;
        this.level = level;
    }
}
public class BinaryTopView {
    static ArrayList<Integer> topView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        queue.add(new Tuple(root, 0));
        while (!queue.isEmpty()) {
            Tuple temp = queue.poll();
            TreeNode node = temp.node;
            int level = temp.level;
            if (!map.containsKey(level)) {
                map.put(level, node.data);
            }
            if (node.left != null) queue.add(new Tuple(node.left, level - 1));
            if (node.right != null) queue.add(new Tuple(node.right, level + 1));

        }
        ans.addAll(map.values());
        return ans;
    }

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
        List<Integer>  list = new ArrayList<>(topView(root));
        System.out.println(list);

    }
}


