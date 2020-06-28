//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/17.%20%E6%89%93%E5%8D%B0%E4%BB%8E%201%20%E5%88%B0%E6%9C%80%E5%A4%A7%E7%9A%84%20n%20%E4%BD%8D%E6%95%B0.md
//剑指17. 打印从 1 到最大的 n 位数
//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
//思路：由于n可能会非常大，因此不能直接用int表示数字，而是用char数组进行存储。
//使用回溯法得到所有的数。

public class printDigits {
    public void print1ToMaxOfNDigits(int n){
        if(n<=0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number,0);
    }
    private void print1ToMaxOfNDigits(char[] number,int digit){
        if(digit == number.length){ //当位数等于number.length才开始打印
            printNumber(number);
            return;
        }
        for(int i=0;i<10;i++){
            number[digit]=(char)(i+'0'); //每一位的数字从0到9
            print1ToMaxOfNDigits(number,digit+1);
            //把从0到第number.length位，所有位都依次填好
        }
    }
    private void printNumber(char[] number){
        int index=0;
        while (index<number.length&&number[index]=='0')
            index++;
        while(index<number.length)
            System.out.print(number[index++]);
        //从左到右（高位到低位）打印一个数
        System.out.println();
    }

    //法2：用库函数Math.pow
    public int[] printNumbers(int n) {
        int maxValue = (int) Math.pow(10,n);
        int[] res = new int[maxValue-1];
        for (int i=1;i<maxValue;i++)
            res[i-1]=i;
        return res;
    }

    public static void main(String[] args){
        printDigits numberDigits = new printDigits();
        numberDigits.print1ToMaxOfNDigits(2);
//        int[] res = numberDigits.printNumbers(2);
//        for (int i=0;i<res.length;i++)
//            System.out.println(res[i]);
    }

}
