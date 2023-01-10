package hard;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/cracking-the-safe/
 * 753. 破解保险箱
 * 思路：构造n-1位的节点，计算欧拉回路，贪心，每次走最大的边
 *
 * @author Lin
 * @date 2023/1/10
 */
public class CrackingTheSafe {
    public String crackSafe(int n, int k) {
        int nodeNum = (int) Math.pow(k, n - 1);
        int[] edge = new int[nodeNum];
        Arrays.fill(edge, k - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append(0);
        }
        int index = 0;
        while (edge[index] >= 0) {
            sb.append(edge[index]);
            index = (index * k + edge[index]--) % nodeNum;
        }
        return sb.toString();
    }
}
