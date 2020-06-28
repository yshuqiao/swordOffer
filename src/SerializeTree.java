//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/37.%20%E5%BA%8F%E5%88%97%E5%8C%96%E4%BA%8C%E5%8F%89%E6%A0%91.md
//剑指37. 序列化二叉树
//请实现两个函数，分别用来序列化和反序列化二叉树。
public class SerializeTree {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val=val;
        }
    }

    public String deserializeStr;
    public String Serialize(TreeNode root){
        if(root==null)
            return "#";
        return root.val+" "+Serialize(root.left)+" "+Serialize(root.right);
    }
    public TreeNode Deserialize(String str){
        deserializeStr = str;
        return Deserialize();
    }
    private TreeNode Deserialize(){
        if(deserializeStr.length()==0)
            return null;
        int index = deserializeStr.indexOf(" ");
        String node = index == -1?deserializeStr:deserializeStr.substring(0,index);
        deserializeStr = index == -1?"":deserializeStr.substring(index+1);
        if(node.equals("#"))
            return null;
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }

    public static void main(String[] args){

        TreeNode a0 = new TreeNode(10);
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(12);
        a0.left = a1;
        a1.left = a2;
        a1.right = a3;
        a0.right = a4;

        SerializeTree serialization = new SerializeTree();
        String serialize = serialization.Serialize(a0);
        System.out.println(serialize);
        TreeNode a0again = serialization.Deserialize(serialize);
        System.out.println(a0again.val);
    }
}
