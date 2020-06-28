//import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//思路：前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，左部分为树的左子树中序遍历结果，右部分为树的右子树中序遍历的结果。然后分别对左右子树递归地求解。
public class reconstructBinarytree {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val=val;
        }
    }

//来源：子烁爱学习up主，https://b23.tv/BV1LJ411y7Xa
    public TreeNode reConstructBinaryTree(int[] pre,int[] in){
        return help(pre,in,0,pre.length-1,0,in.length-1);
        //left和right是前序遍历序列里的分界线；left1和right1是中序遍历序列里的分界线
        /*
        前序[1],[2,4,7],[3,5,6,8]
        中序4,7,2,[1],5,3,8,6
         */
    }
    public TreeNode help(int[] pre,int[] in,int left,int right,int left1,int right1) {
        if(left>=pre.length||left1>=in.length||left>right||left1>right1)
            return null;
        int value = pre[left]; //第一次：取出前序遍历的第1个数
        TreeNode node = new TreeNode(value);
        int count = left1;

        //==在中序遍历中找到位置并计算长度==
        while (in[count]!=value) //第一次：找到中序遍历序列中的[1]
            count++; //的索引
        count-=left1; //求出下次递归的区间长度
        //=============================

        node.left = help(pre,in,left+1,left+count,left1,left1+count-1);
        //左子树递归，第一次：前序遍历序列里的[2,4,7]和中序遍历序列里的4,7,2
        node.right = help(pre,in,left+count+1,right,left1+count+1,right1);
        //右子树递归，第一次：前序遍历序列里的[3,5,6,8]和中序遍历序列里的5,3,8,6
        return node;
    }
    public static void main(String[] args){ //不得不感叹一下，递归真的有点抽象
//        int[] pre = {1,2,4,7,3,5,6,8};
//        int[] in = {4,7,2,1,5,3,8,6};
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        reconstructBinarytree reconstruct = new reconstructBinarytree();
        TreeNode newtree = reconstruct.reConstructBinaryTree(pre,in);
        int root1 = newtree.val;
        System.out.println(root1);  //试打印重建树的根节点值
        TreeNode nodeleft1 = newtree.left;
        System.out.println(nodeleft1.val); //试打印重建树的第一个左节点值

    }

    //来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/7.%20%E9%87%8D%E5%BB%BA%E4%BA%8C%E5%8F%89%E6%A0%91.md
//    //缓存中序遍历数组每个值对应的索引
//    private Map<Integer,Integer> indexForInOrders = new HashMap<>();
//
//    public TreeNode reConstructBinaryTree(int[] pre, int[] in){
//        for(int i=0;i<in.length;i++)
//            indexForInOrders.put(in[i],i); //中序遍历序列里的值压栈到indexForInOrders
//        return reConstructBinaryTree(pre,0,pre.length - 1,0);
//    }
//
//    private TreeNode reConstructBinaryTree(int[] pre,int preL,int preR,int inL) {
//    //preL为前序遍历序列的左边界，preR为前序遍历序列的右边界，inL为中序遍历序列的左边界
//        if (preL > preR)
//            return null;
//        TreeNode root = new TreeNode(pre[preL]); //前序遍历序列的第一个值为根节点的值
//        int inIndex = indexForInOrders.get(root.val); //第一次：取到中序遍历序列对应前序遍历序列第一个值（根节点）的索引
//        int leftTreeSize = inIndex-inL; //求出下次递归的区间长度
//        root.left = reConstructBinaryTree(pre,preL+1,preL+leftTreeSize,inL);
//        root.right = reConstructBinaryTree(pre,preL+leftTreeSize+1,preR,inL+leftTreeSize+1);
//        return root;
//    }

    //来源：https://github.com/h2pl/SwordToOffer
//    public TreeNode reConstructBinaryTree(int[] pre,int[] in){
//        if(pre.length==0||in.length==0){
//            return null;
//        }
//        TreeNode node = new TreeNode(pre[0]);
//        for (int i=0;i<in.length;i++){
//            if (pre[0]==in[i]){
//                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
//                                                                            //为什么不是i和i-1呢，因为要避免出错，中序找的元素需要再用一次
//                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
//            }
//        }
//        return node;
//    }


}
