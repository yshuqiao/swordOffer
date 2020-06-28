//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/21.%20%E8%B0%83%E6%95%B4%E6%95%B0%E7%BB%84%E9%A1%BA%E5%BA%8F%E4%BD%BF%E5%A5%87%E6%95%B0%E4%BD%8D%E4%BA%8E%E5%81%B6%E6%95%B0%E5%89%8D%E9%9D%A2.md
//剑指21. 调整数组顺序使奇数位于偶数前面
//需要保证奇数和奇数，偶数和偶数之间的相对位置不变，这和书本不太一样。
//思路：方法一：创建一个新数组，时间复杂度 O(N)，空间复杂度 O(N)。
//方法二：使用冒泡思想，每次都当前偶数上浮到当前最右边。时间复杂度 O(N2)，空间复杂度 O(1)，时间换空间。

public class oddToEven {
    public void reOrderArray(int[] nums){
        //奇数个数
        int oddCnt = 0;
        for(int x:nums)
            if(!isEven(x))
                oddCnt++;
        int[] copy = nums.clone();
        int i=0,j=oddCnt;
        for(int num:copy){
            if(num%2==1)
                nums[i++]=num;
            else
                nums[j++]=num;
        }
    }
    private boolean isEven(int x){
        return x%2 == 0;
    }

    public void reOrderArray2(int[] nums){
        int N = nums.length;
        for (int i=N-1;i>0;i--){
            for (int j=0;j<i;j++){
                if(isEven(nums[j])&&!isEven(nums[j+1]))
                    swap(nums,j,j+1);
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        oddToEven reOrder = new oddToEven();
        int[] nums={1,2,3,4};
        reOrder.reOrderArray(nums);
        for (int i=0;i<nums.length;i++) {
            if(i==nums.length-1)
                System.out.print(nums[i]);
            else
                System.out.print(nums[i]+",");
        }
    }
}

