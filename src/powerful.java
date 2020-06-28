//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/16.%20%E6%95%B0%E5%80%BC%E7%9A%84%E6%95%B4%E6%95%B0%E6%AC%A1%E6%96%B9.md
//剑指16. 数值的整数次方
//给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。
//思路：以 x 代表 base，n 代表 exponent。
//则当n%2=0,x^n=(x*x)^(n/2)
//当n%2=1,x^n=x*(x*x)^(n/2)
//因为 (x*x)^(n/2) 可以通过递归求解，并且每次递归 n 都减小一半，因此整个算法的时间复杂度为 O(logN)。
public class powerful {
    public double Power(double base,int exponent){
        if(exponent==0)
            return 1;
        if(exponent==1)
            return base;
        boolean isNegative = false;
        if(exponent<0){
            exponent = -exponent;
            isNegative = true;
        }
        double pow = Power(base*base,exponent/2);
        if(exponent%2!=0)
            pow = pow*base;
        return isNegative?1/pow:pow;
    }
    public static void main(String[] args){
        powerful power = new powerful();
        double res = power.Power(4,3);
        System.out.println(res);

    }
}
