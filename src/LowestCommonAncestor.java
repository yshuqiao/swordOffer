//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/68.%20%E6%A0%91%E4%B8%AD%E4%B8%A4%E4%B8%AA%E8%8A%82%E7%82%B9%E7%9A%84%E6%9C%80%E4%BD%8E%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88.md
//剑指68. 树中两个节点的最低公共祖先
//68.1 二叉查找树Leetcode : 235. Lowest Common Ancestor of a Binary Search Tree
//在二叉查找树中，两个节点p,q的公共祖先root满足root.val>=p.val&&root.val<=q.val

//68.2 普通二叉树Leetcode : 236. Lowest Common Ancestor of a Binary Tree
//在左右子树中查找是否存在p或者q，如果p和q分别在两个子树中，那么就说明根节点就是最低公共祖先。
public class LowestCommonAncestor {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val=val;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)
            return root;
        if(root.val>p.val&&root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        if(root.val<p.val&&root.val<q.val)
            return lowestCommonAncestor(root.right,p,q);
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root,TreeNode p,TreeNode q){
        if(root==null||root==p||root==q)
            return root;
        TreeNode left = lowestCommonAncestor2(root.left,p,q);
        TreeNode right = lowestCommonAncestor2(root.right,p,q);
        return left==null?right:right==null?left:root;
    }

    public static void main(String[] args) {
        TreeNode a0 = new TreeNode(4);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(6);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(7);
        a0.left = a1;
        a1.left = a2;
        a1.right = a3;
        a0.right = a4;
        a4.left = a5;
        a4.right = a6;
        LowestCommonAncestor lowest = new LowestCommonAncestor();
        TreeNode common = lowest.lowestCommonAncestor(a0,a5,a6);
        System.out.println(common.val);

        TreeNode b0 = new TreeNode(1);
        TreeNode b1 = new TreeNode(2);
        TreeNode b2 = new TreeNode(4);
        TreeNode b3 = new TreeNode(5);
        TreeNode b4 = new TreeNode(3);
        TreeNode b5 = new TreeNode(6);
        TreeNode b6 = new TreeNode(7);
        b0.left = b1;
        b1.left = b2;
        b1.right = b3;
        b0.right = b4;
        b4.left = b5;
        b4.right = b6;
//        LowestCommonAncestor lowest2 = new LowestCommonAncestor();
        TreeNode common2 = lowest.lowestCommonAncestor2(b0,b5,b6);
        System.out.println(common2.val);
    }
}
