package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/circular-permutation-in-binary-representation/
 * 1238. 循环码排列
 *
 * @author Lin
 * @date 2023/2/23
 */
public class CircularPermutationInBinaryRepresentation {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < (1 << n); i++) {
            ans.add((i >> 1) ^ i ^ start);
        }
        return ans;

    }
}
