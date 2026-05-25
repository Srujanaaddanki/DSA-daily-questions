class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int pt1 = 0;
        int pt2 = 0;
        int unPlaced = 0;

        while(pt1 < fruits.length){
            pt2 = 0;

            while(pt2 < baskets.length){
                if(fruits[pt1] <= baskets[pt2]){
                    baskets[pt2] = -1;
                    break;
                }
                pt2++;
            }

            if(pt2 == baskets.length) {
                unPlaced++;
            }

            pt1++;
        }

        return unPlaced;
    }
}