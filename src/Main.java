import java.util.Scanner;
import java.util.Arrays;
//招行信用卡编程题1，取袜子
//有n种颜色的袜子，第i种颜色有ai个，
// 它们都放在抽屉里，最少抽多少只才能保证有一双？
//王林丰解答
//public class Main {
//    private static int solution(int[] nums) {
//        int result=0;
//        boolean notAllzero=false;
//        boolean overTwo=false;
//        for (int i=0;i<nums.length;i++) {
//            if(nums[i] > 0)
//                notAllzero=true;
//            if (nums[i]>=2)
//                overTwo=true;
//            if(nums[i]!=0)
//                result++;
//        }
//        return notAllzero&&overTwo?result+1:-1;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//        for (int i=0;i<t;i++) {
//            int n = scanner.nextInt();
//            int[] nums = new int[n];
//            for(int j=0;j<n;j++) {
//                nums[j]=scanner.nextInt();
//            }
//            int result = Main.solution(nums);
//            System.out.println(result);
//        }
//    }
//}
//思路：
//如果每种袜子的个数都>=2，则至少拿n+1只袜子
//如果每种袜子的个数都是0或者1，则返回-1（取不到一双）
//否则至少将个数为1的袜子全部拿掉+个数>=2种类各拿一只
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int group = Integer.parseInt(scanner.nextLine()); //不太理解，感觉取到的group并不是“有多少组测试数据”？
            int[] res = new int[group];
            int i=0;
            while(i<group) {
                int kind = Integer.parseInt(scanner.nextLine()); //种类数
                String line = scanner.nextLine(); //第二行的每种袜子的个数
                String[] strs = line.split(" ");
                int[] number = new int[kind];
                for (int j=0;j<kind;j++){
                    number[j]=Integer.parseInt(strs[j]);  //对应某种袜子有多少个
                }
                res[i]=help(number);
                i++;
            }
            for (int k=0;k<group;k++){
                System.out.println(res[k]);
            }
        }
    }
    private static int help(int[] number) {
        int count0=0;
        int count1=0;
        for (int i=0;i<number.length;i++) {
            if (number[i]==0){
                count0++;
            }
            if (number[i]==1) {
                count1++;
            }
        }
        if(count0==0&&count1==0) {
            return number.length+1;
        }
        if(count0==number.length||count1==number.length||(count0+count1)==number.length){
            return -1;
        }
        return count1+(number.length-count0-count1)+1;
    }
}