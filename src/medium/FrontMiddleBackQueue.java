package medium;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/design-front-middle-back-queue/?envType=daily-question&envId=2023-11-28
 * 1670. 设计前中后队列
 *
 * @author Lin
 * @date 2023/11/28
 */
public class FrontMiddleBackQueue {

    private List<Integer> list;

    public FrontMiddleBackQueue() {
        this.list = new ArrayList<>();
    }



    public void pushFront(int val) {
        list.add(0, val);
    }


    public void pushMiddle(int val) {
        list.add((list.size() - 1) / 2, val);
    }

    public void pushBack(int val) {
        list.add(val);
    }

    public int popFront() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.remove(0);
    }

    public int popMiddle() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.remove((list.size() - 1) / 2);
    }

    public int popBack() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.remove(list.size() - 1);

    }
}
