package LeetCode_day04;

import org.junit.Test;

public class Solution37 {

    /**
     * 解数独
     */
    public void solveSudoku(char[][] board) {
        boolean[][][] isUsed = new boolean[3][9][9];
        //将现有的数填入数独中
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '1';
                    int index = (i / 3) * 3 + j / 3;
                    isUsed[0][i][num] = isUsed[1][j][num] = isUsed[2][index][num] = true;
                }
            }
        }
        dfs(board,isUsed,0,0);
    }

    private boolean dfs(char[][] board,boolean[][][] isUsed,int i,int j){
        while (board[i][j]!='.'){
            j++;
            if (j>=9){
                i++;
                j=0;
            }
            if (i>=9) return true;
        }
        for (int k=0;k<9;k++){
            int index=(i / 3) * 3 + j / 3;
            if ((!isUsed[0][i][k]) && (!isUsed[1][j][k]) && (!isUsed[2][index][k])){
                isUsed[0][i][k] = isUsed[1][j][k] = isUsed[2][index][k]=true;
                board[i][j]= (char) (k+'1');
                if (dfs(board,isUsed,i,j)) return true;
                isUsed[0][i][k] = isUsed[1][j][k] = isUsed[2][index][k]=false;
                board[i][j]='.';
            }
        }
        return false;
    }

    @Test
    public void test(){
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

}
