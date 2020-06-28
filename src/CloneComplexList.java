import java.util.HashMap;

//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/35.%20%E5%A4%8D%E6%9D%82%E9%93%BE%E8%A1%A8%E7%9A%84%E5%A4%8D%E5%88%B6.md
//剑指35. 复杂链表的复制
//输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的 head。
//思路：第一步，在每个节点的后面插入复制的节点。
//第二步，对复制节点的random链接进行赋值
//第三步，拆分
public class CloneComplexList {
    public static class RandomListNode{
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label){
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null)
            return null;
        //插入新节点
        RandomListNode cur = pHead;
        while(cur!=null){
            RandomListNode clone = new RandomListNode(cur.label); //复制原链表中的第一个节点
            clone.next = cur.next; //新节点指向原链表中下一个节点（也算是把下一个要遍历的节点存到clone.next）
            cur.next = clone; //原链表第一个节点指向新节点
            cur = clone.next;//把cur指针移动到下一个要遍历的节点
        }
        //建立random连接
        cur = pHead;
        while(cur!=null){
            RandomListNode clone = cur.next; //原链表节点的旁边下一个节点就是新链表的节点
            if(cur.random != null)
                clone.random = cur.random.next; //新链表节点的特殊指针指向的正是原链表的特殊指针指向的节点的旁边下一个节点
            cur = clone.next; //移动指针，通过新链表的下一个节点获取到到原链表的下一个节点
        }

        //拆分
        cur = pHead; //复位
        RandomListNode pCloneHead = pHead.next; // 原链表头节点的旁边下一个节点就是新链表的头节点
        while(cur.next!=null){
            RandomListNode next = cur.next; //第一次，新链表的节点（也算是保存cur指针要遍历的下一个节点）
            cur.next = next.next; //第一次，原链表的下一个节点为新链表的节点的下一个节点
            //用两个next是把新旧链表节点隔过去
            cur = next; //第一次，cur指针指向新链表的节点
            //总之，新旧链表交替着来
        }
        return pCloneHead;
    }

    //第二种写法，仍是空间复杂度O(1)，Up主 舞年落梦
    public RandomListNode Clone2(RandomListNode pHead){
        if(pHead == null){
            return null; //判空
        }
        //第一个过程->创建新链表节点插入到原链表中
        RandomListNode removeNode = pHead;
        while(removeNode!=null){
            RandomListNode temp = removeNode.next; //暂存下一个要遍历的节点
            RandomListNode node = new RandomListNode(removeNode.label);
            removeNode.next = node;//原节点指向新节点
            node.next = temp; //新节点指向当前节点的next
            removeNode = temp;
        }
        //第二个过程->创建random节点指向
        removeNode = pHead; //复位
        while(removeNode!=null){
            removeNode.next.random = removeNode.random == null?null:removeNode.random.next;
            //因为现在新链表和原链表是交替在同一个链表中，新链表的特殊指针指向的节点刚好是原链表的特殊指针指向的节点的旁边那个，画图才看得清楚，加判空是因为可能有些节点的特殊指针没有指向另一个节点
            removeNode = removeNode.next.next; //用两个next是把新链表节点隔过去
        }
        //第三个过程->链表的分割
        removeNode = pHead; //复位
        RandomListNode cloneHead = pHead.next;
        while(removeNode!=null){
            RandomListNode node = removeNode.next;
            removeNode.next = node.next;//原链表中节点之间的结构关系维护
            node.next = node.next==null?null:node.next.next;//新链表中节点关系的维护，加判空是因为尾部
            removeNode = removeNode.next;
        }
        return cloneHead;
    }

    //法2：用哈希map，空间复杂度为O(n),来自up主mmmmm8811
    public RandomListNode Clone3(RandomListNode head){
        RandomListNode cur = head;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        //第一次遍历，存value
        while(cur!=null){
            map.put(cur,new RandomListNode(cur.label));
            cur = cur.next;
        }

        cur = head;//复位
        //第二次遍历，处理徒弟的指向关系
        while(cur!=null){
            //关键代码两行
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }

    //法2的第二种写法，来自up主子烁爱学习
    HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
    private RandomListNode Clone4(RandomListNode oldNode){
        if(oldNode == null)
            return null;
        if(map.containsKey(oldNode)){
            return map.get(oldNode); //主要应用于特殊指针即tmpNode.random那一句，因为在tmpNode.next构建新链表那里已经存有了原链表的各个节点
        }
        RandomListNode tmpNode = new RandomListNode(oldNode.label);
        map.put(oldNode,tmpNode);
        tmpNode.next = Clone4(oldNode.next);
        tmpNode.random = Clone4(oldNode.random);
        return tmpNode;
    }


    public static void main(String[] args){
        RandomListNode a1 = new RandomListNode(1);
        RandomListNode a2 = new RandomListNode(2);
        RandomListNode a3 = new RandomListNode(3);
        RandomListNode a4 = new RandomListNode(4);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a1.random = a3;
        a2.random = a4;
        a3.random = a1;
        a4.random = a2;

        CloneComplexList cloneList = new CloneComplexList();
        RandomListNode newa1 = cloneList.Clone2(a1);
        RandomListNode newa2 = newa1.next;
        RandomListNode newa1Random = newa1.random;
        RandomListNode newa2Random = newa2.random;
        System.out.println(newa1.label);
        System.out.println(newa2.label);
        System.out.println(newa1Random.label);
        System.out.println(newa2Random.label);
    }

}
