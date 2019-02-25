package LeetCode_day10;

import org.junit.Test;

public class Solution79 {

    /**
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
     * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     * 示例:
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     * 给定 word = "ABCCED", 返回 true.
     * 给定 word = "SEE", 返回 true.
     * 给定 word = "ABCB", 返回 false.
     */

    @Test
    public void test(){
        System.out.println(exist(new char[][]{{'A','B','C','E'},
                                              {'S','F','C','S'},
                                              {'A','D','E','E'}},
                "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        if (board.length==0||board[0].length==0) return false;
        int m=board.length;
        int n=board[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (dfs(board,i,j,word,0,new boolean[m][n])) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,int i,int j,String word,int index,boolean[][] isVisited){
        if (board[i][j]!=word.charAt(index)) return false;
        if (index==word.length()-1) return true;
        isVisited[i][j]=true;
        if ((j-1>=0)&&(!isVisited[i][j-1])){
            if (dfs(board,i,j-1,word,index+1,isVisited)) return true;
        }
        if ((j+1<board[0].length)&&(!isVisited[i][j+1])){
            if (dfs(board,i,j+1,word,index+1,isVisited)) return true;
        }
        if((i-1>=0)&&(!isVisited[i-1][j])){
            if (dfs(board,i-1,j,word,index+1,isVisited)) return true;
        }
        if ((i+1<board.length)&&(!isVisited[i+1][j])){
            if (dfs(board,i+1,j,word,index+1,isVisited)) return true;
        }
        isVisited[i][j]=false;
        return false;
    }

}
