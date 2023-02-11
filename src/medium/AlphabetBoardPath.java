package medium;

/**
 * https://leetcode.cn/problems/alphabet-board-path/
 * 1138. 字母板上的路径
 *
 * @author Lin
 * @date 2023/2/12
 */
public class AlphabetBoardPath {
    public String alphabetBoardPath(String target) {
        int curRow = 0;
        int curColumn = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : target.toCharArray()) {
            int index = c - 'a';
            int targetRow = index / 5;
            int targetColumn = index % 5;
            while (targetColumn < curColumn) {
                sb.append('L');
                curColumn--;
            }
            while (targetRow > curRow) {
                sb.append('D');
                curRow++;
            }
            while (targetRow < curRow) {
                sb.append('U');
                curRow--;
            }
            while (targetColumn > curColumn) {
                sb.append('R');
                curColumn++;
            }
            sb.append('!');
        }
        return sb.toString();
    }
}
