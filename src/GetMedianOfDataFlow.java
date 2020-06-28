//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/41.1%20%E6%95%B0%E6%8D%AE%E6%B5%81%E4%B8%AD%E7%9A%84%E4%B8%AD%E4%BD%8D%E6%95%B0.md
//剑指41.1 数据流中的中位数
//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

import java.util.PriorityQueue;

public class GetMedianOfDataFlow {
    //大顶堆，存储左半边元素
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1,o2)->o2-o1);
    //小顶堆，存储右半边元素，并且右半边元素都大于左半边
    /**(o1,o2)->o2-o1意味着重写compare方法
     * Queue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
     *             @Override
     *             public int compare(Integer o1, Integer o2) {
     *                 return o2.compareTo(o1);
     *             }
     *         });
     */
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    //当前数据流读入的元素个数
    private int N = 0;

    public void Insert(Integer val){
        //插入要保证两个堆存于平衡状态
        if(N%2==0){
            /*N为偶数的情况下插入到右半边。
            因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
            因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边
             */
            left.add(val);
            right.add(left.poll());
        }else{
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }
    public Double GetMedian(){
        if(N%2==0)
            return (left.peek()+right.peek())/2.0;
        else
            return (double)right.peek();
    }

    public static void main(String[] args) {
        GetMedianOfDataFlow getMedian = new GetMedianOfDataFlow();
        getMedian.Insert(1);
        getMedian.Insert(2);
        getMedian.Insert(2);
        getMedian.Insert(4);
        double b =  getMedian.GetMedian();
        System.out.println(b);
    }
}
