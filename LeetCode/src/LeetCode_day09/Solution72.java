package LeetCode_day09;

import org.junit.Test;

public class Solution72 {

    /**
     * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
     * 你可以对一个单词进行如下三种操作：
     *     插入一个字符
     *     删除一个字符
     *     替换一个字符
     *
     * 示例 1:
     * 输入: word1 = "horse", word2 = "ros"
     * 输出: 3
     * 解释:
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     *
     * 示例 2:
     * 输入: word1 = "intention", word2 = "execution"
     * 输出: 5
     * 解释:
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     */

    @Test
    public void test(){
        System.out.println(minDistance("intention","execution"));
    }

    public int minDistance(String word1, String word2) {
        //dp
        int m=word1.length();
        int n=word2.length();
        //v[i][j]:从word1[0..i-1]到word2[0..j-1]的最小编辑距离
        //word[0...-1]表示空字符串
        int[][] v=new int[m+1][n+1];
        for (int i=0;i<=m;i++){
            v[i][0]=i;
        }
        for (int j=0;j<=n;j++){
            v[0][j]=j;
        }
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    v[i][j]=v[i-1][j-1];
                }else {
                    v[i][j]=1+Math.min(/*修改*/v[i-1][j-1],Math.min(/*删除*/v[i-1][j],/*添加*/v[i][j-1]));
                }
            }
        }
        return v[m][n];
    }

}
