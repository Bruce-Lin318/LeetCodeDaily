package medium;

import util.annotation.Main;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/adding-two-negabinary-numbers/
 * 1073. 负二进制数相加
 *
 * @author Lin
 * @date 2023/5/18
 */
public class AddingTwoNegabinaryNumbers {
    @Main
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> res = new ArrayList<>();
        int i1 = arr1.length - 1;
        int i2 = arr2.length - 1;
        int i = 0;
        while (i1 >= 0 && i2 >= 0) {
            int count = arr1[i1--] + arr2[i2--];
            if (count == 0) {
                plusZero(res, i);
            } else {
                for (int j = 0; j < count; j++) {
                    plusOne(res, i);
                }
            }
            i++;
        }
        processResidue(arr1, i1, res, i);
        processResidue(arr2, i2, res, i);
        // 去除前导0
        while (res.size() > 0 && res.get(res.size() - 1) == 0) {
            res.remove(res.size() - 1);
        }
        int[] ans = new int[res.size()];
        for (int j = 0; j < ans.length; j++) {
            ans[j] = res.get(ans.length - 1 - j);
        }
        return ans.length == 0 ? new int[]{0} : ans;
    }

    private void processResidue(int[] arr, int index, List<Integer> list, int i) {
        while (index >= 0) {
            if (arr[index--] == 0) {
                plusZero(list, i++);
            } else {
                plusOne(list, i++);
            }
        }
    }

    // i 位置添加占位0
    private void plusZero(List<Integer> list, int i) {
        if (i == list.size()) {
            list.add(0);
        }
    }

    // i 位置 + 1
    private void plusOne(List<Integer> list, int i) {
        plusZero(list, i);
        if (list.get(i) == 0) {
            list.set(i, 1);
        } else {
            carry(list, i);
        }
    }

    // i 位置发生 1 + 1
    private void carry(List<Integer> list, int i) {
        list.set(i, 0);
        if (list.size() > i + 1 && list.get(i + 1) == 1) {
            list.set(i + 1, 0);
        } else {
            plusOne(list, i + 1);
            plusOne(list, i + 2);
        }
    }
}
