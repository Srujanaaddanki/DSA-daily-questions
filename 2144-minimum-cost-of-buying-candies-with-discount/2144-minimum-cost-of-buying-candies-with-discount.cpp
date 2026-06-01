class Solution {
public:
    int minimumCost(vector<int>& cost) {
        int n = cost.size();
        sort(cost.begin(), cost.end());
        int sum = 0, k = 0;
        for (int i = n - 1; i >= 0; i--) {
            k++;
            if (k % 3 == 0) {
                continue;

            } else {
                sum += cost[i];
            }
        }
        return sum;
    }
};