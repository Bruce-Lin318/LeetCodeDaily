package hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/count-subtrees-with-max-distance-between-cities/
 * 1617. 统计子树中城市之间最大距离
 *
 * @author Lin
 * @date 2023/3/12
 */
public class CountSubtreesWithMaxDistanceBetweenCities {
    private List<Integer>[] adj;
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            adj[x].add(y);
            adj[y].add(x);
        }

        int[] ans = new int[n - 1];
        for (int i = 1; i < (1 << n); i++) {
            // 所有可能的子树种类有1 << n种，1代表包含该节点，0代表不包含，1 << n囊括
            int x = 32 - Integer.numberOfLeadingZeros(i) - 1;
            int mask = i;
            int y = -1;
            Queue<Integer> queue = new ArrayDeque<Integer>();
            queue.offer(x);
            mask ^= (1 << x);
            while (!queue.isEmpty()) {
                y = queue.poll();
                for (int vertex : adj[y]) {
                    if ((mask & (1 << vertex)) != 0) {
                        // 能到达即消除
                        mask ^= (1 << vertex);
                        queue.offer(vertex);
                    }
                }
            }
            // 判断是否联通
            if (mask == 0) {
                int diameter = dfs(-1, y, i);
                if (diameter > 0) {
                    ans[diameter - 1]++;
                }
            }
        }
        return ans;
    }

    public int dfs(int parent, int root, int mask) {
        int depth = 0;
        for (int next : adj[root]) {
            if (next != parent && (mask & (1 << next)) != 0) {
                depth = Math.max(depth, 1 + dfs(root, next, mask));
            }
        }
        return depth;
    }
}
