package hard;

/**
 * https://leetcode.cn/problems/online-majority-element-in-subarray/
 * 1157. 子数组中占绝大多数的元素
 *
 * @author Lin
 * @date 2023/4/16
 */
public class MajorityChecker {

    private int[] arr;

    public MajorityChecker(int[] arr) {
        this.arr = arr;
    }

    public int query(int left, int right, int threshold) {
        int[] map = new int[20_001];
        for (int i = left; i <= right; i++) {
            if (++map[arr[i]] >= threshold) {
                return arr[i];
            }
        }
        return -1;
    }
//    private HashMap<Integer, List<Integer>> map;
//
//    public MajorityChecker(int[] arr) {
//        map = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            if (!map.containsKey(arr[i])) {
//                map.put(arr[i], new ArrayList<>());
//            }
//            map.get(arr[i]).add(i);
//        }
//    }
//
//    public int query(int left, int right, int threshold) {
//        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
//            List<Integer> list = entry.getValue();
//            if (list.size() < threshold || list.get(0) > right || list.get(list.size() - 1) < left) {
//                continue;
//            }
//            int r = find(list, right, false);
//            int l = find(list, left, true);
//            if (r >= 0 && l < list.size() && r - l + 1 >= threshold) {
//                return entry.getKey();
//            }
//        }
//        return -1;
//    }
//
//    private int find(List<Integer> list, int target, boolean bigger) {
//        int left = 0;
//        int right  = list.size() - 1;
//        while (right >= left) {
//            int mid = (left + right) / 2;
//            Integer value = list.get(mid);
//            if (value == target) {
//                return mid;
//            } else if (value < target) {
//                left = mid + 1;
//            } else if (value > target) {
//                right = mid - 1;
//            }
//        }
//        return bigger ? left : right;
//    }
}
