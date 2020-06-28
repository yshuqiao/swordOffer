//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/11.%20%E6%97%8B%E8%BD%AC%E6%95%B0%E7%BB%84%E7%9A%84%E6%9C%80%E5%B0%8F%E6%95%B0%E5%AD%97.md
//剑指11. 旋转数组的最小数字
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。

//例如：1234旋转得2341，可由中间值分为23这个非递减数组和41这个旋转数组

//思路：将旋转数组对半分可以得到一个包含最小元素的新旋转数组，以及一个非递减排序的数组。
//新的旋转数组的数组元素的原数组的一半，从而将问题规模减少了一半，这种折半性质的算法时间复杂度为O(logN)
//此时问题的关键在于确定对半分得到的两个数组哪一个是旋转数组，哪一个是非递减数组
//我们很容易知道非递减数组的第一个元素一定小于等于最后一个元素
//通过修改二分查找算法进行求解(l代表low，m代表mid，h代表high):
//当nums[m]<=nums[h]时，表示[m,h]区间内的数组是非递减数组，[l,m]区间内的数组是旋转数组，此时令h=m;
//否则[m+1,h]区间内的数组是旋转数组，令l=m+1。
public class MinNumberInRotateArray {

    public int minNumberInRotateArray(int[] nums) {
        if(nums.length==1)
            return 0;
        int l=0,h=nums.length-1;
        while(l<h){
            int m = 1+(h-1)/2;
            if(nums[m]<=nums[h])
                h=m;
            else
                l=m+1;
        }
        return nums[l];
    }

    //如果数组元素允许重复，会出现一些特殊情况：nums[l]==nums[h],
    //此时无法确定解在哪个区间，需要切换到顺序查找。例如对于数组{1,1,1,0,1},
    //l、m和h指向的数都为1，此时无法知道最小数字0在哪个区间。
    public int minNumberInRotateArray2(int[] nums){
        if(nums.length == 0)
            return 0;
        int l=0,h=nums.length-1;
        while(l<h){
            int m = l+(h-l)/2;
            if (nums[l]==nums[m]&&nums[m]==nums[h])
                return minNumber(nums,l,h);
            else if (nums[m]<=nums[h])
                h=m;
            else
                l = m+1;
        }
        return nums[l];
    }
    //顺序查找
    private int minNumber(int[] nums,int l,int h){
        for (int i=l;i<h;i++)
            if (nums[i]>nums[i+1])
                return nums[i+1]; //感觉这个写法有点神奇
        return nums[l];
    }

    /*
        1234567旋转得到7123456
        找出中间值：
        712[3]456
        比较得3<7且3<6选择新区间：
        7123
        再找中间值：
        7[1]23
        比较得1<7且1<3选择新区间：
        71
         */
    private int solution(int[] array){
        int left = 0;
        int right = array.length-1;
        while(left<right){
            if(right-left==1){
                return Math.min(array[left],array[right]);
            }
            int mid = left+(right-left)/2;
            if (array[mid]>=array[left])
                left = mid;
            if(array[mid]<=array[right])
                right = mid;
        }
        return 0;
    }

    public static void main(String[] args){
        MinNumberInRotateArray minRotate = new MinNumberInRotateArray();
        int[] a = {1,1,1,0,1};
//        int[] a = {3,3,4,5,1,2};
//        int b = minRotate.minNumberInRotateArray2(a);
        int b = minRotate.solution(a);
        System.out.println(b);
    }
}
