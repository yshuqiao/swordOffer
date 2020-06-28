//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/41.2%20%E5%AD%97%E7%AC%A6%E6%B5%81%E4%B8%AD%E7%AC%AC%E4%B8%80%E4%B8%AA%E4%B8%8D%E9%87%8D%E5%A4%8D%E7%9A%84%E5%AD%97%E7%AC%A6.md
//剑指41.2 字符流中第一个不重复的字符
//请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。

import java.util.LinkedList;
import java.util.Queue;

public class FirstAppearOnceOfChatStream {
    private int[] cnts = new int[256];
    private Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch){
        cnts[ch]++;
        queue.add(ch);
        while(!queue.isEmpty()&&cnts[queue.peek()]>1)
            queue.poll(); //若有重复字符则弹出
    }
    public char FirstAppearingOnce(){
        return queue.isEmpty()?'#':queue.peek();
        //利用队列先进先出的特性
    }

    public static void main(String[] args){
        FirstAppearOnceOfChatStream characters = new FirstAppearOnceOfChatStream();
        characters.Insert('g');
        characters.Insert('o');
        characters.Insert('o');
        characters.Insert('g');
        characters.Insert('l');
        characters.Insert('e');
        Character firstOnce = characters.FirstAppearingOnce();
        System.out.println(firstOnce);
    }
}
