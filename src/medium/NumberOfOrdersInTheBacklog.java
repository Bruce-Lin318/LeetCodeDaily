package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/number-of-orders-in-the-backlog/
 * 1801. 积压订单中的订单总数
 *
 * @author Lin
 * @date 2023/1/2
 */
public class NumberOfOrdersInTheBacklog {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> sells = new PriorityQueue<>(Comparator.comparingInt(order -> order[0]));
        PriorityQueue<int[]> buy = new PriorityQueue<>((order1, order2) -> order2[0] - order1[0]);
        for (int[] order : orders) {
            if (order[2] == 0) {
                process(order[0], order[1], sells, buy, true);
            } else {
                process(order[0], order[1], buy, sells, false);
            }
        }
        long ans = 0L;
        while (!sells.isEmpty()) {
            ans += sells.poll()[1];
        }
        while (!buy.isEmpty()) {
            ans += buy.poll()[1];
        }
        return (int) (ans % (Math.pow(10, 9) + 7));
    }

    private void process(int price, int count, PriorityQueue<int[]> pending, PriorityQueue<int[]> backlog, boolean bigger) {
        if (pending.isEmpty() || (bigger ? pending.peek()[0] > price : pending.peek()[0] < price)) {
            backlog.add(new int[]{price, count});
            return;
        }
        int[] peek = pending.peek();
        if (peek[1] > count) {
            peek[1] -= count;
        } else if (peek[1] < count) {
            pending.poll();
            process(price, count - peek[1], pending, backlog, bigger);
        } else {
            pending.poll();
        }
    }
}

