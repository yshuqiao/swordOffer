//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/8.%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E4%B8%8B%E4%B8%80%E4%B8%AA%E7%BB%93%E7%82%B9.md
//剑指8.二叉树的下一个结点
//给定一个二叉树和其中的【一个】结点，请找出【中序遍历顺序】的下一个结点并且返回 。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
//【思考：这意味着整棵二叉树，我只有其中一个结点的值，还有这个结点和其他结点的关系
//特别是：这种二叉树还提供了一个指向父节点的指针】
// 请找出中序遍历顺序的下一个结点并且返回 。
// 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
//思路：① 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
//【因为在中序遍历中，是按左结点、根结点、右结点的顺序遍历，遍历到根结点后下一个自然是右结点那边】
//② 否则，向上找第一个左链接指向的树包含该节点的祖先节点。
//【如果没有右子树，说明这个结点是叶子结点
//如果这个叶子结点是左孩子，则打印父亲
//如果这个叶子结点是右孩子，一直向上找，直到上级是上上级的左孩子
//叶子结点是左孩子或右孩子这两种情况可以合并：都是找到自己是上级的左孩子的那个结点返回】
//在这里，结点和节点意思相同。
public class treeGetNext {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null; //指向父节点的指针

        TreeLinkNode(int val){
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode.right != null){
            TreeLinkNode node = pNode.right;
            while(node.left != null)
                node = node.left;
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode)
                    return parent;
                pNode = pNode.next;
            }
        }
        return null;
    }

    public static void main(String[] args){
        TreeLinkNode atree = new TreeLinkNode(0);
        TreeLinkNode atree1 = new TreeLinkNode(1);
        atree.left = atree1;
        atree1.next =atree;
        TreeLinkNode atree2 = new TreeLinkNode(2);
        atree1.left = atree2;
        atree2.next = atree1;
        TreeLinkNode atree3 = new TreeLinkNode(3);
        atree1.right = atree3;
        atree3.next = atree1;
        TreeLinkNode atree4 = new TreeLinkNode(4);
        atree3.left = atree4;
        atree4.next = atree3;
        TreeLinkNode atree5 = new TreeLinkNode(5);
        atree3.right = atree5;
        atree5.next = atree3;
        TreeLinkNode atree6 = new TreeLinkNode(6);
        atree.right = atree6;
        atree6.next = atree;

        treeGetNext getNext = new treeGetNext();
        TreeLinkNode nextNode = getNext.GetNext(atree2);
        System.out.println(nextNode.val);
    }

}
