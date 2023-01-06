package easy;

/**
 * https://leetcode.cn/problems/count-integers-with-even-digit-sum/
 * 2180. 统计各位数字之和为偶数的整数个数
 *
 * @author Lin
 * @date 2023/1/6
 */
public class CountIntegersWithEvenDigitSum {
    public int countEven(int num) {
        int res = 0;
        for (int i = 0; i < num; i++) {
            int sum = 0;
            int cur = i;
            while (cur != 0) {
                sum += cur % 10;
                cur = cur / 10;
            }
            res += sum & 1 ^ 1;
        }
        return res;
    }
}
