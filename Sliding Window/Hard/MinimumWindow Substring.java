class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> tmap = new HashMap<>();

        int minLen = s.length();

        for(char ch:t.toCharArray()){
            tmap.put(ch,tmap.getOrDefault(ch,0)+1);
        }

        int i=-1;
        int j=-1;
        int n=s.length();

        String result = "";
        int counter = 0;
        
        while(true){

            boolean acquire = false;
            boolean release = false;

            while(i<n-1 && counter<t.length()){
                i++;
                acquire = true;
                char ch = s.charAt(i);

                smap.put(ch,smap.getOrDefault(ch,0)+1);

                if(smap.getOrDefault(ch,0)<=tmap.getOrDefault(ch,0)){
                    counter++;
                }

            }

            while(j<i && counter==t.length()){
                release = true;

                String temp = s.substring(j+1,i+1);

                if(result.length()==0 || temp.length()<result.length()){
                    result = temp;
                }

                j++;
                char ch = s.charAt(j);

                smap.put(ch,smap.get(ch)-1);

                if(smap.get(ch)==0){
                    smap.remove(ch);
                }
                if(smap.getOrDefault(ch,0)<tmap.getOrDefault(ch,0)){
                    counter--;
                }

            }

            if(!release && !acquire)
                break;
        }

        return result;
    }
}
