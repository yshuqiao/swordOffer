//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/14.%20%E5%89%AA%E7%BB%B3%E5%AD%90.md
//剑指14. 剪绳子
//把一根绳子剪成多段，并且使得每段的长度乘积最大。
//思路：贪心/动态规划
//尽可能多剪长度为3的绳子，并且不允许有长度为1的绳子出现。
// 如果出现了，就从已经切好长度为3的绳子中拿出一段与长度为1的绳子重新组合，把它们切成两段长度为2的绳子
//证明：当n>=5时，3(n-3)-n=2n-9>0，且2(n-2)-n=n-4>0。
// 因此在n>=5的情况下，将绳子剪成一段为2或者3，得到的乘积会更大。
// 又因为3(n-3)-2(n-2)=n-5>=0，所以剪成一段长度为3比长度为2的乘积更大。
public class cutRope {
    public int integerBreak(int n){
        if (n<2)
            return 0;
        if (n==2)
            return 1;
        if (n==3)
            return 2;
        int timesOf3 = n/3;
        if(n-timesOf3*3==1)
            timesOf3--;
        int timesOf2 = (n-timesOf3*3)/2;
        return (int)(Math.pow(3,timesOf3))*(int)(Math.pow(2,timesOf2));
    }

    //动态规划
    public int integerBreak2(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i=2;i<=n;i++)
            for (int j=1;j<i;j++)
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),dp[j]*(i-j)));
            return dp[n];
    }

    //动态规划2
    public int cutRope2(int target){
        if(target<2)
            return 0;
        if(target==2)
            return 1;
        if (target==3)
            return 2;
        int[] ropes = new int[target+1];
        int max = -1;
        ropes[0]=0;
        ropes[1]=1;
        ropes[2]=2;
        ropes[3]=3;//因为长度>=4,所以他们不需要拆，拆了反而小了，对于<4的情况，我们开头直接处理了
        for(int i=4;i<=target;i++){
            for(int j=1;j<=i/2;j++){
                int val = ropes[j]*ropes[i-j];
                max = max>val?max:val;
                ropes[i] = max;
            }
        }
        max = ropes[target];
        return max;
    }

    public static void main(String[] args){
        cutRope cutRopes = new cutRope();
        int n = 25;
        int products = cutRopes.cutRope2(n);
        System.out.println(products);
    }
}
