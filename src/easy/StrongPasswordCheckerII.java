package easy;

/**
 * https://leetcode.cn/problems/strong-password-checker-ii/
 * 2299. 强密码检验器 II
 *
 * @author Lin
 * @date 2023/1/19
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class StrongPasswordCheckerII {
    public boolean strongPasswordCheckerII(String password) {
        char[] chars = password.toCharArray();
        if (chars.length < 8) {
            return false;
        }
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                ans |= 1;
            }
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                ans |= 1 << 1;
            }
            if (chars[i] >= '0' && chars[i] <= '9') {
                ans |= 1 << 2;
            }
            if (chars[i] == '!' || chars[i] == '@' || chars[i] == '#' || chars[i] == '$' || chars[i] == '%' || chars[i] == '^' || chars[i] == '&' || chars[i] == '*' || chars[i] == '(' || chars[i] == ')' || chars[i] == '-' || chars[i] == '+') {
                ans |= 1 << 3;
            }

            if (i > 0 && chars[i] == chars[i - 1]) {
                return false;
            }
        }
        return ans == ((1 << 4) - 1);
    }
}
