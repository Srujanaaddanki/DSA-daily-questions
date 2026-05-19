class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0; // Pointer for nums1
        int j = 0; // Pointer for nums2
        
        // Loop runs until one of the pointers hits the end of its array
        while (i < nums1.length && j < nums2.length) {
            
            // Because the arrays are sorted, the first match we hit is the smallest!
            if (nums1[i] == nums2[j]) {
                return nums1[i]; 
            } 
            // If nums1's value is smaller, advance it to find a larger number
            else if (nums1[i] < nums2[j]) {
                i++;
            } 
            // If nums2's value is smaller, advance it
            else {
                j++;
            }
        }
        
        // If we break out of the loop, no common elements exist
        return -1;
    }
}