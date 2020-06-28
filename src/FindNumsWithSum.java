//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/57.1%20%E5%92%8C%E4%B8%BA%20S%20%E7%9A%84%E4%B8%A4%E4%B8%AA%E6%95%B0%E5%AD%97.md
//剑指57.1 和为 S 的两个数字
//输入一个递增排序的数组和一个数字S,在数组中查找两个数，使得他们的和正好是S。
//如果有多对数字的和等于S，输出两个数的乘积最小的。
//思路：使用双指针，一个指针指向元素较小的值，一个指针指向元素较大的值。
//指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
//如果两个指针指向元素的和sum==target，那么得到要求的结果；
//如果sum>target，移动较大的元素，使sum变小一些；
//如果sum<target，移动较小的元素，使sum变大一些。

import java.util.ArrayList;
import java.util.Arrays;

public class FindNumsWithSum {
    public ArrayList<Integer> FindNumberWithSum(int[] array,int sum){
        int i=0,j=array.length-1;
        while(i<j){
            int cur = array[i]+array[j];
            if(cur==sum)
                return new ArrayList<>(Arrays.asList(array[i],array[j]));
            if(cur<sum)
                i++;
            else
                j--;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        FindNumsWithSum findNumsWithSum = new FindNumsWithSum();
        int[] a = {1,2,3,4,5};
        int sum = 6;
        ArrayList<Integer> arrayList = findNumsWithSum.FindNumberWithSum(a,sum);
        for (Integer num:arrayList){
            System.out.println(num);
        }
    }
}
