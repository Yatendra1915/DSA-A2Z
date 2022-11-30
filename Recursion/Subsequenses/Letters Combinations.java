class Solution {
    
    HashMap<Character,String> hm;
    List<String> list;
    
    public List<String> letterCombinations(String digits) {
        
        hm = new HashMap<>();
        list = new ArrayList<>();
        
        if(digits.length()==0)
            return list;
        
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        
        helper(digits,0,"");
        
        return list;
    }
    
    private void helper(String digits,int idx,String temp){
        
        if(temp.length() == digits.length()){
            list.add(temp);
            return;
        }
        
        for(int i=idx;i<digits.length();i++){
            
            String s = hm.get(digits.charAt(i));
            
            for(int j=0;j<s.length();j++){
                
                helper(digits,i+1,temp+s.charAt(j));
                
            }
            
        }
    }
}
