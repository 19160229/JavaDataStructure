package LeetCode_day02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution16 {

    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
     * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     *
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int closestSum=0;
        int diff=Integer.MAX_VALUE;
        for (int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                int tmpSum=nums[i]+nums[left]+nums[right];
                int tmpDiff=Math.abs(tmpSum-target);
                if (tmpDiff<diff){
                    closestSum=tmpSum;
                    diff=tmpDiff;
                }
                if (tmpSum<target){
                    left++;
                }else if (tmpSum>target){
                    right--;
                }else {
                    return tmpSum;
                }
            }
        }
        return closestSum;
    }

    @Test
    public void test(){
        int[] nums={-1,2,1,-4};
        System.out.println(threeSumClosest(nums,1));
    }

}
