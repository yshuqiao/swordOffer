//来源：https://github.com/h2pl/SwordToOffer/tree/master/src/ADT

public class Alias {

    public static class ListNode {

        public int val;

        public ListNode next = null;



        public ListNode(int val) {

            this.val = val;

        }

    }

    public static void main(String[] args) {

        //Alias tryAlias = new Alias();

        ListNode p = new ListNode(0);

        ListNode c = p;

        p = new ListNode(9);

        System.out.println(c.val);

    }

}