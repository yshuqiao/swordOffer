//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/55.1%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%B7%B1%E5%BA%A6.md
//剑指55.1 二叉树的深度
//从根结点到叶结点（含根、叶结点）形成树的一条路径，最长路径为树的深度。
public class TreeDepth {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val=val;
        }
    }

    public int TreeDepth_Solution(TreeNode root){
        return root == null?0:1+Math.max(TreeDepth_Solution(root.left),TreeDepth_Solution(root.right));
    }

    public static void main(String[] args) {
        TreeDepth treeDepth = new TreeDepth();

        TreeNode a0 = new TreeNode(10);
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(12);
        a0.left = a1;
        a1.left = a2;
        a1.right = a3;
        a0.right = a4;

        int depth = treeDepth.TreeDepth_Solution(a0);
        System.out.println(depth);
    }
}
