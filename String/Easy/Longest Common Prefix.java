class Solution {
  
    /*
        Approach => Horizontal Scanning
        
        take resultant variable str then
        start storing common prefix in str then find common in str and next string in array
        
        return str
    */
    public String longestCommonPrefix(String[] strs) {
        
        String str = strs[0];
        
        for(int i=1;i<strs.length;i++){
            
            str = findCommon(str,strs[i]);
            
        }
        
        return str;
    }
    
    public String findCommon(String s1,String s2){
        
        int idx = 0;

        while(idx<s1.length() && idx<s2.length()){
            
            if(s1.charAt(idx)!=s2.charAt(idx))
                break;
            
            idx++;
        }
        
        return s2.substring(0,idx);
    }
}
