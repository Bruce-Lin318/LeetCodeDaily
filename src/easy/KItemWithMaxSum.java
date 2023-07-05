package easy;

/**
 * https://leetcode.cn/problems/k-items-with-the-maximum-sum/
 * 2600. K 件物品的最大和
 *
 * @author Lin
 * @date 2023/7/5
 */
public class KItemWithMaxSum {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        return k > numOnes + numZeros ? numOnes - (k - numOnes - numZeros) : Math.min(numOnes, k);
    }

}
