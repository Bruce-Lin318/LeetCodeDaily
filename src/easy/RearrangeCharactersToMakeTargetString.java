package easy;

/**
 * https://leetcode.cn/problems/rearrange-characters-to-make-target-string/
 * 2287. 重排字符形成目标字符串
 *
 * @author Lin
 * @date 2023/1/13
 */
public class RearrangeCharactersToMakeTargetString {
    public int rearrangeCharacters(String s, String target) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int[] targets = new int[26];
        for (char c : target.toCharArray()) {
            targets[c - 'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < targets.length; i++) {
            if(targets[i] != 0) {
                ans = Math.min(ans, count[i] / targets[i]);
            }
        }
        return ans;
    }
}
