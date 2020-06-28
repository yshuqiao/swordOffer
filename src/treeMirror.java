//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/27.%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E9%95%9C%E5%83%8F.md
//剑指27. 二叉树的镜像
//对一棵树下面所有子树进行镜像操作

public class treeMirror {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val=val;
        }
    }

    public void Mirror(TreeNode root){
        if(root==null)
            return;
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }
    private void swap(TreeNode root){
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
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

        treeMirror mirrorTree = new treeMirror();
        mirrorTree.Mirror(a1);
        TreeNode c2 = a1.left;
        System.out.println(c2.val);
    }

}
