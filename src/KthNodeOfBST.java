//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/54.%20%E4%BA%8C%E5%8F%89%E6%9F%A5%E6%89%BE%E6%A0%91%E7%9A%84%E7%AC%AC%20K%20%E4%B8%AA%E7%BB%93%E7%82%B9.md
//剑指54. 二叉查找树的第 K 个结点
//思路：利用二叉查找树中序遍历有序的特点。
public class KthNodeOfBST {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val=val;
        }
    }

    private TreeNode ret;
    private int cnt = 0;

    public TreeNode KthNode(TreeNode pRoot,int k){
        inOrder(pRoot,k);
        return ret;
    }

    private void inOrder(TreeNode root,int k){
        if (root==null||cnt>=k)
            return;
        inOrder(root.left,k);
        cnt++;
        if(cnt==k)
            ret=root;
        inOrder(root.right,k);
    }

    public static void main(String[] args) {
        KthNodeOfBST kthNodeOfBST = new KthNodeOfBST();

        TreeNode a0 = new TreeNode(10);
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(12);
        a0.left = a1;
        a1.left = a2;
        a1.right = a3;
        a0.right = a4;

        TreeNode Kth = kthNodeOfBST.KthNode(a0,3);
        System.out.println(Kth.val);
    }

}
