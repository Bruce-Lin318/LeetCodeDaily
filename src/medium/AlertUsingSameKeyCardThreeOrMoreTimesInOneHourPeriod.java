package medium;

import java.util.*;

/**
 * https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
 * 1604. 警告一小时内使用相同员工卡大于等于三次的人
 *
 * @author Lin
 * @date 2023/2/7
 */
public class AlertUsingSameKeyCardThreeOrMoreTimesInOneHourPeriod {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<String> names = new LinkedList<>();
        for (int i = 0; i < keyName.length; i++) {
            map.putIfAbsent(keyName[i], new ArrayList<>());
            map.get(keyName[i]).add(parse(keyTime[i]));
        }
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> times = entry.getValue();
            Collections.sort(times);
            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 2) <= 60) {
                    names.add(entry.getKey());
                    break;
                }
            }
        }
        Collections.sort(names);
        return names;
    }

    private int parse(String time) {
        String[] split = time.split(":");
        return Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
    }
}
