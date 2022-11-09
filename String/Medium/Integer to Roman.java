class Solution {
    
    class Pair{
        
        String ch;
        int val;
        Pair(String ch,int val){
            this.ch = ch;
            this.val = val;
        }
    }
    
    public String intToRoman(int num) {
        
        List<Pair> list = new ArrayList<>();
                    
        list.add(new Pair("I",1));
        list.add(new Pair("IV",4));
        list.add(new Pair("V",5));
        list.add(new Pair("IX",9));
        list.add(new Pair("X",10));
        list.add(new Pair("XL",40));
        list.add(new Pair("L",50));
        list.add(new Pair("XC",90));
        list.add(new Pair("C",100));
        list.add(new Pair("CD",400));
        list.add(new Pair("D",500));
        list.add(new Pair("CM",900));
        list.add(new Pair("M",1000));
        
        StringBuilder sb = new StringBuilder();
        
        for(int i= list.size()-1;i>=0;i--){
            
            int val = list.get(i).val;
            String ch = list.get(i).ch;
            
            if(num/val >0){
                
                int count = num/val;
                
                while(count-->0){
                    sb.append(ch);
                }
                
                num = num%val;
                
            }
            
        }
        
        return sb.toString();
    }
}
