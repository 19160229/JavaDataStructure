package LeetCode_day06;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution51 {

    /**
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * 注:相互不能攻击指：不在同一行、同一列，切不在同一个对角线上
     * <p>
     * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
     * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * <p>
     * 示例:
     * 输入: 4
     * 输出: [
     * [".Q..",  // 解法 1
     * "...Q",
     * "Q...",
     * "..Q."],
     * <p>
     * ["..Q.",  // 解法 2
     * "Q...",
     * "...Q",
     * ".Q.."]
     * ]
     * 解释: 4 皇后问题存在两个不同的解法。
     */

    @Test
    public void test() {
        System.out.println(solveNQueens(4).toString());
    }

    //经典回溯法（即DFS问题）问题
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resLists = new ArrayList<>();
        //pos[i]表示第i行的皇后的位置，初始为-1
        int[] pos = new int[n];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = -1;
        }
        solveDFSNQueens(resLists, pos, 0);
        return resLists;
    }

    private void solveDFSNQueens(List<List<String>> resList, int[] pos, int row) {
        int len = pos.length;
        if (row == len) {
            //走到了最后一行，说明找到了一种情况
            List<String> res = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < len; j++) {
                    if (j == pos[i]) stringBuilder.append('Q');
                    else stringBuilder.append('.');
                }
                res.add(stringBuilder.toString());
            }
            resList.add(res);
        }
        for (int col = 0; col < len; col++) {
            if (isValid(pos,row,col)){
                pos[row]=col;
                solveDFSNQueens(resList,pos,row+1);
                pos[row]=-1;
            }
        }
    }

    //判断将皇后放在第row行，第col列是否有效
    private boolean isValid(int[] pos,int row,int col){
        //前row行已经放了皇后
        for (int i=0;i<row;i++){
            //冲突的情况：i行皇后和row行皇后在同一列，pos[i]==col;
            //i行皇后和row行皇后在同一对角线(判(x1,y1)与(x2,y2)在同一对角线，及判断|x1-x2|是否等于|y1-y2|)
            if ((pos[i]==col)||(row-i==Math.abs(pos[i]-col))) return false;
        }
        return true;
    }

}
