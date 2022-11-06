class Solution {
  
    /*
        Approach Brute
        1. create partition at goal string or string s
        2. check if the string is rotation of other at that partiton{
            how we'll check ? see is rotation function
            if yes
              return true
        }
        
        return false;
    */
    public boolean rotateString(String s, String goal) {
        
        if(s.length()!=goal.length())
            return false;
        
        if(s.length()==0)
            return true;
        
        for(int i=0;i<s.length();i++){
            
            if(isRotation(s,goal,i)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isRotation(String s,String goal,int partition){
        
        
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i)!=goal.charAt((i+partition)%goal.length())){
                return false;
            }
        }
        
        return true;
    }
}
