//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/42.%20%E8%BF%9E%E7%BB%AD%E5%AD%90%E6%95%B0%E7%BB%84%E7%9A%84%E6%9C%80%E5%A4%A7%E5%92%8C.md
//剑指42. 连续子数组的最大和
//{6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。

public class FindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] nums){
        if(nums==null||nums.length==0)
            return 0;
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int val:nums){
            sum=sum<=0?val:sum+val;//若前面的和是负数，则重新从当前值取值，有点像贪心
            greatestSum = Math.max(greatestSum,sum);
        }
        return greatestSum;
    }

    public static void main(String[] args) {
        int[] nums = {6, -3, -2, 7, -15, 1, 2, 2};
        FindGreatestSumOfSubArray findGreatest = new FindGreatestSumOfSubArray();
        int greatestSum = findGreatest.FindGreatestSumOfSubArray(nums);
        System.out.println(greatestSum);
    }
}
