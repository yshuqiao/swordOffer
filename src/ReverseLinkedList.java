//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/24.%20%E5%8F%8D%E8%BD%AC%E9%93%BE%E8%A1%A8.md
//剑指24.反转链表

public class ReverseLinkedList {
    public static class ListNode
            //this method could be called when adding the 'static'
    {
        int val;

        ListNode next;

        public ListNode(int x){

            val=x;
        }
    }

    //法1：递归
    public ListNode ReverseList(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode next = head.next; //第一次一直遍历到4（因为下面递归那一句）
        head.next = null;
        ListNode newHead = ReverseList(next); //因为它
        next.next = head; //第一次使4指向3
        return newHead;
    }

    //法2：迭代，使用头插法
    public ListNode ReverseList2(ListNode head){
        ListNode newList = new ListNode(-1);
        while(head!=null){
            ListNode next = head.next; //第一次是2，第二次是3
            head.next = newList.next; //第一次是null，第二次是1
            newList.next = head; //第一次是1，第二次是2
            head = next; //第一次是2，第二次是3
        }
        return newList.next; //最后一次是4
    }

    //递归的第二种实现，up主【程序员刀刀】
    public ListNode ReverseList3(ListNode head){
        if (head == null)return null;
        ListNode[] res = reverse(head);
        return res[0];
    }
    private ListNode[] reverse(ListNode head){
        if(head.next == null){
            return new ListNode[]{head,head};
        }
        ListNode[] res = reverse(head.next);
        res[1].next = head;
        head.next = null;
        return new ListNode[]{res[0],head};
    }

    //迭代的第二种实现，子烁爱学习
    public ListNode ReverseList4(ListNode head){
        //[!]参数合法性校验
        if(head == null)
            return null;

        //[0]定义三个指针
        ListNode ptr_pre = head;  //第一次是1
        ListNode ptr_cur = head.next; //第一次是2
        if(ptr_cur==null)
            return head;
        ListNode ptr_next = ptr_cur.next; //第一次是3

        //[!]第一个元素没有next
        ptr_pre.next = null; //让原来的第一个元素1（作为新链表的尾结点）指向null
        while(ptr_next!=null){
            //[1]切断然后重新连接
            ptr_cur.next = ptr_pre; //第一次是 让2指向1

            //[2]向右移动
            ptr_pre = ptr_cur; // 由1右移到2   最后一次是由2右移到3
            ptr_cur = ptr_next; // 由2右移到3    最后一次是由3右移到4
            ptr_next = ptr_next.next; // 由3右移到4 最后一次是由4右移到null
        }
        //[!]最后一个元素的next指向他前面的一个
        ptr_cur.next = ptr_pre;  //4指向3
        return ptr_cur;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;

        ListNode newL1 = new ReverseLinkedList().ReverseList3(l1);
        while(newL1!=null){
            System.out.println(newL1.val);
            newL1 = newL1.next;
        }
    }
}
