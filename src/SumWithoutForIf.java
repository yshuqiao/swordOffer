//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/64.%20%E6%B1%82%201+2+3+...+n.md
//要求不能使用乘除法、for,while,if,else,switch,case等关键字及条件判断语句A?B:C。
//思路：使用递归解法最重要的是指定返回条件，但本题无法直接使用if语句来指定返回条件。
//条件与&&具有短路原则，即在第一个条件语句为false的情况下不会去执行第二个条件语句。
//利用这一特性，将递归的返回条件取非然后作为&&的第一个条件语句，递归的主体转换成第二个条件语句，
//那么当递归的返回条件为true的情况下就不会执行递归的主题部分，递归返回。
//本题的递归返回条件为n<=0，取非后就是n>0;递归主体部分为sum+=Sum_Solution(n-1)，
// 转换为条件语句后就是(sum+=Sum_Solution(n-1))>0。
public class SumWithoutForIf {
    public int Sum_Solution(int n){
        int sum = n;
        boolean b = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }

    public static void main(String[] args) {
        SumWithoutForIf sumWithoutForIf = new SumWithoutForIf();
        int sum = sumWithoutForIf.Sum_Solution(4);
        System.out.println(sum);
    }
}
