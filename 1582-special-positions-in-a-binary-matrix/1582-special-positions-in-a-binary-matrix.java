class Solution {
    public int numSpecial(int[][] mat) {
        int r =mat.length;
        int c =mat[0].length;
    // Just i created arrays to store no.of 1's in both rows and columns 
        int[] rCount = new int[r];
        int[] cCount = new int[c];

    // My aim Count the 1s in every row and column

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j] == 1){
                    rCount[i]++;
                    cCount[j]++;
                }
            }
        }
        int specialPositCount =0;
    // now i want Count specialPositCount this => if mat[][]==1 && rCount==1 && cCount==1
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j] == 1 && rCount[i] == 1 && cCount[j] == 1){
                    specialPositCount++;
                } 
            }
        }
        return specialPositCount;
    }
}