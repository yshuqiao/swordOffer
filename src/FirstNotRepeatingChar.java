import java.util.BitSet;

//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/50.%20%E7%AC%AC%E4%B8%80%E4%B8%AA%E5%8F%AA%E5%87%BA%E7%8E%B0%E4%B8%80%E6%AC%A1%E7%9A%84%E5%AD%97%E7%AC%A6%E4%BD%8D%E7%BD%AE.md
//剑指50. 第一个只出现一次的字符位置
//在一个字符串中找到第一个只出现一次的字符，并返回它的位置。
//思路：
//最直观的解法是使用HashMap对出现次数进行统计，但是考虑到要统计的字符有限，
//因此可以使用整型数组代替HashMap，从而将空间复杂度由O(N)降低为O(1)。
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar_Solution(String str){
        int[] cnts = new int[256];
        for(int i=0;i<str.length();i++)
            cnts[str.charAt(i)]++;
        for(int i=0;i<str.length();i++)
            if (cnts[str.charAt(i)]==1)
                return i;
        return -1;
    }

    //以上实现的空间复杂度还不是最优的。考虑到只需要找到出现一次的字符，
    //那么需要统计的次数信息只有0,1,更大，使用两个比特位就能存储这些信息。
    public int FirstNotRepeatingChar_Solution2(String str){
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for(char c:str.toCharArray()){
            if(!bs1.get(c)&&!bs2.get(c))
                bs1.set(c); //0 0 -> 0 1
            else if (bs1.get(c)&&!bs2.get(c))
                bs2.set(c); //0 1 -> 1 1
        }
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(bs1.get(c)&&!bs2.get(c)) //0 1
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar appearOnce = new FirstNotRepeatingChar();
        int appearOncePosition =appearOnce.FirstNotRepeatingChar_Solution2("abacc");
        System.out.println(appearOncePosition);
    }
}
