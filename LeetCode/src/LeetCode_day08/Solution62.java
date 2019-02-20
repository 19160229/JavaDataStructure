package LeetCode_day08;

import org.junit.Test;

public class Solution62 {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 问总共有多少条不同的路径？
     *
     * 说明：m 和 n 的值均不超过 100。(m表示列，n表示行)
     *
     * 示例 1:
     * 输入: m = 3, n = 2
     * 输出: 3
     * 解释:
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向右 -> 向下
     * 2. 向右 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向右
     *
     * 示例 2:
     * 输入: m = 7, n = 3
     * 输出: 28
     */

    public int uniquePaths(int m, int n) {
        //dp
        //v[i][j]表示从左上角到i行j列共有多少条不同路径,v[i][j]=v[i-1][j]+v[i][j-1]
        // (只能向右和向下走，所以v[i][j]等于到其左边一个位置的路径总数加上到其上面一个位置的路径总数)
        int[][] v=new int[n][m];
        for (int i=0;i<n;i++) v[i][0]=1;
        for (int j=1;j<m;j++) v[0][j]=1;
        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                v[i][j]=v[i-1][j]+v[i][j-1];
            }
        }
        return v[n-1][m-1];
    }

    @Test
    public void test(){
        System.out.println(uniquePaths(7,3));
//        int[] nums={1,2,3,4,5};
//        nums=new int[6];
//        for (int i = 0; i < nums.length; i++) {
//            int num = nums[i];
//            System.out.println(num);
//        }
    }

}
