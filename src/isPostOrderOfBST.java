//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/33.%20%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E5%BA%8F%E5%88%97.md
//剑指33. 二叉搜索树的后序遍历序列
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。

public class isPostOrderOfBST {
    public boolean VerifySequenceOfBST(int[] sequence){
        if(sequence==null||sequence.length==0)
            return false;
        return verify(sequence,0,sequence.length-1);
    }
    private boolean verify(int[] sequence,int first,int last){
        if(last-first<=1)
            return true;
        int rootVal = sequence[last];
        int cutIndex = first;
        //左子树都小于根结点
        while(cutIndex<last && sequence[cutIndex]<=rootVal)
            cutIndex++;

        //右子树都大于根结点
        for(int i=cutIndex;i<last;i++)
            if(sequence[i]<rootVal)
                return false;
        return verify(sequence,first,cutIndex-1)&&verify(sequence,cutIndex,last-1);
    }

    public static void main(String[] args){
        int[] aPost ={0,2,1,4,6,5,3};
//        int[] aPost ={1,3,2};
        isPostOrderOfBST isPost = new isPostOrderOfBST();
        boolean ispost = isPost.VerifySequenceOfBST(aPost);
        System.out.println(ispost);
    }
}
