class Pair{

    ListNode curr;
    int listidx;
    int data;

    Pair(ListNode curr,int listidx,int data){
        this.curr=curr;
        this.listidx=listidx;
        this.data=data;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){

            public int compare(Pair p1,Pair p2){
                return p1.data-p2.data;
            }
        });


        for(int i=0;i<lists.length;i++){

            if(lists[i]!=null)
              
                // insert (currnode,listindex,value)
                pq.add(new Pair(lists[i],0,lists[i].val));
        }

        ListNode res = new ListNode(-1);
        ListNode dummy = res;

        while(pq.size()>0){

            Pair temp = pq.poll();

            dummy.next = new ListNode(temp.data);
            dummy=dummy.next;

            temp.curr=temp.curr.next;

            if(temp.curr!=null){
                temp.data=temp.curr.val;
                pq.add(temp);
            }

        }

        return res.next;
    }
}
