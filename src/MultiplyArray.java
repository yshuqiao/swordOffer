//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/66.%20%E6%9E%84%E5%BB%BA%E4%B9%98%E7%A7%AF%E6%95%B0%E7%BB%84.md
//剑指66. 构建乘积数组
//给定一个数组A[0,1,...,n-1]，请构建一个数组B[0,1,...,n-1],
// 其中B的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
//要求不能使用除法。
public class MultiplyArray {
    public int[] multiply(int[] A){
        int n = A.length;
        int[] B = new int[n];
        for(int i=0,product = 1;i<n;product*=A[i],i++) //从左往右累乘
            B[i] = product;
        for(int i=n-1,product=1;i>=0;product*=A[i],i--) //从右往左累乘
            B[i]*=product;
        return B;
    }

    public static void main(String[] args) {
        MultiplyArray multiplyArray = new MultiplyArray();
        int[] A = {1,2,3,4};
        int[] B = multiplyArray.multiply(A);
        for(int i=0;i<B.length;i++){
            System.out.println(B[i]);
        }
    }
}
