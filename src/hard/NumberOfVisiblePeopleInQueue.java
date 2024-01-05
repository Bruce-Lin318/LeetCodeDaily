package hard;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/number-of-visible-people-in-a-queue
 * 1944. 队列中可以看到的人数
 *
 * @author Lin
 * @date 2024/1/5
 */
public class NumberOfVisiblePeopleInQueue {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[heights.length];

        for (int i = heights.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                res[i]++;
            }

            if (!stack.isEmpty()) {
                res[i]++;
            }
            stack.push(heights[i]);
        }
        return res;
    }

    public int[] canSeePersonsCount2(int[] heights) {
        int[] res = new int[heights.length];
        int[] stack = new int[heights.length];
        int cur = -1;

        for (int i = heights.length - 1; i >= 0; i--) {

            while (cur != -1 && stack[cur] < heights[i]) {
                cur--;
                res[i]++;
            }

            if (cur != -1) {
                res[i]++;
            }
            stack[++cur] = heights[i];
        }
        return res;
    }
}
