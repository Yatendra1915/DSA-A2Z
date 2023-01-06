class Solution {
    public int trap(int[] height) {
        
        int n = height.length;

        int[] ls = new int[n];
        int[] rs = new int[n];

        int res = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            res=Math.max(res,height[i]);
            ls[i]=res;
        }

        res = Integer.MIN_VALUE;

        for(int i=n-1;i>=0;i--){
            res = Math.max(res,height[i]);
            rs[i]=res;
        }

        int ans = 0;

        for(int i=0;i<n;i++){
            ans+=Math.min(rs[i],ls[i])-height[i];
        }

        return ans;
    }
}
