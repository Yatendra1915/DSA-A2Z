class Solution {
  
    /*
        To find median of array we'll have to arrange the elements in sorted order
        then after that find the middle element that is divide the array in two 
        equal parts (excluding the middle element).
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        /*
            Let's assume that our nums1 array is samller than nums2 array then only this method will work
            if its not true then our below if block will get executed.
        */
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1);
        }
        
        // Please have a look at low and highs
        int low1 = 0;
        int high1=n1;
        
        /*
            Now our stratagy is to cut 1st array and 2nd array such that 
            count of elemnts left to cut1 and cut2 is equal to count of
            elements to right side of cut1 and cut2;
        */
        while(low1<=high1){
            
            // find mid of nums1
            int mid1 = (low1+high1)/2;
          
            /*
              then find mid2 such that count of elements at left side of mid1 and mid2 is equals to
              count of elements at right side of mid1 and mid2;
            */
            int mid2 = (n1+n2+1)/2 - mid1;
            
            // find minimum element at right side of cut1 and cut2 i.e at mid1 and mid2;
            int min1 = (mid1==n1)?Integer.MAX_VALUE:nums1[mid1];
            int min2 = (mid2==n2)?Integer.MAX_VALUE:nums2[mid2];
            
            // find maximum element at left side of cut1 and cut2 i.e at mid1-1 and mid2-1;
            int max1 = (mid1==0)?Integer.MIN_VALUE:nums1[mid1-1];
            int max2 = (mid2==0)?Integer.MIN_VALUE:nums2[mid2-1];
            
            // if this condition is fullfilled that means we found our mid;
            if(max1<=min2 && max2<=min1){
                
                if((n1+n2)%2==0){
                    return (double)(Math.min(min1,min2)+Math.max(max1,max2))/2;
                }
                else{
                    return (double)Math.max(max1,max2);
                }
            }
            
            else if(max2>min1){
                low1 = mid1+1;
            }
            else{
                high1 = mid1-1;
            }
            
        }
        
        return -1;
    }
}
