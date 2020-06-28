//来源：https://leetcode-cn.com/problems/number-of-digit-one/discuss/64381/4+-lines-O(log-n)-C++JavaPython/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
//剑指43. 从 1 到 n 整数中 1 出现的次数/力扣233
//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
//示例:
//输入: 13
//输出: 6
//解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。

public class NumberOf1From1ToN {
    public int NumberOf1Between1AndN_Solution(int n){
        int cnt=0;
        for(int m=1;m<=n;m*=10){
            int a=n/m,b=n%m;
            cnt+=(a+8)/10*m+(a%10==1?b+1:0);
        }
        return cnt;
    }

    //另外来自https://leetcode-cn.com/problems/number-of-digit-one/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-50/
    //解法一，暴力,nlogn
    public int countDigitOne1(int n){
        int num=0;
        for(int i=1;i<=n;i++){
            int temp=i;
            while(temp>0){
                if(temp%10==1){
                    num++;
                }
                temp/=10;
            }
        }
        return num;
    }

    //解法二，递归，logn
    //假设 n = xyzdabc，此时我们求千位是 1 的个数，也就是 d 所在的位置。
    //那么此时有三种情况，
    //d == 0，那么千位上 1 的个数就是 xyz * 1000
    //d == 1，那么千位上 1 的个数就是 xyz * 1000 + abc + 1
    //d > 1，那么千位上 1 的个数就是 xyz * 1000 + 1000
    public int countDigitOne2(int n){
        int count = 0;
        //依次考虑个位、十位、百位……是1
        //当k=1000，对应于上边举的例子
        for(int k=1;k<=n;k*=10){
            //xyzdabc
            int abc = n%k;
            int xyzd = n/k;
            int d = xyzd%10;
            int xyz = xyzd/10;
            count += xyz*k;
            if (d>1){
                count+=k;
            }
            if(d==1){
                count += abc+1;
            }
            //如果不加这句的话，虽然k一直乘以10,但由于溢出的问题
            //k本来要大于n的时候，却小于了n会再次进入循环
            //此时代表最高位是1的情况也考虑完成了
            if(xyz==0){
                break;
            }
        }
        return count;
    }
    //然后代码的话，可以再简化一下，注意到d>1的时候，我们多加了一个k。
    //我们可以通过计算long xyz = xyzd/10;的时候，给xyzd多加8，
    // 从而使当d>1的时候，此时求出来的xyz会比之前大1,这样计算xyz*k的时候就相当于多加了一个k。
    //此外，上边k溢出的问题，我们可以通过long类型解决
    public int countDigitOne3(int n){
        int count = 0;
        for(long k=1;k<=n;k*=10){
            //xyzdabc
            int abc = n%(int)k; //强制转换long到int类型
            int xyzd = n/(int)k;
            int d = xyzd%10;
            int xyz = (xyzd+8)/10;
            count+=xyz*k;
            if(d==1){
                count+=abc+1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1From1ToN count1 = new NumberOf1From1ToN();
        int count = count1.countDigitOne1(145);
        System.out.println(count);
    }


}
