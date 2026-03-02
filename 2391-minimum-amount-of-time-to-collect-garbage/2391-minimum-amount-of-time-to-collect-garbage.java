class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int p =0;
        int m =0;
        int g =0;
        int time = 0;
        for(int i=0;i<garbage.length;i++){
            for(int j=0;j<garbage[i].length();j++){
                if(garbage[i].charAt(j) == 'P') p=i;
                else if(garbage[i].charAt(j) == 'M') m=i;
                else if(garbage[i].charAt(j) == 'G') g=i;
                time++;
            }
        }
        for(int i=1;i<travel.length;i++){
            travel[i] += travel[i-1];
        }
        time += p == 0 ? 0 : travel[p-1];
        time += m == 0 ? 0 : travel[m-1];
        time += g == 0 ? 0 : travel[g-1];
        return time;
    }
}

// this is 100% the optimal solution!
// Time Complexity: $O(N)$
// Space Complexity: $O(1)$ (Constant Space)