package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string/
 * 1807. 替换字符串中的括号内容
 *
 * @author Lin
 * @date 2023/1/12
 */
public class EvaluateTheBracketPairsOfString {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            char a = s.charAt(index);
            if (a == '(') {
                StringBuilder replaced = new StringBuilder();
                index++;
                while (Character.isLowerCase(s.charAt(index))) {
                    replaced.append(s.charAt(index++));
                }
                sb.append(map.getOrDefault(replaced.toString(), "?"));
            } else {
                sb.append(a);
            }
            index++;
        }
        return sb.toString();
    }
}
