class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}













// class Solution {
//     public void moveZeroes(int[] nums) {
//         if(nums.length <=1) return;
//         int nz=0, z =0;
//         int temp;
//         for(int i=0;i<nums.length;i++){
//             if(nums[nz] !=0){
//                 temp = nums[nz];
//                 nums[nz] = nums[z];
//                 nums[z] = temp;
//                 nz++;
//                 z++;
//             }else{
//                 nz++;
//             }
//         }
        
//     }
// }