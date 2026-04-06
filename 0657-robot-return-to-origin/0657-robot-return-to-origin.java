class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        
        // Loop through every single move in the string
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            
            // Update coordinates based on the direction
            if (move == 'U') {
                y++;
            } else if (move == 'D') {
                y--;
            } else if (move == 'R') {
                x++;
            } else if (move == 'L') {
                x--;
            }
        }
        
        // The robot only returned to the origin if BOTH x and y are 0
        return x == 0 && y == 0;
    }
}