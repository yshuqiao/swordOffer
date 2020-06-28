import java.util.ArrayList;
import java.util.PriorityQueue;

//来源：https://github.com/CyC2018/CS-Notes/blob/master/notes/59.%20%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E7%9A%84%E6%9C%80%E5%A4%A7%E5%80%BC.md
//剑指59. 滑动窗口的最大值
//给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值
//例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小为3，
//那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,5}。
//Me：妙啊
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num,int size){
        ArrayList<Integer> ret = new ArrayList<>();
        if(size>num.length||size<1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2)->o2-o1); //大顶堆
        for(int i=0;i<size;i++)
            heap.add(num[i]);
        ret.add(heap.peek());
        for(int i=0,j=i+size;j<num.length;i++,j++){ //维护一个大小为size的大顶堆
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }

    public static void main(String[] args) {
        MaxInWindows maxes = new MaxInWindows();
        int[] num ={2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        ArrayList<Integer> ret = maxes.maxInWindows(num,size);
        for (int j=0; j < ret.size(); j++){
            if(j==ret.size()-1)
                System.out.print(ret.get(j)); //如果是此行最后一个数，则不加逗号
            else
                System.out.print(ret.get(j)+",");
        }
    }
}
