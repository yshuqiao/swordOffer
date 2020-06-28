import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/60.%20n%20%E4%B8%AA%E9%AA%B0%E5%AD%90%E7%9A%84%E7%82%B9%E6%95%B0.md
//剑指60. n 个骰子的点数
//把n个骰子仍在地上，求点数和为s的概率
//思路：
// 法1：动态规划，使用一个二维数组dp存储点数出现的次数，其中dp[i][j]表示前i个骰子产生点数j的次数。
//空间复杂度O(N2)
//Me:未理解
public class NdicesSum {
    public List<Map.Entry<Integer,Double>> dicesSum(int n){
        final int face = 6;
        final int pointNum = face*n;
        long[][] dp = new long[n+1][pointNum+1];

        for(int i=1;i<=face;i++)
            dp[1][i]=1;
        for(int i=2;i<=n;i++)
            for(int j=i;j<=pointNum;j++) //使用i个骰子最小点数为i
                for(int k=1;k<=face&&k<=j;k++)
                    dp[i][j]+=dp[i-1][j-k];

        final double totalNum = Math.pow(6,n);
        List<Map.Entry<Integer,Double>> ret = new ArrayList<>();
        for(int i=n;i<=pointNum;i++)
            ret.add(new AbstractMap.SimpleEntry<>(i,dp[n][i]/totalNum));
        return ret;
    }

    //法2：动态规划+旋转数组
    //空间复杂度O(N)
    public List<Map.Entry<Integer,Double>> dicesSum2(int n){
        final int face = 6;
        final int pointNum = face*n;
        long[][] dp = new long[2][pointNum+1];

        for(int i=1;i<=face;i++)
            dp[0][i] = 1;

        int flag = 1;  //旋转标记
        for(int i=2;i<=n;i++,flag=1-flag){
            for(int j=0;j<=pointNum;j++)
                dp[flag][j]=0; //旋转数组清零

            for(int j=i;j<=pointNum;j++)
                for(int k=1;k<=face&&k<=j;k++)
                    dp[flag][j]+=dp[1-flag][j-k];
        }
        final double totalNum = Math.pow(6,n);
        List<Map.Entry<Integer,Double>> ret = new ArrayList<>();
        for(int i=n;i<=pointNum;i++)
            ret.add(new AbstractMap.SimpleEntry<>(i,dp[1-flag][i]/totalNum));
        return ret;
    }

    public static void main(String[] args) {
        NdicesSum dices = new NdicesSum();
        List<Map.Entry<Integer,Double>> ret = dices.dicesSum2(2);
        for (int i=0;i<ret.size(); i++) {
            Map.Entry<Integer,Double> list =ret.get(i);
            System.out.println(list.getValue()); //换行

        }
    }

}
