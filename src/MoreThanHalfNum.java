//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/39.%20%E6%95%B0%E7%BB%84%E4%B8%AD%E5%87%BA%E7%8E%B0%E6%AC%A1%E6%95%B0%E8%B6%85%E8%BF%87%E4%B8%80%E5%8D%8A%E7%9A%84%E6%95%B0%E5%AD%97.md
//剑指39. 数组中出现次数超过一半的数字
//多数投票问题，可以利用Boyer-Moore Majority Vote Algorithm来解决这个问题，使得时间复杂度为O(N)
//使用cnt来统计一个元素出现的次数，当遍历到的元素和统计元素相等时，令cnt++，否则令cnt--。
//如果前面查找了i个元素，且cnt==0，说明前i个元素没有majority，或者有majority，但是出现的次数少于i/2，因为如果多于i/2的话，cnt就一定不会为0。
//此时剩下的n-i个元素中，majority的数目依然多于(n-i)/2，因此继续查找就能找出majority。

public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int[] nums){
        int majority =  nums[0];
        for (int i=1,cnt=1;i<nums.length;i++){
            cnt=nums[i]==majority?cnt+1:cnt-1;
            if(cnt==0){
                majority=nums[i];
                cnt=1;
            }
        }
        int cnt=0;
        for(int val:nums)
            if(val==majority)
                cnt++;
        return cnt>nums.length/2?majority:0;
    }

    public static void main(String[] args){
        MoreThanHalfNum moreNum = new MoreThanHalfNum();
        int[] nums = {1,2,3,1,1};
        int moreHlfNum = moreNum.MoreThanHalfNum_Solution(nums);
        System.out.println(moreHlfNum);
    }
}
