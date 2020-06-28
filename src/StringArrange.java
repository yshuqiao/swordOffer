//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/38.%20%E5%AD%97%E7%AC%A6%E4%B8%B2%E7%9A%84%E6%8E%92%E5%88%97.md
//剑指38. 字符串的排列
//输入一个字符串，按字典序打印出该字符串中字符的所有排列。例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class StringArrange {
    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return ret;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }

    private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if (s.length() == chars.length) {
            ret.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i])
                continue;
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) // 保证不重复
                continue;
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);

            s.deleteCharAt(s.length() - 1);//撤回来
            hasUsed[i] = false; //加回来
        }
    }

    public static void main(String[] args){
        StringArrange stringPermutations = new StringArrange();
        ArrayList<String> ret = stringPermutations.Permutation2("aabc");
        for(int j=0; j < ret.size(); j++) {
            if (j == ret.size() - 1)
                System.out.print(ret.get(j)); //如果是此行最后一个数，则不加逗号
            else
                System.out.print(ret.get(j) + ",");
        }
    }

    //第二种写法，来自up主子烁爱学习
    private TreeSet<String> result = new TreeSet<>();
    public ArrayList<String> Permutation2(String str){
        if(str==null||str.length()<1)
            return new ArrayList<>();
        List<Character> chars = new ArrayList<>();

        for(char c : str.toCharArray()){
            chars.add(c);
        }
        Compose(chars,new StringBuffer(),str.length(),0);
        return new ArrayList<>(result);
    }
    private void Compose(List<Character> arr,StringBuffer buffer,int len,int index){
        //递归结束条件
        if(index==len){
            result.add(buffer.toString());
            return;
        }
        for (int i=0;i<arr.size();i++){
            char c = arr.get(i);
            buffer.append(c);
            arr.remove(i);
            Compose(arr,buffer,len,index+1);

            arr.add(i,c);
            buffer.deleteCharAt((buffer.length()-1));
        }
    }
}