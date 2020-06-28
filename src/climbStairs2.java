//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/10.4%20%E5%8F%98%E6%80%81%E8%B7%B3%E5%8F%B0%E9%98%B6.md
//剑指10.4 变态跳台阶
//一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//思路：动态规划或数学推导

import java.util.Arrays;

public class climbStairs2 {

    //法1：动态规划：
    public int jumpfloor(int target){
        int[] dp = new int[target];
        Arrays.fill(dp,1);
        for(int i=1;i<target;i++)
            for (int j=0;j<i;j++)
                dp[i] += dp[j];
        return dp[target-1]; //为什么不是返回dp[target]呢
        //！若用dp[target]就数组越界啦！
    }

    //法2：数学推导：
    //跳上 n-1 级台阶，可以从 n-2 级跳 1 级上去，也可以从 n-3 级跳 2 级上去...，那么
    //f(n-1) = f(n-2) + f(n-3) + ... + f(0)
    //同样，跳上 n 级台阶，可以从 n-1 级跳 1 级上去，也可以从 n-2 级跳 2 级上去... ，那么
    //f(n) = f(n-1) + f(n-2) + ... + f(0)
    //综上可得f(n) - f(n-1) = f(n-1)
    //即f(n) = 2*f(n-1)，所以 f(n) 是一个等比数列
    public int jumpfloor2(int target){
        return (int) Math.pow(2,target - 1);
    }

    public static void main(String[] args){
        climbStairs2 climb2 = new climbStairs2();
        int res = climb2.jumpfloor2(9);
        System.out.println(res);
    }

}
