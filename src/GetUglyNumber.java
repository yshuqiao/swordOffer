//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/49.%20%E4%B8%91%E6%95%B0.md
//剑指49. 丑数
//把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。习惯上我们把 1 当做是第一个丑数。求按从小到大的顺序的第 N 个丑数。

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class GetUglyNumber {
    public int GetUglyNumber_Solution(int N){
        if(N<=6)
            return N;
        int i2=0,i3=0,i5=0;
        int[] dp = new int[N];
        dp[0]=1;
        for(int i=1;i<N;i++){
            int next2=dp[i2]*2,next3=dp[i3]*3,next5=dp[i5]*5;
            dp[i] = Math.min(next2,Math.min(next3,next5));
            if(dp[i]==next2)
                i2++;
            if(dp[i]==next3)
                i3++;
            if(dp[i]==next5)
                i5++;
        }
        return dp[N-1];
    }

    public static void main(String[] args) {
        GetUglyNumber getUgly = new GetUglyNumber();
        int uglyNumberN = getUgly.GetUglyNumber_Solution(5);
        System.out.println(uglyNumberN);
    }
}
