package LeetCode_day05;

import org.junit.Test;

public class Solution41 {

    /**
     * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
     *
     * 示例 1:
     * 输入: [1,2,0]
     * 输出: 3
     *
     * 示例 2:
     * 输入: [3,4,-1,1]
     * 输出: 2
     *
     * 示例 3:
     * 输入: [7,8,9,11,12]
     * 输出: 1
     *
     * 说明:
     * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
     */
    public int firstMissingPositive(int[] nums) {
        for (int i=1;i<=nums.length;i++){
            int index=i-1;
            while (nums[index]!=i&&nums[index]>0&&nums[index]<=nums.length){
                int tmp=nums[index]-1;
                nums[index]=nums[tmp];
                nums[tmp]=tmp+1;
            }
        }
        for (int i=1;i<=nums.length;i++){
            if (nums[i-1]!=i) return i;
        }
        return nums.length+1;
    }

    @Test
    public void test(){
        int[] nums={7,8,9,11,12};
//        firstMissingPositive(nums);
//        System.out.println(Arrays.toString(nums));
        System.out.println(firstMissingPositive(nums));
    }

}
