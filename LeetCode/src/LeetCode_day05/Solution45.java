package LeetCode_day05;

import org.junit.Test;

public class Solution45 {

    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     *
     * 示例:
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     *
     * 说明:
     * 假设你总是可以到达数组的最后一个位置。
     */
    private int min=Integer.MAX_VALUE;

    //递归回溯，最慢O(n^n)
    //可动态规划，O(n^2)
    public int jump(int[] nums) {
        if (nums.length==0) return 0;
        int cnt=0;
        jump(nums,cnt,0);
        return min;
    }

    //贪心算法,最快,每次能跳到最大距离，那么一定用最少次数就能到最后
    //下一次跳的起点一定在前一次的起点--前一次跳到的最大距离
    //再在这个范围内看这一次能跳到的最大距离,若这一次已经跳到的最大距离已经到了最后则结束
    public int jump2(int[] nums){
        int start=0,end=0,farthest=0;
        int step=0;
        //从[start,end]是前一次能跳到的距离范围，
        // 这一次能跳到的最大距离一定是max(i+nums[i])(start<=i<=end)
        while (farthest<nums.length-1){
            step++;
            for (int i=start;i<=end;i++){
                if (i+nums[i]>farthest){
                    farthest=i+nums[i];
                }
                if (farthest>=nums.length-1) return step;
            }
            start=end+1;
            end=farthest;
        }
        return step;
    }

    private void jump(int[] nums,int cnt,int index){
        if (index==nums.length-1) {
            min=Math.min(min,cnt);
            return;
        }
        for (int i=1;i<=nums[index];i++){
            cnt++;
            jump(nums,cnt,i+index);
            cnt--;
        }
    }

    @Test
    public void test(){
        System.out.println(jump2(new int[]{1,2,1,1,1}));
    }
}
