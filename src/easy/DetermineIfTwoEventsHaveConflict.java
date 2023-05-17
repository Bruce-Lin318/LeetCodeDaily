package easy;

/**
 * https://leetcode.cn/problems/determine-if-two-events-have-conflict/
 * 2446. 判断两个事件是否存在冲突
 *
 * @author Lin
 * @date 2023/5/17
 */
public class DetermineIfTwoEventsHaveConflict {
    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }
}
