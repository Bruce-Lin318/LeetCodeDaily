package medium;

/**
 * https://leetcode.cn/problems/bianry-number-to-string-lcci/
 * 面试题 05.02. 二进制数转字符串
 *
 * @author Lin
 * @date 2023/3/2
 */
public class BinaryNumberToStringLCCI {
    public String printBin(double num) {
        StringBuilder builder = new StringBuilder(32);
        builder.append("0.");
        double tmp = 0.5;
        for (int i = 0; i < 30 && num != 0; ++i) {
            if (num >= tmp) {
                num -= tmp;
                builder.append(1);
            } else {
                builder.append(0);
            }
            tmp /= 2;
        }
        return num == 0 ? builder.toString() : "ERROR";
    }
}
