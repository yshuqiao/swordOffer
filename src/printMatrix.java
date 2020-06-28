//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/29.%20%E9%A1%BA%E6%97%B6%E9%92%88%E6%89%93%E5%8D%B0%E7%9F%A9%E9%98%B5.md
//剑指29. 顺时针打印矩阵

import java.util.ArrayList;
import java.util.Iterator;

public class printMatrix {
    public ArrayList<Integer> printMatrixByClockwise(int[][] matrix) {
        ArrayList<Integer> ret =new ArrayList<>();
        int r1 = 0, r2 = matrix.length-1,c1=0,c2=matrix[0].length-1;
        while (r1<=r2&&c1<=c2){
            for(int i=c1;i<=c2;i++)
                ret.add(matrix[r1][i]); //向右遍历
            for(int i=r1+1;i<r2;i++)
                ret.add(matrix[i][c2]); //向下遍历
            if(r1!=r2)
                for (int i=c2-1;i>=c1;i--)
                    ret.add(matrix[r2][i]); //向左遍历
            if(c1!=c2)
                for(int i=r2-1;i>r1;i--)
                    ret.add(matrix[i][c1]); //向上遍历
            r1++;r2--;c1++;c2--;
        }
        return ret;
    }

    public static void main(String[] args){
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix= new int[4][4];
        int m=1;
        for(int i=0 ;i<4;i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = m;
//                System.out.println(m);
                m++;
            }
        }


        printMatrix printByclock = new printMatrix();

        ArrayList<Integer> ret = printByclock.printMatrixByClockwise(matrix);


        // 输出方法1
        for (Iterator it2 = ret.iterator(); it2.hasNext();) {
            System.out.println(it2.next());
        }
//        // 输出方法2
//        for (int tmp : ret) {
//            System.out.println(tmp);
//        }
//        // 输出方法3
//        for (int i = 0; i < ret.size(); i++) {
//            System.out.println(ret.get(i));
//        }


    }
}
