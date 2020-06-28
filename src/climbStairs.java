//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/10.3%20%E8%B7%B3%E5%8F%B0%E9%98%B6.md
//剑指10.3 跳台阶
//一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//当 n = 1 时，只有一种跳法，当 n = 2 时，有两种跳法
//跳 n 阶台阶，可以先跳 1 阶台阶，再跳 n-1 阶台阶；或者先跳 2 阶台阶，再跳 n-2 阶台阶。
// 而 n-1 和 n-2 阶台阶的跳法可以看成子问题，该问题可写出递推公式。

public class climbStairs {

    public int JumpFloor(int n) {
        if(n<=2)
            return n;
        int pre2 = 1,pre1 = 2;
        int result = 0;
        for (int i=2;i<n;i++){
            //有意思：无论是从i=2开始还是从i=3开始，计算结果都相同！
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    public static void main(String[] args){
        climbStairs climb = new climbStairs();
        int res = climb.JumpFloor(9);
        System.out.println(res);
    }
}
