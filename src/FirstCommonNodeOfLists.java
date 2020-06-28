
//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/52.%20%E4%B8%A4%E4%B8%AA%E9%93%BE%E8%A1%A8%E7%9A%84%E7%AC%AC%E4%B8%80%E4%B8%AA%E5%85%AC%E5%85%B1%E7%BB%93%E7%82%B9.md
//剑指52. 两个链表的第一个公共结点
//思路：设A的长度为a+c，B的长度为b+c，其中c为尾部公共部分长度，可知a+c+b=b+c+a。
//当访问链表A的指针访问到链表尾部时，令它从链表B的头部重新开始访问链表B；
//同样地，当访问链表B的指针访问到链表尾部时，令它从链表A的头部重新开始访问链表A。
//这样就能控制访问A和B两个链表的指针能同时访问到交点。
//Me:妙啊
public class FirstCommonNodeOfLists {
    public static class ListNode
            //this method could be called when adding the 'static'
    {
        int val;

        ListNode next;

        public ListNode(int x){

            val=x;
        }
    }

    public  ListNode FindFirstCommonNode(ListNode pHead1,ListNode pHead2){
        ListNode l1 = pHead1,l2 = pHead2;
        while(l1!=l2){
            l1=(l1==null)?pHead2:l1.next;
            l2=(l2==null)?pHead1:l2.next;
        }
        return l1;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        l1.next = l11;
        ListNode l12 = new ListNode(3);
        l11.next = l12;
        ListNode l13 = new ListNode(4);
        l12.next = l13;

        ListNode l2 = new ListNode(0);
        ListNode l21 = new ListNode(1);
        l2.next = l21;
        ListNode l22 = new ListNode(2);
        l21.next = l22;
        l22.next = l12;

        FirstCommonNodeOfLists firstCommonNode = new FirstCommonNodeOfLists();
        ListNode commonNode = firstCommonNode.FindFirstCommonNode(l1,l2);

        System.out.println(commonNode.val);
    }
}
