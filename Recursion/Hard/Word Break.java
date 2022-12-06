class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        return helper(s,wordDict,new HashMap<String,Boolean>());
    }
    
    private boolean helper(String s,List<String> wordDict,HashMap<String,Boolean> hm){
        
        if(s.length()==0)
            return true;
        
        if(hm.get(s)!=null)
            return hm.get(s);
        
        for(int i=0;i<wordDict.size();i++){
            
            boolean res = false;
            if(s.startsWith(wordDict.get(i))){
                
                int restOflength = wordDict.get(i).length();
                
                res = helper(s.substring(restOflength),wordDict,hm);
            }
            
            if(res){
                hm.put(s,true);
                return true;
            }
        }
        
        hm.put(s,false);
        return false;
    }
    

}
