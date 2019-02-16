package LeetCode_day02;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution18 {

    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
     * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * 注意：
     * 答案中不可以包含重复的四元组。
     * <p>
     * 示例：
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     * 满足要求的四元组集合为：
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     */
    //求组合方式求四数之和
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resList = new LinkedList<>();
        if (nums == null || nums.length < 4) {
            return resList;
        }
        Arrays.sort(nums);
        Integer[] res = new Integer[4];
        getComb(resList, res, nums, 0, 0, target);
        return resList;
    }

    public void getComb(List<List<Integer>> resList, Integer[] res,
                        int[] nums, int tIndex, int sIndex, int target) {
        if (tIndex == 4) {
            if (getSum(res) == target) {
                List<Integer> tmpRes=new LinkedList<>();
                Collections.addAll(tmpRes,res);
                resList.add(tmpRes);
            }
        } else {
            Integer exist = null;
            for (int i = sIndex; i <= nums.length - 4 + tIndex; i++) {
                if (exist == null || exist != nums[i]) {
                    exist = nums[i];
                    res[tIndex] = nums[i];
                    getComb(resList, res, nums, tIndex + 1, i + 1, target);
                }
            }
        }
    }

    public int getSum(Integer[] res) {
        int sum = 0;
        for (Integer i : res) {
            sum += i;
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0).toString());
    }

}
