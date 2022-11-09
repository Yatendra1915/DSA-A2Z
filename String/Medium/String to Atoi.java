class Solution {
    public int myAtoi(String s) {
    
        s=s.trim();
        
        if(s==null || s.length()==0)
            return 0;

        int sign = 1; int start = 0; long res = 0;
        
        if(s.charAt(start)=='+'){
            sign = 1;
            start++;
        }
        else if(s.charAt(start)=='-'){
            sign = -1;
            start++;
        }
        
        for(int i=start;i<s.length();i++){
            
            if(!Character.isDigit(s.charAt(i))){
                
                return (int)res*sign;
            }
            
            res = res*10 + (s.charAt(i)-'0');
            
            if(sign == 1 && res>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            
            if(sign ==-1 && res*-1<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        
        return (int) res*sign;
        
        
    }
}
