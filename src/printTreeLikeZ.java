import java.util.*;

//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/32.3%20%E6%8C%89%E4%B9%8B%E5%AD%97%E5%BD%A2%E9%A1%BA%E5%BA%8F%E6%89%93%E5%8D%B0%E4%BA%8C%E5%8F%89%E6%A0%91.md
//剑指32.3 按之字形顺序打印二叉树
//请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
//思路：那就立个flag吧
public class printTreeLikeZ {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val=val;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot); //这里是加入queue
        boolean reverse = false;
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while(cnt-- > 0){
                TreeNode node = queue.poll();
                if(node == null)
                    continue;
                list.add(node.val); //这里是加入list
                queue.add(node.left); //这里是加入queue
                queue.add(node.right); //这里是加入queue
            }
            if(reverse)
                Collections.reverse(list);  //如果reverse这个flag为真，那就反转此list
            reverse = !reverse; //把reverse这个flag翻转
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

        printTreeLikeZ print = new printTreeLikeZ();
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
