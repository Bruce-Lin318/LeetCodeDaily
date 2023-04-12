package medium;

import util.annotation.Main;

/**
 * https://leetcode.cn/problems/robot-bounded-in-circle/
 * 1041. 困于环中的机器人
 *
 * @author Lin
 * @date 2023/4/11
 */
public class RobotBoundedInCircle {

    @Main
    public boolean isRobotBounded(String instructions) {
        int[][] operations = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0;
        int y = 0;
        int direction = 0;
        char[] chars = instructions.toCharArray();
        for (char operation : chars) {
            if (operation == 'G') {
                x += operations[direction][0];
                y += operations[direction][1];
            } else if (operation == 'L') {
                direction = direction == 0 ? 3 : direction - 1;
            } else {
                direction = direction == 3 ? 0 : direction + 1;
            }
        }
        return direction != 0 || (x == 0 && y == 0);
    }

}
