class Solution {
    
    List<String> list;
    
    public List<String> generateParenthesis(int n) {
        
        list = new ArrayList<>();
        
        helper(n,0,0,"");
        
        return list;
    }
    
    public void helper(int n,int close,int open,String str){
        
        if(str.length()==2*n){
            list.add(str);
            return;
        }
        
        if(open<n){
            helper(n,close,open+1,str+"(");
        }
        
        if(open>close){
            
            helper(n,close+1,open,str+")");
            
        }
        
        return;
    }
}
