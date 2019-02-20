package LeetCode_day08;

import org.junit.Test;

public class Solution59 {

    /**
     * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     *
     * 示例:
     * 输入: 3
     * 输出:
     * [
     *  [ 1, 2, 3 ],
     *  [ 8, 9, 4 ],
     *  [ 7, 6, 5 ]
     * ]
     */

    @Test
    public void test(){
        int[][] matrix=generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int num=1;
        int[][] matrix=new int[n][n];
        int up=0,down=n-1,left=0,right=n-1;
        while (true){
            //1 从左往右最上面一行
            for (int j=left;j<=right;j++){
                matrix[up][j]=num;
                num++;
            }
            up++;
            if (up>down) break;
            //2 从上往下最右边一行
            for (int i=up;i<=down;i++){
                matrix[i][right]=num;
                num++;
            }
            right--;
            if (right<left) break;
            //3 从右往左最下面一行
            for (int j=right;j>=left;j--){
                matrix[down][j]=num;
                num++;
            }
            down--;
            if (down<up) break;
            //4 从下往上最左边一行
            for (int i=down;i>=up;i--){
                matrix[i][left]=num;
                num++;
            }
            left++;
            if (left>right) break;
        }
        return matrix;
    }

}
