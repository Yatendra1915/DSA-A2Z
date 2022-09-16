class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        
        int n = nums.length;
        
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        
        int count1 = 0;
        int count2 = 0;
        
        for(int i=0;i<n;i++){
            
            if(num1==nums[i]){
                count1++;
            }
            else if(num2==nums[i]){
                count2++;
            }
            else if(count1==0){
                num1=nums[i];
                count1++;
            }
            else if(count2==0){
                num2=nums[i];
                count2++;
            }
            else{
                count1--;
                count2--;
            } 
            
        }
        
        count1=0;
        count2=0;
        
        for(int i:nums){
            
            if(i==num1)
                count1++;
            else if(i==num2){
                count2++;
            }
        }
        
        if(count1>n/3) list.add(num1);
        if(count2>n/3) list.add(num2);
        
        return list;
    }
    
    
}
