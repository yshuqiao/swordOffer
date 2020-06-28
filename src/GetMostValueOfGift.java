//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/47.%20%E7%A4%BC%E7%89%A9%E7%9A%84%E6%9C%80%E5%A4%A7%E4%BB%B7%E5%80%BC.md
//剑指47. 礼物的最大价值
//在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，求拿到礼物的最大价值。
//思路：应该用动态规划求解，而不是深度优先搜索，深度优先搜索过于复杂，不是最优解。
//Me:未能理解
public class GetMostValueOfGift {
    public int getMost(int[][] values){
        if(values==null||values.length==0||values[0].length==0)
            return 0;
        int n = values[0].length;
        int[] dp = new int[n];
        for(int[] value:values){
            dp[0] += value[0];
            for(int i=1;i<n;i++)
                dp[i]=Math.max(dp[i],dp[i-1])+value[i];
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        GetMostValueOfGift getMostValue = new GetMostValueOfGift();
        int[][] gifts = {{1,10,3,8},{12,2,6,6},{5,7,4,11},{3,7,16,5}};
        int mostValue = getMostValue.getMost(gifts);
        System.out.println(mostValue);
    }
}
