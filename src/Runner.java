import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
class Node{
    int numerator;
    int denominator;
    double fraction;
    Node(int num, int deno, double frac){
        numerator=num;
        denominator=deno;
        fraction=frac;
    }
}
class NodeComparator implements Comparator<Node>{
    @Override
    public int compare(Node o1, Node o2) {
        return Double.compare(o1.fraction,o2.fraction);
    }
}
public class Runner {
    public static void main(String[] args) {
        ArrayList<ArrayList<Double>> Karray=new ArrayList<ArrayList<Double>>();
        ArrayList<Integer> A=new ArrayList<>();
        A.add(1);
        A.add(719);
        A.add(983);
        A.add(9293);
        A.add(11321);
        A.add(14447);
        A.add(16411);
        A.add(17881);
        A.add(22079);
        A.add(28297);
        PriorityQueue<Node> pq=new PriorityQueue<>(new NodeComparator());
        for(int i=0 ; i < A.size();i++) {
            for (int j = A.size() - 1; j > i; j--) {
                int num = A.get(i);
                int deno = A.get(j);
                double frac = (double) num / (double) deno;
                //System.out.println(frac);
                Node n1 = new Node(num, deno, frac);
                pq.add(n1);
            }
        }
        for(int i = 1; i <=41;i++){
            pq.poll();
        }
        Node tmp=pq.poll();
        System.out.println(tmp.numerator);
        System.out.println(tmp.denominator);
    }
}
