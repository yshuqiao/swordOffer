import java.util.ArrayList;

//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/57.2%20%E5%92%8C%E4%B8%BA%20S%20%E7%9A%84%E8%BF%9E%E7%BB%AD%E6%AD%A3%E6%95%B0%E5%BA%8F%E5%88%97.md
//剑指57.2 和为 S 的连续正数序列
//输出所有和为S的连续正数序列。
//例如和为100的连续序列有：
//[9,10,11,12,13,14,15,16]
//[18,19,20,21,22]
public class FindContinuousSequenceWithSum {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int start = 1,end=2;
        int curSum = 3;
        while (end<sum){
            if(curSum>sum){
                curSum-=start;
                start++;
            }else if(curSum<sum){
                end++;
                curSum+=end;
            }else { //即curSum==sum的情况
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=start;i<=end;i++)
                    list.add(i);
                ret.add(list); //把这个序列添加到结果集
                curSum-=start;
                start++;
                end++;
                curSum+=end; //整体右移
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        FindContinuousSequenceWithSum findContinuousSequenceWithSum = new FindContinuousSequenceWithSum();
        ArrayList<ArrayList<Integer>> ret = findContinuousSequenceWithSum.FindContinuousSequence(100);
        for (int i=0;i<ret.size(); i++) {
            ArrayList<Integer> list =ret.get(i);
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
