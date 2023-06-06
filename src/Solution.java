import javax.print.attribute.standard.PrinterURI;
import java.util.*;

class pair{
    int vidx;
    int value;
    pair(int idx,int val){
        vidx=idx;
        value=val;
    }
}
class PairComparator implements Comparator<pair>{
    @Override
    public int compare(pair o1, pair o2) {
        return Integer.compare(o1.value,o2.value);
    }
}
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> ans=new ArrayList<>();
        PriorityQueue<Integer> Minpq=new PriorityQueue<>();
        PriorityQueue<Integer> Maxpq=new PriorityQueue<>(Collections.reverseOrder());
        int N = A.size();
        ans.add(A.get(0));
        Maxpq.add(A.get(0));
        for(int i=1; i < N ; i++){
            //insert element
            if(A.get(i) <= Maxpq.peek()){
                //insert into first half
                Maxpq.add(A.get(i));
            }else{
                Minpq.add(A.get(i));
            }
            if(Maxpq.size() < Minpq.size()){
                int elem=Minpq.poll();
                Maxpq.add(elem);
            }else if(Maxpq.size()-Minpq.size() > 1){
                int elem=Maxpq.poll();
                Minpq.add(elem);
            }
            //get medien
            int size= Maxpq.size()+Minpq.size();
            if(size%2==0){
                int median=(Maxpq.peek()+Minpq.peek())/2;
                ans.add(median);
            }else{
                int median=Maxpq.peek();
                ans.add(median);
            }
        }
        return ans;
    }
    public double ReturnMedian(ArrayList<Integer> A, int start , int end){
        int N = A.size();
        PriorityQueue<Integer> Minpq=new PriorityQueue<>();
        PriorityQueue<Integer> Maxpq=new PriorityQueue<>(Collections.reverseOrder());

        double Median=A.get(start);
        Maxpq.add(A.get(start));
        for(int i =start+1;i <=end ; i++){
            //insert into
            if(A.get(i)<=Maxpq.peek()){
                Maxpq.add(A.get(i));
            }else{
                Minpq.add((A.get(i)));
            }
            if(Maxpq.size() < Minpq.size()){
                Maxpq.add(Minpq.poll());
            }else if(Maxpq.size()-Minpq.size() >1){
                Minpq.add(Maxpq.poll());
            }
            int size=Maxpq.size()+Minpq.size();
            if(size%2==0){
                Median=(Maxpq.peek()+Minpq.peek())/2;
            }else{
                Median=Maxpq.peek();
            }
        }
        return Median;

    }
    public ArrayList<Integer> ReturnAthLargest(int A, ArrayList<Integer> B){
        int N = B.size();
        //Ath largest element in subarray [1 to i ]
        ArrayList<Integer> ans=new ArrayList<>();
        PriorityQueue<Integer> minpq=new PriorityQueue<>();
        for(int i =0 ; i < A-1 ; i++){
            minpq.add(B.get(i));
            ans.add(-1);
        }

        ans.add(minpq.peek());
        for(int i = A; i < N ; i++){
            if(minpq.peek() < B.get(i)){
                minpq.poll();
                minpq.add(B.get(i));
            }
            ans.add(minpq.peek());
        }
        return ans;
    }
    public int ReturnMinLargestElement(ArrayList<Integer> A , int B ){
        int N = A.size();
        PriorityQueue<pair> minpq=new PriorityQueue<>(new PairComparator());
        ArrayList<Integer> stateArr=new ArrayList<>(A);
        for(int i =0 ; i < N ; i++){
            pair p1=new pair(i,A.get(i));
            minpq.add(p1);
        }
        while(B>0){
            pair curr=minpq.peek();
            int curr_val=curr.value;
            int curr_idx=curr.vidx;
            stateArr.set(curr_idx,A.get(curr_idx)+curr_val);
            minpq.add(new pair(curr_idx,stateArr.get(curr_idx)));
            B--;
        }
        int maxelem=stateArr.get(0);
        for(int i=1; i < stateArr.size() ; i++){
            maxelem=Math.max(maxelem,stateArr.get(i));
        }
        return maxelem;
    }

    public static void main(String[] args) {
        Solution sln=new Solution();
        //ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1,2,5,4,3));
        //arr=sln.solve(arr);
        /*for(int i = 0 ; i < arr.size();i++){
            System.out.println(arr.get(i));
        }*
        /
         */

        /*ArrayList<Integer> arr1=new ArrayList<>(Arrays.asList(1,2,5,4,3));
        double Median=sln.ReturnMedian(arr1,2,4);
        System.out.println((int)Median);*/
        /*ArrayList<Integer> arr1=new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        ArrayList<Integer> ans= sln.ReturnAthLargest(4,arr1);
        for(int i : ans){
            System.out.println(i);
        }*/
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(5, 1, 4, 2));
        int ans=sln.ReturnMinLargestElement(arr,5);
        System.out.println(ans);

    }
}
