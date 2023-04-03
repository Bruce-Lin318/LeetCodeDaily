package medium;

/**
 * @author Lin
 * @date 2023/4/1
 */
public class MaskingPersonalInformation {
    public String maskPII(String s) {
        char[] chars = s.toCharArray();
        return s.indexOf("@") > 0 ? processForMail(chars) : processForNumber(chars);
    }

    private String processForMail(char[] mail) {
        return null;
    }

    private String processForNumber(char[] number) {
        int count = 0;
        for (int i = number.length - 1; i >= 0; i--) {

        }
        for (char c : number) {
            count += Character.isDigit(c) ? 1 : 0;
        }
        StringBuilder res = new StringBuilder();
        if (count > 10) {
            res.append("+");
            while (count > 10) {
                res.append("*");
                count--;
            }
            res.append("_");
        }
        res.append("***_***_");
        return null;
    }
}
