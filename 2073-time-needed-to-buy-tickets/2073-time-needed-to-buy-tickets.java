class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int target_tickets = tickets[k];
        int total_seconds = 0;
        int n = tickets.length;
        for(int i=0;i<n;i++){
            if(i <= k){
                total_seconds += Math.min(tickets[i],target_tickets);
            }else{
                total_seconds += Math.min(tickets[i],target_tickets -1);
            }
        }
        return total_seconds; 
    }
}