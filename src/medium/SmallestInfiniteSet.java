package medium;

import java.util.TreeSet;

/**
 * https://leetcode.cn/problems/smallest-number-in-infinite-set/?envType=daily-question&envId=2023-11-29
 * 2336. 无限集中的最小数字
 *
 * @author Lin
 * @date 2023/11/29
 */
public class SmallestInfiniteSet {


    int index;
    TreeSet<Integer> set;
    public SmallestInfiniteSet() {
        index = 1;
        set = new TreeSet<>();
    }

    public int popSmallest() {
        return set.isEmpty() ? index++ : set.pollFirst();
    }

    public void addBack(int num) {
        if (num < index) {
            set.add(num);
        }
    }
}
