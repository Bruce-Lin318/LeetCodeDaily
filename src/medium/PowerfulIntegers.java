package medium;

import java.util.*;

/**
 * https://leetcode.cn/problems/powerful-integers/
 * 970. 强整数
 *
 * @author Lin
 * @date 2023/5/2
 */
public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; j + i <= bound; j *= y) {
                set.add(i + j);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(set);
    }
}
