//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/58.1%20%E7%BF%BB%E8%BD%AC%E5%8D%95%E8%AF%8D%E9%A1%BA%E5%BA%8F%E5%88%97.md
//剑指58.1 翻转单词顺序列
//Input:
//"I am a student."
//Output:
//"student. a am I"
//思路：题目应该有一个隐含条件，就是不能用额外的空间。
// 虽然Java的题目输入参数为String类型，需要先创建一个字符数组使得空间复杂度为O(N),
//但是正确的参数类型应该和原书一样，为字符数组，并且只能使用该字符数组的空间。
//任何使用了额外空间的解法在面试时都会大打折扣，包括递归解法。
//正确的解法应该是和书上一样，先旋转每个单词，再旋转整个字符串。
//Me：单词自身旋转了两次相当于没有旋转，但整个句子旋转了
public class ReverseSentence {
    public String ReverseSentence_Solution(String str){
        int n = str.length();
        char[] chars = str.toCharArray();
        int i=0,j=0;
        while(j<=n){
            if(j==n||chars[j]==' '){
                reverse(chars,i,j-1); //先旋转每个单词
                i=j+1; //旋转完了之后把i指针指到下一个单词的首字母
            }
            j++; //刚开始的时候先执行j++，到空格' '或结尾才开始执行上面的if
        }
        reverse(chars,0,n-1);
        return new String(chars);
    }

    private void reverse(char[] c,int i,int j){
        while(i<j)
            swap(c,i++,j--);
    }

    private void swap(char[] c,int i,int j){
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    public static void main(String[] args) {
        ReverseSentence reverseSentence = new ReverseSentence();
        String newString = reverseSentence.ReverseSentence_Solution("I am a student.");
        System.out.println(newString);
    }
}
