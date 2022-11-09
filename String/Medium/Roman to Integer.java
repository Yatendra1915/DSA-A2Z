class Solution {
  
    /*
        Approach 
        1. store 1,5,10,50,100,500,1000 roman in hm
        2. Now if prev roman symbol is lesser then current then subtract Integer value corresponding to prev symbol
        3. if prev roman was greater than or equal to curr roman symbol then add Integer value corresponding to prev symbol
     
    */
    public int romanToInt(String s) {
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        
        if(s.length()==1){
            return hm.get(s.charAt(0));
        }
        char prev = s.charAt(0);
        int sum = 0;
        
        for(int i=1;i<s.length();i++){
            
            char curr = s.charAt(i);
            
            if(hm.get(curr)<=hm.get(prev)){
                sum+=hm.get(prev);
            }
            else if(hm.get(curr)>hm.get(prev)){
                sum-=hm.get(prev);
            }
            
            prev = curr;
        }
        
        
        sum+=hm.get(s.charAt(s.length()-1));
        
        return sum;
    }
}
