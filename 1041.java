/**
 * id: 1041 robot bounded in circle
 * tags: math
 * date: 2021-04-22
 */
class Solution {
    public boolean isRobotBounded(String instructions) {
        int [][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;
        int x = 0, y = 0;
        for(int i=0; i<instructions.length(); i++) {
            if(instructions.charAt(i) == 'G') {
                x += moves[dir][0];
                y += moves[dir][1];
            } else if(instructions.charAt(i) == 'L') {
                dir = (dir + 3) % 4;
            } else {
                dir = (dir + 1) % 4;
            }
        }
        if(dir == 0 && (x != 0 || y != 0)) {
            return false;
        } else {
            return true;
        }
    }
}