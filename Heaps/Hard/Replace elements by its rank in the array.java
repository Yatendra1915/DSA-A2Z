class Pair implements Comparable<Pair>{
    int data, index;
    public Pair(int data,int index){
        this.data=data;
        this.index=index;
    }
    public int compareTo(Pair obj){
        return this.data-obj.data ;
    }
}
public class Solution {
    static int[] replaceWithRank(int arr[], int n) {
        int temp[]=new int[n];
        PriorityQueue<Pair>list =new PriorityQueue<>();
        for (int i = 0; i < temp.length; i++) {
            list.add(new Pair(arr[i], i));
        }
        int inc=0,last=Integer.MIN_VALUE;
        for (int i = 0; i < temp.length; i++) {
            Pair p=list.poll();
            int data=p.data, index=p.index;
           if(data!=last){
            last=data;
            inc++;
            temp[index]=inc;
           }else temp[index]=inc;
        }
        return temp;
   
     }
}
