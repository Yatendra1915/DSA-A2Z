class Solution {
    public int numberOfSubarrays(int[] A, int k) {
        return atMost(A, k) - atMost(A, k - 1);
    }
    
    public int atMost(int[] A, int k) {
        int res = 0;
        int release = 0;
        int n = A.length;
        
        for (int acquire = 0; acquire < n; acquire++) {
            k-= A[acquire] % 2;
            while (k < 0){
                k += A[release++] % 2;
            }
            res += acquire -release  + 1;
        }
        return res;
    }
}
