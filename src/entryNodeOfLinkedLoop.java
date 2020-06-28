//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/23.%20%E9%93%BE%E8%A1%A8%E4%B8%AD%E7%8E%AF%E7%9A%84%E5%85%A5%E5%8F%A3%E7%BB%93%E7%82%B9.md
//剑指23. 链表中环的入口结点
//一个链表中包含环，请找出该链表的环的入口结点。要求不能使用额外的空间。
//思路：使用双指针，一个快指针fast每次移动两个节点，一个慢指针slow每次移动一个节点。
// 因为存在环，所以两个指针必定相遇在环中的某个节点上。
//假设环入口节点为y1，相遇所在节点为z1。
//假设快指针fast在圈内绕了N圈，则路径总长度为x+Ny+(N-1)z。
//z为(N-1)倍是因为快慢指针最后已经在z1节点相遇了，后面就不需要再走了。
//而慢指针slow总路径长度为x+y
//因为快指针是慢指针的两倍，因此x+Ny+(N-1)z=2(x+y)。
//我们要找的是环入口节点y1，也可以成寻找长度x的值，
// 因此我们先将上面的等值分解为和x有关：x=(N-2)y+(N-1)z。
//上面的等值没有很强的规律，但是我们可以发现y+z就是圆环的长度，
// 而右边是在圆环中走过(N-2)圈，再从相遇点 z1再走过长度为z的长度。
// 此时我们可以发现如果让两个指针同时从起点x1和相遇点z1开始，
// 每次只走过一个距离，那么他们会在环入口节点相遇
public class entryNodeOfLinkedLoop {
    public static class ListNode
            //this method could be called when adding the 'static'
    {
        int val;

        ListNode next;

        public ListNode(int x){

            val=x;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead==null||pHead.next==null)
            return null;
        ListNode slow = pHead,fast=pHead;
        do{
            fast = fast.next.next;
            slow = slow.next;
        }while (slow!=fast);
        //相遇之后
        //让快指针从起点x1开始，慢指针从相遇点z1开始，
        fast = pHead;
        // 每次只走过一个距离，那么他们会在环入口节点相遇
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;
        ListNode l5 = new ListNode(5);
        l4.next = l5;
        ListNode l6 = new ListNode(6);
        l5.next = l6;
        ListNode l7 = new ListNode(7);
        l6.next = l7;
        l7.next = l3;

        entryNodeOfLinkedLoop findEntry = new entryNodeOfLinkedLoop();
        ListNode findentry = findEntry.EntryNodeOfLoop(l1);
        int entry = findentry.val;
        System.out.println(entry);
    }
}
