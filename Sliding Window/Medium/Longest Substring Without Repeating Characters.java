class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int ans = 0;

        HashMap<Character,Integer> hm = new HashMap<>();

        int i=-1;
        int j=-1;

        int n = s.length();
        int maxLen = 0;
        
        while(true){


            boolean acquire = false;
            boolean release = false;

            while(i<n-1){
                i++;
                acquire = true;
                char ch = s.charAt(i);

                if(hm.containsKey(ch)){
                    hm.put(ch,2);
                    break;
                }
                
                maxLen = Math.max(maxLen,i-j);
                hm.put(ch,1);
                
            }

            while(j<i){
                j++;
                release = true;
                char ch = s.charAt(j);

                if(hm.get(ch)==2){
                    hm.put(ch,1);
                    break;
                }
                else{
                    maxLen = Math.max(maxLen,j-i+1);
                    hm.remove(ch);
                }

            }

            if(!acquire && !release)
                break;

        }

        return maxLen;
    }
}
