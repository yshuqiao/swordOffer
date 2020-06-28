import java.util.Stack;

//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/30.%20%E5%8C%85%E5%90%AB%20min%20%E5%87%BD%E6%95%B0%E7%9A%84%E6%A0%88.md
//剑指30. 包含 min 函数的栈
//定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的 min 函数。
public class stackIncludeMin {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node){
        dataStack.push(node); //仿佛带着一个仆人，妙啊
        minStack.push(minStack.isEmpty()?node:Math.min(minStack.peek(),node));
    }
    public void pop(){
        dataStack.pop();
        minStack.pop();
    }
    public int top(){
        return dataStack.peek();
    }
    public int min(){
        return minStack.peek();
    }

    public static void main(String[] args){
        int a = 1,b=2,c=3;
        stackIncludeMin datastack = new stackIncludeMin();
        datastack.push(a);
        datastack.push(b);
        datastack.push(c);
        datastack.pop();
        int d = datastack.top();
        System.out.println(d);
        int e = datastack.min();
        System.out.println(e);
    }
}
