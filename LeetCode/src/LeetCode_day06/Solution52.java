package LeetCode_day06;

import org.junit.Test;

public class Solution52 {

    /**
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     *
     * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
     *
     * 示例:
     * 输入: 4
     * 输出: 2
     * 解释: 4 皇后问题存在如下两个不同的解法。
     * [
     *  [".Q..",  // 解法 1
     *   "...Q",
     *   "Q...",
     *   "..Q."],
     *
     *  ["..Q.",  // 解法 2
     *   "Q...",
     *   "...Q",
     *   ".Q.."]
     * ]
     */

    private int cnt;

    @Test
    public void test(){
        System.out.println(totalNQueens(4));
    }

    public int totalNQueens(int n) {
        cnt=0;
        int[] pos=new int[n];
        for (int i = 0; i < pos.length; i++) {
            pos[i]=-1;
        }
        solveNQueens(pos,0);
        return cnt;
    }

    private void solveNQueens(int[] pos,int row){
        int len=pos.length;
        if (row==len) cnt++;
        for (int col=0;col<len;col++){
            if (isValid(pos,row,col)){
                pos[row]=col;
                solveNQueens(pos,row+1);
                pos[row]=-1;
            }
        }
    }

    private boolean isValid(int[] pos,int row,int col){
        for (int i=0;i<row;i++){
            if ((pos[i]==col)||((row-i)==Math.abs(col-pos[i]))) return false;
        }
        return true;
    }
}
