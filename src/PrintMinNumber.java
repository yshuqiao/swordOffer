import java.util.Arrays;

//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/45.%20%E6%8A%8A%E6%95%B0%E7%BB%84%E6%8E%92%E6%88%90%E6%9C%80%E5%B0%8F%E7%9A%84%E6%95%B0.md
//剑指45. 把数组排成最小的数
//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
// 例如输入数组 {3，32，321}，则打印出这三个数字能排成的最小数字为 321323。
//思路：可以看成是一个排序问题，在比较两个字符串S1和S2的大小时，
//应该比较的搜索S1+S2和S2+S1的大小，如果S1+S2<S2+S1，
//那么应该把S1排在前面，否则应该把S2排在前面
public class PrintMinNumber {
    public String PrintMinNumber(int[] numbers){
        if(numbers==null||numbers.length==0)
            return "";
        int n = numbers.length;
        String[] nums = new String[n];
        for(int i=0;i<n;i++)
            nums[i] = numbers[i]+"";
        Arrays.sort(nums,(s1,s2)->(s1+s2).compareTo((s2+s1)));
        String ret = "";
        for(String str:nums)
            ret += str;
        return ret;
    }

    public static void main(String[] args) {
        PrintMinNumber minNumber = new PrintMinNumber();
        int[] a = {3,32,321};
        String ret = minNumber.PrintMinNumber(a);
        System.out.println(ret);
    }
}
