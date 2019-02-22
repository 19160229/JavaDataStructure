package LeetCode_day09;

import org.junit.Test;

public class Solution70 {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     *
     * 示例 1：
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     *
     * 示例 2：
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     */

    public int climbStairs(int n) {
        //dp求解
        int[] value=new int[n];
        if (n==1) return 1;
        value[0]=1;
        value[1]=2;
        for (int i=2;i<n;i++){
            value[i]=value[i-1]+value[i-2];
        }
        return value[n-1];
    }

    @Test
    public void test(){
        System.out.println(climbStairs(3));
    }

}
