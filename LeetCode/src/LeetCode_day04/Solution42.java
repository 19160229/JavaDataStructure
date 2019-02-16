package LeetCode_day04;

import org.junit.Test;

public class Solution42 {

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * 示例:
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     */
    public int trap(int[] height) {
        if (height.length==0) return 0;
        int sum=0;
        //maxRs[i]表示i右边的最大高度
        int[] maxRs=new int[height.length];
        int maxL=0;
        int maxR=0;
        //初始化maxRs数组
        for (int i=height.length-1;i>=0;i--){
            if (height[i]>maxR){
                maxRs[i]=maxR=height[i];
            }else {
                maxRs[i]=maxR;
            }
        }
        for (int i=0;i<height.length;i++){
            if (maxL<height[i]){
                maxL=height[i];
            }
            sum+=Math.max(Math.min(maxL,maxRs[i])-height[i],0);
        }
        return sum;
    }

    @Test
    public void test(){
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

}
