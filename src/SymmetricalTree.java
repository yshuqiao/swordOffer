//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/28.%20%E5%AF%B9%E7%A7%B0%E7%9A%84%E4%BA%8C%E5%8F%89%E6%A0%91.md
//剑指28. 对称的二叉树
//判断一棵二叉树内部是否对称
public class SymmetricalTree {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val=val;
        }
    }

    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null)
            return true;
        return isSymmetrical(pRoot.left,pRoot.right);
    }
    boolean isSymmetrical(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null)
            return true;
        if(t1==null||t2==null)
            return false;
        if(t1.val!=t2.val)
            return false;
        return isSymmetrical(t1.left,t2.right)&&isSymmetrical(t1.right,t2.left);
    }

    public static void main(String[] args){
        TreeNode a0 = new TreeNode(0);
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(1);
        TreeNode a5 = new TreeNode(3);
        TreeNode a6 = new TreeNode(2);
        a0.left = a1;
        a1.left = a2;
        a1.right = a3;
        a0.right = a4;
        a4.left = a5;
        a4.right = a6;

        SymmetricalTree isSymmetricalTree = new SymmetricalTree();
        boolean issymmetrical = isSymmetricalTree.isSymmetrical(a0);
        System.out.println(issymmetrical);

    }
}
