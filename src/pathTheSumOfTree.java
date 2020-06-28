//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/34.%20%E4%BA%8C%E5%8F%89%E6%A0%91%E4%B8%AD%E5%92%8C%E4%B8%BA%E6%9F%90%E4%B8%80%E5%80%BC%E7%9A%84%E8%B7%AF%E5%BE%84.md
//剑指34. 二叉树中和为某一值的路径
//输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

import java.util.ArrayList;

public class pathTheSumOfTree {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val=val;
        }
    }

    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    public  ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target){
        backtracking(root,target,new ArrayList<>());
        return ret;
    }
    private void backtracking(TreeNode node,int target,ArrayList<Integer> path){
        if(node == null)
            return;
        path.add(node.val);
        target -= node.val;
        if(target==0 && node.left==null && node.right==null){
            ret.add(new ArrayList<>((path)));
        }else{
            backtracking(node.left,target,path);
            backtracking(node.right,target,path);
        }
        path.remove(path.size()-1); //不满足则回溯
    }

    public static void main(String[] args){
        pathTheSumOfTree pathTree = new pathTheSumOfTree();

        TreeNode a0 = new TreeNode(10);
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(12);
//        TreeNode a0 = new TreeNode(3);
//        TreeNode a1 = new TreeNode(1);
//        TreeNode a2 = new TreeNode(0);
//        TreeNode a3 = new TreeNode(2);
//        TreeNode a4 = new TreeNode(5);
//        TreeNode a5 = new TreeNode(4);
//        TreeNode a6 = new TreeNode(6);
        a0.left = a1;
        a1.left = a2;
        a1.right = a3;
        a0.right = a4;
//        a4.left = a5;
//        a4.right = a6;


        ArrayList<ArrayList<Integer>> paths = pathTree.FindPath(a0,22);

        for (int i=0;i<paths.size(); i++) {
            ArrayList<Integer> list = paths.get(i);
            System.out.println(); //换行
//            for(Integer a:list){
//                System.out.print(a+" ");
            for (int j = 0; j < list.size(); j++) {
                if (j == list.size() - 1)
                    System.out.print(list.get(j)); //如果是此行最后一个数，则不加逗号
                else
                    System.out.print(list.get(j) + ",");
            }
        }
    }
}
