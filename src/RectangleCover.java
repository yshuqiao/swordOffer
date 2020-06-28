//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/10.2%20%E7%9F%A9%E5%BD%A2%E8%A6%86%E7%9B%96.md
//10.2 矩形覆盖
//我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
//思路：当 n 为 1 时，只有一种覆盖方法；当 n 为 2 时，有两种覆盖方法；
//要覆盖 2*n 的大矩形，可以先覆盖 2*1 的矩形，再覆盖 2*(n-1) 的矩形；或者先覆盖 2*2 的矩形，再覆盖 2*(n-2) 的矩形。
// 而覆盖 2*(n-1) 和 2*(n-2) 的矩形可以看成子问题。可写出递推公式。

public class RectangleCover {
    public int RectCover(int n) {
        if(n<=2)
            return n;
        int pre2 = 1,pre1 = 2;
        int result = 0;
        for (int i=3;i<=n;i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    public static void main(String[] args){
        RectangleCover rectCover = new RectangleCover();
        int res = rectCover.RectCover(9);
        System.out.println(res);
    }
}
