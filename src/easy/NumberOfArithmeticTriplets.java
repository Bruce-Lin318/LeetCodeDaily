package easy;

import java.lang.reflect.Method;

/**
 * @author Lin
 * @date 2023/3/31
 */
public class NumberOfArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        // 0 1 3 2 1 3
        // 0 1 1 1 1 1
        int ans = 0;
        int length = nums.length;
        for (int i = 0, j = 1, k = 2; i < length - 2 && j < length - 1 && k < length; i++) {
            j = Math.max(j, i + 1);
            while (j < length - 1 && nums[j] - nums[i] < diff) {
                j++;
            }
            if (j >= length - 1 || nums[j] - nums[i] > diff) {
                continue;
            }
            k = Math.max(k, j + 1);
            while (k < length && nums[k] - nums[j] < diff) {
                k++;
            }
            if (k < length && nums[k] - nums[j] == diff) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfArithmeticTriplets n = new NumberOfArithmeticTriplets();
        System.out.println(n.arithmeticTriplets(new int[]{4, 5, 6, 7, 8, 9}, 2));
    }
}
