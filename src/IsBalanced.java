//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/55.2%20%E5%B9%B3%E8%A1%A1%E4%BA%8C%E5%8F%89%E6%A0%91.md
//剑指55.2 平衡二叉树
//平衡二叉树左右子树高度差不超过 1。

public class IsBalanced {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val=val;
        }
    }

    private boolean isBalanced = true;

    public boolean isBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }
    private int height(TreeNode root){
        if(root==null||!isBalanced)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>1)
            isBalanced=false;
        return 1+Math.max(left,right);
    }

    public static void main(String[] args) {
        IsBalanced isBalancedSolution = new IsBalanced();

        TreeNode a0 = new TreeNode(10);
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(12);
        a0.left = a1;
        a1.left = a2;
        a1.right = a3;
        a0.right = a4;

        boolean isBalanced = isBalancedSolution.isBalanced_Solution(a0);
        System.out.println(isBalanced);
    }
}
