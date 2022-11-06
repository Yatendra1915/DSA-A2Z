class Solution {
    public String reverseWords(String s) {
        
        /*
            Approach
            take low and high as two pointers
            1. til high is less than str len
                1. while low and high are at whitespace then skip i.e low++ high++
                2. while high < strLen and high hasn't hit white space do high ++;
                
                /trick
                then append substring from low to high after reversing to resultant string
                
            / trick
            2. reverse whole resultant string
        */
        StringBuilder sb = new StringBuilder();
        
        int low = 0;
        int high = 0;
        
        int n = s.length();
        
        while(high<n){
            
            while(high<n && s.charAt(low)==' ' && s.charAt(high)==' '){
                low++; high++;
            }
            
            while(high<n && s.charAt(high)!=' '){
                high++;
            }
                
            StringBuilder temp = new StringBuilder();
            temp.append(s.substring(low,high)+" ");
            temp.reverse();
            sb.append(temp);
            low = high;
            
        }
        
        sb.reverse();
        
        return sb.toString().trim();
    }
}
