package easy;

/**
 * https://leetcode.cn/problems/sort-the-people/
 * 2418. 按身高排序
 *
 * @author Lin
 * @date 2023/4/25
 */
public class SortThePeople {
    public String[] sortPeople(String[] names, int[] heights) {
        process(0, heights.length - 1, heights, names);
        return names;
    }

    private void process(int l, int r, int[] heights, String[] names) {
        if (l >= r) {
            return;
        }
        int right = r;
        int cur = l;
        while (cur < right) {
            if (heights[cur] < heights[cur + 1]) {
                swap(cur, ++cur, names, heights);
            } else {
                swap(cur + 1, right--, names, heights);
            }
        }
        process(l, cur - 1, heights, names);
        process(cur + 1, r, heights, names);
    }

    private void swap(int a, int b, String[] names, int[] heights) {
        int temp = heights[a];
        heights[a] = heights[b];
        heights[b] = temp;

        String name = names[a];
        names[a] = names[b];
        names[b] = name;
    }
}
