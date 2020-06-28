//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/12.%20%E7%9F%A9%E9%98%B5%E4%B8%AD%E7%9A%84%E8%B7%AF%E5%BE%84.md
//剑指12. 矩阵中的路径
//判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向上下左右移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
//思路：用回溯法进行求解，它是一种暴力搜索方法，通过搜索所有可能的结果来求解问题。
// 回溯法在一次搜索结束时需要进行回溯（回退），将这一次搜索过程中设置的状态进行清楚，从而开始一次新的搜索过程。

public class rectHasPath {
    private final static int[][] next = {{0,-1},{0,1},{-1,0},{1,0}}; //四个坐标方向
    private int rows;
    private int cols;

    public boolean hasPath(char[] array,int rows,int cols,char[] str){
        if (rows==0||cols==0) return false;
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        //本题的输入是数组而不是矩阵（二维数组），因此需要先将数组array转换成矩阵matrix。
        char [][] matrix = buildMatrix(array);
        for (int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                if (backtracking(matrix,str,marked,0,i,j))
                    return true;
        return false;
    }

    private boolean backtracking(char[][] matrix,char[] str,boolean[][] marked,int pathLen,int r,int c){
        if (pathLen == str.length)return true;
        if (r<0||r>=rows||c<0||c>=cols||matrix[r][c]!=str[pathLen]||marked[r][c]){
            return false;
        }
        marked[r][c] = true;
        for(int[] n:next)
            if (backtracking(matrix,str,marked,pathLen+1,r+n[0],c+n[1]))
                return true;
        marked[r][c] = false;  //在这一次搜索结束之后，需要将marked[r][c]的已经使用状态清除
        return false;
    }
    private char[][] buildMatrix(char[] array){
        char[][] matrix = new char[rows][cols];
        for(int r=0,idx=0;r<rows;r++)
            for(int c=0;c<cols;c++)
                matrix[r][c]=array[idx++];
        return matrix;
    }

    public static void main(String[] args){
        rectHasPath haspath = new rectHasPath();
        char[] array = {'a','b','t','g','a','f','c','s','j','d','e','h'};
        int rows = 3;
        int cols=4;
        char[] str={'b','f','c','e'};
        boolean hasornot = haspath.hasPath(array,rows,cols,str);
        System.out.println(hasornot);
    }

}
