import java.util.Scanner;
//public class Main3 {
//阿里编程题1，养鸡场增长贩卖问题，我自己写的
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] b = sc.nextLine().split(" ");
//        String[] a = sc.nextLine().split(" ");
//        int n = Integer.parseInt(b[0]);
//        int m = Integer.parseInt(b[1]);
//        int k = Integer.parseInt(b[2]);
//        for (int i=0;i<m;i++) {
//            for (int j=0;i<n;j++) {
//                a[j]+=k;
//            }
//            int maxa=0;
//            int maxaj=0;
//            for (int j=0;i<n;j++) {
//
//                if (a[j]>maxa) {
//                    maxa = a[j];
//                    maxaj=j;
//                }
//            }
//            a[maxaj]=a[maxaj]/2;
//        }
//        int outnum=0;
//        for (int j=0;i<n;j++) {
//            outnum+=a[j];
//        }
//        System.out.println(outnum);
//    }
//}