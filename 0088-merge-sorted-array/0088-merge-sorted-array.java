class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;         // Pointer for nums1 valid elements
        int p2 = n - 1;         // Pointer for nums2 elements
        int p = m + n - 1;      // Pointer for placing elements at the back of nums1

        // Compare elements from the back and place the larger one at index 'p'
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // If there are still elements left in nums2, copy them over.
        // (Note: If elements are left in nums1, they are already in their correct places!)
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}