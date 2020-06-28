//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/22.%20%E9%93%BE%E8%A1%A8%E4%B8%AD%E5%80%92%E6%95%B0%E7%AC%AC%20K%20%E4%B8%AA%E7%BB%93%E7%82%B9.md
//剑指22. 链表中倒数第 K 个结点
//思路：设链表的长度为N。设置两个指针P1和P2,先让P1移动K个节点，则还有N-K个节点可以移动。此时让P1和P2同时移动，
//可以知道当P1移动到链表结尾时，P2移动到第N-K个节点处，该位置就是倒数第K个节点。
//有点巧妙啊，(K+N)-K=(N-K)+K

public class fromTailKth {
    public static class ListNode
            //this method could be called when adding the 'static'
    {
        int val;

        ListNode next;

        public ListNode(int x){

            val=x;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k){
        if (head==null)
            return null;
        ListNode P1 = head;
        while(P1!=null&&k-->0)
            P1=P1.next;
        if (k>0)
            return null;
        ListNode P2=head;
        while(P1!=null){
            P1=P1.next;
            P2=P2.next;
        }
        return P2;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;

        fromTailKth tailedKth = new fromTailKth();
        ListNode tailedkth = tailedKth.FindKthToTail(l1,3);
        int kth = tailedkth.val;
        System.out.println(kth);

    }

}
