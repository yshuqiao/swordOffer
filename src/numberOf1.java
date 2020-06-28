//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/15.%20%E4%BA%8C%E8%BF%9B%E5%88%B6%E4%B8%AD%201%20%E7%9A%84%E4%B8%AA%E6%95%B0.md
//剑指15. 二进制中 1 的个数
//输入一个整数，输出该数二进制表示中 1 的个数。
//n&(n-1)
//该位运算去除n的位级表示中最低的那一位
//如：
//n      :10110100
//n-1    :10110011
//n&(n-1):10110000
//时间复杂度：O(M),其中M表示1的个数

public class numberOf1 {
    //法1：位运算
    public int NumberOf1(int n){
        int cnt = 0;
        while (n!=0){
            cnt++;
            n &= (n-1);
        }
        return cnt;
    }

    //法2：直接调用函数Integer.bitCount()
    public int numberof1(int n){
        return Integer.bitCount(n);
    }

    public static void main(String[] args){
        numberOf1 count1 = new numberOf1();
        int n = 10110100;
//        int res = count1.NumberOf1(n);
        int res = count1.numberof1(n);
        System.out.println(res);
    }
}
