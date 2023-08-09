// TIME COMPLEXITY =  LOG(MIN(A, B))
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // assign values to both the arrays for easily identifying which is the smaller one
        int A = nums1.length;
        int B = nums2.length;
       // because we have to run binary search on only one of the array
        // we will make sure than it is done on the smaller array 
        if(A > B){
            // swap arrays
            return findMedianSortedArrays(nums2, nums1);
        }

        // to store the value to merged array
        int total = A + B; // A+B
        // to differentiate left and right side of merged array
        int half = (total + 1) / 2;
 

        // start Binary search on the smaller array 
        // which is A herre
        int left = 0;
        int right = A;
        var result = 0.0;

        while(left <= right){ // because we are guranteed there is a median so we will simply return it after finding it
            int mid = left + (right - left) / 2; // use to left left partition reffered to A
            int j = half - mid; // refered to B we are doing -2 because of indices

            // get the values to check if we find the median or not
            // the value go out of bounce we will asign them some default value too
            // i.e infinity so that we will be able to continue our comoparison of median

            // get the four points around possible median
                        // here if mid is in bounce that assign it to the value otherwise put negative infinity
            int Aleft = (mid > 0) ? nums1[mid - 1] : Integer.MIN_VALUE;
                        // if the above is oout oof bouce then we would need all the element in left partition so put positive infinity
            int Aright = (mid < A) ? nums1[mid] : Integer.MAX_VALUE;
            int Bleft = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int Bright = (j < B) ? nums2[j] : Integer.MAX_VALUE;

            // Four variables (Aleft, Aright, Bleft, and Bright) are used to store values that help identify the elements around the possible median. The ternary expressions handle cases where mid or j might be out of bounds by using extreme values (Integer.MIN_VALUE and Integer.MAX_VALUE).



            // now we simple have to get 
            
            // check the correct partiton
            if(Aleft <= Bright && Bleft <= Aright){
               
                if(total % 2 == 0){
                // if even array
                result = (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                } else{                 // if odd array
                    result = Math.max(Aleft, Bleft); // actual one number of merged array in middle
                }
                break;
            } else if(Aleft >= Bright){// in case we don't fine the median'
            // we got to know that values of A if bigger than B
            // so we will reduce the values of A
            right = mid - 1;
            // If the Aleft values are greater than the Bright values, the partition needs to be adjusted to the left side, so the right boundary is updated.
            } else {
                //Otherwise, if Aleft is smaller than Bright, the partition needs to be adjusted to the right side, so the left boundary is updated.
                left = mid + 1;
            }
        }
        return result;
    }
}
