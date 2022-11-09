import java.util.*;

public class Main {
  
  /*
      APPROACH if k==1
        simple relase and acquire approach with one hm.
        
      APPROACH if k>2
      1. create 2 hm for holding k and k-1 unique characters
      2. add characters to 1st hm untill it's size beecome k
      3. add characters to 2nd hm untill it's size becomes k-1
      4. now comes release part
          a. if 1st hm size == k and 2nd hm size ==k-1 then add (end index of k unique char string) - (end idx if k-1 unique characters string) in resultant
          b. release from front of both strings simultaneously i.e remove from both hm
          c. keep repeating a and b step untill release idx become equal to end index of k-1 string or 1sthm size < k or 2nd hmsize < k-1
          
  */

  public static int solution(String str, int k) {
    
    
    if(k==1){
        return solutionk1(str);
    }
    HashMap<Character,Integer> hmk = new HashMap<>();
    HashMap<Character,Integer> hm  = new HashMap<>();
    
    int ik=-1;
    int i = -1;
    
    int j=-1;
    
    int ans=0;
    while(true){
        
        boolean acquirek=false;
        boolean acquire=false;
        boolean release=false;
        //acquire k unique characters
        while(ik<str.length()-1){
            
            acquirek=true;
            ik++;
            
            char ch = str.charAt(ik);
            
            hmk.put(ch,hmk.getOrDefault(ch,0)+1);
            
            if(hmk.size()>k){
                hmk.remove(ch);
                ik--;
                break;
            }
            
        }
        
        //acquire k-1 unique characters
        while(i<ik){
            
            acquire=true;
            i++;
            
            char ch = str.charAt(i);
            
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            
            if(hm.size()>k-1){
                hm.remove(ch);
                i--;
                break;
            }
            
        }
        
        //release from both k-1 and k at the same time
        
        while(j<i){
            
            release=true;
            if(hmk.size()==k && hm.size()==k-1){
                ans+=ik-i;
            }
            j++;
            
            char ch = str.charAt(j);
            
            removeFromHm(hmk,ch);
            removeFromHm(hm,ch);
            
            if(hmk.size()<k || hm.size()<k-1)
                break;
            
        }
        
        if(acquire==false && acquirek==false && release==false)
            break;
        
    }

    return ans;
  }
  
  public static void removeFromHm(HashMap<Character,Integer> hm,char ch){
      
      hm.put(ch,hm.get(ch)-1);
      
      if(hm.get(ch)==0)
        hm.remove(ch);
  }
  
  
	public static int solutionk1(String str){
        
        int i=-1;
        int j=-1;
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        int ans=0;
        
        while(true){
            
            boolean f1=false;
            boolean f2=false;
            while(i<str.length()-1){
                f1=true;
                i++;
                
                char ch = str.charAt(i);
                
                hm.put(ch,hm.getOrDefault(ch,0)+1);
                
                if(hm.size()==2){
                    hm.remove(ch);
                    i--;
                    break;
                }
            }
            
            while(j<i){
                f2=true;
                if(hm.size()==1){
                    ans+=i-j;
                }
                
                j++;
                
                char ch = str.charAt(j);
                
                removeFromHm(hm,ch);
                
                if(hm.size()==0){
                    break;
                }
            }
            
            if(f1==false && f2==false)
                break;
        }
        
        return ans;
    }


}
