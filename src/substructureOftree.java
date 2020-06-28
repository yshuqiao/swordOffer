//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/26.%20%E6%A0%91%E7%9A%84%E5%AD%90%E7%BB%93%E6%9E%84.md
//剑指26.树的子结构
//判断一棵树是不是另一棵树的子树（包含关系）
public class substructureOftree {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val=val;
        }
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2){
        if(root1==null||root2==null)
            return false;
        return isSubtreeWithRoot(root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }
    private boolean isSubtreeWithRoot(TreeNode root1,TreeNode root2){
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        if(root1.val!=root2.val)
            return false;
        return isSubtreeWithRoot(root1.left,root2.left)&&isSubtreeWithRoot(root1.right,root2.right);
    }

    public static void main(String[] args){
        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(8);
        TreeNode a3 = new TreeNode(9);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(7);
        TreeNode a6 = new TreeNode(1);
        TreeNode a7 = new TreeNode(1);
        a1.left = a2;
        a2.left = a3;
        a2.right = a4;
        a1.right = a5;
        a5.left = a6;
        a5.right = a7;
        TreeNode b1 = new TreeNode(8);
        b1.left = a3;
        b1.right = a4;

        substructureOftree isSubstructure = new substructureOftree();
        boolean isSubtree = isSubstructure.HasSubtree(a1,b1);
        System.out.println(isSubtree);
    }

}
