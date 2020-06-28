//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/58.2%20%E5%B7%A6%E6%97%8B%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2.md
//剑指58.2 左旋转字符串
//Input:
//S="abcXYZdef"
//K=3
//Output:
//"XYZdefabc"
//思路：先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，然后再把整个字符串翻转得到 "XYZdefabc"。
//Me:与上题58.1 翻转单词顺序列类似，还多了一个输入参数（隔开两个“单词”）
public class LeftRotateStringFromK {
    public String LeftRotateString(String str,int n){
        if(n>=str.length())
            return str;
        char[] chars = str.toCharArray();
        reverse(chars,0,n-1);
        reverse(chars,n,chars.length-1);
        reverse(chars,0,chars.length-1);
        return new String(chars);
    }

    private void reverse(char[] chars,int i,int j){
        while(i<j)
            swap(chars,i++,j--);
    }
    private void swap(char[] chars,int i,int j){
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] =t;
    }

    public static void main(String[] args) {
        LeftRotateStringFromK leftRotateStringFromK = new LeftRotateStringFromK();
        String newString = leftRotateStringFromK.LeftRotateString("abcXYZdef",3);
        System.out.println(newString);
    }

}
