package medium;

import util.annotation.Main;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/camelcase-matching/
 * 1023. 驼峰式匹配
 *
 * @author Lin
 * @date 2023/4/14
 */
public class CamelcaseMatching {
    @Main
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<Boolean>();
        char[] chars = pattern.toCharArray();
        for (int i = 0; i < queries.length; i++) {
            boolean flag = true;
            int p = 0;
            for (int j = 0; j < queries[i].length(); j++) {
                char c = queries[i].charAt(j);
                if (p < chars.length && chars[p] == c) {
                    p++;
                } else if (Character.isUpperCase(c)) {
                    flag = false;
                    break;
                }
            }
            if (p < chars.length) {
                flag = false;
            }
            res.add(flag);
        }
        return res;
    }
}
