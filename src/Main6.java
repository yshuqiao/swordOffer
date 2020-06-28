import java.util.ArrayList;
import java.util.Scanner;
//腾讯笔试题1。
public class Main6 {

    public static class Q{
        private ArrayList<Object> arr;
        private int length;

        public Q(){
            this.length=0;
            this.arr = new ArrayList<Object>();
        }

        public void push(Object o){
            arr.add(o);
            this.length++;
        }
        public Object top(){
            if(this.length==0)return -1;
            else{
                return this.arr.get(0);
            }
        }

        public Object pop(){
            if(this.length==0) return -1;
            else{
                this.arr.remove(0);
                this.length--;
                return true;
            }
        }
        public int size(){
            return this.length;
        }

        public void clear(){
            this.arr.clear();
            this.length=0;
        }

        private static void main(){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            for(int i=0;i<n;i++){
                int m = sc.nextInt();
//                sc.nextLine();
                Q q = new Q();
                for(int j=0;j<m;j++){
                    String op = sc.nextLine();
                    if(op.length()>=6){
                        if("PUSH".equals(op.substring(0,4))){
                            String dg = op.substring(5,op.length());
                            q.push(dg);
                        }
                    }else if("TOP".equals(op)){
                        System.out.println(q.top());
                    }else if("SIZE".equals(op)){
                        System.out.println(q.size());
                    }else if("CLEAR".equals(op)){
                        q.clear();
                    }
                }
            }
        }
    }

}
