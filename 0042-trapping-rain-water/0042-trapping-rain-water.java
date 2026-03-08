class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lMax = height[0] , rMax = height[n-1];
        int i =1, j = n-2;
        int totalWater = 0;
        while(i <= j){
            if(lMax < rMax){
                if(lMax > height[i]){
                    totalWater += (lMax - height[i]);
                }else{
                    lMax = height[i];
                }
                i += 1;
            }else{
                if(rMax > height[j]){
                    totalWater += (rMax - height[j]);
                }else{
                    rMax = height[j];
                }
                j -= 1;
            }
        }
        return totalWater;
    }
}