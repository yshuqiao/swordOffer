//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/10.1%20%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E6%95%B0%E5%88%97.md
//10.1 斐波那契数列（求斐波那契数列的第 n 项，n <= 39。）
//思路：如果使用递归求解，会重复计算一些子问题。例如，计算 f(4) 需要计算 f(3) 和 f(2)，计算 f(3) 需要计算 f(2) 和 f(1)，可以看到 f(2) 被重复计算了。
//递归是将一个问题划分成多个子问题求解，动态规划也是如此，但是动态规划会把子问题的解缓存起来，从而避免重复求解子问题。


public class solveFibonacci {
    public int Fibonacci1(int n) {
        if (n<=1)
            return n;
        int[] fib = new int[n+1];
        fib[1] = 1;
        for(int i=2;i<=n;i++)
            fib[i] = fib[i-1]+fib[i-2]; //疑惑：为什么没有定义fib[0]=0，也能自动求fib[0]
        return fib[n];
    }

    //考虑到第 i 项只与第 i-1 和第 i-2 项有关，
    // 因此只需要存储前两项的值就能求解第 i 项，
    // 从而将空间复杂度由 O(N) 降低为 O(1)。
    public int Fibonacci2(int n) {
        if(n<=1)
            return n;
        int pre2 = 0,pre1 = 1;
        int fib = 0;
        for(int i=1;i<=n;i++) {
            fib = pre2+pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }

    public static void main(String[] args){

//        solveFibonacci solver = new solveFibonacci();
//        int res = solver.Fibonacci1(2);
//        System.out.println(res);
        Solution solver2 = new Solution();
        int res2 = solver2.Fibonacci(2);
        System.out.println(res2);
    }

    //由于待求解的 n 小于 40，因此可以将前 40 项的结果先进行计算，
    // 之后就能以 O(1) 时间复杂度得到第 n 项的值。
    public static class Solution{  //notic:make it "static"
        private int[] fib = new int[40];
        public Solution() {
            fib[1]=1;
            for(int i=2;i<fib.length;i++)
                fib[i] = fib[i-1]+fib[i-2]; //默认fib[0]=0（和数组初始化有关）
        }
        public int Fibonacci(int n){
            return fib[n];
        }
    }

}
