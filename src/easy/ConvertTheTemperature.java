package easy;

/**
 * https://leetcode.cn/problems/convert-the-temperature/
 * 2469. 温度转换
 *
 * @author Lin
 * @date 2023/3/21
 */
public class ConvertTheTemperature {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }
}
