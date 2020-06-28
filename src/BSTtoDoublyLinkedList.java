import java.util.ArrayList;
import java.util.List;

//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/36.%20%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E4%B8%8E%E5%8F%8C%E5%90%91%E9%93%BE%E8%A1%A8.md
//剑指36. 二叉搜索树与双向链表
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
//题外话：java中的LinkedHashMap用到了双向链表
//Me：未看懂
public class BSTtoDoublyLinkedList {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val=val;
        }
    }

    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode root){
        inOrder(root);
        return head;
    }
    private void inOrder(TreeNode node){
        if(node==null)
            return;
        inOrder(node.left);
        node.left = pre;
        if(pre!=null)
            pre.right=node;
        pre = node;
        if(head == null)
            head = node;
        inOrder(node.right);
    }


    public static void main(String[] args) {
        TreeNode a0 = new TreeNode(10);
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(12);
        a0.left = a1;
        a1.left = a2;
        a1.right = a3;
        a0.right = a4;

        BSTtoDoublyLinkedList convert = new BSTtoDoublyLinkedList();
        TreeNode newa0 = convert.Convert2(a0);
        TreeNode newa1 = newa0.right;
        System.out.println(newa0.val);
        System.out.println(newa1.val);
    }

    //法2，来自up主子烁爱学习
    public TreeNode Convert2(TreeNode pRootOfTree){
        if(pRootOfTree==null)
            return null;
        List<TreeNode> tmpList = new ArrayList<>();
        //注意：这里开辟了新的内存空间
        InOrder(pRootOfTree,tmpList);
        TreeNode head = tmpList.get(0); //用来返回头结点
        TreeNode ptr = head;
        head.left = null;
        for(int i=1;i<tmpList.size();i++){
            ptr.right = tmpList.get(i);
            tmpList.get(i).left = ptr;
            ptr = ptr.right;  //依次排成双向链表
        }
        return head;
    }
    private void InOrder(TreeNode pRootOfTree,List<TreeNode> tmpList){
        if(pRootOfTree==null)
            return;
        InOrder(pRootOfTree.left,tmpList); //先遍历左子树
        tmpList.add(pRootOfTree);  //中序遍历，根节点自然在中间
        InOrder(pRootOfTree.right,tmpList); //再遍历右子树
    }

}
