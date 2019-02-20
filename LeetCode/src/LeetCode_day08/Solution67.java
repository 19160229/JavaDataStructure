package LeetCode_day08;

import org.junit.Test;

public class Solution67 {

    /**
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。
     * 输入为非空字符串且只包含数字 1 和 0。
     * <p>
     * 示例 1:
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * <p>
     * 示例 2:
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     */

    public String addBinary(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int m = a.length();
        int n = b.length();
        int i = m - 1, j = n - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int tmp = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
            carry = tmp / 2;
            sum.insert(0, (tmp % 2));
            i--;
            j--;
        }
        while (i >= 0) {
            int tmp = (a.charAt(i) - '0') + carry;
            carry = tmp / 2;
            sum.insert(0, (tmp % 2));
            i--;
        }
        while (j >= 0) {
            int tmp = (b.charAt(j) - '0') + carry;
            carry = tmp / 2;
            sum.insert(0, (tmp % 2));
            j--;
        }
        while (carry > 0) {
            sum.insert(0, (carry % 2));
            carry = carry / 2;
        }
        return sum.toString();
    }

    @Test
    public void test() {
        System.out.println(addBinary("1010", "1011"));
    }

}
