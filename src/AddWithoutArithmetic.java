//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/65.%20%E4%B8%8D%E7%94%A8%E5%8A%A0%E5%87%8F%E4%B9%98%E9%99%A4%E5%81%9A%E5%8A%A0%E6%B3%95.md
//剑指65. 不用加减乘除做加法
//写一个函数，求两个整数之和，要求不得使用 +、-、*、/ 四则运算符号。
//a^b表示没有考虑进位的情况下两数的和，(a&b)<<1就是进位。
//递归会终止的原因是(a&b)<<最右边会多一个0，那么继续递归，
// 进位最右边的0会慢慢增多，最后进位会变为0，递归终止。

public class AddWithoutArithmetic {
    public int Add(int a,int b){
        return b==0?a:Add(a^b,(a&b)<<1);
    }

    public static void main(String[] args) {
        AddWithoutArithmetic add = new AddWithoutArithmetic();
        int c = add.Add(1,2);
        System.out.println(c);
    }
}
