class Solution {
    public int missingNumber(int[] nums) {
        int mn=0;
        int m=0;
        int n=nums.length;
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<n;i++){
            if(hs.contains(nums[i])){
                mn=nums[i];
            }
            hs.add(nums[i]);
        }
        for(int i=1;i<=n;i++){
            if(!hs.contains(i)){
                m=i;
                break;
            }
        }
        return m;
    }
}