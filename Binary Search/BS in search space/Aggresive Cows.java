import java.util.*;
class AggresiveCows {
  
    /*
        You are given an array consisting of position of diffrent cows
        Now we have to calculate the distance such that the minimum distance
        between two cows is maximum.
        
        Find minimum largest distance
    */
     public int findDist(int a[]){
        Arrays.sort(a);

        // highest distance can only be distance between the 1st cow to last cow
        int low = 1, high = a[n - 1] - a[0];

        while (low <= high) {
            int mid = (low + high) >> 1;
            
            /* if it is possible to arrange all the cows with this mid(distance) then 
                we'll target for more larger distance.
            */
            if (isPossible(a, n, cows, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
       return low;
    }
  
    private boolean isPossible(int a[], int n, int cows, int minDist) {
        int cntCows = 1;
        int lastPlacedCow = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] - lastPlacedCow >= minDist) {
                cntCows++;
                lastPlacedCow = a[i];
            }
        }
        if (cntCows >= cows) return true;
        return false;
    }
  
}
