import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/9.%20%E7%94%A8%E4%B8%A4%E4%B8%AA%E6%A0%88%E5%AE%9E%E7%8E%B0%E9%98%9F%E5%88%97.md
//腾讯实习笔试题4。
//思路：in 栈用来处理入栈（push）操作，out 栈用来处理出栈（pop）操作。
// 一个元素进入 in 栈之后，出栈的顺序被反转。
// 当元素要出栈时，需要先进入 out 栈，此时元素出栈顺序再一次被反转，
// 因此出栈顺序就和最开始入栈顺序是相同的，先进入的元素先退出，这就是队列的顺序。
public class Main5 {
    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
        if (out.isEmpty())
            while (!in.isEmpty())
                out.push(in.pop());

        if (out.isEmpty())
            throw new Exception("queue is empty");

        return out.pop();
    }

    public int peek() throws Exception {
        if (out.isEmpty())
            while (!in.isEmpty())
                out.push(in.pop());

        if (out.isEmpty())
            throw new Exception("queue is empty");

        return out.peek();
    }


    public static void main(String[] args) throws Exception {

        Main5 aqueue = new Main5();

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        ArrayList<Integer> ret=new ArrayList<>();
        while (T-- >= 0) {
            String action = in.nextLine();
            if(action.startsWith("add"))
                aqueue.push(Integer.parseInt(action.substring(4)));
            if(action.startsWith("peek"))
                ret.add(aqueue.peek());
            if(action.startsWith("poll"))
                aqueue.pop();
        }
        for(Integer a:ret) {
            System.out.println(a);
        }
    }
}
