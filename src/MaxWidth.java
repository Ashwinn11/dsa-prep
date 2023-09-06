import java.util.*;
class Pair{
    TreeNode node;
    int level ;
    Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}
public class MaxWidth {
    public static void main(String[] args) {
        TreeNode  root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(6);

        int maxWidth = widthOfBinaryTree(root);
        System.out.println("The maximum width of the Binary Tree is "+maxWidth);

    }
    public static int widthOfBinaryTree(TreeNode root) {
            if(root == null) return 0;
            int ans = 0;
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(root, 0));
            while(!q.isEmpty()){
                int size = q.size();
                int mmin = q.peek().level;
                int first = 0,last = 0;
                for(int i=0; i<size; i++){
                    int cur_id = q.peek().level-mmin;
                    TreeNode node = q.peek().node;
                    q.poll();
                    if(i==0) first = cur_id;
                    if(i==size-1) last = cur_id;
                    if(node.left != null)
                        q.offer(new Pair(node.left, cur_id*2+1));
                    if(node.right != null)
                        q.offer(new Pair(node.right, cur_id*2+2));
                }
                ans = Math.max(ans, last-first+1);
            }
            return ans;
        }
}
