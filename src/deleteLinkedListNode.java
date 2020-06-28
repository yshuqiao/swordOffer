//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/18.1%20%E5%9C%A8%20O(1)%20%E6%97%B6%E9%97%B4%E5%86%85%E5%88%A0%E9%99%A4%E9%93%BE%E8%A1%A8%E8%8A%82%E7%82%B9.md
//剑指18.1 在 O(1) 时间内删除链表节点
//思路：① 如果该节点不是尾节点，那么可以直接将下一个节点的值赋给该节点，然后令该节点指向下下个节点，再删除下一个节点，时间复杂度为 O(1)。
//② 否则，就需要先遍历链表，找到节点的前一个节点，然后让前一个节点指向 null，时间复杂度为 O(N)。
//综上，如果进行 N 次操作，那么大约需要操作节点的次数为 N-1+N=2N-1，其中 N-1 表示 N-1 个不是尾节点的每个节点以 O(1) 的时间复杂度操作节点的总次数，N 表示 1 个尾节点以 O(N) 的时间复杂度操作节点的总次数。(2N-1)/N ~ 2，因此该算法的平均时间复杂度为 O(1)。

public class deleteLinkedListNode {
    public static class ListNode
            //this method could be called when adding the 'static'
    {
        int val;

        ListNode next;

        public ListNode(int x){

            val=x;
        }
    }
    public ListNode deleteNode(ListNode head,ListNode tobeDetete){
        if(head==null || tobeDetete==null)
            return null;
        if(tobeDetete.next!=null){
            //要删除的节点不是尾节点
            ListNode next = tobeDetete.next;
            tobeDetete.val = next.val;
            tobeDetete.next = next.next;
        }else{
            if(head==tobeDetete)
                //只有一个节点
                head = null;
            else{
                ListNode cur = head;
                while(cur.next!=tobeDetete)
                    cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;

        deleteLinkedListNode deletenode = new deleteLinkedListNode();
        ListNode newl1 = deletenode.deleteNode(l1,l1);
//        ListNode newl2 = newl1.next;
        System.out.println(newl1.val);
    }
}
