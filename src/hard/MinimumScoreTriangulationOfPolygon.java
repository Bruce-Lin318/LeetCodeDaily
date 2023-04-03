package hard;

/**
 * @author Lin
 * @date 2023/4/2
 */
public class MinimumScoreTriangulationOfPolygon {

    private int[] vertices;
    private int[][] dp;

    public int minScoreTriangulation(int[] values) {
        dp = new int[values.length][values.length];
        vertices = values;
        return process(0, values.length - 1);
    }

    private int process(int start, int end) {
        if (end == start + 2) {
            return getScore(start, start + 1, end);
        }
        if (end < start + 2) {
            return 0;
        }
        return 0;
    }

    private int getScore(int a, int b, int c) {
        if (a == b || b == c || a == c) {
            return 0;
        }
        return vertices[a] * vertices[b] * vertices[c];
    }
}
