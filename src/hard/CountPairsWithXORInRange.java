package hard;

/**
 * https://leetcode.cn/problems/count-pairs-with-xor-in-a-range/
 * 1803. 统计异或值在范围内的数对有多少
 *
 * @author Lin
 * @date 2023/1/5
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class CountPairsWithXORInRange {
    private Trie root;
    private int limit = 14;

    public int countPairs(int[] nums, int low, int high) {
        return f(nums, high) - f(nums, low - 1);
    }

    private int f(int[] nums, int target) {
        root = new Trie();
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i - 1]);
            res += compute(nums[i], target);
        }
        return res;
    }

    private int compute(int num, int target) {
        Trie cur = root;
        int sum = 0;
        for (int i = limit; i >= 0; i--) {
            int r = (num >> i) & 1;
            if (((target >> i) & 1) == 0) {
                if (cur.children[r] == null) {
                    return sum;
                }
                cur = cur.children[r];
            } else {
                if (cur.children[r] != null) {
                    sum += cur.children[r].sum;
                }
                if (cur.children[r ^ 1] == null) {
                    return sum;
                }
                cur = cur.children[r ^ 1];
            }
        }
        sum += cur.sum;
        return sum;
    }

    private void add(int num) {
        Trie cur = root;
        cur.sum++;
        for (int i = limit; i >= 0; i--) {
            int r = (num >> i) & 1;
            if (cur.children[r] == null) {
                cur.children[r] = new Trie();
            }
            cur = cur.children[r];
            cur.sum++;
        }
    }

    private class Trie {
        Trie[] children = new Trie[2];
        int sum = 0;
    }
}
