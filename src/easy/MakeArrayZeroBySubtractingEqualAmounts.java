package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts/
 * 2357. 使数组中所有元素都等于零
 *
 * @author Lin
 * @date 2023/2/24
 */
public class MakeArrayZeroBySubtractingEqualAmounts {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        set.remove(0);
        return set.size();
    }
}
