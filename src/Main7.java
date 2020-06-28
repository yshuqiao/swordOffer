import java.util.Scanner;

//腾讯笔试题5。
//给你一棵无限深度的满二叉树，节点的编号按层次依次编号，即第一层节点编号为 ，
//第二层节点编号为 ，第三层节点编号为 ，依次类推。
//接下来有Q次询问，每一次询问让你找到一个编号为 的结点在深度为 的祖先节点的编号搜索多少？
//输入描述：
//输入第一行一个整数Q,代表有Q次询问
//接下来Q行，每一行输入两个数和。
//输出描述：
//对于每一组测试数据，如果深度为 的祖先存在，输出结点编号，不存在输出 。
public class Main7 {
    public static long res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int i = 0;
        while (sc.hasNext() && i < count) {
            long a = sc.nextLong();
            int b = sc.nextInt();
            solve(a, b);
            i++;
            System.out.println(res);
        }
    }

    public static void solve(long x, int y) {
        long num = x;
        if (y == 1)
            res = 1;
        else {
            int place = 0;
            while (x != 0) {
                x = x / 2;
                place++;
            }
            if (y > place) {
                res = -1;
                return;
            }
            int c = place - y;
            while (c > 0) {
                num = num / 2;
                c--;
            }
            res = num;
        }
    }

}
