//京东实习笔试20200418，未完成
import java.util.*;

public class Main4 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int len = Integer.parseInt(scanner.nextLine());
//        ArrayList<Boolean> a = new ArrayList<>(len);
//        int box=0;
//        while(box<len) {
//            ArrayList<ArrayList<Integer>> res = new ArrayList<>(6);
//            for(int i=0;i<6;i++){
//                ArrayList<Integer> b = new ArrayList<>(2);
//                String line = scanner.nextLine();
//                String[] c = line.split(" ");
//                for (int j=0;i<2;j++) {
//                    b.add(Integer.parseInt(c[j])) ;
//                }
//                res.add(b);
//
//            }
//        }
//    }

    //来自牛友【求求给我offer吧~】
    public static class Node{
        int a,b;
        public Node(int a,int b){
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int a, b, tmp;
        boolean flag;
        Node[] nodes = new Node[6];
        while (T-- > 0) {
            map = new HashMap<Integer, Integer>();
            nodes = new Node[6];


            for (int i = 0; i < 6; i++) {
                a = in.nextInt();
                b = in.nextInt();
                if (a > b) {
                    tmp = a;
                    a = b;
                    b = tmp;
                }
                nodes[i] = new Node(a, b);
                map.put(a, map.getOrDefault(a, 0) + 1);
                map.put(b, map.getOrDefault(b, 0) + 1);
            }
            Arrays.sort(nodes, new Comparator<Node>() {
                public int compare(Node o1, Node o2) {
                    if (o1.a != o2.a)
                        return o1.a - o2.a;
                    return o1.b - o2.b;
                }
            });
            flag = true;
            for (int i = 0; i < 6; i += 2) {
                if (nodes[i].a != nodes[i + 1].a || nodes[i].b != nodes[i + 1].b)
                    flag = false;
            }
            if (map.size() > 3/*||map.size()==1*/)
                flag = false;
            System.out.println(!flag ? "IMPOSSIBLE" : "POSSIBLE");

        }
    }
}
