package LeetCode_day01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {

    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * 请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     * <p>
     * 示例 1:
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * <p>
     * 示例 2:
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int currentRow = 0;
        Boolean goDown = false;
        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);
            if (currentRow == 0 || currentRow == numRows-1)
                goDown = !goDown;
            currentRow += goDown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sBuilder : rows) {
            res.append(sBuilder);
        }
        return res.toString();
    }

    @Test
    public void test(){
        System.out.println(convert("LEETCODEISHIRING",4));
    }

}
