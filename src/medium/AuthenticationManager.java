package medium;

import java.util.*;

/**
 * https://leetcode.cn/problems/design-authentication-manager/
 * 1797. 设计一个验证系统
 *
 * @author Lin
 * @date 2023/2/9
 */
public class AuthenticationManager {
    private int limit;
    private Map<String, Integer> map;

    public AuthenticationManager(int timeToLive) {
        limit = timeToLive;
        map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.putIfAbsent(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId) && map.get(tokenId) > currentTime - limit) {
            map.put(tokenId, currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        List<String> tokenIds = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() <= currentTime - limit) {
                tokenIds.add(entry.getKey());
            }
        }
        tokenIds.forEach(tokenId -> map.remove(tokenId));
        return map.size();
    }
}

