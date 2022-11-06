class Solution {
  
    /*
        
    */
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length()!=t.length())
            return false;
        
        HashMap<Character,Character> shm = new HashMap<>();
        HashMap<Character,Boolean> thm = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            
            if(!shm.containsKey(s.charAt(i))){
                
                if(thm.containsKey(t.charAt(i))){
                    
                    if(thm.get(t.charAt(i))==true){
                        return false;
                    }
                }
                
                shm.put(s.charAt(i),t.charAt(i));
                thm.put(t.charAt(i),true);
            }
            
            else if(shm.get(s.charAt(i))!=t.charAt(i)){
                return false;
            }
        }
        
        return true;
    }
}
