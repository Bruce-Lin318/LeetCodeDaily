package easy;

/**
 * https://leetcode.cn/problems/check-if-number-has-equal-digit-count-and-digit-value/comments/
 * 2283. 判断一个数的数字计数是否等于数位的值
 *
 * @author Lin
 * @date 2023/1/11
 */
public class CheckIfNumberHasEqualDigitCountAndDigitValue {
    public boolean digitCount(String num) {
        char[] chars = num.toCharArray();
        int[] nums = new int[10];
        for (int i = 0; i < chars.length; i++) {
            nums[chars[i] - '0']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if(nums[i] != chars[i] - '0') {
                return false;
            }
        }
        return true;
    }
}
