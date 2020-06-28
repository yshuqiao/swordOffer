//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/40.%20%E6%9C%80%E5%B0%8F%E7%9A%84%20K%20%E4%B8%AA%E6%95%B0.md
//剑指40. 最小的 K 个数
//法1：快速选择，复杂度O(N)+O(1)，只有当允许修改数组元素时才可以使用
//快速排序的partition()方法，会返回一个整数j使得a[1...j-1]小于等于a[j]，且a[j+1...h]大于等于a[j],
//此时a[j]就是数组的第j大元素。可以利用这个特性找出数组的第K个元素，这种找第K个元素的算法称为快速选择算法。

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums,int k){
        ArrayList<Integer> ret = new ArrayList<>();
        if(k>nums.length||k<=0)
            return ret;
        findKthSmallest(nums,k-1);
        /*findKthSmallest会改变数组，使得前k个数都是最小的k个数*/
        for(int i=0;i<k;i++)
            ret.add(nums[i]);
        return ret;
    }
    public void findKthSmallest(int[] nums,int k){
        int l=0,h=nums.length-1;
        while (l<h){
            int j = partition(nums,l,h);
            if(j==k)
                break;
            if(j<k)
                h=j-1;
            else
                l=j+1;
        }
    }
    private int partition(int[] nums,int l,int h){
        int p = nums[l]; // 切分元素
        int i=l,j=h+1;
        while(true){
            while(i!=h&&nums[++i]<p);
            while(j!=l&&nums[--j]>p);
            if(i>=j)
                break;
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }
    private void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

    //法2：大小为K的最小堆，复杂度O(NlogK)+O(K)
    //特别适合处理海量数据
    //应该使用大顶堆来维护最小堆(妙啊)，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
    //维护一个大小为K的最小堆过程如下：在添加一个元素之后，如果大顶堆的大小大于K，那么需要将大顶堆的堆顶元素去除。
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] nums,int k){
        if(k>nums.length||k<=0)
            return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->(o2-o1));
        //加(o1,o2)->(o2-o1)这个传参是为了把默认的PriorityQueue<>()这个小顶堆转化为大顶堆
        for(int num:nums){
            maxHeap.add(num);
            if(maxHeap.size()>k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }
}
