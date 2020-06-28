//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/53.%20%E6%95%B0%E5%AD%97%E5%9C%A8%E6%8E%92%E5%BA%8F%E6%95%B0%E7%BB%84%E4%B8%AD%E5%87%BA%E7%8E%B0%E7%9A%84%E6%AC%A1%E6%95%B0.md
//剑指53. 数字在排序数组中出现的次数
//例如：
//Input:
//nums = 1, 2, 3, 3, 3, 3, 4, 6
//K = 3
//Output:
//4
public class GetCountsOfKInArray {
    public int GetNumberOfK(int[] nums,int K){
        int first = binarySearch(nums,K);
        int last = binarySearch(nums,K+1);
        return(first==nums.length||nums[first]!=K)?0:last-first;
    }
    private int binarySearch(int[] nums,int K){
        int l=0,h=nums.length;
        while(l<h){
            int m=l+(h-l)/2;
            if(nums[m]>=K)
                h=m;
            else
                l=m+1;
        }
        return l;
    }

    public static void main(String[] args) {
        GetCountsOfKInArray getCountsOfK = new GetCountsOfKInArray();
        int[] a = {1, 2, 3, 3, 3, 3, 4, 6};
        int K = 3;
        int counts = getCountsOfK.GetNumberOfK(a,K);
        System.out.println(counts);
    }
}
