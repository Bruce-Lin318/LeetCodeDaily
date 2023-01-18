package hard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * https://leetcode.cn/problems/finding-mk-average/
 * 1825. 求出 MK 平均值
 *
 * @author Lin
 * @date 2023/1/18
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class FindingMKAverage {
    class MKAverage {
        private TreeMap<Integer, Integer> min;
        private TreeMap<Integer, Integer> max;
        private TreeMap<Integer, Integer> med;
        private Queue<Integer> queue;
        private int minSize, medSize;
        private int count;
        private int limit;
        private int medSum;

        public MKAverage(int m, int k) {
            min = new TreeMap<>();
            max = new TreeMap<>();
            med = new TreeMap<>();
            queue = new LinkedList<>();
            minSize = 0;
            medSize = 0;
            count = m;
            limit = k;
            medSum = 0;
        }

        public void addElement(int num) {
            if (queue.size() == count) {
                remove(queue.poll());
            }
            add(min, num);
            minSize++;
            if (minSize > limit) {
                int last = popLast(min);
                add(med, last);
                minSize--;
                medSize++;
                medSum += last;
            }
            if (medSize > count - limit * 2) {
                int last = popLast(med);
                add(max, last);
                medSize--;
                medSum -= last;
            }
            queue.offer(num);
        }

        public int calculateMKAverage() {
            return queue.size() < count ? -1 : medSum / medSize;
        }

        private void remove(int discard) {
            if (discard >= max.firstKey()) {
                pop(max, discard);
            } else if (discard >= med.firstKey()) {
                pop(med, discard);
                medSum -= discard;
                int first = popFirst(max);
                add(med, first);
                medSum += first;
            } else {
                pop(min, discard);
                int medFirst = popFirst(med);
                medSum -= medFirst;
                add(min, medFirst);

                int maxFirst = popFirst(max);
                medSum += maxFirst;
                add(med, maxFirst);
            }
        }

        private void pop(TreeMap<Integer, Integer> map, int key) {
            map.put(key, map.get(key) - 1);
            if (map.get(key) == 0) {
                map.remove(key);
            }
        }

        private int popFirst(TreeMap<Integer, Integer> map) {
            int res = map.firstKey();
            pop(map, res);
            return res;
        }

        private int popLast(TreeMap<Integer, Integer> map) {
            int res = map.lastKey();
            pop(map, res);
            return res;
        }

        private void add(TreeMap<Integer, Integer> map, int key) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
    }
}
