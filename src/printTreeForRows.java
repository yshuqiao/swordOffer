//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/32.2%20%E6%8A%8A%E4%BA%8C%E5%8F%89%E6%A0%91%E6%89%93%E5%8D%B0%E6%88%90%E5%A4%9A%E8%A1%8C.md
//剑指32.2 把二叉树打印成多行

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class printTreeForRows {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val=val;
        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while(cnt-- >0){
                TreeNode node = queue.poll();
                if(node==null)
                    continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if(list.size()!=0)
                ret.add(list);
        }
        return ret;
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

        printTreeForRows print = new printTreeForRows();
        ArrayList<ArrayList<Integer>> res = print.Print(a0);
        for (int i=0;i<res.size(); i++) {
            ArrayList<Integer> list =res.get(i);
            System.out.println(); //换行
//            for(Integer a:list){
//                System.out.print(a+" ");
            for(int j=0; j < list.size(); j++){
                if(j==list.size()-1)
                    System.out.print(list.get(j)); //如果是此行最后一个数，则不加逗号
                else
                    System.out.print(list.get(j)+",");
            }
        }

    }
}
