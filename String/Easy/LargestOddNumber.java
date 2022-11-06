class Solution {
    public String largestOddNumber(String num) {
        
        int n = num.length();
        
        /*
            start from last if odd number is encountred return substring from 0 to curr index
        */
        for(int i=n-1;i>=0;i--){
            
            if(num.charAt(i)%2==1){
                return num.substring(0,i+1);
            }
        }
        
        // else return empty string
        return "";
    }
}
