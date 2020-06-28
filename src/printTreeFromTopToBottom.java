//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/32.1%20%E4%BB%8E%E4%B8%8A%E5%BE%80%E4%B8%8B%E6%89%93%E5%8D%B0%E4%BA%8C%E5%8F%89%E6%A0%91.md
//剑指32.1 从上往下打印二叉树
//从上往下打印出二叉树的每个节点，同层节点从左至右打印。
//思路：使用队列来进行层次遍历
//不需要使用两个队列分别存储当前层的节点和下一层的节点，因为在开始遍历一层的节点时，当前队列中的节点数就是当前层的节点数，
//只要控制遍历这么多节点数，就能保证这次遍历的都是当前层的节点。

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class printTreeFromTopToBottom {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val=val;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int cnt = queue.size();
            while(cnt-- > 0){
                TreeNode t = queue.poll();
                if (t==null)
                    continue;
                ret.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return ret;
    }

    //第二种写法，up主 舞年落梦
    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();//放入遍历二叉树的节点（本质上是维护宽搜）
        if(root!=null){ //判空
            queue.add(root);
        }
        //迭代的过程->宽搜
        while(!queue.isEmpty()){
            TreeNode node = queue.peek();
            ans.add(node.val); //将当前节点的val值放入ArrayList中
            //同层节点从左至右打印
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            queue.poll();//当前节点val值已经放入ans中，所以要删去
        }
        return ans;
    }

    public static void main(String[] args){

        TreeNode a0 = new TreeNode(0);
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(4);
        TreeNode a6 = new TreeNode(5);
        a0.left = a1;
        a1.left = a2;
        a1.right = a3;
        a0.right = a4;
        a4.left = a5;
        a4.right = a6;

        printTreeFromTopToBottom printTree = new printTreeFromTopToBottom();
        ArrayList<Integer> res = printTree.PrintFromTopToBottom2(a0);

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
