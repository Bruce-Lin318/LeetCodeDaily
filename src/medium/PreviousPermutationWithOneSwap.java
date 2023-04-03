package medium;

/**
 * https://leetcode.cn/problems/previous-permutation-with-one-swap/
 * 1053. 交换一次的先前排列
 *
 * @author Lin
 * @date 2023/4/3
 */
public class PreviousPermutationWithOneSwap {
    public int[] prevPermOpt1(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                continue;
            }
            int index = i + 1;
            for (int j = i + 2; j < arr.length; j++) {
                if (arr[j] < arr[i] && arr[j] > arr[index]) {
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
            return arr;
        }
        return arr;
    }
}
