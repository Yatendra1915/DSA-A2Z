import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(int val) {
      // write your code here
      data.add(val);
      
      int idx = data.size()-1;
      
      if(data.get(idx)<data.get((idx-1)/2))
        upheapify(idx);
    }

    public int remove() {
        
        int maxIdx = data.size()-1;
        
        int temp = data.get(0);
        data.set(0,data.get(maxIdx));
        data.set(maxIdx,temp);
        
        data.remove(maxIdx);
        downheapify(0);
        return temp;
    }

    public int peek() {
        
        return data.get(0);
      // write your code here
    }

    public int size() {
      // write your code here
      
      return data.size();
    }
    
    public void downheapify(int idx){
        
        int maxLen = data.size()-1;
        
        while(idx<maxLen){
            
            int minIdx = idx;
            
            if(data.get(2*idx+1)<data.get(idx)){
                minIdx = 2*idx+1;
            }
            
            if(data.get(2*idx+2)<data.get(idx)){
                minIdx = 2*idx+2;
            }
            
            int temp = data.get(minIdx);
            data.set(minIdx,data.get(idx));
            data.set(idx,temp);
            
            idx = minIdx;
        }
    }
    public void upheapify(int idx){
        
        
        while(idx>=0 && data.get(idx)<data.get((idx-1)/2)){
            
            int temp = data.get(idx);
            data.set(idx,data.get((idx-1)/2));
            data.set((idx-1)/2,temp);
            
            idx = (idx-1)/2;
        }
    }
  }
}
