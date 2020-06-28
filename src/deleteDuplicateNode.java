//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/18.2%20%E5%88%A0%E9%99%A4%E9%93%BE%E8%A1%A8%E4%B8%AD%E9%87%8D%E5%A4%8D%E7%9A%84%E7%BB%93%E7%82%B9.md
//剑指18.2 删除链表中重复的结点
//例如：输入1->2->2->3->3->4
//输出为1->4
public class deleteDuplicateNode {
    public static class ListNode
            //this method could be called when adding the 'static'
    {
        int val;

        ListNode next;

        public ListNode(int x){

            val=x;
        }
    }

    public ListNode deleteDuplication(ListNode pHead){

        if(pHead==null || pHead.next==null)
            return pHead;
        ListNode next = pHead.next;
        if(pHead.val == next.val){
            while(next!=null&&pHead.val==next.val)
                next = next.next;
            return deleteDuplication(next);  //删除连续的重复结点
        }else{
            pHead.next=deleteDuplication(pHead.next);
            //进行下一个结点的检查
            return pHead;
        }
    }

    //子烁爱学习
    public ListNode deleteDuplication2(ListNode pHead){
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        ListNode root = new ListNode(Integer.MAX_VALUE);
        root.next = pHead;
        ListNode pre = root; //造一个哨兵结点
        ListNode cur = root;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val)
                //先用到cur.next，这就是为什么上面定义ListNode cur = root的原因
                cur=cur.next; //例如：输入1->2->2->3->3->4,先删除第一个2
            cur=cur.next; //再删除第二个2
            if(cur!=null&&cur.next!=null&&cur.val==cur.next.val)
                continue; //返回上一个while循环，删除接下来重复的3

            pre.next = cur;
            pre = pre.next; //大循环继续走下去（外层的while）
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(2);
        l2.next = l3;
        ListNode l4 = new ListNode(2);
        l3.next = l4;
        ListNode l5 = new ListNode(3);
        l4.next = l5;

        deleteDuplicateNode deletenode = new deleteDuplicateNode();
        ListNode newl1 = deletenode.deleteDuplication2(l1);
        ListNode newl2 = newl1.next;
        System.out.println(newl2.val);
    }
}
