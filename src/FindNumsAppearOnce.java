//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/56.%20%E6%95%B0%E7%BB%84%E4%B8%AD%E5%8F%AA%E5%87%BA%E7%8E%B0%E4%B8%80%E6%AC%A1%E7%9A%84%E6%95%B0%E5%AD%97.md
//剑指56. 数组中只出现一次的数字
//一个整型数组除了两个数字以外，其他的数字都出现了两次，找出这两个数。
//思路：两个不相等的元素在位级表示上必定会有一位存在不同，将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。/
//diff&=-diff得到出diff最右侧不为0的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，
//利用这一位就可以将两个元素区分开来
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] nums,int num1[],int num2[]){
        int diff=0;
        for(int num:nums)
            diff^=num; //数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果
        diff&=-diff;  //得到出diff最右侧不为0的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位
        for(int num:nums){
            if((num&diff)==0)
                num1[0]^=num; //取出第一个元素
            else
                num2[0]^=num; //取出第二个元素
        }
    }

    public static void main(String[] args) {
        FindNumsAppearOnce findNums = new FindNumsAppearOnce();
        int[] nums={1,2,1,3,4,3};
        int[] num1=new int[1], num2 = new int[1];
        findNums.FindNumsAppearOnce(nums,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
