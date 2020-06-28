//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/62.%20%E5%9C%86%E5%9C%88%E4%B8%AD%E6%9C%80%E5%90%8E%E5%89%A9%E4%B8%8B%E7%9A%84%E6%95%B0.md
//剑指62. 圆圈中最后剩下的数
//让小朋友们围成一个大圈。然后，随机指定一个数m，让编号为0的小朋友开始报数。
//每次喊到m-1的那个小朋友要出列唱首歌，然后可以在礼品箱中任意地挑选礼物，并且不再回到圈中，
//从他的下一个小朋友开始，继续0...m-1报数…这样下去…直到剩下最后一个小朋友，可以不用表演
//思路：
//约瑟夫环，圆圈长度为n的解可以看成长度为n-1的解再加上报数的长度m。因为是圆圈，所以最后需要对n取余。
//Me：未理解
public class LastRemainingInCircle {
    public int LastRemaining_Solution(int n,int m){
        if(n==0)  //特殊输入的处理
            return -1;
        if(n==1) //递归返回条件
            return 0;
        return (LastRemaining_Solution(n-1,m)+m)%n;
    }

    public static void main(String[] args) {
        LastRemainingInCircle lastRemainingInCircle = new LastRemainingInCircle();
        int lastRemaining = lastRemainingInCircle.LastRemaining_Solution(10,5);
        System.out.println(lastRemaining);
    }
}
