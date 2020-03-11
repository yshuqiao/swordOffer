/*
在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
本题要求找出重复的数字，因此在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。
 */
public class duplicateFigures {
    public boolean duplicate(int[] nums,int length,int[] duplication) {
        if (nums == null || length <= 0)
            return false;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private void swap(int[] nums,int i,int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    //以下是实例化
    public static void main(String[] args) {
        duplicateFigures duplicatfigures = new duplicateFigures();
        int [] a = {2, 3, 1, 0, 2, 5};
        int len = a.length;
        int [] duplication = new int[len] ;
        boolean b = duplicatfigures.duplicate(a,len,duplication);
        System.out.println(b);
        System.out.println(duplication[0]);
    }
}
