import java.util.Arrays;
import java.util.Scanner;
//百度编程题2，取数
public class Main2 {
    //最小堆？
//    public static long test2(long[] a,int n) {
//        long res = 0;
//        Arrays.parallelSort(a);
//        long max = a[n-1];
//        while (max>=n) {
//            long t = a[n-1];
//            a = Arrays.stream(a).map(o->o+1).toArray();
//            a[n-1]=t-n;
//            Arrays.parallelSort(a);
//            max=a[n-1];
//            res++;
//        }
//        return res;
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        long[] a = new long[n];
        String[] c = sc.nextLine().split(" ");
        for (int i=0;i<n;i++) {
            a[i] = Long.parseLong(c[i]);
        }
        long num = 0;
        long[] index = new long[n];
        long temp = 1;
        while(temp!=0) {
            temp=0;
            for (int i=0;i<n;i++) {
                index[i] = a[i] / n;
                a[i] %= n;
                temp += index[i];
            }
            if (temp !=0) {
                for (int i=0;i<n;i++) {
                    a[i] += temp - index[i];
                }
                num += temp;
            }
        }
        System.out.println(num);
    }
}
