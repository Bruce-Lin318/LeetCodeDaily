package medium;

import util.TestUtil;
import util.annotation.Main;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/making-file-names-unique/
 * 1487. 保证文件名唯一
 *
 * @author Lin
 * @date 2023/3/3
 */
public class MakingFileNamesUnique {

    @Main
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] ans = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (map.containsKey(name)) {
                int num = map.get(name);
                while (map.containsKey(addSuffix(name, num))) {
                    num++;
                }
                ans[i] = addSuffix(name, num);
                map.put(name, num + 1);
                map.put(ans[i], 1);
            } else {
                ans[i] = name;
                map.put(name, 1);
            }
        }
        return ans;
    }

    private String addSuffix(String name, int num) {
        return name + "(" + num + ")";
    }

    public static void main(String[] args) {
        TestUtil.invoke(new String[]{"pes","fifa","gta","pes(2019)"});
    }

}
