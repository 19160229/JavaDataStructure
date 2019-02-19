package LeetCode_day06;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {

    /**
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     *
     * 示例 1:
     * 输入:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     *
     * 示例 2:
     * 输入:
     * [
     *   [1, 2, 3, 4],
     *   [5, 6, 7, 8],
     *   [9,10,11,12]
     * ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     */

    @Test
    public void test(){
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}).toString());
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int m=matrix.length;
        if (m==0) return list;
        int n=matrix[0].length;
        //up表示上边界,down表示下边界,left表示左边界,right表示右边界
        int up=0,down=m-1,left=0,right=n-1;
        while (true){
            //先从左往后输出最上面一行
            for (int j=left;j<=right;j++){
                list.add(matrix[up][j]);
            }
            //上边界往下一行
            up++;
            //若上边界超过了下边界则说明遍历结束，退出
            if (up>down) break;
            //再从上往下输出最右边一行
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (right<left) break;
            //再从右往左输出最下边一行
            for (int j=right;j>=left;j--){
                list.add(matrix[down][j]);
            }
            down--;
            if (down<up) break;
            //最后从下往上输出最左边一行
            for (int i=down;i>=up;i--){
                list.add(matrix[i][left]);
            }
            left++;
            if (left>right) break;
        }
        return list;
    }

}
