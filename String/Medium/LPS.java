class Solution {
    
    int low=0;
    int high=0;
    int maxLen=0;
    public String longestPalindrome(String s) {
        
        for(int i=0;i<s.length();i++){
            
            checkPalindrome(i,i,s);
            checkPalindrome(i,i+1,s);
        }
        
        return s.substring(low,high+1);
    }
    
    public void checkPalindrome(int i,int j,String s){
        
        while(i>=0 &&j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
            
            if(maxLen<j-i-1){
                low = i+1;
                high=j-1;
                maxLen = j-i-1;
            }
            
        }
        
    }
}
