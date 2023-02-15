package hard;

/**
 * https://leetcode.cn/problems/check-if-it-is-a-good-array/
 * 1250. 检查「好数组」
 *
 * @author Lin
 * @date 2023/2/15
 */
public class CheckIfItIsGoodArray {
    public boolean isGoodArray(int[] nums) {
        int res = nums[0];
        int index = 1;
        while (res != 1 && index < nums.length) {
            res = gcd(res, nums[index++]);
        }
        return res == 1;
    }

    private int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}
