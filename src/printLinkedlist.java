
import java.util.ArrayList;
import java.util.Stack;

/**
 * 来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/6.%20%E4%BB%8E%E5%B0%BE%E5%88%B0%E5%A4%B4%E6%89%93%E5%8D%B0%E9%93%BE%E8%A1%A8.md
 * 剑指题6，从头到尾打印链表
 * 思路1：【使用递归】要逆序打印链表 1->2->3（3,2,1)，可以先逆序打印链表 2->3(3,2)，最后再打印第一个节点 1。
 * 而链表 2->3 可以看成一个新的链表，要逆序打印该链表可以继续使用求解函数，也就是在求解函数中调用自己，这就是递归函数。
 * 思路2：【头插法】顾名思义是将节点插入到头部：在遍历原始链表时，将当前节点插入新链表的头部，使其成为第一个节点。
 * 链表的操作需要维护后继关系，例如在某个节点 node1 之后插入一个节点 node2，我们可以通过修改后继关系来实现：
 * 思路3：【使用栈】栈具有后进先出的特点，在遍历链表时将值按顺序放入栈中，最后出栈的顺序即为逆序。
 */
public class printLinkedlist {

    public static class ListNode
    //this method could be called when adding the 'static'
    {
        int val;

        ListNode next;

        public ListNode(int x){

            val=x;
        }
    }

    public ArrayList<Integer> printListFromTailtoHead1(ListNode listNode){
        //法1：使用递归
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode !=null) {
            ret.addAll(printListFromTailtoHead1(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    public ArrayList<Integer> printListFromTailtoHead2(ListNode listNode) {
        //法2：头插法
        //头插法构建逆序链表
        ListNode head = new ListNode(-1);
        while(listNode != null){
            ListNode memo = listNode.next; //把原链表的下一个节点存储起来
            listNode.next = head.next; //链表新值由head.next驱动，注意是赋值给listNode.next，
            // 所以才能逆序（head从原链表顺序读取，而新链表不断地把读取到的值放到next）
            head.next = listNode; //head.next去获取原链表的当前节点值
            listNode = memo; //原链表下个节点赋值到当前节点
        }
        //构建ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head!=null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }

    public ArrayList<Integer> printListFromTailtoHead3(ListNode listNode) {
        //法3：使用桟
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while(!stack.isEmpty())
            ret.add(stack.pop());
        return ret;
    }

    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);   //make up linkedlist l1
        printLinkedlist printlist = new printLinkedlist();

        ArrayList<Integer> result = printlist.printListFromTailtoHead3(l1);
        System.out.println();
        for (Integer a:result) {
            System.out.print(a+" ");
        }



    }

}
