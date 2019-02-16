package LeetCode_day01;

import org.junit.Test;

public class Solution5 {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * <p>
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     */
    public String longestPalindrome(String s) {
        if (s.equals("")) {
            return "";
        }
        char[] chars = s.toCharArray();
        Boolean[][] l = new Boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            l[i][i] = true;
        }
        int max = 1;
        String res = s.substring(0, 1);
        for (int len = 1; len < chars.length; len++) {
            for (int i = 0; i + len < chars.length; i++) {
                int j = i + len;
                if (len == 1) {
                    l[i][j] = (chars[i] == chars[i + 1]);
                } else {
                    l[i][j] = (l[i + 1][j - 1]) && (chars[i] == chars[j]);
                }
                if (l[i][j] && len + 1 > max) {
                    max = len + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(longestPalindrome("cbbd"));
    }

}
