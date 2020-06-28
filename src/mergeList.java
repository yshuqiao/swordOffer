//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/25.%20%E5%90%88%E5%B9%B6%E4%B8%A4%E4%B8%AA%E6%8E%92%E5%BA%8F%E7%9A%84%E9%93%BE%E8%A1%A8.md
//剑指25. 合并两个排序的链表

public class mergeList {
    public static class ListNode
            //this method could be called when adding the 'static'
    {
        int val;

        ListNode next;

        public ListNode(int x){

            val=x;
        }
    }

    //法1：递归，巧妙啊
    public ListNode Merge(ListNode list1,ListNode list2){
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        if(list1.val<=list2.val){
            list1.next = Merge(list1.next,list2);
            return list1;
        }else{
            list2.next = Merge(list1,list2.next);
            return list2;
        }
    }

    //法2：迭代
    public ListNode Merge2(ListNode list1,ListNode list2){
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null){
            if(list1.val<=list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1!=null)
            cur.next=list1;
        if (list2!=null)
            cur.next=list2;
        return head.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        l1.next = l2;
        ListNode l3 = new ListNode(5);
        l2.next = l3;

        ListNode m1 = new ListNode(2);
        ListNode m2 = new ListNode(4);
        m1.next = m2;
        ListNode m3 = new ListNode(6);
        m2.next = m3;

        mergeList mergelist = new mergeList();
        ListNode newlist = mergelist.Merge2(l1,m1);
        while(newlist!=null){
            System.out.println(newlist.val);
            newlist = newlist.next;
        }

    }
}
