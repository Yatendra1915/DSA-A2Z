class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        k=n-k;
        int minSum =Integer.MAX_VALUE;
        int tempSum = 0;
        
        int acquire = 0;
        int release = 0;

        while(acquire<k){
            tempSum+=cardPoints[acquire++];
        }

        minSum=Math.min(minSum,tempSum);

        while(acquire<n){

            tempSum = tempSum+cardPoints[acquire++]-cardPoints[release++];
            minSum = Math.min(minSum,tempSum);
        }

        int totalSum = 0;

        for(int i:cardPoints){
            totalSum+=i;
        }

        return totalSum-minSum;
    }
}
