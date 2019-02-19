package LeetCode_day05;

import org.junit.Test;

public class Solution44 {

    /**
     * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符串（包括空字符串）。
     * 两个字符串完全匹配才算匹配成功。
     *
     * 说明:
     *     s 可能为空，且只包含从 a-z 的小写字母。
     *     p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
     *
     * 示例 1:
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     *
     * 示例 2:
     * 输入:
     * s = "aa"
     * p = "*"
     * 输出: true
     * 解释: '*' 可以匹配任意字符串。
     *
     * 示例 3:
     * 输入:
     * s = "cb"
     * p = "?a"
     * 输出: false
     * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
     *
     * 示例 4:
     * 输入:
     * s = "adceb"
     * p = "*a*b"
     * 输出: true
     * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
     *
     * 示例 5:
     * 输入:
     * s = "acdcb"
     * p = "a*c?b"
     * 输入: false
     */
    @Test
    public void test(){
        System.out.println(isMatch("acdcb","a*c?b"));
    }

    public boolean isMatch(String s, String p) {
        //表示主串的前i个字符与模式串的前j个字符是否匹配
        boolean[][] value = new boolean[s.length() + 1][p.length() + 1];
        value[0][0]=true;
        //当模式串是空串时，一定不匹配
        for(int i=1;i<=s.length();i++){
            value[i][0]=false;
        }
        //当主串是空串时
        for (int j=1;j<=p.length();j++){
            value[0][j]= p.charAt(j-1) == '*' && value[0][j - 1];
        }
        for (int i=1;i<=s.length();i++){
            for (int j=1;j<=p.length();j++){
                //如果模式串的第j个字符是'*',value[i-1][j]表示'*'匹配1+k个字符
                //value[i][j-1]表示'*'匹配空字符，value[i-1][j-1]表示'*'匹配主串第i个字符
                if (p.charAt(j-1)=='*'){
                    value[i][j]=value[i-1][j]||value[i][j-1]||value[i-1][j-1];
                }else if (p.charAt(j-1)=='?'){
                    //如果模式串的第j个字符是'?',而'?'匹配任意一个非空字符,则'?'必然匹配主串的第i个字符
                    value[i][j]=value[i-1][j-1];
                }else {
                    value[i][j]=value[i-1][j-1]&&s.charAt(i-1)==p.charAt(j-1);
                }
            }
        }
        return value[s.length()][p.length()];
    }
}
