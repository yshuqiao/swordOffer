//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/67.%20%E6%8A%8A%E5%AD%97%E7%AC%A6%E4%B8%B2%E8%BD%AC%E6%8D%A2%E6%88%90%E6%95%B4%E6%95%B0.md
//剑指67. 把字符串转换成整数
//将一个字符串转换成一个整数，字符串不是一个合法的数值则返回 0，要求不能使用字符串转换整数的库函数。
//Iuput:
//+2147483647
//1a33
//Output:
//2147483647
//0
public class StrToIntByHand {
    public int StrToInt(String str) {
        if (str == null)
            return 0;
        int result = 0;
        boolean negative = false;//是否负数
        int i = 0, len = str.length();
        /**
         * limit默认初始化范围为*负的最大正整数，假如字符串表示的是正数
         * 由于int的范围为-2147483648~-2147483647
         * 那么result（在返回之前一直是负数形式）就必须和这个最大正数的负数来比较来判断是否溢出
         */
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = str.charAt(0); // 首先看第一位
            if (firstChar < '0') {//有可能是“+”or"-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE; //在负号的情况下，判断溢出的值就变成了整数的最小负数了
                } else if (firstChar != '+')//第一位不是数字和-只能是+
                    return 0;
                if (len == 1)//Cannot have lone "+"or"-"
                    return 0;
                i++;
            }
            multmin = limit / 10;
            while (i < len) {
                digit = str.charAt(i++) - '0';
                if (digit < 0 || digit > 9)
                    return 0;
                //判断溢出
                if (result < multmin) {
                    return 0;
                }
                result *= 10; //注意这里
                if (result < limit + digit) {
                    return 0;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        //如果是正数就返回-result(result一直是负数）
        return negative ? result : -result;
    }

    public static void main(String[] args) {
        StrToIntByHand strToIntByHand = new StrToIntByHand();
        int res = strToIntByHand.StrToInt("1234");
        System.out.println(res);
    }

}
