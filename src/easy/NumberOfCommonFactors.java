package easy;

/**
 * https://leetcode.cn/problems/number-of-common-factors/
 * 2427. 公因子的数目
 *
 * @author Lin
 * @date 2023/4/5
 */
public class NumberOfCommonFactors {
    public int commonFactors(int a, int b) {
        int res = 0;
        int rem = a % b;
        while(rem != 0){
            a = b;
            b = rem;
            rem = a % b;
        }
        for(int i = 1; i <= b; ++i){
            res += a % i == 0 && b % i == 0 ? 1 : 0;
        }
        return res;
    }
}
