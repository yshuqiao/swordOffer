//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/51.%20%E6%95%B0%E7%BB%84%E4%B8%AD%E7%9A%84%E9%80%86%E5%BA%8F%E5%AF%B9.md
//剑指51. 数组中的逆序对
//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

public class InversePairsOfArray {
    public long cnt = 0;
    private int[] tmp; //在这里声明辅助数组，而不是在merge()递归函数中声明

    public int InversePairs(int[] nums){
        tmp = new int[nums.length];
        mergeSort(nums,0,nums.length-1);
        return (int)(cnt%1000000007); //题目要求把结果去模1000000007
    }
    private void mergeSort(int[] nums,int l,int h){
        if(h-l<1) //递归终止条件
            return;
        int m = l+(h-l)/2;
        mergeSort(nums,l,m);
        mergeSort(nums,m+1,h);
        merge(nums,l,m,h);
    }
    private void merge(int[] nums,int l,int m,int h){
        int i=l,j=m+1,k=l;
        while(i<=m||j<=h){ //注意，这里用的是或||
            if(i>m)
                tmp[k]=nums[j++];
            else if(j>h)
                tmp[k]=nums[i++];
            else if(nums[i]<=nums[j])
                tmp[k]=nums[i++];
            else{
                tmp[k]=nums[j++];
                this.cnt+=m-i+1; //nums[i]>nums[j]，说明nums[i...mid]都大于nums[j]
            }
            k++;
        }
        for(k=l;k<=h;k++)
            nums[k]=tmp[k];
    }

    public static void main(String[] args) {
        InversePairsOfArray pairsOfArray = new InversePairsOfArray();
        int[] a = {5,3,2,6};
        int modPairs = pairsOfArray.InversePairs2(a);
        System.out.println(modPairs);
    }
    //写法2（仍是利用归并排序），来自up主 舞年落梦
    private long sum;//用来去统计逆序对的个数
    public int InversePairs2(int[] array){
        sum = 0;
        int l = 0;
        int r = array.length-1;
        divide(l,r,array);
        return (int)(sum%1000000007);
    }
    private void divide(int l,int r,int[] array){
        if(l!=r){
            int mid = (l+r)>>1;
            divide(l,mid,array);
            divide(mid+1,r,array);
            merge2(l,r,mid,array);
        }
    }
    private void merge2(int l,int r,int mid,int[] array){
        int i=l;//左区间的起点
        int j=mid+1;//右区间的起点
        int[] temp=new int[r-l+1]; //辅助数组，用来存储排序后有序的数
        int index=0;
        while(i<=mid&&j<=r){ //注意，这里用的是与&&
            if(array[i]>array[j]){
                temp[index++]=array[j++];
                sum+=mid-i+1;//这一行是核心，去统计逆序对个数，统计的基础是在归并排序的合并过程中，合并的两个子序列都是有序的
            }else{
                temp[index++]=array[i++];
            }
        }
        while(i<=mid){ //对应j>r的时候
            temp[index++]=array[i++];
        }
        while(j<=r){ //对应i>mid的时候
            temp[index++]=array[j++];
        }
        index=0;
        for(int k=l;k<=r;k++){
            array[k] = temp[index++];
        }
    }

}
