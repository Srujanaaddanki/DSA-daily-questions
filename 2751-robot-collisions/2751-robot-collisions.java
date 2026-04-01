import java.util.*;

class Solution {
    // 1. Create a custom class to bundle all the robot data together
    class Robot {
        int index;
        int position;
        int health;
        char direction;

        Robot(int index, int position, int health, char direction) {
            this.index = index;
            this.position = position;
            this.health = health;
            this.direction = direction;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];

        // 2. Bundle the arrays into objects
        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(i, positions[i], healths[i], directions.charAt(i));
        }

        // 3. Sort the robots physically from left to right based on position
        Arrays.sort(robots, (a, b) -> Integer.compare(a.position, b.position));

        Stack<Robot> stack = new Stack<>();

        // 4. Simulate the collisions
        for (Robot current : robots) {
            if (current.direction == 'R') {
                // Moving right, just add to stack. It might hit something later.
                stack.push(current);
            } else {
                // Moving left! Time to fight any 'R' robots in our path.
                boolean survived = true;

                while (!stack.isEmpty() && stack.peek().direction == 'R') {
                    Robot top = stack.peek();

                    if (top.health < current.health) {
                        // Current robot wins, destroys top, loses 1 health. Keep fighting!
                        stack.pop();
                        current.health -= 1;
                    } else if (top.health > current.health) {
                        // Top robot wins, destroys current, loses 1 health. Fight is over.
                        top.health -= 1;
                        survived = false;
                        break;
                    } else {
                        // Tie! Both are destroyed. Fight is over.
                        stack.pop();
                        survived = false;
                        break;
                    }
                }

                // If the 'L' robot destroyed everything in its path, it survives!
                if (survived) {
                    stack.push(current);
                }
            }
        }

        // 5. Unpack the survivors and sort them back by their original index
        List<Robot> survivors = new ArrayList<>(stack);
        survivors.sort((a, b) -> Integer.compare(a.index, b.index));

        // 6. Extract just the health values for the final answer
        List<Integer> result = new ArrayList<>();
        for (Robot r : survivors) {
            result.add(r.health);
        }

        return result;
    }
}