class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] mArr = new int[m + n];

        int i = 0, j = 0, k = 0;

        // Two-pointer merge
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                mArr[k++] = nums1[i++];
            } else {
                mArr[k++] = nums2[j++];
            }
        }

        // Copy remaining elements
        while (i < m) mArr[k++] = nums1[i++];
        while (j < n) mArr[k++] = nums2[j++];

        int totalLen = m + n;

        // Odd length -> Single middle element
        if (totalLen % 2 != 0) {
            return (double) mArr[totalLen / 2];
        } 
        // Even length -> Average of two middle elements
        else {
            int mid1 = mArr[(totalLen / 2) - 1];
            int mid2 = mArr[totalLen / 2];
            return (mid1 + mid2) / 2.0; // 2.0 forces double division!
        }
    }
}

//  or

// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int n1 = nums1.length;
//         int n2 = nums2.length;
//         int n = n1 + n2;
//         int[] newArr = new int[n];

//         int i = 0, j = 0, k = 0;

//         while (i < n1 && j < n2) {
//             if (nums1[i] < nums2[j]) {
//                 newArr[k++] = nums1[i++];
//             } else {
//                 newArr[k++] = nums2[j++];
//             }
//         }

//         while (i < n1) {
//             newArr[k++] = nums1[i++];
//         }

//         while (j < n2) {
//             newArr[k++] = nums2[j++];
//         }

//         if (n % 2 == 0) {
//             return ((double) newArr[n / 2 - 1] + (double) newArr[n / 2]) / 2;
//         } else {
//             return (double) newArr[n / 2];
//         }
//     }
// }