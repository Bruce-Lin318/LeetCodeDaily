package medium;

import java.util.*;

/**
 * https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/
 * 1233. 删除子文件夹
 *
 * @author Lin
 * @date 2023/2/8
 */
public class RemoveSubFoldersFromTheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> folders = new HashSet<>();
        for (String s : folder) {
            folders.add(s);
        }
        List<String> ans = new LinkedList<>();
        for (String s : folders) {
            boolean isSubFolder = false;
            for (int i = s.length() - 1; i > 0; i--) {
                if (s.charAt(i) == '/' && folders.contains(s.substring(0, i))) {
                    isSubFolder = true;
                    break;
                }
            }
            if (!isSubFolder) {
                ans.add(s);
            }
        }
        return ans;
    }
}
