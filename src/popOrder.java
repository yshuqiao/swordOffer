import java.util.Stack;

//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/31.%20%E6%A0%88%E7%9A%84%E5%8E%8B%E5%85%A5%E3%80%81%E5%BC%B9%E5%87%BA%E5%BA%8F%E5%88%97.md
//剑指31. 栈的压入、弹出序列
//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
//例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
//思路：使用一个栈来模拟压入弹出操作
public class popOrder {
    public boolean IsPopOrder(int[] pushSequence,int[] popSequence){
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        for(int pushIndex=0,popIndex=0;pushIndex<n;pushIndex++){
            stack.push(pushSequence[pushIndex]);
            while(popIndex<n && !stack.isEmpty() && stack.peek()==popSequence[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        int[] b = {4,3,5,1,2};
        popOrder isPopOrder = new popOrder();
        boolean isOrder = isPopOrder.IsPopOrder(a,b);
        System.out.println(isOrder);
    }

    //第二种写法，来自up主子烁爱学习
    public boolean IsPopOrder2(int[] pushed,int[] popped){
        if(pushed.length!=popped.length)
            return false;
        if(pushed.length<1)
            return true;
        Stack<Integer> stack = new Stack<>();
        stack.push(pushed[0]);
        int i=1;
        for(int j=0;j<popped.length;j++){
            int num = popped[j];
            while(stack.peek()!=num&&i<pushed.length){
                stack.push(pushed[i++]);
            }
            if(stack.peek()==num){
                stack.pop();
                continue;
            }
            return false;
        }
        return true;
    }

}
